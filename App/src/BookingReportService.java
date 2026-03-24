import java.util.List;

class BookingReportService {

    // Generate simple report
    public void generateReport(List<Reservation> history) {

        System.out.println("\n--- Booking Report ---");

        if (history.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        int totalBookings = history.size();

        System.out.println("Total Bookings: " + totalBookings);

        System.out.println("\nDetailed Report:");
        for (Reservation r : history) {
            r.displayReservation();
        }
    }
}
