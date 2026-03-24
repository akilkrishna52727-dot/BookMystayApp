import java.util.*;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 * Version: 10.1
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v10.1 =====");

        RoomInventory inventory = new RoomInventory();

        // Simulated allocated rooms
        Map<String, Set<String>> allocatedRooms = new HashMap<>();

        allocatedRooms.put("Single Room", new HashSet<>());
        allocatedRooms.get("Single Room").add("SINGLEROOM-101");
        allocatedRooms.get("Single Room").add("SINGLEROOM-102");

        // Simulate reduced inventory
        inventory.updateAvailability("Single Room", 3);

        System.out.println("\n--- Before Cancellation ---");
        inventory.displayInventory();
        System.out.println("Allocated Rooms: " + allocatedRooms);

        // Initialize service
        CancellationService service =
                new CancellationService(inventory, allocatedRooms);

        // Valid cancellation
        service.cancelBooking("Single Room", "SINGLEROOM-101");

        // Invalid cancellation
        service.cancelBooking("Single Room", "INVALID-ID");

        System.out.println("\n--- After Cancellation ---");
        inventory.displayInventory();
        System.out.println("Allocated Rooms: " + allocatedRooms);

        service.displayRollbackStack();
    }
}
