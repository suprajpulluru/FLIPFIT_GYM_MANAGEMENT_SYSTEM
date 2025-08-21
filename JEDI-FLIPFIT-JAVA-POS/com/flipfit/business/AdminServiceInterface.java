package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface AdminServiceInterface {

    public List<FlipFitGymOwner> getGymOwners();
    public List<FlipFitGym> getGym();
    public List<FlipFitGymOwner> viewAllPendingGymOwnerRequests();
    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail);
    public boolean approveAllPendingGymOwnerRequests();
    public List<FlipFitGym> viewAllPendingGymRequests();
    public boolean approveSingleGymRequest(String gymId);
    public boolean approveAllPendingGymRequests();
}
