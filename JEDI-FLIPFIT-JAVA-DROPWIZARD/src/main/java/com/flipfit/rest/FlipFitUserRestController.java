package com.flipfit.rest;

import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.UserService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class FlipFitUserRestController {
    private final UserService userService = new UserService();

    @POST
    @Path("/register/customer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCustomer(FlipFitCustomer customer) {
        boolean isRegistered = userService.registerCustomer(customer);
        if (isRegistered) {
            return Response.status(Response.Status.CREATED).entity("Customer registered successfully!").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Customer registration failed.").build();
        }
    }

    @POST
    @Path("/register/gym-owner")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(FlipFitGymOwner gymOwner) {
        gymOwner.setVerified(false); // New owners are unverified by default
        boolean isRegistered = userService.registerGymOwner(gymOwner);
        if (isRegistered) {
            return Response.status(Response.Status.CREATED).entity("Gym Owner registered successfully! Awaiting admin approval.").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Gym Owner registration failed.").build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(FlipFitUser user) {
        boolean isAuthenticated = userService.authenticateUser(user);
        if (isAuthenticated) {
            return Response.ok("Login successful! Welcome " + user.getEmail()).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Login failed. Please check credentials.").build();
        }
    }
}