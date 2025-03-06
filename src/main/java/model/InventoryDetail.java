/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "inventory_detail")
public class InventoryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private double price;

    @Column(name = "amount_start", nullable = false)
    private int amountStart;

    @Column(name = "amount_end", nullable = false)
    private int amountEnd;

    @Column(nullable = false)
    private boolean status;

    public InventoryDetail() {
    }

    public InventoryDetail(Inventory inventory, Product product, double price, int amountStart, int amountEnd, boolean status) {
        this.inventory = inventory;
        this.product = product;
        this.price = price;
        this.amountStart = amountStart;
        this.amountEnd = amountEnd;
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmountStart() {
        return amountStart;
    }

    public void setAmountStart(int amountStart) {
        this.amountStart = amountStart;
    }

    public int getAmountEnd() {
        return amountEnd;
    }

    public void setAmountEnd(int amountEnd) {
        this.amountEnd = amountEnd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
