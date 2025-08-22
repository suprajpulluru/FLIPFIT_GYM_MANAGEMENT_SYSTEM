package com.flipfit.bean;
/*
 *@Author : "Gaurav"
 *@ClassName: "FlipFitRole"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.util.Date"
 */

public class FlipFitRole {
    public int RoleId;
    public String RoleName;

    public FlipFitRole() {
        super();
    }

    public FlipFitRole(int roleId, String roleName) {
        RoleId = roleId;
        RoleName = roleName;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }
}
