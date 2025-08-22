package com.flipfit.bean;

/*
 *@Author : "Asmitha Gangoni"
 *@ClassName: "FlipFitBooking"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "java.util.Date"
 */
public class FlipFitBooking {
    private String bookingId;
    private String slotId;
    private String gymId;
    private String type;
    private String customerEmail;

    public FlipFitBooking() {
        super();
    }//default constructor

    public FlipFitBooking(String bookingId, String slotId, String gymId, String type,String customerEmail) {
        this.bookingId = bookingId;
        this.slotId = slotId;
        this.gymId = gymId;
        this.type = type;
        this.customerEmail = customerEmail;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
