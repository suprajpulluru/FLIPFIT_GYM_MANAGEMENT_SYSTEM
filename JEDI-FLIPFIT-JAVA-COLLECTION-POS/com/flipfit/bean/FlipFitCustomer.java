package com.flipfit.bean;
/*
 *@Author : "Dhara Periwal"
 *@ClassName: "FlipFitCustomer"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.util.Date"
 */
public class FlipFitCustomer extends FlipFitUser {
    private String name;
    private String phoneNumber;
    private int age;
    private String address;

    public FlipFitCustomer() {
        super();
    }

    public FlipFitCustomer(String email, String password, String roleId, String name, String phoneNumber, int age, String address) {
        super(email, password, roleId);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
