package com.flipfit.dao;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.collection.FlipFitData;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of FlipFitGymOwnerDAO interface.
 * This class provides the concrete logic for all operations
 * a gym owner can perform, interacting with the in-memory data store.
 */
public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAO {

    @Override
    public FlipFitGymOwner getGymOwnerDetails(String gymOwnerEmailId) {
        return FlipFitData.gymOwnerMap.get(gymOwnerEmailId);
    }

    @Override
    public void editGymOwnerDetails(FlipFitGymOwner gymOwnerDetails) {
        // The put method updates the value if the key already exists.
        FlipFitData.gymOwnerMap.put(gymOwnerDetails.getEmail(), gymOwnerDetails);
    }

    @Override
    public FlipFitGym getGym(String gymId) {
        return FlipFitData.gymMap.get(gymId);
    }

    @Override
    public void addGym(FlipFitGym gymDetails) {
        FlipFitData.gymMap.put(gymDetails.getGymId(), gymDetails);
    }

    @Override
    public void editGym(FlipFitGym gymDetails) {
        // The put method updates the value if the key already exists.
        FlipFitData.gymMap.put(gymDetails.getGymId(), gymDetails);
    }

    @Override
    public List<FlipFitGym> getGymsOfGymOwner(String gymOwnerId) {
        return FlipFitData.gymMap.values().stream()
                .filter(gym -> gym.getOwnerEmail().equals(gymOwnerId))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlipFitSlots> getPossibleSlots(String gymId) {
        // This method can be implemented to return available time slots,
        // but for now, it mirrors fetchSlotsForGym.
        return fetchSlotsForGym(gymId);
    }

    @Override
    public void addSlot(FlipFitSlots slot) {
        // Generate a unique ID for the slot before adding
        String slotId = UUID.randomUUID().toString();
        slot.setSlotId(slotId);
        FlipFitData.slotMap.put(slotId, slot);
    }

    @Override
    public boolean checkOwnerApproval(String email) {
        FlipFitGymOwner owner = FlipFitData.gymOwnerMap.get(email);
        // Return true only if the owner exists and is verified.
        return owner != null && owner.isVerified();
    }

    @Override
    public boolean checkGymApproval(String gymId) {
        FlipFitGym gym = FlipFitData.gymMap.get(gymId);
        // Return true only if the gym exists and is verified.
        return gym != null && gym.isVerified();
    }

    @Override
    public List<FlipFitSlots> fetchSlotsForGym(String gymId) {
        return FlipFitData.slotMap.values().stream()
                .filter(slot -> slot.getGymId().equals(gymId))
                .collect(Collectors.toList());
    }
}