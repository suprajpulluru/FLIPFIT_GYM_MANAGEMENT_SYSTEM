package com.flipfit.client;

import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.UserService;

import java.util.Scanner;

public class FlipFitApplication {

    public static void login(){
        System.out.println("\nChoose a role: ");
        System.out.println("1. Admin");
        System.out.println("2. FlipFitCustomer");
        System.out.println("3. FlipFitGymOwner");

        Scanner sc = new Scanner(System.in);
        String role = "";
        boolean roleChosen = false;

        int roleChoice = sc.nextInt();

        switch (roleChoice){
            case 1:
                role = "Admin";
                roleChosen = true;
                break;
            case 2:
                role = "FlipFitCustomer";
                roleChosen = true;
                break;
            case 3:
                role = "FlipFitGymOwner";
                roleChosen = true;
                break;
            default:
                System.out.println("Invalid choice.");
                break;

        }


        if(roleChosen) {
            System.out.println("Enter email: ");
            String email = sc.next();
            System.out.println("Enter password: ");
            String password = sc.next();

            FlipFitUser user = new FlipFitUser(email, password, role);
            UserService userService = new UserService();

            if(userService.authenticateUser(user)){
                System.out.println("\nWelcome " + email + "! You are logged in.");

                if (role.equalsIgnoreCase("Admin")) {
                    AdminMenu admin = new AdminMenu();
                    admin.showAdminMenu();
                } else if (role.equalsIgnoreCase("Customer")) {
                    CustomerMenu customer = new CustomerMenu();
                    customer.showCustomerMenu(email);
                } else if (role.equalsIgnoreCase("GymOwner")) {
                    GymOwnerMenu gymOwner = new GymOwnerMenu();
                    gymOwner.showOwnerMenu(email);
                }
            }
            else {
                System.out.println("Login failed. Please check your credentials and role.");
                login();
            }

        }


    }

    public static void applicationMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to FlipFit Application!");

        boolean retry = true;

        while(retry){
            System.out.println("Please enter your choice:");
            System.out.println("1. Login");
            System.out.println("2. GymCustomerRegister");
            System.out.println("3. GymOwnerRegister");
            System.out.println("4. Exit!");

            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    login();
                    retry = false;
                    break;
                case 2:
                    CustomerMenu customer = new CustomerMenu();
                    customer.registerCustomer();
                    login();
                    retry = false;
                    break;
                case 3:
                    GymOwnerMenu gymOwner = new GymOwnerMenu();
                    gymOwner.registerGymOwner();
                    login();
                    retry = false;
                    break;
                case 4:
                    retry = false;
                    System.out.println("Thanks for stopping by!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }

    }

    public static void main(String[] args){
        applicationMenu();
    }
}
