package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitSlots;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/*
 *@Author : "Gaurav"
 *@ClassName: "BookingServiceInterface"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.BookingServiceInterface"
 */
public interface BookingServiceInterface {
    public List<FlipFitGym> getAvailableGyms();

    public List<FlipFitSlots> getAvailableSlots(String gymId);

    public void bookSlot(String customerEmail, String gymId, String slotId);

    public List<FlipFitBooking> getMyBookings(String customerEmail);

    public boolean cancelBooking(String bookingId);
}
