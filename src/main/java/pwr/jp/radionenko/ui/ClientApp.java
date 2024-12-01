package pwr.jp.radionenko.ui;

import pwr.jp.radionenko.model.Offer;
import pwr.jp.radionenko.model.Order;
import pwr.jp.radionenko.service.OfferService;
import pwr.jp.radionenko.service.OrderService;
import pwr.jp.radionenko.service.UserService;

import java.util.List;
import java.util.Scanner;

public class ClientApp {

    private static final OfferService offerService = new OfferService();
    private static final OrderService orderService = new OrderService();
    private static final UserService userService = new UserService();
    private static int loggedInUserId = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Client Application!");

        // Step 1: Login
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            System.out.println("Please log in to access the application.");
            System.out.print("Username: ");
            String username = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();

            int userId = userService.authenticateUser(username, password);
            if (userId > 0) {
                loggedInUserId = userId;
                isAuthenticated = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        System.out.println("Login successful! Welcome to the Client Application.");

        // Step 2: Menu
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View All Offers");
            System.out.println("2. Place an Order");
            System.out.println("3. View My Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewAllOffers();
                case 2 -> placeOrder(scanner);
                case 3 -> viewMyOrders();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewAllOffers() {
        List<Offer> offers = offerService.getAllOffers();
        System.out.println("Available Offers:");
        offers.forEach(System.out::println);
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter the Offer ID: ");
        int offerId = scanner.nextInt();
        orderService.placeOrder(loggedInUserId, offerId);
        System.out.println("Order placed successfully!");
    }

    private static void viewMyOrders() {
        List<Order> orders = orderService.getOrdersByClientId(loggedInUserId);
        if (orders.isEmpty()) {
            System.out.println("You have no orders.");
        } else {
            System.out.println("Your Orders:");
            orders.forEach(System.out::println);
        }
    }
}



