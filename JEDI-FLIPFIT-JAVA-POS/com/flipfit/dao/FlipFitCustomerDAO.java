package com.flipfit.dao;

import java.util.Date;
import java.util.List;

import com.flipfit.bean.*;
//import com.flipfit.exception.NoSlotsFoundException;

public interface FlipFitCustomerDAO {
    public List<FlipFitGym> fetchGymList();

    public List<FlipFitSlots> fetchSlotsByGym(String gymId);

    public List<FlipFitBooking> fetchBookedSlots(String email);

    public String bookSlots(String bookingId, String slotId, String gymId, String type, Date date, String customerEmail);

    public boolean isFull(String slotId, String date);

    public boolean alreadyBooked(String slotId, String email, String date);

    public boolean cancelBookingById(String bookingId);

    public boolean checkSlotExists(String slotId, String gymId);

    public boolean checkGymApprove(String gymId);

    public void editProfile(FlipFitCustomer customer);

    public List<FlipFitGym> fetchGymsByDate(Date date);

    public void processPayment(FlipFitPayment payment);
}