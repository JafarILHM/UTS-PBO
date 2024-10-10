package aplikasireservasihotel;

import java.util.Scanner;

public class RegisterService {
    private Hotel hotel;

    public RegisterService(Hotel hotel) {
        this.hotel = hotel;
    }


    public Customer handleCustomerRegistration() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your contact: ");
        String contact = sc.nextLine();
        Customer newCustomer = new Customer(name, contact);
        hotel.addCustomer(newCustomer);
        System.out.println("Registration successful! Your Customer ID: " + newCustomer.getCustomerId());
        return newCustomer;
    }
}
