package com.flipfit.dao;


/*
 *@Author : "Gaurav"
 *@ClassName: "FlipFitGymOwnerDAO"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.FlipFitGym, com.flipfit.bean.FlipFitGymOwner, java.util.List"
 */

import java.util.List;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitSlots;

public interface FlipFitGymOwnerDAO {
    public FlipFitGymOwner getGymOwnerDetails(String gymOwnerEmailId);

    public void editGymOwnerDetails(FlipFitGymOwner gymOwnerDetails);

    public FlipFitGym getGym(String gymId);

    public void addGym(FlipFitGym gymDetails);

    public void editGym(FlipFitGym gymDetails);

    public List<FlipFitGym> getGymsOfGymOwner(String gymOwnerId);

    public List<FlipFitSlots> getPossibleSlots(String gymId);

    public void addSlot(FlipFitSlots slot);

    public boolean checkOwnerApproval(String email);

    public boolean checkGymApproval(String gymId);

    public List<FlipFitSlots> fetchSlotsForGym(String gymId);
}