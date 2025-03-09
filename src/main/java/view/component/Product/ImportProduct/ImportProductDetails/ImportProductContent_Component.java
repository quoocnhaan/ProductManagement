/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.ImportProduct.ImportProductDetails;

import java.awt.BorderLayout;
import model.Product;
import view.component.Product.ImportProduct.ImportDetails_Component;
import view.component.Product.ImportProduct.ImportProductDetails.Header_Component.Header_Component;

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

    public void transferData(Product newProduct, double importPriceValue) {
        orderProductPage_Component.addNewProduct(newProduct, importPriceValue);
        updateSumaryData(importPriceValue);
    }

    private void updateSumaryData(double price) {
        parent.updateSumaryData(price);
    }

    public void updateDataWhenBrowse() {
        orderProductPage_Component.addBrowsedProducts();
    }

    public void saveImportProducts() {
        orderProductPage_Component.saveImportProducts();
    }

    void updateTotal(double price) {
        parent.updateTotal(price);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
