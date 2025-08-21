package com.flipfit.business;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;

import java.util.List;

public interface GymOwnerServiceInterface {

    public FlipFitGymOwner getGymOwnerDetails(String gymOwnerEmailId);
    public void editGymOwnerDetails(FlipFitGymOwner gymOwnerDetails);
    public FlipFitGym getGym(String gymId);
    public void addGym(FlipFitGym gymDetails);
    public void editGym(FlipFitGym gymDetails);
    public List<FlipFitGym> getGymsOfGymOwner(String gymOwnerId);
    public void addSlot(FlipFitSlots slot);
    public boolean isOwnerApproved(String email);
    public boolean isGymApproved(String gymId);
    public List<FlipFitSlots> fetchSlotsForGym(String gymId);
}
