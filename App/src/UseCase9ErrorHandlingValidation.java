public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v9.1 =====");

        RoomInventory inventory = new RoomInventory();
        BookingValidator validator = new BookingValidator(inventory);

        // Case 1: Valid booking
        try {
            validator.validate("Single Room", 2);
            System.out.println("Booking validated successfully!");
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Case 2: Invalid room type
        try {
            validator.validate("Luxury Room", 1);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Case 3: Exceeds availability
        try {
            validator.validate("Suite Room", 10);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Case 4: Negative input
        try {
            validator.validate("Double Room", -1);
        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nSystem continues running safely...");
    }
}
