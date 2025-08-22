package com.flipfit.business;

/*
 *@Author : "Dhara Periwal"
 *@ClassName: "AdminService"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.AdminService"
 */
import java.util.*;

import com.flipfit.dao.FlipFitAdminDAOImpl;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitGymOwner;

public class AdminService implements AdminServiceInterface{
    FlipFitAdminDAOImpl adminDAO = new FlipFitAdminDAOImpl();

    public List<FlipFitGymOwner> getGymOwners() {
        System.out.println("Fetched gym owner details successfully!");
        return adminDAO.getAllGymOwners();
    }

    public List<FlipFitGym> getGym() {
        System.out.println("Fetched gym details successfully!");
        return adminDAO.getAllGyms();
    }

    public List<FlipFitGymOwner> viewAllPendingGymOwnerRequests() {
        System.out.println("Fetched pending gym owner details successfully!");
        return adminDAO.getPendingGymOwnerRequests();
    }

    public boolean approveSingleGymOwnerRequest(String gymOwnerEmail) {
        boolean success = adminDAO.approveSingleOwnerRequest(gymOwnerEmail);
        if(success) {
            System.out.println("Approved gym owner request! " + gymOwnerEmail);
        } else {
            System.out.println("Failed to approve gym owner request! " + gymOwnerEmail);
        }
        return success;
    }

    public boolean approveAllPendingGymOwnerRequests() {
        adminDAO.approveAllOwnerRequest();
        System.out.println("Approved all pending gym owner requests!");
        return true;
    }

    public List<FlipFitGym> viewAllPendingGymRequests() {
        System.out.println("Fetched pending gym requests successfully!");
        return adminDAO.getPendingGymRequests();
    }

    public boolean approveSingleGymRequest(String gymId) {
        adminDAO.approveSingleGymRequest(gymId);
        System.out.println("Successfully approved gym request! " + gymId);
        return true;
    }

    public boolean approveAllPendingGymRequests() {
        adminDAO.approveAllGymRequest();
        System.out.println("Successfully approved all pending gym requests!");
        return true;
    }
}