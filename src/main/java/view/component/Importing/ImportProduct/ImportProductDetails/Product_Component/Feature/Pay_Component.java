/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Feature;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Product_Component;

/**
 *
 * @author PC
 */
public class Pay_Component extends javax.swing.JPanel {

    private MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, new Color(60, 63, 65));
    private Product_Component parent;
    private double prevPaidValue;

    public Pay_Component(Product_Component parent, double paid) {
        initComponents();
        this.parent = parent;
        customComponents();
        prevPaidValue = paid;
        pay.setText(formatPrice(paid));
        addEvents();
        parent.updateBalance(paid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pay = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        pay.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        pay.setForeground(new java.awt.Color(131, 131, 131));
        pay.setText("jTextField1");
        pay.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField pay;
    // End of variables declaration//GEN-END:variables

    private void customComponents() {
        pay.setEditable(true);
        pay.setBorder(matteBorder);
        pay.setBackground(Color.WHITE); // Ensure the background stays white
    }

    private String formatPrice(double priceValue) {
        if (priceValue == 0) {
            return "0";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(priceValue);
    }

    private void addEvents() {
        this.pay.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                try {
                    int value = Integer.parseInt(text);

                    // Adjust value if it's out of bounds
                    if (value < 0) {
                        ((JTextField) input).setText("0");
                    }
                    ((JTextField) input).setText(formatPrice(value));

                } catch (NumberFormatException e) {
                    // If it's not a valid number, set the field to 1
                    ((JTextField) input).setText("0");
                }
                double paid = Double.parseDouble(((JTextField) input).getText().replace(",", ""));

                double t = prevPaidValue - paid;
                prevPaidValue = paid;
                parent.updateBalance(-t);
                return true;
            }
        });
    }

    public double getPaid() {
        return Double.parseDouble(pay.getText().replace(",", ""));
    }
}
