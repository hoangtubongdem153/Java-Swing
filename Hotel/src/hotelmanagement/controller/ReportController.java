/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.controller;

import com.mysql.cj.jdbc.CallableStatement;
import db.DatabaseConnector;
import hotelmanagement.model.PriceModel;
import hotelmanagement.model.ReportModel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class ReportController {

    public ArrayList<ReportModel> getReport(int year) {
        var result = new ArrayList<ReportModel>();
        try (Connection connection = DatabaseConnector.connect()) {

            CallableStatement callableStatement = (CallableStatement) connection.prepareCall("{call usp_Report(?)}");
            callableStatement.setInt(1, year);
            callableStatement.execute();
            var resultSet = callableStatement.getResultSet();

            while (resultSet.next()) {
                var item = new ReportModel();
                item.setMonth(resultSet.getInt(1));
                item.setTotal(resultSet.getDouble(2));
                result.add(item);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnector.closeConnection();
            return result;

        }
    }
    
}
