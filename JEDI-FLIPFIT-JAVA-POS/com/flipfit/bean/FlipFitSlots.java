package com.flipfit.bean;
/*
 *@Author : "Gaurav"
 *@ClassName: "FlipFitSlots"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.util.Date"
 */
public class FlipFitSlots {
    private String slotId;
    private String gymId;
    private String startTime;
    private String endTime;
    private int numOfSeats;
    private int numOfSeatsBooked;

    public FlipFitSlots() {
        super();
    }

    public FlipFitSlots(String slotId, String gymId, String startTime, String endTime, int numOfSeats, int numOfSeatsBooked) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numOfSeats = numOfSeats;
        this.numOfSeatsBooked = numOfSeatsBooked;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeatsBooked() {
        return numOfSeatsBooked;
    }

    public void setNumOfSeatsBooked(int numOfSeatsBooked) {
        this.numOfSeatsBooked = numOfSeatsBooked;
    }
}
