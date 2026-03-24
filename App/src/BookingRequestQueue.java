import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Added request for " + reservation.getGuestName());
    }

    // Display all requests
    public void displayQueue() {
        System.out.println("\n--- Booking Request Queue ---");

        for (Reservation r : queue) {
            r.displayReservation();
        }
    }
}
