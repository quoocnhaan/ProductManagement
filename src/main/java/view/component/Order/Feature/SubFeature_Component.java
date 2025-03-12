/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.Feature;

import controller.Functional.Functional;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author PC
 */
public class SubFeature_Component extends javax.swing.JPanel {

    /**
     * Creates new form ProductName_Component
     */
    public SubFeature_Component(String text) {
        initComponents();
        this.feature.setText(text);
    }

    public SubFeature_Component(String text, boolean changeColor) {
        initComponents();
        feature.setFont(new Font("Roboto", Font.BOLD, 15));
        if (changeColor) {
            feature.setForeground(Functional.adjustColorBrightness(Color.green, 0.4f));
        } else {
            feature.setForeground(Color.red);
        }
        this.feature.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        feature = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        feature.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        feature.setForeground(new java.awt.Color(0, 0, 0));
        feature.setText("Paid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(feature, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(feature, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel feature;
    // End of variables declaration//GEN-END:variables
}
