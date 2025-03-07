/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails.OderProductDetails.Product_Component.Feature;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import view.component.Order.OrderDetails.OderProductDetails.Product_Component.Product_Component;

/**
 *
 * @author PC
 */
public class QuantityFeature_Component extends javax.swing.JPanel {
    
    private boolean isEditing = false;
    private EmptyBorder emptyBorder = new EmptyBorder(1, 1, 1, 1);
    private MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, new Color(60, 63, 65));
    private Product_Component parent;
    
    public QuantityFeature_Component(String text, Product_Component parent) {
        initComponents();
        this.parent = parent;
        customComponents();
        quantity.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        quantity = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        quantity.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        quantity.setForeground(new java.awt.Color(131, 131, 131));
        quantity.setText("jTextField1");
        quantity.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables

    private void customComponents() {
        quantity.setEditable(false); // Initially non-editable to behave like JLabel
        quantity.setBackground(Color.WHITE); // Ensure the background stays white
        quantity.setDisabledTextColor(Color.BLACK); // Ensure the text is visible when disabled
    }
    
    public void setEditable(String str) {
        if (str.equals("Edit")) {
            if (!isEditing) {
                parent.storeData();
                quantity.setEditable(true);
                setEditBorder(true);
            } else {
                //to-do: save to database
                quantity.setEditable(false);
                setEditBorder(false);
            }
        } else {
            parent.rollback();
            quantity.setEditable(false);
            setEditBorder(false);
        }
        isEditing = !isEditing;
    }
    
    private void setEditBorder(boolean editing) {
        if (editing) {
            quantity.setBorder(matteBorder);
        } else {
            quantity.setBorder(emptyBorder);
        }
    }
    
    public String getQuantity() {
        return quantity.getText();
    }
    
    public void setPrevData(String data) {
        quantity.setText(data);
    }
}
