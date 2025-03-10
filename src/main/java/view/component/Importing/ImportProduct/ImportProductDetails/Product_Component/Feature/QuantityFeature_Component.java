/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Feature;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Product_Component;

/**
 *
 * @author PC
 */
public class QuantityFeature_Component extends javax.swing.JPanel {

    private MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, new Color(60, 63, 65));
    private Product_Component parent;

    public QuantityFeature_Component(Product_Component parent) {
        initComponents();
        this.parent = parent;
        customComponents();
        quantity.setText("1");
    }

    public QuantityFeature_Component(Product_Component parent, int amount) {
        initComponents();
        this.parent = parent;
        customComponents();
        quantity.setText(amount + "");
        parent.updateTotal(amount);
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
        quantity.setEditable(true);
        quantity.setBorder(matteBorder);
        quantity.setBackground(Color.WHITE); // Ensure the background stays white
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public void setMaximumQuantity(int quantity) {
        this.quantity.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                try {
                    int value = Integer.parseInt(text);

                    // Adjust value if it's out of bounds
                    if (value < 1) {
                        ((JTextField) input).setText("1");
                    } else if (value > quantity) {
                        ((JTextField) input).setText(String.valueOf(quantity));
                    }
                } catch (NumberFormatException e) {
                    // If it's not a valid number, set the field to 1
                    ((JTextField) input).setText("1");
                }
                int quantityValue = Integer.parseInt(((JTextField) input).getText());
                parent.updateTotal(quantityValue);
                return true;
            }
        });
    }
}
