/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.controller;

import db.DatabaseConnector;
import hotelmanagement.model.RoomDetail;
import hotelmanagement.model.RoomModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class RoomController {

    public static ArrayList<RoomModel> getAll() {
        ArrayList<RoomModel> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "SELECT * FROM room";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        RoomModel room = new RoomModel();
                        room.setRoomId(resultSet.getInt("roomId"));
                        room.setDescription(resultSet.getString("description"));
                        room.setFloor(resultSet.getInt("floor"));
                        room.setType(resultSet.getInt("type"));
                        room.setStatus(resultSet.getInt("status"));

                        rooms.add(room);
                    }
                }
            }
        } catch (SQLException e) {
        } finally {
            DatabaseConnector.closeConnection();
        }
        return rooms;
    }

    public static ArrayList<RoomModel> getAllRoomByFloor(int floor) {
        ArrayList<RoomModel> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "SELECT * FROM Room WHERE floor = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, floor);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        RoomModel room = new RoomModel();
                        room.setRoomId(resultSet.getInt("roomId"));
                        room.setDescription(resultSet.getString("description"));
                        room.setFloor(resultSet.getInt("floor"));
                        room.setType(resultSet.getInt("type"));
                        room.setStatus(resultSet.getInt("status"));

                        rooms.add(room);
                    }
                }
            }
        } catch (SQLException e) {
        } finally {
            DatabaseConnector.closeConnection();
        }
        return rooms;
    }

    public static RoomDetail getById(int roomId) {
        RoomDetail room = null;

        try (Connection connection = DatabaseConnector.connect()) {
            // Adjust the query to match your database schema and table relationships
            String query = "SELECT r.roomId, r.description, r.floor, r.type, r.status, "
                    + "b.startDate, b.endDate, c.name AS customerName, c.phoneNumber, "
                    + "p.price AS roomPrice "
                    + "FROM Room r "
                    + "JOIN Booking b ON r.roomId = b.roomId "
                    + "JOIN Customer c ON b.customerId = c.customerId "
                    + "JOIN Price p ON r.type = p.roomType "
                    + "WHERE r.roomId = ? AND r.status = 0 "
                    + "ORDER BY b.bookingId DESC "
                    + "LIMIT 1 ";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, roomId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        room = new RoomDetail();
                        room.setRoomId(resultSet.getInt("roomId"));
                        room.setDescription(resultSet.getString("description"));
                        room.setFloor(resultSet.getInt("floor"));
                        room.setType(resultSet.getInt("type"));
                        room.setStatus(resultSet.getInt("status"));
                        room.setStartDate(resultSet.getTimestamp("startDate"));
                        room.setEndDate(resultSet.getTimestamp("endDate"));
                        room.setNameCustomer(resultSet.getString("customerName"));
                        room.setPhoneNumberCustomer(resultSet.getString("phoneNumber"));
                        room.setPrice(resultSet.getFloat("roomPrice"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }

        return room;
    }

    public static RoomModel getByIdBooking(int roomId) {
        RoomModel room = null;

        try (Connection connection = DatabaseConnector.connect()) {
            // Adjust the query to match your database schema and table relationships
            String query = "SELECT * from Room WHERE roomId = ? ";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, roomId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        room = new RoomModel();
                        room.setRoomId(resultSet.getInt("roomId"));
                        room.setDescription(resultSet.getString("description"));
                        room.setFloor(resultSet.getInt("floor"));
                        room.setType(resultSet.getInt("type"));
                        room.setStatus(resultSet.getInt("status"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }

        return room;
    }

    public static ArrayList<RoomModel> getRoomEmpty(int typeRoom) {
        ArrayList<RoomModel> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnector.connect()) {

            String query = "SELECT * FROM room WHERE status = 2 AND type = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, typeRoom);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        RoomModel room = new RoomModel();
                        room.setRoomId(resultSet.getInt("roomId"));
                        room.setDescription(resultSet.getString("description"));
                        room.setFloor(resultSet.getInt("floor"));
                        room.setType(resultSet.getInt("type"));
                        room.setStatus(resultSet.getInt("status"));

                        rooms.add(room);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }
        return rooms;
    }

    public static ArrayList<RoomModel> getRoomBooked() {
        ArrayList<RoomModel> rooms = new ArrayList<>();
        try (Connection connection = DatabaseConnector.connect()) {

            String query = "SELECT * FROM room WHERE status = 0";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        RoomModel room = new RoomModel();
                        room.setRoomId(resultSet.getInt("roomId"));
                        room.setDescription(resultSet.getString("description"));
                        room.setFloor(resultSet.getInt("floor"));
                        room.setType(resultSet.getInt("type"));
                        room.setStatus(resultSet.getInt("status"));

                        rooms.add(room);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }
        return rooms;
    }

    public static RoomModel updateStatus(int roomId, int status) {
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "UPDATE Room SET status = ? WHERE roomId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, status);
                preparedStatement.setInt(2, roomId);

                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Updating staff failed, no rows affected.");
                }

                // Assuming the update was successful, return a StaffModel instance with updated data
                RoomModel updatedRoom = new RoomModel();
                updatedRoom.setStatus(status);

                return updatedRoom;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
        }
        return null;
    }
}
