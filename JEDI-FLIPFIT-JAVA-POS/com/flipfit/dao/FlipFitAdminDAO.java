package com.flipfit.dao;

import java.util.List;

import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;

public interface FlipFitAdminDAO {
    public List<FlipFitGymOwner> getAllGymOwners();

    public List<FlipFitGym> getAllGyms();

    public List<FlipFitGymOwner> getPendingGymOwnerRequests();

    public List<FlipFitGym> getPendingGymRequests();

    public boolean approveSingleOwnerRequest(String gymOwnerEmail);

    public void approveAllOwnerRequest();

    public void approveSingleGymRequest(String gymId);

    public void approveAllGymRequest();

}