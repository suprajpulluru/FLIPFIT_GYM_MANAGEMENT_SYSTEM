package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.dao.collection.FlipFitData;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAO {

    @Override
    public List<FlipFitGym> fetchGymList() {
        return FlipFitData.gymMap.values().stream()
                .filter(FlipFitGym::isVerified)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlipFitSlots> fetchSlotsByGym(String gymId) {
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

        // Update the filled seats count for the slot
        FlipFitSlots slot = FlipFitData.slotMap.get(slotId);
        if (slot != null) {
            // CHANGED HERE: Using the correct method names from your FlipFitSlots class
            slot.setNumOfSeatsBooked(slot.getNumOfSeatsBooked() + 1);
        }
        return bookingId;
    }

    @Override
    public boolean isFull(String slotId, String date) {
        FlipFitSlots slot = FlipFitData.slotMap.get(slotId);
        // CHANGED HERE: Using the correct method names
        return slot != null && slot.getNumOfSeatsBooked() >= slot.getNumOfSeats();
    }

    @Override
    public boolean alreadyBooked(String slotId, String email, String date) {
        return FlipFitData.bookingMap.values().stream()
                .anyMatch(booking -> booking.getCustomerEmail().equals(email) && booking.getSlotId().equals(slotId));
    }

    @Override
    public boolean cancelBookingById(String bookingId) {
        if (FlipFitData.bookingMap.containsKey(bookingId)) {
            FlipFitBooking booking = FlipFitData.bookingMap.remove(bookingId);

            // Decrement the filled seats count in the corresponding slot
            FlipFitSlots slot = FlipFitData.slotMap.get(booking.getSlotId());
            if (slot != null) {
                // CHANGED HERE: Using the correct method names
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

    // Unimplemented methods for this scenario
    @Override
    public boolean checkGymApprove(String gymId) { return false; }
    @Override
    public void editProfile(FlipFitCustomer customer) {}
    @Override
    public List<FlipFitGym> fetchGymsByDate(Date date) { return null; }
    @Override
    public void processPayment(FlipFitPayment payment) {}
}