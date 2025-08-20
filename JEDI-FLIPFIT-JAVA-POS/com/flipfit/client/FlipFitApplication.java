package com.flipfit.client;

import com.flipfit.business.UserService;

import java.util.Scanner;

public class FlipFitApplication {

    public static void login(){
        System.out.println("Choose a role: ");
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

        }


        if(roleChosen) {
            System.out.println("Enter username: ");
            String username = sc.next();
            System.out.println("Enter password: ");
            String password = sc.next();

//            UserService userService = new UserService();
//            userService.loginUser(username, password, role);
//            above lines will take care of logging the user in
            System.out.println("logged in successfully!");
            AdminMenu adminMenu;
            CustomerMenu customerMenu;
            GymOwnerMenu gymOwnerMenu;
            if (role == "Admin") {
                adminMenu = new AdminMenu();
                adminMenu.showAdminMenu();
            }
            else if (role == "FlipFitCustomer") {
                customerMenu = new CustomerMenu();
                customerMenu.showCustomerMenu(username);
            }
            else{
                gymOwnerMenu = new GymOwnerMenu();
                gymOwnerMenu.showOwnerMenu(username);
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
