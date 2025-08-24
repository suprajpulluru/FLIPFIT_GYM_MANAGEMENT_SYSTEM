package com.flipfit.business;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.FlipFitGymOwnerDAO;
import com.flipfit.dao.FlipFitGymOwnerDAOImpl;

import java.util.List;



/*
 *@Author : "Harshita Kanwar"
 *@ClassName: "GymOwnerService"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.GymOwnerService"
 */
/**
 * Service class for Gym Owner operations.
 * This class handles the business logic by interacting with the DAO layer.
 */
public class GymOwnerService implements GymOwnerServiceInterface {

    // Using the interface for declaration, but instantiating the implementation
    private final FlipFitGymOwnerDAOImpl gymOwnerDAO = new FlipFitGymOwnerDAOImpl();

    public FlipFitGymOwner getGymOwnerDetails(String gymOwnerEmailId) {
        System.out.println("Fetching details for gym owner: " + gymOwnerEmailId);
        return gymOwnerDAO.getGymOwnerDetails(gymOwnerEmailId);
    }

    public void editGymOwnerDetails(FlipFitGymOwner gymOwnerDetails) {
        gymOwnerDAO.editGymOwnerDetails(gymOwnerDetails);
        System.out.println("Successfully updated details for: " + gymOwnerDetails.getEmail());
    }

    public FlipFitGym getGym(String gymId) {
        System.out.println("Fetching details for gym: " + gymId);
        return gymOwnerDAO.getGym(gymId);
    }

    public boolean addGym(FlipFitGym gymDetails) {
        gymOwnerDAO.addGym(gymDetails);
        System.out.println("Successfully added a new gym with ID: " + gymDetails.getGymId());
        return true;
    }

    public void editGym(FlipFitGym gymDetails) {
        gymOwnerDAO.editGym(gymDetails);
        System.out.println("Successfully updated details for gym: " + gymDetails.getGymId());
    }

    public List<FlipFitGym> getGymsOfGymOwner(String ownerEmail) {
        System.out.println("Fetching all gyms for owner: " + ownerEmail);
        return gymOwnerDAO.getGymsOfGymOwner(ownerEmail);
    }

    public void addSlot(FlipFitSlots slot) {
        gymOwnerDAO.addSlot(slot);
        System.out.println("Successfully added a new slot for gym ID: " + slot.getGymId());
    }

    public boolean isOwnerApproved(String email) {
        return gymOwnerDAO.checkOwnerApproval(email);
    }

    public boolean isGymApproved(String gymId) {
        return gymOwnerDAO.checkGymApproval(gymId);
    }

    public List<FlipFitSlots> fetchSlotsForGym(String gymId) {
        System.out.println("Fetching all slots for gym: " + gymId);
        return gymOwnerDAO.fetchSlotsForGym(gymId);
    }
}