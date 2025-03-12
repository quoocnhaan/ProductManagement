/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class OrderHistory {

    private Date paidDate;
    private Date packedDate;
    private Date shippedDate;
    private Date deliveredDate;

    public OrderHistory() {
    }

    public OrderHistory(Date paidDate, Date packedDate, Date shippedDate, Date deliveredDate) {
        this.paidDate = paidDate;
        this.packedDate = packedDate;
        this.shippedDate = shippedDate;
        this.deliveredDate = deliveredDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getPackedDate() {
        return packedDate;
    }

    public void setPackedDate(Date packedDate) {
        this.packedDate = packedDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

}
