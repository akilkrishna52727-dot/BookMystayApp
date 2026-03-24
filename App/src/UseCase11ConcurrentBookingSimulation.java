public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v11.1 =====");

        RoomInventory inventory = new RoomInventory();

        // Reduce rooms for testing
        inventory.updateAvailability("Single Room", 2);

        ThreadSafeBookingService service =
                new ThreadSafeBookingService(inventory);

        // Create multiple threads (simulating users)
        Thread t1 = new Thread(new BookingTask(service, "Akil", "Single Room"), "Thread-1");
        Thread t2 = new Thread(new BookingTask(service, "Rahul", "Single Room"), "Thread-2");
        Thread t3 = new Thread(new BookingTask(service, "Priya", "Single Room"), "Thread-3");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}