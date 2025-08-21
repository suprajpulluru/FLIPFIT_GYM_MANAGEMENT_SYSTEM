package com.flipfit.client;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.business.GymOwnerService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class GymOwnerMenu {

    private final GymOwnerService gymOwnerService = new GymOwnerService();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu(String gymOwnerEmail) {
        System.out.println("\nLogin Successful! Welcome, " + gymOwnerEmail);

        while (true) {
            System.out.println("\n--- Gym Owner Menu ---");
            System.out.println("1. View My Profile");
            System.out.println("2. Edit My Profile");
            System.out.println("3. View My Gyms");
            System.out.println("4. Register a New Gym");
            System.out.println("5. Edit a Gym's Details");
            System.out.println("6. Manage Slots for a Gym");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    viewProfile(gymOwnerEmail);
                    break;
                case 2:
                    editProfile(gymOwnerEmail);
                    break;
                case 3:
                    viewMyGyms(gymOwnerEmail);
                    break;
                case 4:
                    registerNewGym(gymOwnerEmail);
                    break;
                case 5:
                    editGymDetails(gymOwnerEmail);
                    break;
                case 6:
                    manageSlots(gymOwnerEmail);
                    break;
                case 7:
                    System.out.println("Logging you out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Unchanged methods...
    private void viewProfile(String email) {
        FlipFitGymOwner owner = gymOwnerService.getGymOwnerDetails(email);
        if (owner != null) {
            System.out.println("\n--- Your Profile ---");
            System.out.println("Name: " + owner.getName());
            System.out.println("Email: " + owner.getEmail());
            System.out.println("Phone Number: " + owner.getPhoneNumber());
            System.out.println("Aadhar Number: " + owner.getAadharNumber());
            System.out.println("PAN Number: " + owner.getPanNumber());
            System.out.println("Approval Status: " + (owner.isVerified() ? "Approved ✅" : "Pending ⏳"));
            System.out.println("--------------------");
        }
    }

    private void editProfile(String email) {
        FlipFitGymOwner owner = gymOwnerService.getGymOwnerDetails(email);
        if (owner == null) return;

        System.out.print("Enter new name (or press Enter to keep '" + owner.getName() + "'): ");
        String name = scanner.nextLine();
        if (!name.trim().isEmpty()) owner.setName(name);

        System.out.print("Enter new phone number (or press Enter to keep '" + owner.getPhoneNumber() + "'): ");
        String phoneNumber = scanner.nextLine();
        if (!phoneNumber.trim().isEmpty()) owner.setPhoneNumber(phoneNumber);

        System.out.print("Enter new Aadhar number (or press Enter to keep '" + owner.getAadharNumber() + "'): ");
        String aadhar = scanner.nextLine();
        if (!aadhar.trim().isEmpty()) owner.setAadharNumber(aadhar);

        System.out.print("Enter new PAN number (or press Enter to keep '" + owner.getPanNumber() + "'): ");
        String pan = scanner.nextLine();
        if (!pan.trim().isEmpty()) owner.setPanNumber(pan);

        gymOwnerService.editGymOwnerDetails(owner);
    }

    private void viewMyGyms(String ownerEmail) {
        List<FlipFitGym> gyms = gymOwnerService.getGymsOfGymOwner(ownerEmail);
        if (gyms.isEmpty()) {
            System.out.println("\n--> You have not registered any gyms yet.");
            return;
        }
        System.out.println("\n--- Your Registered Gyms ---");
        for (FlipFitGym gym : gyms) {
            System.out.println("ID: " + gym.getGymId() + " | Name: " + gym.getGymName() +
                    " | Address: " + gym.getAddress() +
                    " | Status: " + (gym.isVerified() ? "Approved ✅" : "Pending ⏳"));
        }
        System.out.println("--------------------------");
    }

    private void registerNewGym(String ownerEmail) {
        if (!gymOwnerService.isOwnerApproved(ownerEmail)) {
            System.out.println("\n❌ Your profile is not yet approved by the admin. You cannot add gyms.");
            return;
        }

        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();
        System.out.print("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();

        String gymId = "G-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();

        FlipFitGym newGym = new FlipFitGym(gymId, gymName, ownerEmail, gymAddress, 0, 0, false);
        gymOwnerService.addGym(newGym);
    }

    private void editGymDetails(String ownerEmail) {
        viewMyGyms(ownerEmail);
        System.out.print("Enter the Gym ID to edit: ");
        String gymId = scanner.nextLine();

        FlipFitGym gym = gymOwnerService.getGym(gymId);
        if (gym == null || !gym.getOwnerEmail().equals(ownerEmail)) {
            System.out.println("❌ Gym not found or you are not the owner.");
            return;
        }

        System.out.print("Enter new Gym Name (or press Enter to keep '" + gym.getGymName() + "'): ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) gym.setGymName(newName);

        System.out.print("Enter new Gym Address (or press Enter to keep '" + gym.getAddress() + "'): ");
        String newAddress = scanner.nextLine();
        if (!newAddress.trim().isEmpty()) gym.setAddress(newAddress);

        gymOwnerService.editGym(gym);
    }

    /**
     * This method has been updated to align with the new FlipFitSlots bean.
     */
    private void manageSlots(String ownerEmail) {
        viewMyGyms(ownerEmail);
        System.out.print("Enter the Gym ID to manage slots for: ");
        String gymId = scanner.nextLine();

        FlipFitGym gym = gymOwnerService.getGym(gymId);
        if (gym == null || !gym.getOwnerEmail().equals(ownerEmail)) {
            System.out.println("❌ Gym not found or you are not the owner.");
            return;
        }

        if (!gymOwnerService.isGymApproved(gymId)) {
            System.out.println("\n❌ This gym is not yet approved. You cannot manage slots.");
            return;
        }

        System.out.println("\n--- Slot Management for Gym: " + gym.getGymName() + " ---");
        List<FlipFitSlots> slots = gymOwnerService.fetchSlotsForGym(gymId);
        if (slots.isEmpty()) {
            System.out.println("No slots have been added for this gym yet.");
        } else {
            System.out.println("Existing Slots:");
            // UPDATED display logic to match new bean fields
            slots.forEach(s -> System.out.println("  -> Start: " + s.getStartTime() + ", End: " + s.getEndTime() + ", Seats: " + s.getNumOfSeats() +
                    ", Booked: " + s.getNumOfSeatsBooked() + ", Trainer: " + s.getTrainer()));
        }

        System.out.println("\n-- Add a New Slot --");
        try {
            // UPDATED prompts to match new bean fields
            System.out.print("Enter Start Time (e.g., 09:00): ");
            String startTime = scanner.nextLine();
            System.out.print("Enter End Time (e.g., 10:00): ");
            String endTime = scanner.nextLine();
            System.out.print("Enter Trainer Name: ");
            String trainer = scanner.nextLine();
            System.out.print("Enter Number of Seats: ");
            int numOfSeats = Integer.parseInt(scanner.nextLine());

            // UPDATED constructor call to match new bean
            // Assumes a new slot has 0 seats booked initially
            FlipFitSlots newSlot = new FlipFitSlots(null, gymId, startTime, endTime, trainer, numOfSeats, 0);
            gymOwnerService.addSlot(newSlot);

        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid seat count. Please enter a number.");
        }
    }
}