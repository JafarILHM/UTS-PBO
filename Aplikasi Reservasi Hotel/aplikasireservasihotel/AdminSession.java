package aplikasireservasihotel;

import java.util.Scanner;

class AdminSession implements AdminActions {
    private Hotel hotel;

    public AdminSession(Hotel hotel) {
        this.hotel = hotel;
    }

    public void addCustomerBooking() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();
            System.out.print("Enter customer contact: ");
            String contact = sc.nextLine();
            Customer customer = new Customer(name, contact);
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
            hotel.addCustomer(customer);
            System.out.println("Customer booking added successfully! Customer ID: " + customer.getCustomerId());
        } catch (Exception e) {
            System.out.println("Error in adding customer booking. Please try again.");
            sc.nextLine(); 
        }
    }
    
    public void addRoom() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter room number: ");
            int roomNumber = sc.nextInt();
            sc.nextLine(); 
            if (hotel.findRoomByNumber(roomNumber) != null) {
                System.out.println("Room with this number already exists.");
                return;
            }
            System.out.print("Enter room type (Suite/Deluxe): ");
            String roomType = sc.nextLine();
            System.out.print("Enter room price: ");
            double price = sc.nextDouble();
            sc.nextLine(); 
            Room room = new Room(roomNumber, roomType, price, true);
            hotel.addRoom(room);
            System.out.println("Room added successfully!");
        } catch (Exception e) {
            System.out.println("Error in adding room. Please try again.");
            sc.nextLine(); 
        }
    }

    public void removeCustomerBooking() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Customer ID to remove booking: ");
            int customerId = sc.nextInt();
            sc.nextLine(); 
            Customer customer = hotel.findCustomerById(customerId);
            if (customer == null) {
                System.out.println("Customer not found.");
                return;
            }
            if (customer.getBookedRoom() != null) {
                customer.getBookedRoom().setAvailable(true);
            }
            hotel.removeCustomer(customer);
            System.out.println("Customer booking removed successfully.");
        } catch (Exception e) {
            System.out.println("Error in removing customer booking. Please try again.");
            sc.nextLine(); 
        }
    }

    public void removeRoom() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Room Number to remove: ");
            int roomNumber = sc.nextInt();
            sc.nextLine(); 
            Room room = hotel.findRoomByNumber(roomNumber);
            if (room == null) {
                System.out.println("Room not found.");
                return;
            }
            if (!room.isAvailable()) {
                System.out.println("Cannot remove a booked room.");
                return;
            }
            hotel.removeRoom(room);
            System.out.println("Room removed successfully.");
        } catch (Exception e) {
            System.out.println("Error in removing room. Please try again.");
            sc.nextLine(); 
        }
    }

    public void viewRoomAvailability() {
        System.out.println("\n--- Room Availability ---");
        for (Room room : hotel.getAllRooms()) {
            System.out.println(room);
        }
    }

    public void viewAllReservations() {
        System.out.println("\n--- All Customer Reservations ---");
        for (Customer customer : hotel.getAllCustomers()) {
            if (customer.getBookedRoom() != null) {
                System.out.println(customer);
            }
        }
    }
}
