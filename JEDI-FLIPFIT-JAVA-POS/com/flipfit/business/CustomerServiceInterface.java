package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.utils.IdGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface CustomerServiceInterface {
    public FlipFitCustomer getProfile(FlipFitCustomer customer);

    public void editProfile(FlipFitCustomer customer);

    public List<FlipFitBooking> getBookings(String email);

    public boolean cancelBooking(String bookingId, String email);

    public List<FlipFitGym> getGymsByCity(String city);

    public List<FlipFitSlots> getSlotInGym(String gymId);

    public String bookSlot(String gymId, String slotId, String email, Date date);

    public List<FlipFitGym> getGymsByDate(String dateStr);

    public void makePayment(FlipFitPayment payment);

    public boolean hasBookedSlotAlready(String slotId, String customerEmail);
}
