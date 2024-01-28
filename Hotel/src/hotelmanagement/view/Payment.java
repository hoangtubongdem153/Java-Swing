/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelmanagement.view;

import hotelmanagement.controller.PaymentController;
import hotelmanagement.controller.RoomController;
import hotelmanagement.model.PaymentModel;
import hotelmanagement.model.RoomDetail;
import hotelmanagement.model.RoomModel;
import hotelmanagement.model.Session;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Payment extends javax.swing.JFrame {

    private RoomController roomController;

    public void setTextPayment(int roomId) {
        RoomDetail room = roomController.getById(roomId);

        Date startDate = room.getStartDate();
        Date endDate = room.getEndDate();
        float pricePerHour = room.getPrice();

// Tính số giờ chênh lệch giữa startDate và endDate
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        long hours = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

// Tính total_amount
        float totalAmount = hours * pricePerHour;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        String formattedPrice = currencyFormat.format(totalAmount);
//        SetText name and phoneNumber, startDate, EndDate
        this.inp_name_customer.setText(room.getNameCustomer());
        this.inp_phoneNumber.setText(room.getPhoneNumberCustomer());
        this.inp_total_amount.setText(formattedPrice);

        LocalDateTime localStartDateTime = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime localEndDateTime = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

// Bây giờ bạn có thể lấy các thành phần từ localDateTime
        this.YearBD.setSelectedItem(String.valueOf(localStartDateTime.getYear()));
        this.MonthBD.setSelectedItem(String.valueOf(localStartDateTime.getMonthValue()));
        this.DayBD.setSelectedItem(String.valueOf(localStartDateTime.getDayOfMonth()));
        this.HourBD.setSelectedItem(String.valueOf(localStartDateTime.getHour()));
        this.MinuteBD.setSelectedItem(String.valueOf(localStartDateTime.getMinute()));

        this.YearKT.setSelectedItem(String.valueOf(localEndDateTime.getYear()));
        this.MonthKT.setSelectedItem(String.valueOf(localEndDateTime.getMonthValue()));
        this.DayKT.setSelectedItem(String.valueOf(localEndDateTime.getDayOfMonth()));
        this.HourKT.setSelectedItem(String.valueOf(localEndDateTime.getHour()));
        this.MinuteKT.setSelectedItem(String.valueOf(localEndDateTime.getMinute()));

//        Disable input
        this.inp_name_customer.setEnabled(false);
        this.inp_phoneNumber.setEnabled(false);

        this.YearBD.setEnabled(false);
        this.MonthBD.setEnabled(false);
        this.DayBD.setEnabled(false);
        this.HourBD.setEnabled(false);
        this.MinuteBD.setEnabled(false);

        this.YearKT.setEnabled(false);
        this.MonthKT.setEnabled(false);
        this.DayKT.setEnabled(false);
        this.HourKT.setEnabled(false);
        this.MinuteKT.setEnabled(false);

    }

    public int staffId = Session.getInstance().getStaffId();

    public Payment(int roomId) {
        initComponents();
        
        this.setLocationRelativeTo(null);
        setTextPayment(roomId);
        this.setResizable(false);
        cmb_roomId.addItem(String.valueOf(roomId));
        cmb_roomId.setSelectedItem(String.valueOf(roomId));
        cmb_roomId.setEnabled(false);
    }

    public Payment() {
        initComponents();
        this.setLocationRelativeTo(null);

        ArrayList<RoomModel> rooms = roomController.getRoomBooked();

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        for (var room : rooms) {
            comboBoxModel.addElement(String.valueOf(room.getRoomId()));
        }

        cmb_roomId.setModel(comboBoxModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_roomId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inp_name_customer = new javax.swing.JTextField();
        inp_phoneNumber = new javax.swing.JTextField();
        inp_total_amount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        YearKT = new javax.swing.JComboBox<>();
        MonthKT = new javax.swing.JComboBox<>();
        DayKT = new javax.swing.JComboBox<>();
        HourBD = new javax.swing.JComboBox<>();
        HourKT = new javax.swing.JComboBox<>();
        DayBD = new javax.swing.JComboBox<>();
        MinuteKT = new javax.swing.JComboBox<>();
        MinuteBD = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        YearBD = new javax.swing.JComboBox<>();
        MonthBD = new javax.swing.JComboBox<>();
        cmb_roomId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Thanh toán");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel1.setText("Tên khách hàng:");

        txt_roomId.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        txt_roomId.setText("Mã phòng:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel3.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel6.setText("Tổng tiền:");

        inp_name_customer.setBackground(new java.awt.Color(204, 204, 204));
        inp_name_customer.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        inp_phoneNumber.setBackground(new java.awt.Color(204, 204, 204));
        inp_phoneNumber.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        inp_total_amount.setBackground(new java.awt.Color(204, 204, 204));
        inp_total_amount.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        inp_total_amount.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Thanh toán");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(204, 204, 204));
        btnExit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(51, 51, 51));
        btnExit.setText("Hủy");
        btnExit.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 255, 255)));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel9.setText("Tháng:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel10.setText("Năm:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel11.setText("Kết thúc:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel12.setText("Bắt đầu:");

        YearKT.setBackground(new java.awt.Color(153, 153, 153));
        YearKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        YearKT.setForeground(new java.awt.Color(51, 51, 51));
        YearKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025" }));
        YearKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearKTActionPerformed(evt);
            }
        });

        MonthKT.setBackground(new java.awt.Color(153, 153, 153));
        MonthKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MonthKT.setForeground(new java.awt.Color(51, 51, 51));
        MonthKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        MonthKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthKTActionPerformed(evt);
            }
        });

        DayKT.setBackground(new java.awt.Color(153, 153, 153));
        DayKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DayKT.setForeground(new java.awt.Color(51, 51, 51));
        DayKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        HourBD.setBackground(new java.awt.Color(153, 153, 153));
        HourBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HourBD.setForeground(new java.awt.Color(51, 51, 51));
        HourBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        HourKT.setBackground(new java.awt.Color(153, 153, 153));
        HourKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        HourKT.setForeground(new java.awt.Color(51, 51, 51));
        HourKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        DayBD.setBackground(new java.awt.Color(153, 153, 153));
        DayBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DayBD.setForeground(new java.awt.Color(51, 51, 51));
        DayBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        MinuteKT.setBackground(new java.awt.Color(153, 153, 153));
        MinuteKT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MinuteKT.setForeground(new java.awt.Color(51, 51, 51));
        MinuteKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        MinuteBD.setBackground(new java.awt.Color(153, 153, 153));
        MinuteBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MinuteBD.setForeground(new java.awt.Color(51, 51, 51));
        MinuteBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel17.setText("Ngày thuê:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel18.setText("Ngày:");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel19.setText("Giờ:");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel20.setText("Phút:");

        YearBD.setBackground(new java.awt.Color(153, 153, 153));
        YearBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        YearBD.setForeground(new java.awt.Color(51, 51, 51));
        YearBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025" }));
        YearBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearBDActionPerformed(evt);
            }
        });

        MonthBD.setBackground(new java.awt.Color(153, 153, 153));
        MonthBD.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        MonthBD.setForeground(new java.awt.Color(51, 51, 51));
        MonthBD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        MonthBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthBDActionPerformed(evt);
            }
        });

        cmb_roomId.setBackground(new java.awt.Color(153, 153, 153));
        cmb_roomId.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cmb_roomId.setForeground(new java.awt.Color(51, 51, 51));
        cmb_roomId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb_roomId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_roomIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(273, 273, 273)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(YearBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(YearKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(HourBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HourKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MinuteBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(MinuteKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1)
                                    .addGap(39, 39, 39)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_roomId, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inp_name_customer)
                                        .addComponent(cmb_roomId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inp_phoneNumber)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel11))
                                            .addGap(134, 134, 134)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(MonthKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(MonthBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9))
                                            .addGap(0, 0, Short.MAX_VALUE))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(inp_total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(313, 313, 313))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_roomId)
                    .addComponent(cmb_roomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inp_name_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(inp_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18)
                            .addComponent(jLabel10)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MonthBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(YearBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(HourBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MinuteBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YearKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(MonthKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(HourKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MinuteKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inp_total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(jButton1))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YearBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearBDActionPerformed
        // TODO add your handling code here:
        updateDayComboBox();
    }//GEN-LAST:event_YearBDActionPerformed

    private void YearKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearKTActionPerformed
        // TODO add your handling code here:
        updateDayKTComboBox();
    }//GEN-LAST:event_YearKTActionPerformed

    private void MonthKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthKTActionPerformed
        // TODO add your handling code here:
        updateDayKTComboBox();
    }//GEN-LAST:event_MonthKTActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        HotelManager hotelManagerView = new HotelManager();
        hotelManagerView.setVisible(true);
        hotelManagerView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnExitActionPerformed

    private void MonthBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonthBDActionPerformed

    private void cmb_roomIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_roomIdActionPerformed
        // TODO add your handling code here:
        setTextPayment(Integer.parseInt(cmb_roomId.getSelectedItem().toString()));
    }//GEN-LAST:event_cmb_roomIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int roomId = Integer.parseInt(cmb_roomId.getSelectedItem().toString());

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
        String total_amout_string = inp_total_amount.getText();

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        Number parsedNumber = null;
        try {
            parsedNumber = currencyFormat.parse(total_amout_string);
        } catch (ParseException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        float totalAmount = parsedNumber.floatValue();

        // Sử dụng giá trị totalAmount ở đây
        Calendar calendar = Calendar.getInstance();
        calendar.set(startYear, startMonth, startDay, startHour, startMinute);
        Date startDate = calendar.getTime();
        calendar.set(endYear, endMonth, endDay, endHour, endMinute);
        Date endDate = calendar.getTime();

        PaymentController paymentController = new PaymentController();
        PaymentModel newPayment = paymentController.create(roomId, staffId, nameCustomer, phoneNumber, startDate, endDate, totalAmount);
        if (newPayment != null) {
            JOptionPane.showMessageDialog(this, "Thanh toán thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            HotelManager hotelManagerView = new HotelManager();
            hotelManagerView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa đăng nhập", "Thông báo", JOptionPane.ERROR_MESSAGE);
            this.setVisible(false);
            Login LoginView = new Login();
            LoginView.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> DayBD;
    private javax.swing.JComboBox<String> DayKT;
    private javax.swing.JComboBox<String> HourBD;
    private javax.swing.JComboBox<String> HourKT;
    private javax.swing.JComboBox<String> MinuteBD;
    private javax.swing.JComboBox<String> MinuteKT;
    private javax.swing.JComboBox<String> MonthBD;
    private javax.swing.JComboBox<String> MonthKT;
    private javax.swing.JComboBox<String> YearBD;
    private javax.swing.JComboBox<String> YearKT;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<String> cmb_roomId;
    private javax.swing.JTextField inp_name_customer;
    private javax.swing.JTextField inp_phoneNumber;
    private javax.swing.JTextField inp_total_amount;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel txt_roomId;
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

    private void updateDayKTComboBox() {
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
