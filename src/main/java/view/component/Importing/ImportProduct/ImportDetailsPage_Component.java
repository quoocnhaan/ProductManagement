/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct;

import controller.Session.SharedData;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import model.GoodsReceipt;
import view.component.Importing.Header.HeaderTitle_Component;
import view.component.Importing.Pagination.Pagination_Component;

/**
 *
 * @author PC
 */
public class ImportDetailsPage_Component extends javax.swing.JPanel {

    private ImportDetails_Component importDetails_Component;
    private Footer footer;
    private JDialog dialog;
    private HeaderTitle_Component parent;

    public ImportDetailsPage_Component(JDialog jDialog, HeaderTitle_Component parent) {
        initComponents();

        this.parent = parent;
        this.dialog = jDialog;
        importDetails_Component = new ImportDetails_Component(this);
        footer = new Footer(this);

        setLayout(new BorderLayout());
        add(importDetails_Component, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    public ImportDetailsPage_Component(Pagination_Component parent, GoodsReceipt goodsReceipt, JDialog addProductDialog) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

    public void saveImportProducts() {
        importDetails_Component.saveImportProducts();
        parent.resetDataWhenAdded();
    }

    public void close() {
        if (dialog != null) {
            SharedData.browsedProduct.clear();
            dialog.dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
