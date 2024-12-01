package pwr.jp.radionenko.ui;

import pwr.jp.radionenko.service.OfferService;
import pwr.jp.radionenko.service.SellerService;

import java.util.Scanner;

public class SellerApp {

    private static final SellerService sellerService = new SellerService();
    private static final OfferService offerService = new OfferService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Seller Application!");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View all offers");
            System.out.println("2. Add new offer");
            System.out.println("3. Approve Order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewOffers();
                case 2 -> addOffers();
                case 3 -> approveOrder();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewOffers() {
        System.out.println("Our offers: ");
        sellerService.getOrdersForApproval().forEach(System.out::println);
    }


    private static void approveOrder() {
        sellerService.getOrdersForApproval().forEach(System.out::println);
        System.out.print("Enter Order ID to Approve: ");
        int orderId = scanner.nextInt();
        sellerService.approveOrder(orderId);
        System.out.println("Order ID " + orderId + " approved successfully.");
    }

    private static void addOffers() {
        System.out.print("Add new offer (name, description, price): ");
        String name = scanner.nextLine();
        String description = scanner.nextLine();
        double price = scanner.nextDouble();
        offerService.addOffer(name, description, price);
        System.out.println("Offer added!");
    }

}


