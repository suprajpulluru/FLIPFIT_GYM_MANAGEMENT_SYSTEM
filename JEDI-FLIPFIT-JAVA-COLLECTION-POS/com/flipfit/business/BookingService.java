package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.FlipFitCustomerDAO;
import com.flipfit.dao.FlipFitCustomerDAOImpl; // Make sure this import points to your implementation

import java.util.Date;
import java.util.List;
import java.util.UUID;


/*
 *@Author : "Asmitha Gangoni"
 *@ClassName: "BookingService"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.BookingService"
 */
public class BookingService implements BookingServiceInterface{

    private final FlipFitCustomerDAO customerDAO = new FlipFitCustomerDAOImpl();

    public List<FlipFitGym> getAvailableGyms() {
        return customerDAO.fetchGymList();
    }

    public List<FlipFitSlots> getAvailableSlots(String gymId) {
        return customerDAO.fetchSlotsByGym(gymId);
    }

    public void bookSlot(String customerEmail, String gymId, String slotId) {
        Date today = new Date();

        // Check if the slot is valid for the given gym
        if (!customerDAO.checkSlotExists(slotId, gymId)) {
            System.out.println("Booking Failed: This slot does not exist for the selected gym.");
            return;
        }
        // Check if the slot is already full
        if (customerDAO.isFull(slotId)) {
            System.out.println("Booking Failed: This slot is already full.");
            return;
        }
        // Check if the customer has already booked this slot
        if (customerDAO.alreadyBooked(slotId, customerEmail)) {
            System.out.println("Booking Failed: You have already booked this slot.");
            return;
        }

        String newBookingId = UUID.randomUUID().toString(); // Generate a unique booking ID
        String bookingId = customerDAO.bookSlots(newBookingId, slotId, gymId, "confirmed", today, customerEmail);
        System.out.println("Booking Successful! Your Booking ID is: " + bookingId);
    }

    public List<FlipFitBooking> getMyBookings(String customerEmail) {
        return customerDAO.fetchBookedSlots(customerEmail);
    }

    public boolean cancelBooking(String bookingId) {
        return customerDAO.cancelBookingById(bookingId);
    }
}