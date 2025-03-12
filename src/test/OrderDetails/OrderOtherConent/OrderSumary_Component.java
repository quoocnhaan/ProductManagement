/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails.OrderOtherConent;

import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author PC
 */
public class OrderSumary_Component extends javax.swing.JPanel {

    private boolean isEditing = false;
    private ImageIcon editIcon = new ImageIcon(getClass().getResource("/icon/edit.png"));
    private ImageIcon checkIcon = new ImageIcon(getClass().getResource("/icon/check.png"));
    private EmptyBorder emptyBorder = new EmptyBorder(1, 1, 1, 1);
    private MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, new Color(60, 63, 65));

    private String prevDiscount;
    private String prevDeliveryFee;
    private String prevOtherDiscount;

    public OrderSumary_Component() {
        initComponents();
        customComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        accept = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        discount = new javax.swing.JTextField();
        deliveryFee = new javax.swing.JTextField();
        otherDiscount = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Order Summary");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(131, 131, 131));
        jLabel2.setText("Subtotal");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(131, 131, 131));
        jLabel3.setText("Discount");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(131, 131, 131));
        jLabel4.setText("Delivery Fee");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(131, 131, 131));
        jLabel5.setText("Other Discount");

        subtotal.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        subtotal.setForeground(new java.awt.Color(131, 131, 131));
        subtotal.setText("500000");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total");

        total.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));
        total.setText("50000");

        accept.setBackground(new java.awt.Color(255, 255, 255));
        accept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        accept.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        accept.setBorderPainted(false);
        accept.setContentAreaFilled(false);
        accept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accept.setFocusPainted(false);
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel2.png"))); // NOI18N
        cancel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cancel.setBorderPainted(false);
        cancel.setContentAreaFilled(false);
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.setFocusPainted(false);
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        discount.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        discount.setForeground(new java.awt.Color(131, 131, 131));
        discount.setText("Lam Quoc Nhan");
        discount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        deliveryFee.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        deliveryFee.setForeground(new java.awt.Color(131, 131, 131));
        deliveryFee.setText("Lam Quoc Nhan");
        deliveryFee.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        otherDiscount.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        otherDiscount.setForeground(new java.awt.Color(131, 131, 131));
        otherDiscount.setText("Lam Quoc Nhan");
        otherDiscount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deliveryFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otherDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(subtotal))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(deliveryFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(otherDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(total))
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        isEditing = !isEditing;
        prevDiscount = discount.getText();
        prevDeliveryFee = deliveryFee.getText();
        prevOtherDiscount = otherDiscount.getText();

        changeStatusComponents();
    }//GEN-LAST:event_acceptActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        isEditing = !isEditing;
        discount.setText(prevDiscount);
        deliveryFee.setText(prevDeliveryFee);
        otherDiscount.setText(prevOtherDiscount);
        changeStatusComponents();
    }//GEN-LAST:event_cancelActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField deliveryFee;
    private javax.swing.JTextField discount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField otherDiscount;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

    private void changeStatusComponents() {
        if (isEditing) {
            accept.setIcon(checkIcon);
            cancel.setEnabled(isEditing);
            setEditable(discount, isEditing);
            setEditable(deliveryFee, isEditing);
            setEditable(otherDiscount, isEditing);
            setEditBorder();
        } else {
            accept.setIcon(editIcon);
            cancel.setEnabled(isEditing);
            setEditable(discount, isEditing);
            setEditable(deliveryFee, isEditing);
            setEditable(otherDiscount, isEditing);
            setEditBorder();
        }
    }

    private void setEditBorder() {
        if (isEditing) {
            discount.setBorder(matteBorder);
            deliveryFee.setBorder(matteBorder);
            otherDiscount.setBorder(matteBorder);
        } else {
            discount.setBorder(emptyBorder);
            deliveryFee.setBorder(emptyBorder);
            otherDiscount.setBorder(emptyBorder);
        }
    }

    private void setEditable(JTextField textField, boolean status) {
        textField.setEditable(status);
        if (status) {
            textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // Set right-to-left text orientation
        } else {
            textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Set right-to-left text orientation
        }
    }

    private void customComponents() {
        settings(discount);
        settings(deliveryFee);
        settings(otherDiscount);

        cancel.setEnabled(false);
    }

    private void settings(JTextField textField) {
        textField.setEditable(false); // Initially non-editable to behave like JLabel
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Set right-to-left text orientation
        textField.setBackground(Color.WHITE); // Ensure the background stays white
        textField.setDisabledTextColor(Color.BLACK); // Ensure the text is visible when disabled
    }
}
