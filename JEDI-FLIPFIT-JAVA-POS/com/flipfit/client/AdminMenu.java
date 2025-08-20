package com.flipfit.client;

public class AdminMenu {

    private boolean isAuthenticated;
    private String currentMenuState;

    private FlipFitApplication flipFitApp;

    public AdminMenu(FlipFitApplication flipFitApp) {
        this.flipFitApp = flipFitApp;
        this.isAuthenticated = false;
        this.currentMenuState = "main";
    }


}
