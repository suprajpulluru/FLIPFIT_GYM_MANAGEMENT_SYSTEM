package com.flipfit.bean;

public class FlipFitAdmin extends FlipFitUser {
    private String name;
    private String phoneNumber;

    public FlipFitAdmin() {
        super();
    }

    public FlipFitAdmin(String email, String password, String roleId, String name, String phoneNumber) {
        super(email, password, roleId);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}