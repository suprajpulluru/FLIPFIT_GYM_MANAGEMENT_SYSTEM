package com.flipfit.bean;

public class FlipFitUser {
    private String email;
    private String password;
    private String roleId;

    public FlipFitUser() {
        super();
    }

    public FlipFitUser(String email, String password, String roleId) {
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
