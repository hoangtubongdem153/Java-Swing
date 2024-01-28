/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelmanagement.view;

import hotelmanagement.controller.RoomController;
import hotelmanagement.model.RoomDetail;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Acer
 */
public class DepartmentManager extends javax.swing.JFrame {

    public class RoomStatusColors {

        public static final String COLOR_EMPTY = "#FFB534";
        public static final String COLOR_BOOKED = "#76EE00";
        public static final String COLOR_STAYING = "#38B6F1";

        private Map<Integer, String> settingColor = new HashMap<>();

        public RoomStatusColors() {
            settingColor.put(0, COLOR_EMPTY);
            settingColor.put(1, COLOR_BOOKED);
            settingColor.put(2, COLOR_STAYING);
        }

        public String getColor(int status) {
            return settingColor.getOrDefault(status, "#FFFFFF");
        }
    }
    private RoomController roomController;

    public DepartmentManager() {

        declareFrame();
        initComponents();
        drawFirstLook();
        //addEvents();
    }


    private void declareFrame() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900, 450);
        this.setLocationRelativeTo(null);
        roomController = new RoomController();

    }
    private void drawFirstFloor(JPanel pnlInner, int index) {
        var roomList = roomController.getAllRoomByFloor(index);
        for (var room : roomList) {
            JButton btn = new JButton();
//          TODO Set Id Room
            String idRoom = room.getRoomId() + "";
            btn.setText(idRoom);
//          Set Color button
            int status = room.getStatus();
            RoomStatusColors roomStatusColors = new RoomStatusColors();
            String roomColor = roomStatusColors.getColor(status);
            Color color = Color.decode(roomColor);
            btn.setBackground(color);
//          Event Click
            btn.addActionListener((e) -> {
                JButton btnCurrent = (JButton) e.getSource();
                String currentRoomId = btnCurrent.getText();
                RoomDetail roomDetail = roomController.getById(Integer.parseInt(currentRoomId));
                if (roomDetail == null) {
                    this.setVisible(false);
//              TODO Chuyển sang trang đặt phòng (Booking)
                    Booking bookingView = new Booking(Integer.parseInt(currentRoomId));
                    bookingView.setVisible(true);
                } else {
                    this.setVisible(false);
//              TODO Chuyển sang trang Thông tin phòng (RoomInfor)
                    RoomInfo roooInfoView = new RoomInfo(Integer.parseInt(currentRoomId));
                    roooInfoView.setVisible(true);
                }
            });

            pnlInner.add(btn);
        }
    }

    private void drawFirstLook() {
        for (int i = 1; i <= 7; i++) {
            var pnlInner = new JPanel();
            pnlInner.setLayout(new GridLayout(4, 4));
            tabApartments.addTab("Tầng " + i, pnlInner);
            drawFirstFloor(pnlInner, i);
        }
    }

    public enum RoomStatus {
        CHECKED_IN(1),
        UNBOOKED(2),
        BOOKED(3);

        private int value;

        RoomStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private RoomStatus roomStatus;

    public void setRoomStatus(RoomStatus status) {
        roomStatus = status;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    private void addEvents() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlApartment = new javax.swing.JPanel();
        tabApartments = new javax.swing.JTabbedPane();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setName("pnlMain"); // NOI18N
        pnlMain.setLayout(new java.awt.BorderLayout());

        btn_back.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlApartmentLayout = new javax.swing.GroupLayout(pnlApartment);
        pnlApartment.setLayout(pnlApartmentLayout);
        pnlApartmentLayout.setHorizontalGroup(
            pnlApartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabApartments, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlApartmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addGap(30, 30, 30))
        );
        pnlApartmentLayout.setVerticalGroup(
            pnlApartmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApartmentLayout.createSequentialGroup()
                .addComponent(tabApartments, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_back)
                .addContainerGap())
        );

        pnlMain.add(pnlApartment, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        HotelManager hotelManagerView = new HotelManager();
        hotelManagerView.setVisible(true);
        hotelManagerView.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_backActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentManager().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JPanel pnlApartment;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTabbedPane tabApartments;
    // End of variables declaration//GEN-END:variables

}
