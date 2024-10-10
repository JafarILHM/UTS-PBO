package aplikasireservasihotel;

import java.util.Scanner;

public class HotelReservationApp {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginService(hotel);
        RegisterService registerService = new RegisterService(hotel);
        MainMenuService mainMenuService = new MainMenuService(hotel);

        while (true) {
            System.out.println("\n=== Welcome to Hotel Seadanya Reservation System ===");
            System.out.println("1. Customer");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
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
                    System.out.println("\n--- Customer Menu ---");
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.print("Enter your choice: ");
                    int customerChoice = -1;
                    try {
                        customerChoice = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.next(); 
                        continue;
                    }
                    sc.nextLine(); 

                    switch (customerChoice) {
                        case 1:
                            Customer customer = loginService.handleCustomerLogin();
                            if (customer != null) {
                                mainMenuService.handleCustomerSession(customer);
                            }
                            break;
                        case 2:
                            Customer newCustomer = registerService.handleCustomerRegistration();
                            mainMenuService.handleCustomerSession(newCustomer);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    Admin admin = loginService.handleAdminLogin();
                    if (admin != null) {
                        mainMenuService.handleAdminSession();
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
