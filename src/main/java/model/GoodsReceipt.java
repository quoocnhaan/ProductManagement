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
import javax.persistence.Table;

@Entity
@Table(name = "goods_receipt")
public class GoodsReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int amount;

    @Column(name = "discount", nullable = false)
    private double discount;

    @Column(name = "deliverty_fee", nullable = false)
    private double delivertyFee;

    @Column(name = "other_discount", nullable = false)
    private double otherDiscount;

    @Column(name = "total_prices", nullable = false)
    private double totalPrices;

    @Column(nullable = false)
    private boolean status;

    public GoodsReceipt() {
    }

    public GoodsReceipt(Date date, int amount, double discount, double delivertyFee, double otherDiscount, double totalPrices, boolean status) {
        this.date = date;
        this.amount = amount;
        this.discount = discount;
        this.delivertyFee = delivertyFee;
        this.otherDiscount = otherDiscount;
        this.totalPrices = totalPrices;
        this.status = status;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDelivertyFee() {
        return delivertyFee;
    }

    public void setDelivertyFee(double delivertyFee) {
        this.delivertyFee = delivertyFee;
    }

    public double getOtherDiscount() {
        return otherDiscount;
    }

    public void setOtherDiscount(double otherDiscount) {
        this.otherDiscount = otherDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(double totalPrices) {
        this.totalPrices = totalPrices;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
