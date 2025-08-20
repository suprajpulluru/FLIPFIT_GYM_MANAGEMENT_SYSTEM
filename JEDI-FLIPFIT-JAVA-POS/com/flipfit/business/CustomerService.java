package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitPayment;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.FlipFitCustomerDAO;
import com.flipfit.dao.FlipFitCustomerDAOImpl;
import com.flipfit.utils.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerService {
    List<FlipFitCustomer> customers = new ArrayList<>();
    List<FlipFitBooking> bookings = new ArrayList<>();

    List<FlipFitSlots> slots = new ArrayList<>();
    List<FlipFitGym> gyms = new ArrayList<>();



    FlipFitCustomerDAOImpl customerDAO = new FlipFitCustomerDAOImpl();

    public FlipFitCustomer getProfile(FlipFitCustomer customer) {
        for (FlipFitCustomer cust : customers) {
            if (cust.getEmail().equals(customer.getEmail()))
                return cust;
        }
        return null;
    }

    public void editProfile(FlipFitCustomer customer) {
        customerDAO.editProfile(customer);
    }

    public List<FlipFitBooking> getBookings(String email) {
        return customerDAO.fetchBookedSlots(email);
    }


    public boolean cancelBooking(String bookingId, String email) {
        // Here you could add logic to ensure a customer only cancels their own booking.
        // For now, we will just call the DAO.
        return customerDAO.cancelBookingById(bookingId);
    }

    public List<FlipFitGym> getGymsByCity(String city) {
        List<FlipFitGym> allGyms = customerDAO.fetchGymList();
        List<FlipFitGym> gymsInCity = new ArrayList<>();

        for (FlipFitGym gym : allGyms) {
            if (gym.getAddress().equalsIgnoreCase(city) && gym.isVerified()) {
                gymsInCity.add(gym);
            }
        }
        return gymsInCity;
    }

    public List<FlipFitSlots> getSlotInGym(String gymId) {
        return customerDAO.fetchSlotsByGym(gymId);
    }

    public String bookSlot(String gymId, String slotId, String email, Date date) {
        // Check if gym is approved
        if (!customerDAO.checkGymApprove(gymId)) {
            return "Gym is not approved.";
        }

        // Check if slot exists in the given gym
        if (!customerDAO.checkSlotExists(slotId, gymId)) {
            return "Slot not found in this gym.";
        }

        // Check if slot is already full
        if (customerDAO.isFull(slotId)) {
            return "Slot is full.";
        }

        // Check if customer has already booked the same slot
        if (customerDAO.alreadyBooked(slotId, email)) {
            return "You have already booked this slot.";
        }

        String bookingId = IdGenerator.generateId("Booking");
        return customerDAO.bookSlots(bookingId, slotId, gymId, "Confirmed", date, email);
    }

    public List<FlipFitGym> getGymsByDate(String dateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dateStr);
            return customerDAO.fetchGymsByDate(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return new ArrayList<>();
        }
    }

    public void makePayment(FlipFitPayment payment) {
        customerDAO.processPayment(payment);
    }


    /**
     * Checks if the slot is already booked or not
     * @param slotId the slot id for which the booking status is requested
     * @param-date  the date on which the booking status is requested
     * @return returns true if the slot id for the given date is fully booked else returns false
     */
//	public boolean isSlotBooked(String slotId, Date date) {
//		for (Slot s : slots) {
//			if (s.getSlotId().equals(slotId)) {
//				if (s.getNumOfSeats() <= s.getNumOfSeatsBooked())
//					return true;
//				else
//					return false;
//			}
//		}
//		return false;
//	}

    public boolean isSlotBooked(String slotId, String gymId) {
        return customerDAO.isFull(slotId);
    }
    /**
     * Checks if the customer has already booked a seat in the same slot for the given date
     * @param slotId the slot id for which the booking status is requested
     * @param-date the date on which the booking status is requested
     * @param customerEmail the email of customer for which the booking status is getting checked
     * @return returns true if the customer has already booked a seat on the same date in the same slot
     */
    public boolean hasBookedSlotAlready(String slotId, String customerEmail) {
        return customerDAO.alreadyBooked(slotId, customerEmail);
    }



}
