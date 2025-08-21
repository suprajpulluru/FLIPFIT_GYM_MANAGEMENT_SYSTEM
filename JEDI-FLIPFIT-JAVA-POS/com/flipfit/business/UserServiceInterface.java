package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;

public interface UserServiceInterface {

    public boolean registerCustomer(FlipFitCustomer customer);
    public boolean registerGymOwner(FlipFitGymOwner gymOwner);
    public boolean authenticateUser(FlipFitUser user);
    public boolean logout(FlipFitUser user);

}
