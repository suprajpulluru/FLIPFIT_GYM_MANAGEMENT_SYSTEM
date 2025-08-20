package com.flipfit.client;

import java.util.Scanner;

public class CustomerMenu {

    Scanner sc = new Scanner(System.in);

    public void registerCustomer() {
        System.out.println("Customer registered successfully!");

    }

    public void viewGyms(String email)  {
        System.out.println("Gyms are: ");
    }


    public void editProfile(String email) {
        System.out.println("Successfully edited your profile.");
    }



    public void getGyms() {
        System.out.println("Gyms are: ");
    }


    public void cancelBooking(String email) {
        System.out.println("Booking cancelled");
    }

    public void showCustomerMenu(String email) {
        int choice = 0;

        while (choice != 5) {
            System.out.println("Menu:-");
            System.out.println("1.Search Gyms \n2.View Booked Slots \n3.Cancel Booked Slots \n4.Edit Profile \n5.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewGyms(email);
                    break;
                case 2:
                    System.out.println("Booked slots are: ");
                    break;
                case 3:
                    cancelBooking(email);
                    break;
                case 4:
                    editProfile(email);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
