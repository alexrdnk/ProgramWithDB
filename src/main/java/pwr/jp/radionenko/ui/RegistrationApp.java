package pwr.jp.radionenko.ui;

import pwr.jp.radionenko.service.UserService;

import java.util.Scanner;

public class RegistrationApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sign in");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        boolean success = userService.registerUser(username, password, name);
        if (success) {
            System.out.println("Congratulations! Your account has been added!");
        } else {
            System.out.println("Sorry, error!");
        }

        scanner.close();
    }
}


