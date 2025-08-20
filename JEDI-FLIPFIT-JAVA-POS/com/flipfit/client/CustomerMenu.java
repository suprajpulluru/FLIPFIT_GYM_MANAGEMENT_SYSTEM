package com.flipfit.client;

import com.flipfit.bean.FlipFitCustomer;

public class CustomerMenu {

    private FlipFitCustomer customer;
    private boolean isAuthenticated;
    private String currentMenuState;

    public CustomerMenu(FlipFitCustomer customer) {
        this.customer = customer;
        this.isAuthenticated = false;
        this.currentMenuState = "main";
    }
}
