import java.util.ArrayList;
import java.util.List;

class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Get all bookings
    public List<Reservation> getHistory() {
        return history;
    }

    // Display all bookings
    public void displayHistory() {
        System.out.println("\n--- Booking History ---");

        for (Reservation r : history) {
            r.displayReservation();
        }
    }
}

