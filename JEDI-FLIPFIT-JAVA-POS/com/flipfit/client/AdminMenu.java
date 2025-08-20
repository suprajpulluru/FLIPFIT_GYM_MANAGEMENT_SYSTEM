package com.flipfit.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.AdminService;
import com.flipfit.dao.FlipFitUserDAOImpl;
import com.flipfit.dao.collection.FlipFitData;


public class AdminMenu {
    private final AdminService adminService = new AdminService();
    private final FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
    private final Scanner scanner = new Scanner(System.in);

    public void viewAllGyms() {
        System.out.println("--- All Gyms ---");
        List<FlipFitGym> gyms = adminService.getGym();
        if (gyms.isEmpty()) {
            System.out.println("No gyms found.");
        } else {
            gyms.forEach(System.out::println);
        }
    }

    public void viewAllGymOwners() {
        System.out.println("--- All Gym Owners ---");
        List<FlipFitGymOwner> gymOwners = adminService.getGymOwners();
        if (gymOwners.isEmpty()) {
            System.out.println("No gym owners found.");
        } else {
            gymOwners.forEach(owner -> {
                System.out.println("Name: " + owner.getName() + ", Email: " + owner.getEmail() + ", Verified: " + owner.isVerified());
            });
        }
    }

    public void viewAllPendingGymOwnerRequests() {
        System.out.println("--- Pending Gym Owner Requests ---");
        List<FlipFitGymOwner> pendingRequests = adminService.viewAllPendingGymOwnerRequests();
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending gym owner requests.");
        } else {
            pendingRequests.forEach(owner -> {
                System.out.println("Name: " + owner.getName() + ", Email: " + owner.getEmail());
            });
        }
    }

    public void viewAllPendingGymRequests() {
        System.out.println("--- Pending Gym Requests ---");
        List<FlipFitGym> pendingRequests = adminService.viewAllPendingGymRequests();
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending gym requests.");
        } else {
            pendingRequests.forEach(gym -> {
                System.out.println("Gym Name: " + gym.getGymName() + ", Gym ID: " + gym.getGymId() + ", Owner: " + gym.getOwnerEmail());
            });
        }
    }


    public void approveSingleGymOwnerRequest() {
        System.out.print("Enter Gym Owner Email to approve: ");
        String email = scanner.next();
        adminService.approveSingleGymOwnerRequest(email);
    }

    public void approveSingleGymRequest() {
        System.out.print("Enter Gym ID to approve: ");
        String gymId = scanner.next();
        adminService.approveSingleGymRequest(gymId);
    }

    public void approveAllPendingGymOwnerRequests() {
        adminService.approveAllPendingGymOwnerRequests();
    }

    public void approveAllPendingGymRequests() {
        adminService.approveAllPendingGymRequests();
    }

    public void addGymOwner() {
        System.out.println("\n--- Add New Gym Owner ---");
        System.out.print("Enter Email: ");
        String email = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.print("Enter Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter Aadhar Number: ");
        String aadhar = scanner.next();
        System.out.print("Enter PAN Number: ");
        String pan = scanner.next();

        FlipFitGymOwner newOwner = new FlipFitGymOwner(email, password, "GymOwner", name, phoneNumber, aadhar, pan);
        if (userDAO.registerGymOwner(newOwner)) {
            System.out.println("New Gym Owner registered successfully. Awaiting admin approval.");
        } else {
            System.out.println("Registration failed. Email might already be in use.");
        }
    }

    public void showAdminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Gyms");
            System.out.println("2. View All Gym Owners");
            System.out.println("3. View All Pending Gym Owner Requests");
            System.out.println("4. View All Pending Gym Requests");
            System.out.println("5. Approve All Pending Gym Owner Requests");
            System.out.println("6. Approve All Pending Gym Requests");
            System.out.println("7. Approve Single Gym Owner Request");
            System.out.println("8. Approve Single Gym Request");
            System.out.println("9. Add New Gym Owner");
            System.out.println("10. Exit");

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        viewAllGyms();
                        break;
                    case 2:
                        viewAllGymOwners();
                        break;
                    case 3:
                        viewAllPendingGymOwnerRequests();
                        break;
                    case 4:
                        viewAllPendingGymRequests();
                        break;
                    case 5:
                        approveAllPendingGymOwnerRequests();
                        break;
                    case 6:
                        approveAllPendingGymRequests();
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
                        System.out.println("Exiting Admin Menu.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }
    }
}