package aplikasireservasihotel;

import java.util.Scanner;

public class MainMenuService {
    private Hotel hotel;

    public MainMenuService(Hotel hotel) {
        this.hotel = hotel;
    }

    public void handleCustomerSession(Customer customer) {
        CustomerSession session = new CustomerSession(hotel, customer);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Book a room");
            System.out.println("2. Check availability");
            System.out.println("3. View reservation");
            System.out.println("4. Cancel reservation");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    session.bookRoom();
                    break;
                case 2:
                    session.checkAvailability();
                    break;
                case 3:
                    session.viewReservation();
                    break;
                case 4:
                    session.cancelReservation();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public void handleAdminSession() {
        AdminSession session = new AdminSession(hotel);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Customer Booking");
            System.out.println("2. Add Room");
            System.out.println("3. Remove Customer Booking");
            System.out.println("4. Remove Room");
            System.out.println("5. View Room Availability");
            System.out.println("6. View All Customer Reservations");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); 
                continue;
            }
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    session.addCustomerBooking();
                    break;
                case 2:
                    session.addRoom();
                    break;
                case 3:
                    session.removeCustomerBooking();
                    break;
                case 4:
                    session.removeRoom();
                    break;
                case 5:
                    session.viewRoomAvailability();
                    break;
                case 6:
                    session.viewAllReservations();
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
