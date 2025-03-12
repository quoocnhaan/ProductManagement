/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import model.Bills;
import view.component.Order.Header.HeaderTitle_Component;
import view.component.Order.Pagination.Pagination_Component;

/**
 *
 * @author PC
 */
public class OrderDetails_Component extends javax.swing.JPanel {

    private OrderDetailsPage_Component orderDetailsPage_Component;
    private Footer footer;
    private JDialog dialog;
    private HeaderTitle_Component parent;
    private Pagination_Component paginationParent;
    private Bills bills;

    public OrderDetails_Component(JDialog jDialog, HeaderTitle_Component parent) {
        initComponents();

        this.parent = parent;
        this.dialog = jDialog;
        orderDetailsPage_Component = new OrderDetailsPage_Component(dialog, this);
        footer = new Footer(this);

        setLayout(new BorderLayout());
        add(orderDetailsPage_Component, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    public OrderDetails_Component(Pagination_Component paginationParent, Bills bills, JDialog addProductDialog) {
        initComponents();
        this.paginationParent = paginationParent;
        dialog = addProductDialog;
        orderDetailsPage_Component = new OrderDetailsPage_Component(paginationParent, bills, addProductDialog);
        this.bills = bills;

        setLayout(new BorderLayout());
        footer = new Footer(this);
        add(orderDetailsPage_Component);
        add(footer, BorderLayout.SOUTH);
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
        orderDetailsPage_Component.updateImportProducts(bills);
        if (parent != null) {
            parent.resetDataWhenAdded();
        } else {
            paginationParent.resetDataWhenEdit();
        }
    }

    public void close() {
        if (dialog != null) {
            dialog.dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
