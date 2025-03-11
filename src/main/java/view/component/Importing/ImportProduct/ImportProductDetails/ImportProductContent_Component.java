/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct.ImportProductDetails;

import java.awt.BorderLayout;
import model.GoodsReceipt;
import model.Product;
import view.component.Importing.ImportProduct.ImportDetails_Component;
import view.component.Importing.ImportProduct.ImportProductDetails.Header_Component.Header_Component;

/**
 *
 * @author PC
 */
public class ImportProductContent_Component extends javax.swing.JPanel {

    private Header_Component header_Component;
    private ImportProductPage_Component orderProductPage_Component;
    private ImportDetails_Component parent;

    public ImportProductContent_Component(ImportDetails_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout(0, 15));
        initData();
        addComponents();
    }

    public ImportProductContent_Component(ImportDetails_Component parent, GoodsReceipt goodsReceipt) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout(0, 15));
        initData(goodsReceipt);
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
        orderProductPage_Component = new ImportProductPage_Component(this);
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

    private void initData(GoodsReceipt goodsReceipt) {
        header_Component = new Header_Component(this);
        orderProductPage_Component = new ImportProductPage_Component(this, goodsReceipt);
    }

    public void updateImportProducts(GoodsReceipt goodsReceipt, double deliveryFree, double discount, double otherDiscount, double totalPrice) {
        orderProductPage_Component.updateImportProducts(goodsReceipt, deliveryFree, discount, otherDiscount, totalPrice);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
