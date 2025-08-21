package com.flipfit.dao;

import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;

import static com.flipfit.dao.collection.FlipFitData.userMap;

public class FlipFitUserDAOImpl implements FlipFitUserDAO {

    public boolean authenticateUser(FlipFitUser user) {
        boolean isUserValid = false;

        if (user.getPassword().equals("admin123") && user.getRoleId().equalsIgnoreCase("Admin")) {
            System.out.println(user.getEmail() + " " + user.getPassword() + " " + "Admin");
            isUserValid = true;
        }
        else if (user.getPassword().equals("customer123") && user.getRoleId().equalsIgnoreCase("FlipFitCustomer")) {
            System.out.println(user.getEmail() + " " + user.getPassword() + " " + "Customer");
            isUserValid = true;
        }
        else if (user.getPassword().equals("gymowner123") && user.getRoleId().equalsIgnoreCase("FlipFitGymOwner")) {
            System.out.println(user.getEmail() + " " + user.getPassword() + " " + "Owner");
            isUserValid = true;
        }

        return isUserValid;
    }

    public boolean registerCustomer(FlipFitCustomer customer) {
        userMap.put(customer.getEmail(), customer);
        return true;
    }

    public boolean registerGymOwner(FlipFitGymOwner gymOwner) {

        userMap.put(gymOwner.getEmail(), gymOwner);
        return true;
    }

}