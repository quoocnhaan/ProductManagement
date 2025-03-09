/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.SelectingProduct;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import view.component.Product.ImportProduct.ImportProductDetails.Header_Component.Header_Component;
import view.component.Product.PaginationWithSearchBar;

/**
 *
 * @author PC
 */
public class SelectingProduct_Component extends javax.swing.JPanel {

    private PaginationWithSearchBar paginationWithSearchBar;
    private Footer footer;
    private JDialog jDialog;
    private Header_Component parent;

    public SelectingProduct_Component(JDialog jDialog, Header_Component parent) {
        initComponents();
        this.jDialog = jDialog;
        this.parent = parent;
        paginationWithSearchBar = new PaginationWithSearchBar(null, true);
        footer = new Footer(this);

        setLayout(new BorderLayout(0, 15));
        add(paginationWithSearchBar, BorderLayout.CENTER);
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

    public void updateDataWhenBrowse() {
        parent.updateDataWhenBrowse();
    }

    public void close() {
        if (jDialog != null) {
            jDialog.dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
