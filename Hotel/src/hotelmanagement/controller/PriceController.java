/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.controller;

import db.DatabaseConnector;
import hotelmanagement.model.PriceModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class PriceController {

    public static PriceModel getById(int roomId) {
        PriceModel price = null;

        try (Connection connection = DatabaseConnector.connect()) {
            // Adjust the query to match your database schema and table relationships
            String query = "SELECT * from Price WHERE r.roomId = ? ";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, roomId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        price = new PriceModel();
                        price.setPrice(resultSet.getFloat("price"));
                        price.setPriceId(resultSet.getInt("priceId"));
                        price.setRoomType(resultSet.getInt("roomType"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }

        return price;
    }
}
