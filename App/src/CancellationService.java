import java.util.*;

class CancellationService {

    private RoomInventory inventory;
    private Map<String, Set<String>> allocatedRooms;
    private Stack<String> rollbackStack;

    public CancellationService(RoomInventory inventory,
                               Map<String, Set<String>> allocatedRooms) {
        this.inventory = inventory;
        this.allocatedRooms = allocatedRooms;
        this.rollbackStack = new Stack<>();
    }

    public void cancelBooking(String roomType, String roomId) {

        System.out.println("\nAttempting cancellation for Room ID: " + roomId);

        // Validate booking existence
        if (!allocatedRooms.containsKey(roomType) ||
                !allocatedRooms.get(roomType).contains(roomId)) {

            System.out.println("Cancellation FAILED: Booking not found");
            return;
        }

        // Remove room allocation
        allocatedRooms.get(roomType).remove(roomId);

        // Add to rollback stack (LIFO)
        rollbackStack.push(roomId);

        // Restore inventory
        int available = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, available + 1);

        System.out.println("Cancellation SUCCESS for Room ID: " + roomId);
    }

    public void displayRollbackStack() {
        System.out.println("\n--- Rollback Stack ---");
        System.out.println(rollbackStack);
    }
}
