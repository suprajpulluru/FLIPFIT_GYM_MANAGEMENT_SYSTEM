package com.flipfit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipfit.bean.*;
import com.flipfit.dao.FlipFitGymOwnerDAO;
import com.flipfit.utils.DbConnection;
/*
 *@Author : "Dhara Periwal"
 *@ClassName: "FlipFitGymOwnerDAOImpl"
 *@Exceptions: "java.sql.SQLException"
 *@Version : "1.0"
 *@See : "com.flipfit.bean.Gym, com.flipfit.bean.FlipFitGymOwner, com.flipkart.bean.flipfitSlot, com.flipkart.utils.DbConnection"
 */
public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAO {

    public FlipFitGymOwner getGymOwnerDetails(String gymOwnerEmailId) {
        Connection connection = null;
        FlipFitGymOwner gymOwner = new FlipFitGymOwner();
        String query = "select email, name, phoneNumber, aadharNumber, panNumber, isVerified from gym_owner where email = ?";
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymOwnerEmailId);
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                gymOwner.setEmail(rs.getString("email"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setPhoneNumber(rs.getString("phoneNumber"));
                gymOwner.setAadharNumber(rs.getString("aadharNumber"));
                gymOwner.setPanNumber(rs.getString("panNumber"));
                gymOwner.setVerified(rs.getBoolean("isVerified"));

//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gymOwner;
    }



    public void editGymOwnerDetails(FlipFitGymOwner gymOwnerDetails) {
        Connection connection = null;
        String UPDATE_USER_SQL = "update user set email = ?, roleId = ?" + " where email = ?;";
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, gymOwnerDetails.getEmail());
            preparedStatement.setString(2, "3");
            preparedStatement.setString(3, gymOwnerDetails.getEmail());
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }

        String UPDATE_GYM_OWNER_SQL = "update gym_owner set email = ?, name = ?, phoneNumber = ?, aadharNumber = ?, panNumber = ?, isVerified = ? "
                + "where email = ?;";
//        System.out.println(UPDATE_GYM_OWNER_SQL);
        // Step 1: Establishing a Connection
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GYM_OWNER_SQL);
            preparedStatement.setString(1, gymOwnerDetails.getEmail());
            preparedStatement.setString(2, gymOwnerDetails.getName());
            preparedStatement.setString(3, gymOwnerDetails.getPhoneNumber());
            preparedStatement.setString(4, gymOwnerDetails.getAadharNumber());
            preparedStatement.setString(5, gymOwnerDetails.getPanNumber());
            preparedStatement.setBoolean(6, gymOwnerDetails.isVerified());
            preparedStatement.setString(7, gymOwnerDetails.getEmail());
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public FlipFitGym getGym(String gymId) {
        Connection connection = null;
        FlipFitGym gym = new FlipFitGym();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, isVerified from gym where gymId = ?";
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setOwnerEmail(rs.getString("ownerEmail"));
                gym.setAddress(rs.getString("address"));
                gym.setSlotCount(rs.getInt("slotCount"));
                gym.setVerified(rs.getBoolean("isVerified"));

//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gym;
    }

    public void addGym(FlipFitGym gymDetails) {
        Connection connection = null;
        String INSERT_GYM_SQL = "INSERT INTO gym"
                + "  (gymId, gymName, ownerEmail, address, isVerified) VALUES "
                + " (?, ?, ?, ?, ?, ?, ?);";
//        System.out.println(INSERT_GYM_SQL);
        // Step 1: Establishing a Connection
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_SQL);
            preparedStatement.setString(1, gymDetails.getGymId());
            preparedStatement.setString(2, gymDetails.getGymName());
            preparedStatement.setString(3, gymDetails.getOwnerEmail());
            preparedStatement.setString(4, gymDetails.getAddress());
            preparedStatement.setBoolean(5, gymDetails.isVerified());

//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public void editGym(FlipFitGym gymDetails) {
        Connection connection = null;
        String INSERT_GYM_SQL = "update gym"
                + "  set gymId = ?, gymName = ?, ownerEmail = ?, address = ?, slotCount = ?, isVerified = ? where gymId = ?;";
