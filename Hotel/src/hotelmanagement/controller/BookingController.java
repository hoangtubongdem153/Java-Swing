/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.controller;

import db.DatabaseConnector;
import hotelmanagement.model.BookingModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BookingController {

    public static BookingModel create(String phoneNumber, String nameCustomer, int roomId, int typeRoom, Date startDate, Date endDate) {
        BookingModel newBooking = null;

        try (Connection connection = DatabaseConnector.connect()) {
            // Start by finding the customerId for the given phoneNumber
            String customerQuery = "SELECT customerId FROM Customer WHERE phoneNumber = ?";
            int customerId = -1;
            try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery)) {
                customerStatement.setString(1, phoneNumber);
                try (ResultSet customerResultSet = customerStatement.executeQuery()) {
                    if (customerResultSet.next()) {
                        customerId = customerResultSet.getInt("customerId");
                    } else {
                        String insertCustomerQuery = "INSERT INTO Customer (name, phoneNumber) VALUES (?, ?)";
                        try (PreparedStatement insertCustomerStatement = connection.prepareStatement(insertCustomerQuery, Statement.RETURN_GENERATED_KEYS)) {
                            insertCustomerStatement.setString(1, nameCustomer);
                            insertCustomerStatement.setString(2, phoneNumber);

                            int affectedRows = insertCustomerStatement.executeUpdate();
                            if (affectedRows == 0) {
                                throw new SQLException("Creating new customer failed, no rows affected.");
                            }

                            try (ResultSet generatedKeys = insertCustomerStatement.getGeneratedKeys()) {
                                if (generatedKeys.next()) {
                                    customerId = generatedKeys.getInt(1);
                                } else {
                                    throw new SQLException("Creating customer failed, no ID obtained.");
                                }
                            }
                        }
                    }
                }
            }
            int priceId = -1;
            String priceQuery = "SELECT priceId FROM Price WHERE roomType = ?";
            try (PreparedStatement priceStatement = connection.prepareStatement(priceQuery)) {
                priceStatement.setInt(1, typeRoom);
                try (ResultSet resultSet = priceStatement.executeQuery()) {
                    if (resultSet.next()) {
                        priceId = resultSet.getInt("priceId");
                    } else {
                        throw new SQLException("No price found for the given room type.");
                    }
                }
            }
            // Insert the booking using the customerId
            if (priceId == -1) {
                throw new SQLException("No price found for the given room type.");
            }

            String bookingQuery = "INSERT INTO Booking (customerId, roomId, priceId, startDate, endDate) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement bookingStatement = connection.prepareStatement(bookingQuery, Statement.RETURN_GENERATED_KEYS)) {
                bookingStatement.setInt(1, customerId);
                bookingStatement.setInt(2, roomId);
                bookingStatement.setInt(3, priceId);
                bookingStatement.setTimestamp(4, new java.sql.Timestamp(startDate.getTime()));
                bookingStatement.setTimestamp(5, new java.sql.Timestamp(endDate.getTime()));

                int affectedRows = bookingStatement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating booking failed, no rows affected.");
                }

                // Retrieve the generated keys and create the BookingModel
                try (ResultSet generatedKeys = bookingStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        newBooking = new BookingModel();
                        newBooking.setBookingId(generatedKeys.getInt(1));
                        newBooking.setCustomerId(customerId);
                        newBooking.setRoomId(roomId);
                        newBooking.setPriceId(priceId);
                        newBooking.setStartDate(startDate);
                        newBooking.setEndDate(endDate);
                    } else {
                        throw new SQLException("Creating booking failed, no ID obtained.");
                    }
                }

                // Update the room status to booked
                String updateRoomQuery = "UPDATE Room SET status = 0 WHERE roomId = ?";
                try (PreparedStatement updateRoomStatement = connection.prepareStatement(updateRoomQuery)) {
                    updateRoomStatement.setInt(1, roomId);
                    updateRoomStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }
        return newBooking;
    }
}
