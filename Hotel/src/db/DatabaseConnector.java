/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import hotelmanagement.controller.BookingController;
import hotelmanagement.model.BookingModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DatabaseConnector {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotelmanagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public static Connection connect() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<BookingModel> bookings = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Dữ liệu giả mạo
        String[] phoneNumbers = {
            "0356956553", "0356855858", "0356999999", "0356888888", "0356000000",
            "0909123456", "0909988777", "0909111111", "0909333333", "0909777777",
            "0356333333", "0356444444", "0909666666", "0356555555", "0909555555",
            "0356666666", "0356777777", "0909444444", "0909333333", "0356000000",
            "0909222222", "0909111111", "0356888888", "0909000000", "0909888888",
            "0356999999", "0356888888", "0909777777", "0909666666", "0909555555"
        };
        String[] names = {
            "Phạm Thị Lan", "Lê Văn Hòa", "Vũ Thị Nga", "Trần Văn Lượng", "Hoàng Đình Phú",
            "Nguyễn Thị Anh", "Lý Văn Tuấn", "Đỗ Văn Hùng", "Trịnh Thị Mai", "Bùi Văn Đức",
            "Mai Thị Tâm", "Nguyễn Đình Nam", "Lê Thị Thu", "Phan Văn Khánh", "Võ Thị Huệ",
            "Trương Văn Bình", "Ngô Thị Hương", "Đặng Văn Long", "Vũ Thanh Hà", "Lê Đức Thắng",
            "Trần Văn Huy", "Đinh Thị Hồng", "Hoàng Văn Dũng", "Nguyễn Thanh Thảo", "Lê Quang Nam",
            "Phạm Thanh Tuấn", "Nguyễn Văn Đông", "Lý Thị Hạnh", "Vũ Văn Khai", "Trần Thị Lệ"
        };

        int[] roomIds = {
            401, 402, 403, 404, 405,
            101, 102, 103, 104, 105,
            201, 202, 203, 204, 205,
            301, 302, 303, 304, 305,
            501, 502, 503, 504, 505,
            601, 602, 603, 604, 605
        };

        int[] typeRooms = {
            0, 1, 2, 3, 4,
            0, 1, 2, 3, 4,
            0, 1, 2, 3, 4,
            0, 1, 2, 3, 4,
            0, 1, 2, 3, 4,
            0, 1, 2, 3, 4
        };
        // Lấy ngày hiện tại
        Calendar calendar = Calendar.getInstance();
        Date startDate = calendar.getTime();

        // Tạo dữ liệu giả mạo cho 20 bản ghi với INTERVAL 3 DAY
        for (int i = 0; i < 30; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, 3); // Thêm 3 ngày vào ngày hiện tại
            Date endDate = calendar.getTime();

            // Lấy thông tin từ mảng dữ liệu giả mạo
            String phoneNumber = phoneNumbers[i];
            String nameCustomer = names[i];
            int roomId = roomIds[i];
            int typeRoom = typeRooms[i];

            BookingController bookingController = new BookingController();
            BookingModel newBooking = bookingController.create(phoneNumber, nameCustomer, roomId, typeRoom, startDate, endDate);

            // Cập nhật startDate cho lần lặp tiếp theo
            startDate = endDate;
        }

    }
}
