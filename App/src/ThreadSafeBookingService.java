import java.util.*;

class ThreadSafeBookingService {

    private RoomInventory inventory;

    public ThreadSafeBookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // synchronized method (critical section)
    public synchronized void bookRoom(String guestName, String roomType) {

        int available = inventory.getAvailability(roomType);

        if (available > 0) {
            inventory.updateAvailability(roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " SUCCESS: " + guestName + " booked " + roomType);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED: No rooms available for " + guestName);
        }
    }
}
