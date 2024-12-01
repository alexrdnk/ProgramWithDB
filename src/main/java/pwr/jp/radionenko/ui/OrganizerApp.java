package pwr.jp.radionenko.ui;

import pwr.jp.radionenko.service.OrderService;
import pwr.jp.radionenko.service.OrganizerService;

import java.util.Scanner;

public class OrganizerApp {

    private static final OrganizerService organizerService = new OrganizerService();
    private static final OrderService orderService = new OrderService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Organizer Application!");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View Orders to Realize");
            System.out.println("2. Confirm Orders");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewOrdersToRealize();
                case 2 -> confirmParticipants();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void confirmParticipants() {
        viewOrdersToRealize();
        System.out.print("Enter order ID to realization: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new date of realization (YYYY-MM-DD): ");
        String realizationDate = scanner.nextLine();
        orderService.setRealizationDate(orderId, realizationDate);
        organizerService.confirmParticipants(orderId);
        System.out.println("Order status has been updated!");
    }

    private static void viewOrdersToRealize() {
        System.out.println("Orders Waiting for Realization:");
        organizerService.getOrdersToRealize().forEach(System.out::println);
    }

}

