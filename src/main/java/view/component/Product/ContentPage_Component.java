/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product;

import java.awt.BorderLayout;
import view.component.Product.Header.Header_Component;

/**
 *
 * @author PC
 */
public class ContentPage_Component extends javax.swing.JPanel {

    private Header_Component header_Component;
    private DataTable_Component dataTable_Component;

    public ContentPage_Component() {
        initComponents();

        header_Component = new Header_Component(this);
        dataTable_Component = new DataTable_Component(this, false);

        setLayout(new BorderLayout(0, 20));
        add(header_Component, BorderLayout.NORTH);
        add(dataTable_Component, BorderLayout.CENTER);
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void resetDataWhenAdded() {
        header_Component.updateData();
        dataTable_Component.resetDataWhenAdded();
    }

    public void updateData() {
        header_Component.updateData();
    }

    public void resetSearchOption() {
        dataTable_Component.resetSearchOption();
    }

    public void resetPageWhenCloseImport() {
        dataTable_Component.resetPageWhenCloseImport();
        header_Component.updateData();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
