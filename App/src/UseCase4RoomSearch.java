public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v4.1 =====");

        // Initialize inventory (read-only usage)
        RoomInventory inventory = new RoomInventory();

        // Create room objects (Domain Model)
        Room single = new SingleRoom();
        Room dbl = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Search and display available rooms
        System.out.println("\n--- Available Rooms ---");

        displayIfAvailable(single, inventory);
        displayIfAvailable(dbl, inventory);
        displayIfAvailable(suite, inventory);
    }

    // Read-only search method
    public static void displayIfAvailable(Room room, RoomInventory inventory) {

        int available = inventory.getAvailability(room.roomType);

        if (available > 0) {
            room.displayRoomDetails();
            System.out.println("Available: " + available);
            System.out.println("-----------------------------");
        }
    }
}
