package com.flipfit.client;

import java.util.Scanner;

public class AdminMenu {


    Scanner sc = new Scanner(System.in);


    public void viewAllPendingGymOwnerRequests() {
        System.out.println("Pending Gym Owner Requests are: ");
    }

    public void viewAllPendingGymRequests() {
        System.out.println("Pending Gym Requests are: ");
    }


    public void approveSingleGymOwnerRequest() {
        System.out.println("Gym Owner Request Approved");
    }

    public void approveSingleGymRequest() {
        System.out.println("Gym Request Approved");
    }

    public void approvePendingGymOwnerRequests() {
        System.out.println("Pending Gym Owner Requests are: ");
    }

    public void approvePendingGymRequests() {
        System.out.println("Pending Gym Requests are: ");
    }

    public void showAdminMenu() {
        System.out.println("");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1. View All Gym ");
            System.out.println("2. View All Gym Owners");
            System.out.println("3. View all pending Gym Owner Requests");
            System.out.println("4. View all pending Gym Requests");
            System.out.println("5. Approve all pending Gym Owner Requests");
            System.out.println("6. Approve all pending Gym Requests");
            System.out.println("7. Approve Single Gym Owner Request");
            System.out.println("8. Approve Single Gym Request");
            System.out.println("9. Add New Gym Owner");
            System.out.println("10. Remove Gym Owner"); // BONUS
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("All Gyms:");
                    break;
                case 2:
                    System.out.println("All Gym Owners:");
                    break;
                case 3:
                    viewAllPendingGymOwnerRequests();
                    break;
                case 4:
                    viewAllPendingGymRequests();
                    break;
                case 5:
                    approvePendingGymOwnerRequests();
                    break;
                case 6:
                    approvePendingGymRequests();
                    break;
                case 7:
                    approveSingleGymOwnerRequest();
                    break;
                case 8:
                    approveSingleGymRequest();
                    break;
                case 9:
                    addGymOwner();
                    break;
                case 10:
                    removeGymOwner(); // BONUS
                    break;
                case 11:
                    return;
            }
        }
    }

    public void addGymOwner() {
        System.out.println("\nEnter New Gym Owner Details:");
    }

    public void removeGymOwner() {
        System.out.println("\nEnter the email of the Gym Owner to remove:");
    }
}
