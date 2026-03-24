class BookingValidator {

    private RoomInventory inventory;

    public BookingValidator(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void validate(String roomType, int requestedRooms)
            throws InvalidBookingException {

        // Validate room type
        if (!roomType.equals("Single Room") &&
                !roomType.equals("Double Room") &&
                !roomType.equals("Suite Room")) {

            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        // Validate positive request
        if (requestedRooms <= 0) {
            throw new InvalidBookingException("Requested rooms must be greater than 0");
        }

        // Validate availability
        int available = inventory.getAvailability(roomType);

        if (requestedRooms > available) {
            throw new InvalidBookingException(
                    "Not enough rooms available. Available: " + available);
        }
    }
}
