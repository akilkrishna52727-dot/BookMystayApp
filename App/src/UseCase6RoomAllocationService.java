import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 6: Room Allocation & Confirmation
 * Version: 6.1
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v6.1 =====");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Create booking queue
        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Akil", "Single Room"));
        queue.add(new Reservation("Rahul", "Single Room"));
        queue.add(new Reservation("Priya", "Suite Room"));
        queue.add(new Reservation("John", "Suite Room"));
        queue.add(new Reservation("David", "Suite Room")); // may fail if no availability

        // Process bookings
        RoomAllocationService service = new RoomAllocationService(inventory);
        service.processBookings(queue);

        // Show results
        service.displayAllocations();

        System.out.println("\n--- Final Inventory ---");
        inventory.displayInventory();
    }
}