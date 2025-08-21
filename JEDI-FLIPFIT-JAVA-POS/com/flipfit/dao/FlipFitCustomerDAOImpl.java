package com.flipfit.dao;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitPayment;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.dao.collection.FlipFitData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAO {

    @Override
    public List<FlipFitGym> fetchGymList() {
        return new ArrayList<>(FlipFitData.gymMap.values());
    }

    @Override
    public List<FlipFitSlots> fetchSlotsByGym(String gymId) {
        System.out.println(gymId);
        for(FlipFitSlots slot : FlipFitData.slotMap.values()){
            System.out.println(slot.getGymId());
            System.out.println(FlipFitData.slotMap.values().stream());
        }
        return FlipFitData.slotMap.values().stream()
                .filter(slot -> slot.getGymId().equals(gymId))
                .collect(Collectors.toList());
    }

    @Override
    public List<FlipFitBooking> fetchBookedSlots(String email) {
        return FlipFitData.bookingMap.values().stream()
                .filter(booking -> booking.getCustomerEmail().equals(email))
                .collect(Collectors.toList());
    }

    @Override
    public String bookSlots(String bookingId, String slotId, String gymId, String type, Date date, String customerEmail) {
        FlipFitBooking newBooking = new FlipFitBooking(bookingId, slotId, gymId, type, date, customerEmail);
        FlipFitData.bookingMap.put(bookingId, newBooking);

        // Update the number of booked seats in the slot
        FlipFitSlots slot = FlipFitData.slotMap.get(slotId);
        if (slot != null) {
            slot.setNumOfSeatsBooked(slot.getNumOfSeatsBooked() + 1);
        }
        return bookingId;
    }

    @Override
    public boolean isFull(String slotId) {
        FlipFitSlots slot = FlipFitData.slotMap.get(slotId);
        return slot != null && slot.getNumOfSeatsBooked() >= slot.getNumOfSeats();
    }

    @Override
    public boolean alreadyBooked(String slotId, String email) {
        return FlipFitData.bookingMap.values().stream()
                .anyMatch(booking -> booking.getSlotId().equals(slotId) && booking.getCustomerEmail().equals(email));
    }

    @Override
    public boolean cancelBookingById(String bookingId) {
        FlipFitBooking booking = FlipFitData.bookingMap.remove(bookingId);
        if (booking != null) {
            // Decrease the number of booked seats in the slot
            FlipFitSlots slot = FlipFitData.slotMap.get(booking.getSlotId());
            if (slot != null) {
                slot.setNumOfSeatsBooked(slot.getNumOfSeatsBooked() - 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean checkSlotExists(String slotId, String gymId) {
        FlipFitSlots slot = FlipFitData.slotMap.get(slotId);
        return slot != null && slot.getGymId().equals(gymId);
    }

    @Override
    public boolean checkGymApprove(String gymId) {
        FlipFitGym gym = FlipFitData.gymMap.get(gymId);
        return gym != null && gym.isVerified();
    }

    @Override
    public void editProfile(FlipFitCustomer customer) {
        // Update both the user and customer details in their respective maps
        FlipFitData.userMap.put(customer.getEmail(), customer);
        FlipFitData.customerMap.put(customer.getEmail(), customer);
    }

    @Override
    public List<FlipFitGym> fetchGymsByDate(Date date) {
        // This is a placeholder as the in-memory data model doesn't store bookings by date in an efficient way.
        // It would require iterating through all bookings to find the gyms.
        // For simplicity, we will assume this method fetches all verified gyms from the in-memory map.
        return FlipFitData.gymMap.values().stream()
                .filter(FlipFitGym::isVerified)
                .collect(Collectors.toList());
    }

    @Override
    public void processPayment(FlipFitPayment payment) {
        FlipFitData.paymentMap.put(payment.getTransactionId(), payment);
    }
}