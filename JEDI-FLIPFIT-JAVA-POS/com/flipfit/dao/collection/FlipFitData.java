//package com.flipfit.dao.collection;
//
//import com.flipfit.bean.*;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * This class acts as a static, in-memory database for the FlipFit application.
// * It uses Java Collections to store and manage all application data.
// * The data is hardcoded for demonstration purposes.
// */
//public class FlipFitData {
//
//    // Using HashMap for in-memory, single-threaded data storage.
//    public static Map<String, FlipFitUser> userMap = new HashMap<>();
//    public static Map<String, FlipFitCustomer> customerMap = new HashMap<>();
//    public static Map<String, FlipFitGymOwner> gymOwnerMap = new HashMap<>();
//    public static Map<String, FlipFitGym> gymMap = new HashMap<>();
//    public static Map<String, FlipFitSlots> slotMap = new HashMap<>();
//    public static Map<String, FlipFitBooking> bookingMap = new HashMap<>();
//    public static Map<String, FlipFitPayment> paymentMap = new HashMap<>();
//    public static Map<String, FlipFitNotification> notificationMap = new HashMap<>();
//    public static Map<String, FlipFitRegistration> registrationMap = new HashMap<>();
//    public static Map<Integer, FlipFitRole> roleMap = new HashMap<>();
//
//    // Static initializer block to populate the collections with hardcoded data
//    static {
//        // Hardcoded Roles
//        roleMap.put(1, new FlipFitRole(1, "Admin"));
//        roleMap.put(2, new FlipFitRole(2, "Customer"));
//        roleMap.put(3, new FlipFitRole(3, "GymOwner"));
//
//        // Hardcoded Users
//        userMap.put("admin@flipfit.com", new FlipFitUser("admin@flipfit.com", "admin123", "Admin"));
//        userMap.put("customer@flipfit.com", new FlipFitUser("customer@flipfit.com", "customer123", "FlipFitCustomer"));
//        userMap.put("gymowner@flipfit.com", new FlipFitUser("gymowner@flipfit.com", "gymownern123", "FlipFitGymOwner"));
//
//        // Hardcoded Customers - Now using the updated constructor
//        FlipFitCustomer customer1 = new FlipFitCustomer("customer1@gmail.com", "customer123", "Customer", "Customer 1", "9876543210", 30, "123 Customer St");
//        FlipFitCustomer customer2 = new FlipFitCustomer("customer2@gmail.com", "customer123", "Customer", "Customer 2", "9876543211", 25, "456 User Ave");
//        customerMap.put(customer1.getEmail(), customer1);
//        customerMap.put(customer2.getEmail(), customer2);
//        userMap.put(customer1.getEmail(), customer1);
//        userMap.put(customer2.getEmail(), customer2);
//
//        // Hardcoded Gym Owners - Now using the updated constructor
//        FlipFitGymOwner owner1 = new FlipFitGymOwner("owner1@gmail.com", "owner123", "GymOwner", "Owner 1", "9998887776", "123456789012", "ABCDE1234F");
//        owner1.setVerified(true); // Manually set verification to true for this hardcoded entry
//        FlipFitGymOwner owner2 = new FlipFitGymOwner("owner2@gmail.com", "owner123", "GymOwner", "Owner 2", "9998887777", "234567890123", "FGHIJ5678K");
//        gymOwnerMap.put(owner1.getEmail(), owner1);
//        gymOwnerMap.put(owner2.getEmail(), owner2);
//        userMap.put(owner1.getEmail(), owner1);
//        userMap.put(owner2.getEmail(), owner2);
//
//        // Hardcoded Gyms
//        gymMap.put("GYM001", new FlipFitGym("GYM001", "Flex Fit Gym", "owner1@gmail.com", "MainSttown", 5, 10, true)); // Verified
//        gymMap.put("GYM002", new FlipFitGym("GYM002", "Hardcore Fitness", "owner1@gmail.com", "SideAvetown", 4, 15, true)); // Verified
//        gymMap.put("GYM003", new FlipFitGym("GYM003", "Quick Flex", "owner2@gmail.com", "Broadwaytown", 6, 8, false)); // Pending verification
//
//        slotMap.put("SLOT001", new FlipFitSlots("SLOT001", "GYM001", "08:00", "09:00", "Trainer A", 10, 0, new Date()));
//        slotMap.put("SLOT002", new FlipFitSlots("SLOT002", "GYM001", "09:00", "10:00", "Trainer A", 10, 2, new Date()));
//        slotMap.put("SLOT003", new FlipFitSlots("SLOT003", "GYM002", "18:00", "19:00", "Trainer B", 15, 15, new Date())); // This slot is full
//        slotMap.put("SLOT004", new FlipFitSlots("SLOT004", "GYM003", "07:00", "08:00", "Trainer C", 8, 0, new Date())); // Gym not verified
//
//        // Hardcoded Bookings
//        bookingMap.put("B001", new FlipFitBooking("B001", "SLOT001", "GYM001", "confirmed", new Date(), "customer1@gmail.com"));
//        bookingMap.put("B002", new FlipFitBooking("B002", "SLOT002", "GYM002", "confirmed", new Date(), "cust1@example.com"));
//        bookingMap.put("B003", new FlipFitBooking("B003", "SLOT003", "GYM003", "waiting", new Date(), "cust2@example.com"));
//        bookingMap.put("B004", new FlipFitBooking("B004", "SLOT004", "GYM004", "confirmed", new Date(), "cust3@example.com"));
//
//    }
//}