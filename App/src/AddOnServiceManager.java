import java.util.*;

class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added " + service.getServiceName() +
                " to Reservation " + reservationId);
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {

        System.out.println("\nServices for Reservation: " + reservationId);

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        double total = 0;

        for (AddOnService s : services) {
            s.displayService();
            total += s.getPrice();
        }

        System.out.println("Total Add-On Cost: ₹" + total);
    }
}
