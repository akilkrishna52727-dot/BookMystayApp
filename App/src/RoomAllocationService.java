import java.util.*;

class RoomAllocationService {

    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms;

    public RoomAllocationService(RoomInventory inventory) {
        this.inventory = inventory;
        this.allocatedRooms = new HashMap<>();
    }

    // Process booking queue
    public void processBookings(Queue<Reservation> queue) {

        System.out.println("\n--- Processing Bookings ---");

        while (!queue.isEmpty()) {

            Reservation reservation = queue.poll();
            String roomType = reservation.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = roomType.replace(" ", "").toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);

                // Store allocated room
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                allocatedRooms.get(roomType).add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking CONFIRMED for " + reservation.getGuestName() +
                        " | Room: " + roomId);

            } else {
                System.out.println("Booking FAILED for " + reservation.getGuestName() +
                        " | No rooms available");
            }
        }
    }

    // Display allocated rooms
    public void displayAllocations() {

        System.out.println("\n--- Allocated Rooms ---");

        for (String type : allocatedRooms.keySet()) {
            System.out.println(type + " -> " + allocatedRooms.get(type));
        }
    }
}