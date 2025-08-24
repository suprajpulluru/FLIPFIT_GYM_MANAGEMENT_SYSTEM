package com.flipfit.business;


/*
 *@Author : "Akanksha"
 *@ClassName: "GymOwnerServiceInterface"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.GymOwnerServiceInterface"
 */
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;

import java.util.List;

public interface GymOwnerServiceInterface {

    public FlipFitGymOwner getGymOwnerDetails(String gymOwnerEmailId);
    public void editGymOwnerDetails(FlipFitGymOwner gymOwnerDetails);
    public FlipFitGym getGym(String gymId);
    public boolean addGym(FlipFitGym gymDetails);
    public void editGym(FlipFitGym gymDetails);
    public List<FlipFitGym> getGymsOfGymOwner(String ownerEmail);
    public void addSlot(FlipFitSlots slot);
    public boolean isOwnerApproved(String email);
    public boolean isGymApproved(String gymId);
    public List<FlipFitSlots> fetchSlotsForGym(String gymId);
}
