package com.flipfit.client;

import java.util.Scanner;

public class GymOwnerMenu {

    public void registerGymOwner() {
        System.out.println("Gym Owner Registration Successful");
    }

    public void editProfile(Scanner in, String email) {
        System.out.println("Profile Edited Successfully!");
    }

    public void viewProfile(Scanner in, String email) {
        System.out.println("Profile Viewed Successfully!");
    }

    public void addGym(Scanner in, String email) {
        System.out.println("Gym Added Successfully!");
    }

    public void editGym(Scanner in, String email) {
        System.out.println("Gym Details Edited Successfully!");
    }



    public void getGymDetails(Scanner in, String email) {
        System.out.println("Gym Details Displayed Successfully!");

    }

    public void addSlot(Scanner in) {
        System.out.println("Slot Added Successfully!");
    }

    public void showOwnerMenu(String email) {
        Scanner in = new Scanner(System.in);

            System.out.println("\nHere are the actions you can perform!");

            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Add Gym");
            System.out.println("4. Edit Gym");
            System.out.println("5. Add Slot");
            System.out.println("6. View All Gym Details");
            System.out.println("7. Exit\n");

            System.out.print("Enter Your Choice: " );
            int choice = in.nextInt();


            switch (choice) {
                case 1:
                    viewProfile(in, email);
                    break;
                case 2:
                    editProfile(in, email);
                    break;
                case 3:
                    addGym(in, email);
                    break;
                case 4:
                    editGym(in, email);
                    break;
                case 5:
                    addSlot(in);
                    break;
                case 6:
                    getGymDetails(in, email);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

    }

}