//        System.out.println(INSERT_GYM_SQL);
        // Step 1: Establishing a Connection
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GYM_SQL);
            preparedStatement.setString(1, gymDetails.getGymId());
            preparedStatement.setString(2, gymDetails.getGymName());
            preparedStatement.setString(3, gymDetails.getOwnerEmail());
            preparedStatement.setString(4, gymDetails.getAddress());
            preparedStatement.setInt(5, gymDetails.getSlotCount());
            preparedStatement.setBoolean(6, gymDetails.isVerified());
            preparedStatement.setString(7, gymDetails.getGymId());

//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public List<FlipFitGym> getGymsOfGymOwner(String ownerEmail) {
        Connection connection = null;
        List<FlipFitGym> gyms = new ArrayList<FlipFitGym>();
        String query = "select gymId, gymName, ownerEmail, address, slotCount, isVerified from gym where ownerEmail =  ?";
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ownerEmail);
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                FlipFitGym gym = new FlipFitGym();
                gym.setGymId(rs.getString("gymId"));
                gym.setGymName(rs.getString("gymName"));
                gym.setOwnerEmail(rs.getString("ownerEmail"));
                gym.setAddress(rs.getString("address"));
                gym.setSlotCount(rs.getInt("slotCount"));
                gym.setVerified(rs.getBoolean("isVerified"));
                gyms.add(gym);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return gyms;
    }

    public List<FlipFitSlots> getPossibleSlots(String gymId) {
        Connection connection = null;
        List<FlipFitSlots> slots = new ArrayList<FlipFitSlots>();
        String query = "select slotId, gymId, startTime, endTime, numOfSeats, numOfSeatsBooked from slot where gymId =  ?";
        try {connection = DbConnection.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);
//            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getString("slotId"));
                slot.setGymId(rs.getString("gymId"));
                slot.setStartTime(rs.getString("startTime"));
                slot.setEndTime(rs.getString("endTime"));
                slots.add(slot);
//	                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        // Step 4: try-with-resource statement will auto close the connection.
        return slots;
    }

    public void addSlot(FlipFitSlots slot) {
        Connection connection = null;
        String INSERT_SLOT_SQL = "INSERT INTO slot (slotId, gymId, startTime, endTime, numOfSeats, numOfSeatsBooked) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SLOT_SQL);

            preparedStatement.setString(1, slot.getSlotId());
            preparedStatement.setString(2, slot.getGymId());
            preparedStatement.setString(3, slot.getStartTime());
            preparedStatement.setString(4, slot.getEndTime());
            preparedStatement.setInt(5, slot.getNumOfSeats());
            preparedStatement.setInt(6, slot.getNumOfSeatsBooked());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public boolean checkOwnerApproval(String email) {
        Connection connection = null;
        boolean isApproved = false; // Default to false
        String query = "SELECT isVerified FROM gym_owner WHERE email = ?";

        try {
            connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            // Check if a row was found AND if the isVerified column is true
            if (rs.next()) {
                isApproved = rs.getBoolean("isVerified");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isApproved;
    }

    public boolean checkGymApproval(String gymId) {
        Connection connection = null;
        boolean isApproved = false; // Default to false
        String query = "SELECT isVerified FROM gym WHERE gymId = ?";

        try {
            connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gymId);

            ResultSet rs = preparedStatement.executeQuery();

            // Check if a row was found AND if the isVerified column is true
            if (rs.next()) {
                isApproved = rs.getBoolean("isVerified");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isApproved;
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

    public List<FlipFitSlots> fetchSlotsForGym(String gymId) {
        Connection connection = null;
        List<FlipFitSlots> slots = new ArrayList<>();
        String query = "SELECT * FROM slot WHERE gymId = ?";

        try {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, gymId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getString("slotId"));
                slot.setGymId(rs.getString("gymId"));
//                slot.setDate(rs.getDate("date"));
                slot.setStartTime(rs.getString("startTime"));
                slot.setEndTime(rs.getString("endTime"));
                slot.setNumOfSeats(rs.getInt("numOfSeats"));
                slot.setNumOfSeatsBooked(rs.getInt("numOfSeatsBooked"));
                slots.add(slot);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return slots;
    }
}