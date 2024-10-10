package aplikasireservasihotel;

import java.util.Scanner;

class CustomerSession implements Reservation {
    private Hotel hotel;
    private Customer customer;

    public CustomerSession(Hotel hotel, Customer customer) {
        this.hotel = hotel;
        this.customer = customer;
    }

    public void bookRoom() {
        Room[] availableRooms = hotel.getAvailableRooms();
        if (availableRooms.length == 0) {
            System.out.println("No rooms available.");
            return;
        }

        System.out.println("\n--- Available Rooms ---");
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        Scanner sc = new Scanner(System.in); 
        try {
            System.out.print("Enter room number to book: ");
            int roomNumber = sc.nextInt();
            sc.nextLine(); 
            Room room = hotel.findRoomByNumber(roomNumber);

            if (room == null) {
                System.out.println("Room not found.");
                return;
            }

            if (!room.isAvailable()) {
                System.out.println("Room is not available.");
                return;
            }

            System.out.print("Enter number of nights: ");
            int nights = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter booking date (dd/mm/yyyy): ");
            String date = sc.nextLine();

            customer.setBookedRoom(room, nights, date);
            room.setAvailable(false);
            System.out.println("Room booked successfully!");
        } catch (Exception e) {
            System.out.println("Error in booking room. Please try again.");
            sc.nextLine();
        }
    }

    public void checkAvailability() {
        Room[] availableRooms = hotel.getAvailableRooms();
        if (availableRooms.length == 0) {
            System.out.println("No rooms available.");
        } else {
            System.out.println("\n--- Available Rooms ---");
            for (Room room : availableRooms) {
                System.out.println(room);
            }
        }
    }

    public void viewReservation() {
        if (customer.getBookedRoom() == null) {
            System.out.println("No reservation found.");
        } else {
            System.out.println("\n--- Reservation Details ---");
            System.out.println(customer);
        }
    }

    public void cancelReservation() {
        if (customer.getBookedRoom() == null) {
            System.out.println("No reservation to cancel.");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Are you sure you want to cancel your reservation? (y/n): ");
            String confirmation = sc.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                customer.getBookedRoom().setAvailable(true);
                customer.clearBooking();
                System.out.println("Reservation cancelled.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        }
    }
}
