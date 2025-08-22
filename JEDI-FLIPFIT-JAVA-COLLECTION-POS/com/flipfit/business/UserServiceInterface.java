package com.flipfit.business;

import com.flipfit.bean.*;
import java.util.*;


/*
 *@Author : "Asmitha gangoni"
 *@ClassName: "UserServiceInterface"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.UserServiceInterface"
 */
public interface UserServiceInterface {

    public boolean registerCustomer(FlipFitCustomer customer);
    public boolean registerGymOwner(FlipFitGymOwner gymOwner);
    public boolean authenticateUser(FlipFitUser user);
    public boolean logout(FlipFitUser user);

}
