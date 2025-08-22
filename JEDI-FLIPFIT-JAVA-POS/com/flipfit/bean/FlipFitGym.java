package com.flipfit.bean;
/*
 *@Author : "Gaurav"
 *@ClassName: "FlipFitGym"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.util.Date"
 */
public class FlipFitGym {
    private String gymId;
    private String gymName;
    private String ownerEmail;
    private String address;
    private int slotCount;
    private boolean isVerified;

    public FlipFitGym() {

    }

    public FlipFitGym(String gymId, String gymName, String ownerEmail, String address, int slotCount, boolean isVerified) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.ownerEmail = ownerEmail;
        this.address = address;
        this.slotCount = slotCount;
        this.isVerified = isVerified;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSlotCount() {
        return slotCount;
    }

    public void setSlotCount(int slotCount) {
        this.slotCount = slotCount;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String toString() {

        String s = "Gym Id : " + this.gymId +
                "\nGym Name : " + this.gymName +
                "\nGym Owner Email : " + this.getOwnerEmail() +
                "\nGym Address : " + this.getAddress() +
                "\nGym Slotcount : " + this.getSlotCount() +
                "\nVerification : " + (this.isVerified() ? "Yes" : "No");
        return s;

    }
}
