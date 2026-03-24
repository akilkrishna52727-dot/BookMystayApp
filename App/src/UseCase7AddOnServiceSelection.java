public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App v7.1 =====");

        // Assume reservation already created (from UC6)
        String reservationId = "SINGLEROOM-12345";

        // Create service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 200);
        AddOnService wifi = new AddOnService("WiFi", 100);
        AddOnService spa = new AddOnService("Spa", 500);

        // Add services to reservation
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, wifi);
        manager.addService(reservationId, spa);

        // Display services and cost
        manager.displayServices(reservationId);
    }
}
