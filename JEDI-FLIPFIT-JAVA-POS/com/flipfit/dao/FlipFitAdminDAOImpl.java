package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.dao.collection.FlipFitData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/*
 *@Author : "Dhara Periwal"
 *@ClassName: "FlipFitAdminDAOImpl"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.FlipFitGym, com.flipfit.bean.FlipFitGymOwner, java.util.List"
 */

public class FlipFitAdminDAOImpl implements FlipFitAdminDAO {
    public List<FlipFitGymOwner> getAllGymOwners() {
        return new ArrayList<>(FlipFitData.gymOwnerMap.values());
    }

    public List<FlipFitGym> getAllGyms() {
        return new ArrayList<>(FlipFitData.gymMap.values());
    }

    public List<FlipFitGymOwner> getPendingGymOwnerRequests() {
        return FlipFitData.gymOwnerMap.values().stream()
                .filter(owner -> !owner.isVerified())
                .collect(Collectors.toList());
    }

    public List<FlipFitGym> getPendingGymRequests() {
        return FlipFitData.gymMap.values().stream()
                .filter(gym -> !gym.isVerified())
                .collect(Collectors.toList());
    }

    public boolean approveSingleOwnerRequest(String gymOwnerEmail) {
        FlipFitGymOwner owner = FlipFitData.gymOwnerMap.get(gymOwnerEmail);
        if (owner != null) {
            owner.setVerified(true);
            System.out.println("Gym owner " + gymOwnerEmail + " has been approved.");
            return true; // Return true on success
        } else {
            System.out.println("Gym owner not found: " + gymOwnerEmail);
            return false; // Return false on failure
        }
    }

    public void approveAllOwnerRequest() {
        FlipFitData.gymOwnerMap.values().forEach(owner -> {
            if (!owner.isVerified()) {
                owner.setVerified(true);
            }
        });
        System.out.println("All pending gym owner requests have been approved.");
    }

    public void approveSingleGymRequest(String gymId) {
        FlipFitGym gym = FlipFitData.gymMap.get(gymId);
        if (gym != null) {
            gym.setVerified(true);
            System.out.println("Gym " + gymId + " has been approved.");
        } else {
            System.out.println("Gym not found: " + gymId);
        }
    }

    public void approveAllGymRequest() {
        FlipFitData.gymMap.values().forEach(gym -> {
            if (!gym.isVerified()) {
                gym.setVerified(true);
            }
        });
        System.out.println("All pending gym requests have been approved.");
    }
}