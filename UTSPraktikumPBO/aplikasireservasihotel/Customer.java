package aplikasireservasihotel;

class Customer {
    private static int customerIdCounter = 1000;
    private int customerId;
    private String name;
    private String contact;
    private Room bookedRoom;
    private int nights;
    private String bookingDate;

    public Customer(String name, String contact) {
        this.customerId = ++customerIdCounter;
        this.name = name;
        this.contact = contact;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public Room getBookedRoom() {
        return bookedRoom;
    }

    public void setBookedRoom(Room bookedRoom, int nights, String bookingDate) {
        this.bookedRoom = bookedRoom;
        this.nights = nights;
        this.bookingDate = bookingDate;
    }

    public void clearBooking() {
        this.bookedRoom = null;
        this.nights = 0;
        this.bookingDate = null;
    }

    public String getContact() {
        return contact;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalPrice() {
        if (bookedRoom != null) {
            return bookedRoom.getPrice() * nights;
        }
        return 0.0;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Contact: " + contact + ", Room: " +
                (bookedRoom != null ? bookedRoom.getRoomNumber() + " (" + bookedRoom.getRoomType() + ")" : "None") +
                ", Nights: " + (nights > 0 ? nights : "N/A") + ", Total: " + (bookedRoom != null ? getTotalPrice() : "N/A");
    }
}
