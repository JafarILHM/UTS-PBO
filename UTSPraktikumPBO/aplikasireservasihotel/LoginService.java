package aplikasireservasihotel;

import java.util.Scanner;

public class LoginService {
    private Hotel hotel;

    public LoginService(Hotel hotel) {
        this.hotel = hotel;
    }

    public Customer handleCustomerLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Customer customer = hotel.findCustomerByName(name);
        if (customer == null) {
            System.out.println("Customer not found. Please register first.");
            return null;
        } else {
            System.out.println("Login successful! Welcome, " + customer.getName());
            return customer;
        }
    }

    public Admin handleAdminLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter admin name: ");
        String adminName = sc.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = sc.nextLine();

        Admin admin = new Admin();
        if (admin.authenticate(adminName, adminPassword)) {
            System.out.println("Admin login successful!");
            return admin;
        } else {
            System.out.println("Invalid admin credentials.");
            return null;
        }
    }
}
