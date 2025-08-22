package com.flipfit.business;

import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;
import com.flipfit.dao.FlipFitGymOwnerDAOImpl;
import com.flipfit.dao.FlipFitUserDAOImpl;

public class UserService {

    FlipFitGymOwnerDAOImpl gymOwnerDao = new FlipFitGymOwnerDAOImpl();
    FlipFitUserDAOImpl userDao = new FlipFitUserDAOImpl();

    public boolean registerCustomer(FlipFitCustomer customer) {
        boolean registerSuccess = false;
        registerSuccess = userDao.registerCustomer(customer);
        return registerSuccess;
    }

    public boolean registerGymOwner(FlipFitGymOwner gymOwner) {
        boolean registerSuccess = false;
        registerSuccess = userDao.registerGymOwner(gymOwner);
        return registerSuccess;
    }

    public boolean authenticateUser(FlipFitUser user) {
        boolean authenticateSuccess = false;
        authenticateSuccess = userDao.authenticateUser(user);
        return authenticateSuccess;
    }

    public boolean logout(FlipFitUser user) {
        return true;
    }
}