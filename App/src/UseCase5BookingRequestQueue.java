public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v5.1 =====");

        // Initialize queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Akil", "Single Room");
        Reservation r2 = new Reservation("Rahul", "Double Room");
        Reservation r3 = new Reservation("Priya", "Suite Room");

        // Add requests (FIFO order)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queue
        bookingQueue.displayQueue();
    }
}
