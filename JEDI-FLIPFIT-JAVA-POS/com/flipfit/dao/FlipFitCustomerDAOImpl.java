package com.flipfit.dao;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitCustomer;
import com.flipfit.bean.FlipFitGym;
import com.flipfit.bean.FlipFitPayment;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.utils.DbConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.flipfit.dao.FlipFitGymOwnerDAOImpl.printSQLException;

/*
 *@Author : "Asmitha Gangoni"
 *@ClassName: "FlipFitCustomerDAOImpl"
 *@Exceptions: "N/A"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.FlipFitGym, com.flipfit.bean.FlipFitGymOwner, java.util.List"
 */
public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAO {

    @Override
    public List<FlipFitGym> fetchGymList() {
        Connection connection = null;
        List<FlipFitGym> gyms = new ArrayList<FlipFitGym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, seatsPerSlotCount, isVerified from gym";
        try {connection = DbConnection.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement(query);
            // System.out.println(statement);
            // Step 3: Execute the query or update query
            ResultSet rs = statement.executeQuery();

            // Step 4: Process the ResultSet object.

            while (rs.next()) {
                FlipFitGym gym = new FlipFitGym();
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setOwnerEmail(rs.getString("ownerEmail"));
                gym.setAddress(rs.getString("address"));
                gym.setSlotCount(rs.getInt("slotCount"));
                gym.setSeatsPerSlotCount(rs.getInt("seatsPerSlotCount"));
                gym.setVerified(rs.getBoolean("isVerified"));
                gyms.add(gym);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return gyms;
    }

    @Override
    public List<FlipFitSlots> fetchSlotsByGym(String gymId) {
        Connection connection = null;
        List<FlipFitSlots> slots = new ArrayList<>();
        String query = "SELECT * FROM slot WHERE gymId = ?";

        try {
            connection =DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, gymId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getString("slotId"));
                slot.setGymId(rs.getString("gymId"));
                slot.setStartTime(rs.getString("startTime"));
                slot.setEndTime(rs.getString("endTime"));
//
                slot.setNumOfSeats(rs.getInt("numOfSeats"));
                slot.setNumOfSeatsBooked(rs.getInt("numOfSeatsBooked"));
//                slot.setDate(rs.getDate("date"));
                slots.add(slot);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return slots;
    }


    @Override
    public List<FlipFitBooking> fetchBookedSlots(String email) {
        Connection connection = null;
        List<FlipFitBooking> userBookings = new ArrayList<>();
        String query = "SELECT * FROM booking WHERE customerEmail = ?";

        try {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                FlipFitBooking booking = new FlipFitBooking();
                booking.setBookingId(rs.getString("bookingId"));
                booking.setSlotId(rs.getString("slotId"));
                booking.setGymId(rs.getString("gymId"));
                booking.setType(rs.getString("type"));
                booking.setCustomerEmail(rs.getString("customerEmail"));
                userBookings.add(booking);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return userBookings;
    }


    @Override
    public String bookSlots(String bookingId, String slotId, String gymId, String type, String customerEmail) {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // 1. Insert the new booking
            String insertBookingSQL = "INSERT INTO booking (bookingId, slotId, gymId, type, customerEmail) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertBookingSQL);
            insertStmt.setString(1, bookingId);
            insertStmt.setString(2, slotId);
            insertStmt.setString(3, gymId);
            insertStmt.setString(4, type);
            insertStmt.setString(5, customerEmail);
            insertStmt.executeUpdate();

            // 2. Update the seat count in the slot table
            String updateSlotSQL = "UPDATE slot SET numOfSeatsBooked = numOfSeatsBooked + 1 WHERE slotId = ?";
            PreparedStatement updateStmt = connection.prepareStatement(updateSlotSQL);
            updateStmt.setString(1, slotId);
            updateStmt.executeUpdate();

            connection.commit();
            return bookingId;// Finalize the transaction

        } catch (SQLException e) {
            printSQLException(e);
            try {
                if (connection != null) connection.rollback(); // Rollback on error
            } catch (SQLException ex) {
                printSQLException(ex);
            }
        } finally {
            try {
                if (connection != null) connection.setAutoCommit(true);
            } catch (SQLException ex) {
                printSQLException(ex);
            }
        }
        return null;
    }

    @Override
    public boolean isFull(String slotId) {
        Connection connection = null;
        String query = "Select * from slot where slotId=? and (numOfSeatsBooked>=numOfSeats)";
        try {connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, slotId);
//            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e)
        {
            printSQLException(e);
        }

        return false;
    }

    @Override
    public boolean alreadyBooked(String slotId, String email) {
        Connection connection = null;
        String query = "select bookingId from Booking where slotId=? and customerEmail =  ?";
        try {connection = DbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, email);
//            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    @Override
    public boolean cancelBookingById(String bookingId) {
        Connection connection = null;
        boolean success = false;
        String fetchSlotIdSQL = "SELECT slotId FROM booking WHERE bookingId = ?";
        String deleteBookingSQL = "DELETE FROM booking WHERE bookingId = ?";
        String deletePaymentSQL = "DELETE FROM payment WHERE bookingId = ?";  /// experiment
        String updateSlotSQL = "UPDATE slot SET numOfSeatsBooked = numOfSeatsBooked - 1 WHERE slotId = ?";

        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // 1. Get the slotId from the booking before deleting it
            String slotId = null;
            PreparedStatement fetchStmt = connection.prepareStatement(fetchSlotIdSQL);
            fetchStmt.setString(1, bookingId);
            ResultSet rs = fetchStmt.executeQuery();
            if (rs.next()) {
                slotId = rs.getString("slotId");
            }

            PreparedStatement deletePaymentStmt = connection.prepareStatement(deletePaymentSQL);
            deletePaymentStmt.setString(1, bookingId);
            deletePaymentStmt.executeUpdate();

            PreparedStatement deleteStmt = connection.prepareStatement(deleteBookingSQL);
            deleteStmt.setString(1, bookingId);
            int rowsAffected = deleteStmt.executeUpdate();

            // 3. If deletion was successful and we have a slotId, update the slot table
            if (rowsAffected > 0 && slotId != null) {
                PreparedStatement updateStmt = connection.prepareStatement(updateSlotSQL);
                updateStmt.setString(1, slotId);
                updateStmt.executeUpdate();
                success = true;
            }

            connection.commit(); // Finalize the transaction

        } catch (SQLException e) {
            printSQLException(e);
            try {
                if (connection != null) connection.rollback(); // Rollback on error
            } catch (SQLException ex) {
                printSQLException(ex);
            }
        } finally {
            try {
                if (connection != null) connection.setAutoCommit(true);
            } catch (SQLException ex) {
                printSQLException(ex);
            }
        }
        return success;
    }

    @Override
    public boolean checkSlotExists(String slotId, String gymId) {
        Connection connection = null;
        String query = "select slotId from slot where slotId=? and gymId =  ?";
        try {connection = DbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, slotId);
            preparedStatement.setString(2, gymId);
//            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    @Override
    public boolean checkGymApprove(String gymId) {
        Connection connection = null;
        String query = "select isVerified from gym where gymId =  ?";
        try {connection = DbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
//            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return false;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void editProfile(FlipFitCustomer customer) {
        Connection connection = null;
        try {
            connection = DbConnection.getConnection();
            connection.setAutoCommit(false); // Start transaction

            // 1. Update the 'customer' table
            String updateCustomerSQL = "UPDATE customer SET name = ?, phoneNumber = ?, age = ?, address = ? WHERE email = ?";
            PreparedStatement updateCustomerStmt = connection.prepareStatement(updateCustomerSQL);
            updateCustomerStmt.setString(1, customer.getName());
            updateCustomerStmt.setString(2, customer.getPhoneNumber());
            updateCustomerStmt.setInt(3, customer.getAge());
            updateCustomerStmt.setString(4, customer.getAddress());
            updateCustomerStmt.setString(5, customer.getEmail());
            updateCustomerStmt.executeUpdate();

            connection.commit(); // Finalize transaction

        } catch (SQLException e) {
            printSQLException(e);
            try {
                if (connection != null) connection.rollback();
            } catch (SQLException ex) {
                printSQLException(ex);
            }
        } finally {
            try {
                if (connection != null) connection.setAutoCommit(true);
            } catch (SQLException e) {
                printSQLException(e);
            }
        }
    }

    @Override
    public void processPayment(FlipFitPayment payment) {
        Connection connection = null;
        String query = "INSERT INTO payment (transactionId, bookingId, paymentStatus, paymentMethod, paymentMethodId) VALUES (?, ?, ?, ?, ?)";
        try {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, payment.getTransactionId());
            statement.setString(2, payment.getBookingId());
            statement.setString(3, payment.getPaymentStatus());
            statement.setString(4, payment.getPaymentMethod());
            statement.setString(5, payment.getPaymentMethodId());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}