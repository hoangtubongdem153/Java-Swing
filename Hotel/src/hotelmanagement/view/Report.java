/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelmanagement.view;

import hotelmanagement.controller.ReportController;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Year;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;

/**
 *
 * @author Acer
 */
public class Report extends javax.swing.JFrame {

    final ReportController reportController = new ReportController();
    CategoryChart chart;
    private Boolean isFirstChartDraw = true;
    private HotelManager hotelManager;

    public HotelManager getHotelManager() {
        return hotelManager;
    }

    public void setHotelManager(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    public Report() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        drawChart();
        initData();
        addEvents();
    }

    private void drawChart() {

        chart = new CategoryChartBuilder()
                .title("Doanh thu theo năm")
                .yAxisTitle("Doanh thu(triệu đồng)")
                .build();
        pnlMain.add(new XChartPanel<>(chart), BorderLayout.CENTER);
    }

    private void addEvents() {

        cmbReportYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = cmbReportYear.getSelectedItem();
                if (selectedItem instanceof String) {
                    int selectedYear = Integer.parseInt((String) selectedItem);
                    reloadChart(selectedYear);
                }
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(hotelManager != null)
                {
                    hotelManager.setVisible(true);
                }
            }
        });
    }

    private void reloadChart(int year) {
        if(chart == null) return;
        if (!isFirstChartDraw) {
            chart.removeSeries("Doanh thu");
        }

        var result = reportController.getReport(year);
        var monthSeries = new ArrayList<String>();
        var totalSeries = new ArrayList<Double>();

        for (var item : result) {
            monthSeries.add("Tháng " + item.getMonth());
            totalSeries.add(item.getTotal() / 1000000);
        }
        chart.addSeries("Doanh thu", monthSeries, totalSeries);
        pnlMain.revalidate();
        pnlMain.repaint();

        isFirstChartDraw = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmbReportYear = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setLayout(new java.awt.BorderLayout());

        cmbReportYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(cmbReportYear, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(cmbReportYear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pnlMain.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) { 
        new Report().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbReportYear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

    private void initData() {
        ArrayList<Integer> years = new ArrayList<>();

        int yearNow = Year.now().getValue();
        reloadChart(yearNow);
        for (int i = yearNow; i >= yearNow - 4; --i) {
            years.add(i);
        }
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Integer year : years) {
            comboBoxModel.addElement(year.toString());
        }
        cmbReportYear.setModel(comboBoxModel);
    }

}
