public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v3.1 =====");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display inventory
        inventory.displayInventory();

        // Check availability
        System.out.println("\nAvailable Single Rooms: " +
                inventory.getAvailability("Single Room"));

        // Update availability
        inventory.updateAvailability("Single Room", 4);

        System.out.println("\nAfter Booking 1 Single Room:");
        inventory.displayInventory();
    }
}
