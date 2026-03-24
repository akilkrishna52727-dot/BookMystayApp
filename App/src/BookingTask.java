class BookingTask implements Runnable {

    private ThreadSafeBookingService service;
    private String guestName;
    private String roomType;

    public BookingTask(ThreadSafeBookingService service,
                       String guestName,
                       String roomType) {
        this.service = service;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    @Override
    public void run() {
        service.bookRoom(guestName, roomType);
    }
}
