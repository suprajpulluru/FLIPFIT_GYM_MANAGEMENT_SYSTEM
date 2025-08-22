package com.flipfit.dao;

import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;

public interface FlipFitUserDAO {
    public boolean authenticateUser(FlipFitUser user);

    public boolean registerCustomer(FlipFitCustomer customer);

    public boolean registerGymOwner(FlipFitGymOwner gymOwner);

}