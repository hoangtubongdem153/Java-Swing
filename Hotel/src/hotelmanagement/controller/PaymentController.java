/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.controller;

import db.DatabaseConnector;
import hotelmanagement.model.PaymentModel;
import hotelmanagement.model.RoomModel;
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
public class PaymentController {

    public static PaymentModel create(int roomId, int staffId, String nameCustomer, String phoneNumberCustomer, Date startDate, Date endDate, float total_amount) {
        PaymentModel newPayment = null;

        try (Connection connection = DatabaseConnector.connect()) {
            connection.setAutoCommit(false);

            String staffQuery = "SELECT customerId FROM Customer WHERE phoneNumber = ?";
            int customerId = -1;
            try (PreparedStatement staffStatement = connection.prepareStatement(staffQuery)) {
                staffStatement.setString(1, phoneNumberCustomer);
                ResultSet staffResultSet = staffStatement.executeQuery();
                if (staffResultSet.next()) {
                    customerId = staffResultSet.getInt("customerId");
                } else {
                    throw new SQLException("No customer found with the provided phone number.");
                }
            }

            String paymentQuery = "INSERT INTO Payment (roomId, staffId, customerId, total_amount, paymentDate) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement paymentStatement = connection.prepareStatement(paymentQuery, Statement.RETURN_GENERATED_KEYS)) {
                paymentStatement.setInt(1, roomId);
                paymentStatement.setInt(2, staffId);
                paymentStatement.setInt(3, customerId);
                paymentStatement.setFloat(4, total_amount);
                paymentStatement.setTimestamp(5, new java.sql.Timestamp(endDate.getTime()));

                int affectedRows = paymentStatement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating payment failed, no rows affected.");
                }

                connection.commit();

                try (ResultSet generatedKeys = paymentStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        newPayment = new PaymentModel();

                        newPayment.setPaymentId(generatedKeys.getInt(1));
                        newPayment.setRoomId(roomId);
                        newPayment.setStaffId(staffId);
                        newPayment.setCustomerId(customerId);
                        newPayment.setTotal_amount(total_amount);
                        newPayment.setPaymentDate(new java.sql.Date(endDate.getTime()));

                        String updateRoomQuery = "UPDATE room SET status = 2 WHERE roomId = ?";
                        try (PreparedStatement updateRoomStatement = connection.prepareStatement(updateRoomQuery)) {
                            updateRoomStatement.setInt(1, roomId);
                            int roomUpdatedRows = updateRoomStatement.executeUpdate();
                            if (roomUpdatedRows == 0) {
                                throw new SQLException("Updating room status failed, no rows affected.");
                            }
                            connection.commit();
                        }

                    } else {
                        throw new SQLException("Creating payment failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DatabaseConnector.closeConnection();
        }
        return newPayment;
    }
}
