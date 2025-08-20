package com.flipfit.client;

import com.flipfit.bean.FlipFitGymOwner;

public class GymOwnerMenu {

    private FlipFitGymOwner gymOwner;
    private boolean isAuthenticated;
    private String currentMenuState;

    public GymOwnerMenu(FlipFitGymOwner gymOwner) {
        this.gymOwner = gymOwner;
        this.isAuthenticated = false;
        this.currentMenuState = "main";
    }
}