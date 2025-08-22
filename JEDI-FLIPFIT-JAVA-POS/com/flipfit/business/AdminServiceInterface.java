package com.flipfit.business;
/*
 *@Author : "Asmitha Gangoni"
 *@ClassName: "AdminServiceInterface"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.AdminServiceInterface"
 */
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
