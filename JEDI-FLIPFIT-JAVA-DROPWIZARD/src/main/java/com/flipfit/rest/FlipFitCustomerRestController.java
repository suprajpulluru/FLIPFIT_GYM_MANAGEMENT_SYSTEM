package com.flipfit.rest;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitPayment;
import com.flipfit.business.CustomerService;
import com.flipfit.utils.IdGenerator;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitCustomerRestController {
    private final CustomerService customerService = new CustomerService();

    @GET
    @Path("/gyms/address/{address}")
    public Response getGymsByAddress(@PathParam("address") String address) {
        List<FlipFitGym> gyms = customerService.getGymsByCity(address);
        return Response.ok(gyms).build();
    }

    @POST
    @Path("/bookings/book")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response bookSlot(FlipFitBooking bookingRequest) {
        String bookingId = customerService.bookSlot(
                bookingRequest.getGymId(),
                bookingRequest.getSlotId(),
                bookingRequest.getCustomerEmail()
        );

        if (bookingId != null && !bookingId.equals("Slot not available")) {
            // In a real app, you'd handle payment here.
            // For now, we simulate a successful payment.
            FlipFitPayment payment = new FlipFitPayment();
            payment.setBookingId(bookingId);
            payment.setTransactionId("T-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());
            payment.setPaymentStatus("Success");
            customerService.makePayment(payment);

            return Response.status(Response.Status.CREATED)
                    .entity("Booking successful! Booking ID: " + bookingId)
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Booking failed: " + bookingId).build();
    }

    @GET
    @Path("/bookings/{email}")
    public Response getMyBookings(@PathParam("email") String email) {
        List<FlipFitBooking> bookings = customerService.getBookings(email);
        return Response.ok(bookings).build();
    }

    @DELETE
    @Path("/bookings/cancel/{bookingId}")
    public Response cancelBooking(@PathParam("bookingId") String bookingId) {
        boolean isCancelled = customerService.cancelBooking(bookingId, null); // Email not needed for this logic
        if (isCancelled) {
            return Response.ok("Booking " + bookingId + " cancelled successfully.").build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Booking cancellation failed.").build();
    }
}