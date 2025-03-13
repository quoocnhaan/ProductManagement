/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails.OrderDetailContent;

import java.awt.BorderLayout;
import model.Address;
import model.Bills;
import model.Customer;
import model.GoodsReceipt;
import model.OrderHistory;
import model.Product;
import view.component.Order.OrderDetails.OrderDetailContent.Header_Component.Header_Component;
import view.component.Order.OrderDetails.OrderDetailsSouth_Component;

/**
 *
 * @author PC
 */
public class OrderProductContent_Component extends javax.swing.JPanel {

    private Header_Component header_Component;
    private OrderProductPage_Component orderProductPage_Component;
    private OrderDetailsSouth_Component parent;

    public OrderProductContent_Component(OrderDetailsSouth_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout(0, 15));
        initData();
        addComponents();
    }

    public OrderProductContent_Component(OrderDetailsSouth_Component parent, Bills bills) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout(0, 15));
        initData(bills);
        addComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initData() {
        header_Component = new Header_Component(this);
        orderProductPage_Component = new OrderProductPage_Component(this);
    }

    private void addComponents() {
        add(header_Component, BorderLayout.NORTH);
        add(orderProductPage_Component, BorderLayout.CENTER);
    }

    public void transferData(Product newProduct) {
        orderProductPage_Component.addNewProduct(newProduct);
        updateSumaryData(newProduct.getImportPrice());
    }

    private void updateSumaryData(double price) {
        parent.updateSumaryData(price);
    }

    public void updateDataWhenBrowse() {
        orderProductPage_Component.addBrowsedProducts();
    }

//    public void saveImportProducts(double totalPrice, double discount, double deliveryFee, double otherDiscount) {
//        orderProductPage_Component.saveImportProducts(totalPrice, discount, deliveryFee, otherDiscount);
//    }
    void updateTotal(double price) {
        parent.updateTotal(price);
    }

    private void initData(Bills bills) {
        header_Component = new Header_Component(this);
        orderProductPage_Component = new OrderProductPage_Component(this, bills);
    }

    public void updateImportProducts(Bills bills, Customer customer, Address address, OrderHistory orderHistory, double deliveryFree, double totalPaid, double discount, double otherDiscount, double totalPrice) {
        orderProductPage_Component.updateImportProducts(bills, customer, address, orderHistory, deliveryFree, totalPaid, discount, otherDiscount, totalPrice);
    }

    public void unfulfilledOrder(Bills bills, Customer customer, Address address, OrderHistory orderHistory, double deliveryFee, double totalPaid, double discount, double otherDiscount, double totalPrice) {
        orderProductPage_Component.unfulfilledOrder(bills, customer, address, orderHistory, deliveryFee, totalPaid, discount, otherDiscount, totalPrice);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
