/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class BookingModel {

    private int BookingId;
    private int customerId;
    private int roomId;
    private int priceId;
    private Date startDate;
    private Date endDate;

    public BookingModel() {
    }

    public BookingModel(int BookingId, int customerId, int roomId, int priceId, Date startDate, Date endDate) {
        this.BookingId = BookingId;
        this.customerId = customerId;
        this.roomId = roomId;
        this.priceId = priceId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int BookingId) {
        this.BookingId = BookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
