/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct;

import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import model.GoodsReceipt;
import view.component.Importing.ImportProduct.ImportProductDetails.ImportProductContent_Component;

/**
 *
 * @author PC
 */
public class ImportDetails_Component extends javax.swing.JPanel {

    private ImportProductContent_Component importProductContent_Component;
    private ImportSumary_Component importSumary_Component;
    private ImportDetailsPage_Component parent;

    public ImportDetails_Component(ImportDetailsPage_Component parent) {
        initComponents();

        this.parent = parent;
        setLayout(new BorderLayout(20, 0));
        setBorder(new EmptyBorder(15, 15, 15, 15));

        importSumary_Component = new ImportSumary_Component(this);
        importProductContent_Component = new ImportProductContent_Component(this);

        add(importSumary_Component, BorderLayout.EAST);
        add(importProductContent_Component, BorderLayout.CENTER);
    }

    public ImportDetails_Component(ImportDetailsPage_Component parent, GoodsReceipt goodsReceipt) {
        initComponents();

        this.parent = parent;
        setLayout(new BorderLayout(20, 0));
        setBorder(new EmptyBorder(15, 15, 15, 15));

        importSumary_Component = new ImportSumary_Component(this, goodsReceipt);
        importProductContent_Component = new ImportProductContent_Component(this, goodsReceipt);

        add(importSumary_Component, BorderLayout.EAST);
        add(importProductContent_Component, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(248, 248, 248));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateSumaryData(double price) {
        importSumary_Component.updateSumaryData(price);
    }

    public void updateTotal(double price) {
        importSumary_Component.updateTotal(price);
    }

    void updateImportProducts(GoodsReceipt goodsReceipt) {
        importProductContent_Component.updateImportProducts(goodsReceipt, importSumary_Component.getDiscount(), importSumary_Component.getDebugGraphicsOptions(), importSumary_Component.getOtherDiscount(), importSumary_Component.getTotalPrice());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
