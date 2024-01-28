/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelmanagement.view;

import db.DatabaseConnector;
import hotelmanagement.controller.BookingController;
import hotelmanagement.controller.RoomController;
import hotelmanagement.model.BookingModel;
import hotelmanagement.model.RoomModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import java.time.YearMonth; // Import lớp YearMonth để tính toán số ngày trong tháng
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class Booking extends javax.swing.JFrame {

    private RoomController roomController;

    /**
     * Creates new form Booking
     */
    public void setDateNow() {
        Calendar now = Calendar.getInstance();

        // Set giờ cho ngày bắt đầu
        YearBD.setSelectedItem(String.valueOf(now.get(Calendar.YEAR)));
        MonthBD.setSelectedItem(String.valueOf(now.get(Calendar.MONTH) + 1));
        DayBD.setSelectedItem(String.valueOf(now.get(Calendar.DAY_OF_MONTH)));
        HourBD.setSelectedItem(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
        MinuteBD.setSelectedItem(String.valueOf(now.get(Calendar.MINUTE)));
        // Set giờ cho ngày kết thúc
        YearKT.setSelectedItem(String.valueOf(now.get(Calendar.YEAR)));
        MonthKT.setSelectedItem(String.valueOf(now.get(Calendar.MONTH) + 1));
        DayKT.setSelectedItem(String.valueOf(now.get(Calendar.DAY_OF_MONTH) + 1));
        HourKT.setSelectedItem(String.format("%02d", now.get(Calendar.HOUR_OF_DAY)));
        MinuteKT.setSelectedItem(String.valueOf(now.get(Calendar.MINUTE)));
    }

    public void setTextBooking(int roomId) {
        roomController = new RoomController();
        RoomModel room = roomController.getByIdBooking(roomId);

        Enumeration<AbstractButton> buttons = buttonGroup_Loaiphong.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            int actionButton = Integer.parseInt(button.getActionCommand());
            int typeRoom = room.getType();
            if (actionButton == typeRoom) {
                button.setSelected(true);
                break;
            }
        }
    }

    public Booking(int roomId) {
        initComponents();
        setLocationRelativeTo(null);
        setTextBooking(roomId);
//        pnlOption.setVisible(false);
        JcmbRoom.setVisible(true);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Phòng " + String.valueOf(roomId));
        JcmbRoom.setModel(comboBoxModel);
        JcmbRoom.setSelectedIndex(0);
        setDateNow();
    }

    public Booking() {
        initComponents();
        setLocationRelativeTo(null);
//        pnlOption.setVisible(true);
        JcmbRoom.setVisible(false);
        setDateNow();
    }

    public void setCmbRoomIdEmpty(int typeRoom) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        ArrayList<RoomModel> rooms = roomController.getRoomEmpty(typeRoom);
        for (var room : rooms) {
            comboBoxModel.addElement(String.valueOf("Phòng " + room.getRoomId()));
        }
        JcmbRoom.setModel(comboBoxModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_Gioitinh = new javax.swing.ButtonGroup();
        buttonGroup_Loaiphong = new javax.swing.ButtonGroup();
        txt_roomId = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inp_name_customer = new javax.swing.JTextField();
        inp_phoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        btnExit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        YearBD = new javax.swing.JComboBox<>();
        YearKT = new javax.swing.JComboBox<>();
        MonthBD = new javax.swing.JComboBox<>();
        MonthKT = new javax.swing.JComboBox<>();
        DayBD = new javax.swing.JComboBox<>();
        DayKT = new javax.swing.JComboBox<>();
        HourBD = new javax.swing.JComboBox<>();
        HourKT = new javax.swing.JComboBox<>();
        MinuteBD = new javax.swing.JComboBox<>();
        MinuteKT = new javax.swing.JComboBox<>();
        JcmbRoom = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(100, 100));
        setMinimumSize(new java.awt.Dimension(800, 600));

        txt_roomId.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        txt_roomId.setText("Đặt phòng");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Họ và tên:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Giới tính:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Loại phòng:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Ngày thuê:");

        inp_name_customer.setBackground(new java.awt.Color(204, 204, 204));
        inp_name_customer.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inp_name_customer.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));

        inp_phoneNumber.setBackground(new java.awt.Color(204, 204, 204));
        inp_phoneNumber.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inp_phoneNumber.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        inp_phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inp_phoneNumberActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Ngày:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Tháng:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Năm:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Kết thúc:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Bắt đầu:");

        buttonGroup_Gioitinh.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton1.setText("Nam");
        jRadioButton1.setBorder(null);

        buttonGroup_Gioitinh.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton2.setText("Nữ");
        jRadioButton2.setBorder(null);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup_Loaiphong.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton3.setText("Phòng đơn");
        jRadioButton3.setActionCommand("2");
        jRadioButton3.setBorder(null);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup_Loaiphong.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton4.setText("Phòng đôi");
        jRadioButton4.setActionCommand("3");
        jRadioButton4.setBorder(null);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup_Loaiphong.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton5.setText("Phòng tiêu chuẩn");
        jRadioButton5.setActionCommand("1");
        jRadioButton5.setBorder(null);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        buttonGroup_Loaiphong.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton6.setText("Phòng sang trọng");
        jRadioButton6.setActionCommand("0");
        jRadioButton6.setBorder(null);
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnExit.setText("Thoát");
        btnExit.setBorder(null);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Đặt phòng");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("Giờ:");

        buttonGroup_Loaiphong.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jRadioButton7.setText("Phòng tổng thống");
        jRadioButton7.setActionCommand("4");
        jRadioButton7.setBorder(null);
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setText("Phút:");

        YearBD.setBackground(new java.awt.Color(153, 153, 153));
        YearBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        YearBD.setForeground(new java.awt.Color(51, 51, 51));
        YearBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025" }));
        YearBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearBDActionPerformed(evt);
            }
        });

        YearKT.setBackground(new java.awt.Color(153, 153, 153));
        YearKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        YearKT.setForeground(new java.awt.Color(51, 51, 51));
        YearKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025" }));
        YearKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearKTActionPerformed(evt);
            }
        });

        MonthBD.setBackground(new java.awt.Color(153, 153, 153));
        MonthBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MonthBD.setForeground(new java.awt.Color(51, 51, 51));
        MonthBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        MonthBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthBDActionPerformed(evt);
            }
        });

        MonthKT.setBackground(new java.awt.Color(153, 153, 153));
        MonthKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MonthKT.setForeground(new java.awt.Color(51, 51, 51));
        MonthKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        MonthKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthKTActionPerformed(evt);
            }
        });

        DayBD.setBackground(new java.awt.Color(153, 153, 153));
        DayBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DayBD.setForeground(new java.awt.Color(51, 51, 51));
        DayBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DayBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayBDActionPerformed(evt);
            }
        });

        DayKT.setBackground(new java.awt.Color(153, 153, 153));
        DayKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DayKT.setForeground(new java.awt.Color(51, 51, 51));
        DayKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        DayKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayKTActionPerformed(evt);
            }
        });

        HourBD.setBackground(new java.awt.Color(153, 153, 153));
        HourBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HourBD.setForeground(new java.awt.Color(51, 51, 51));
        HourBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        HourKT.setBackground(new java.awt.Color(153, 153, 153));
        HourKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HourKT.setForeground(new java.awt.Color(51, 51, 51));
        HourKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        MinuteBD.setBackground(new java.awt.Color(153, 153, 153));
        MinuteBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MinuteBD.setForeground(new java.awt.Color(51, 51, 51));
        MinuteBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        MinuteKT.setBackground(new java.awt.Color(153, 153, 153));
        MinuteKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MinuteKT.setForeground(new java.awt.Color(51, 51, 51));
        MinuteKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        JcmbRoom.setBackground(new java.awt.Color(153, 153, 153));
        JcmbRoom.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JcmbRoom.setForeground(new java.awt.Color(51, 51, 51));
        JcmbRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "201", " " }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Mã phòng:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_roomId, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton3)
                                .addGap(35, 35, 35)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton5)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jRadioButton7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(211, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(inp_phoneNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                                        .addComponent(inp_name_customer, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(JcmbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(247, 247, 247)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(YearBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(YearKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(MonthBD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MonthKT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(DayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(HourKT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(MinuteKT, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(HourBD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(MinuteBD, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txt_roomId)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inp_name_customer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inp_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JcmbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(YearBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(YearKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HourKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinuteKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HourBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(MinuteBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (jRadioButton3.isSelected()) {
            JcmbRoom.setVisible(true);
            String selectedValue = buttonGroup_Loaiphong.getSelection().getActionCommand();
            // Sử dụng giá trị đã chọn ở đây
            setCmbRoomIdEmpty(Integer.parseInt(selectedValue));
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton4.isSelected()) {
            JcmbRoom.setVisible(true);
            String selectedValue = buttonGroup_Loaiphong.getSelection().getActionCommand();
            // Sử dụng giá trị đã chọn ở đây
            setCmbRoomIdEmpty(Integer.parseInt(selectedValue));
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void inp_phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inp_phoneNumberActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_inp_phoneNumberActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        HotelManager hotelManagerView = new HotelManager();
        hotelManagerView.setVisible(true);
        hotelManagerView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnExitActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton6.isSelected()) {
            JcmbRoom.setVisible(true);
            String selectedValue = buttonGroup_Loaiphong.getSelection().getActionCommand();
            // Sử dụng giá trị đã chọn ở đây
            setCmbRoomIdEmpty(Integer.parseInt(selectedValue));
        }
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton7.isSelected()) {
            JcmbRoom.setVisible(true);
            String selectedValue = buttonGroup_Loaiphong.getSelection().getActionCommand();
            // Sử dụng giá trị đã chọn ở đây
            setCmbRoomIdEmpty(Integer.parseInt(selectedValue));
        }
    }//GEN-LAST:event_jRadioButton7ActionPerformed


    private void YearBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearBDActionPerformed
        // TODO add your handling code here:     
        updateDayComboBox();
    }//GEN-LAST:event_YearBDActionPerformed

    private void YearKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearKTActionPerformed
        // TODO add your handling code here:
        updateKTDayComboBox();
    }//GEN-LAST:event_YearKTActionPerformed

    private void MonthBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthBDActionPerformed
        // TODO add your handling code here:
        updateDayComboBox();
    }//GEN-LAST:event_MonthBDActionPerformed

    private void MonthKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthKTActionPerformed
        // TODO add your handling code here:
        updateKTDayComboBox();
    }//GEN-LAST:event_MonthKTActionPerformed

    private void DayBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayBDActionPerformed

    private void DayKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayKTActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton5.isSelected()) {
            JcmbRoom.setVisible(true);
            String selectedValue = buttonGroup_Loaiphong.getSelection().getActionCommand();
            // Sử dụng giá trị đã chọn ở đây
            setCmbRoomIdEmpty(Integer.parseInt(selectedValue));
        }
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String selectedItem = JcmbRoom.getSelectedItem().toString();
        int roomId = Integer.parseInt(selectedItem.substring(selectedItem.lastIndexOf(" ") + 1));

        int startYear = Integer.parseInt(YearBD.getSelectedItem().toString());
        int startMonth = Integer.parseInt(MonthBD.getSelectedItem().toString());
        int startDay = Integer.parseInt(DayBD.getSelectedItem().toString());
        int startHour = Integer.parseInt(HourBD.getSelectedItem().toString());
        int startMinute = Integer.parseInt(MinuteBD.getSelectedItem().toString());

        int endYear = Integer.parseInt(YearKT.getSelectedItem().toString());
        int endMonth = Integer.parseInt(MonthKT.getSelectedItem().toString());
        int endDay = Integer.parseInt(DayKT.getSelectedItem().toString());
        int endHour = Integer.parseInt(HourKT.getSelectedItem().toString());
        int endMinute = Integer.parseInt(MinuteKT.getSelectedItem().toString());

        String nameCustomer = inp_name_customer.getText();
        String phoneNumber = inp_phoneNumber.getText();
        if (nameCustomer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Sử dụng giá trị totalAmount ở đây
        Calendar calendar = Calendar.getInstance();
        calendar.set(startYear, startMonth, startDay, startHour, startMinute);
        Date startDate = calendar.getTime();
        calendar.set(endYear, endMonth, endDay, endHour, endMinute);
        Date endDate = calendar.getTime();
        System.out.println(startDate);
        System.out.println(endDate);

        Date now = new Date();
        if (startDate.before(now)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu không được nhỏ hơn hiện tại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (endDate.before(startDate)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc không được nhỏ hơn ngày bắt đầu", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String typeRoom = buttonGroup_Loaiphong.getSelection().getActionCommand();
        // Sử dụng giá trị đã chọn ở đây

        BookingController bookingController = new BookingController();
        BookingModel newBooking = bookingController.create(phoneNumber, nameCustomer, roomId, Integer.parseInt(typeRoom), startDate, endDate);

        if (newBooking != null) {
            JOptionPane.showMessageDialog(this, "Đặt phòng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            HotelManager hotelManagerView = new HotelManager();
            hotelManagerView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Đặt phòng thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DayBD;
    private javax.swing.JComboBox<String> DayKT;
    private javax.swing.JComboBox<String> HourBD;
    private javax.swing.JComboBox<String> HourKT;
    private javax.swing.JComboBox<String> JcmbRoom;
    private javax.swing.JComboBox<String> MinuteBD;
    private javax.swing.JComboBox<String> MinuteKT;
    private javax.swing.JComboBox<String> MonthBD;
    private javax.swing.JComboBox<String> MonthKT;
    private javax.swing.JComboBox<String> YearBD;
    private javax.swing.JComboBox<String> YearKT;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup buttonGroup_Gioitinh;
    private javax.swing.ButtonGroup buttonGroup_Loaiphong;
    private javax.swing.JTextField inp_name_customer;
    private javax.swing.JTextField inp_phoneNumber;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    public javax.swing.JLabel txt_roomId;
    // End of variables declaration//GEN-END:variables

    // Phương thức này được gọi khi thay đổi năm hoặc tháng
    private void updateDayComboBox() {
        // Lấy giá trị năm và tháng đã chọn
        int selectedYear = Integer.parseInt(YearBD.getSelectedItem().toString());
        int selectedMonth = MonthBD.getSelectedIndex() + 1;

        // Cập nhật danh sách ngày theo tháng và năm đã chọn
        int daysInMonth = calculateDaysInMonth(selectedYear, selectedMonth);
        List<String> daysArray = new ArrayList<>();
        for (int i = 1; i <= daysInMonth; i++) {
            daysArray.add(String.valueOf(i));
        }

        // Đặt mô hình mới cho JComboBox của ngày
        DayBD.setModel(new javax.swing.DefaultComboBoxModel<>(daysArray.toArray(new String[0])));
    }

    // Phương thức tính toán số ngày trong tháng và năm
    private int calculateDaysInMonth(int year, int month) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    }

    private void updateKTDayComboBox() {
        // Lấy giá trị năm và tháng đã chọn
        int selectedYear = Integer.parseInt(YearKT.getSelectedItem().toString());
        int selectedMonth = MonthKT.getSelectedIndex() + 1;

        // Cập nhật danh sách ngày theo tháng và năm đã chọn
        int daysInMonth = calculateDaysInMonthKT(selectedYear, selectedMonth);
        List<String> daysArray = new ArrayList<>();
        for (int i = 1; i <= daysInMonth; i++) {
            daysArray.add(String.valueOf(i));
        }

        // Đặt mô hình mới cho JComboBox của ngày
        DayKT.setModel(new javax.swing.DefaultComboBoxModel<>(daysArray.toArray(new String[0])));
    }

    // Phương thức tính toán số ngày trong tháng và năm
    private int calculateDaysInMonthKT(int year, int month) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    }

}
