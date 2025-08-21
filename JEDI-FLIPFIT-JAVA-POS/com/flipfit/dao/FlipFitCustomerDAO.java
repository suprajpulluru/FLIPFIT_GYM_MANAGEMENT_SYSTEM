package com.flipfit.dao;

import java.util.Date;
import java.util.List;

import com.flipfit.bean.*;
//import com.flipfit.exception.NoSlotsFoundException;


/*
 *@Author : "Akanksha"
 *@ClassName: "FlipFitCustomerDAO"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.FlipFitGym, com.flipfit.bean.FlipFitGymOwner, java.util.List"
 */
public interface FlipFitCustomerDAO {
    public List<FlipFitGym> fetchGymList();

    public List<FlipFitSlots> fetchSlotsByGym(String gymId);

    public List<FlipFitBooking> fetchBookedSlots(String email);

    public String bookSlots(String bookingId, String slotId, String gymId, String type, String customerEmail);

    public boolean isFull(String slotId);

    public boolean alreadyBooked(String slotId, String email);

    public boolean cancelBookingById(String bookingId);

    public boolean checkSlotExists(String slotId, String gymId);

    public boolean checkGymApprove(String gymId);

    public void editProfile(FlipFitCustomer customer);

    public void processPayment(FlipFitPayment payment);
}