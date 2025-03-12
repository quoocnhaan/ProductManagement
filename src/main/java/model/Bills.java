/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bill_per_day_id", nullable = false)
    private BillsPerDay billPerDay;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double profit;

    @Column(nullable = false)
    private double deposit;

    private Date paidDate;

    private Date packedDate;

    private Date shippedDate;

    private Date deliveredDate;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private double deliveryFee;

    @Column(nullable = false)
    private double otherDiscount;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private boolean status;

    public Bills() {
    }

    public Bills(BillsPerDay billPerDay, double total, double profit, double deposit, Date paidDate, Date packedDate, Date shippedDate, Date deliveredDate, double discount, double deliveryFee, double otherDiscount, Customer customer, boolean status) {
        this.billPerDay = billPerDay;
        this.total = total;
        this.profit = profit;
        this.deposit = deposit;
        this.paidDate = paidDate;
        this.packedDate = packedDate;
        this.shippedDate = shippedDate;
        this.deliveredDate = deliveredDate;
        this.discount = discount;
        this.deliveryFee = deliveryFee;
        this.otherDiscount = otherDiscount;
        this.customer = customer;
        this.status = status;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDelivertyFee() {
        return deliveryFee;
    }

    public void setDelivertyFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public double getOtherDiscount() {
        return otherDiscount;
    }

    public void setOtherDiscount(double otherDiscount) {
        this.otherDiscount = otherDiscount;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
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

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BillsPerDay getBillPerDay() {
        return billPerDay;
    }

    public void setBillPerDay(BillsPerDay billPerDay) {
        this.billPerDay = billPerDay;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
