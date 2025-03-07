/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails;

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
public class CustomerDetails_Component extends javax.swing.JPanel {

    private boolean isEditing = false;
    private ImageIcon editIcon = new ImageIcon(getClass().getResource("/icon/edit.png"));
    private ImageIcon checkIcon = new ImageIcon(getClass().getResource("/icon/check.png"));
    private EmptyBorder emptyBorder = new EmptyBorder(1, 1, 1, 1);
    private MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, new Color(60, 63, 65));

    private String prevName;
    private String prevPhone;

    public CustomerDetails_Component() {
        initComponents();
        initData();
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
        name = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        accept = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Customer Details");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(131, 131, 131));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(131, 131, 131));
        jLabel3.setText("Phone");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(131, 131, 131));
        jLabel4.setText("CLV");

        name.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        name.setForeground(new java.awt.Color(131, 131, 131));
        name.setText("Lam Quoc Nhan");
        name.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        phone.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        phone.setForeground(new java.awt.Color(131, 131, 131));
        phone.setText("0968270553");
        phone.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

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

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(131, 131, 131));
        jLabel5.setText("300000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 275, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(78, 78, 78)
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(126, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocus();
    }//GEN-LAST:event_formMouseClicked

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        isEditing = !isEditing;
        prevName = name.getText();
        prevPhone = phone.getText();
        changeStatusComponents();
    }//GEN-LAST:event_acceptActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        isEditing = !isEditing;
        name.setText(prevName);
        phone.setText(prevPhone);
        changeStatusComponents();
    }//GEN-LAST:event_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables

    private void settings(JTextField textField) {
        textField.setEditable(false); // Initially non-editable to behave like JLabel
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Set right-to-left text orientation
        textField.setBackground(Color.WHITE); // Ensure the background stays white
        textField.setDisabledTextColor(Color.BLACK); // Ensure the text is visible when disabled
    }

    private void customComponents() {
        settings(name);
        settings(phone);
        cancel.setEnabled(false);
    }

    private void setEditable(JTextField textField, boolean status) {
        textField.setEditable(status);
        if (status) {
            textField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT); // Set right-to-left text orientation
        } else {
            textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Set right-to-left text orientation
        }
    }

    private void changeStatusComponents() {
        if (isEditing) {
            accept.setIcon(checkIcon);
            cancel.setEnabled(isEditing);
            setEditable(name, isEditing);
            setEditable(phone, isEditing);
            setEditBorder();
        } else {
            accept.setIcon(editIcon);
            cancel.setEnabled(isEditing);
            setEditable(name, isEditing);
            setEditable(phone, isEditing);
            setEditBorder();
        }
    }

    private void setEditBorder() {
        if (isEditing) {
            name.setBorder(matteBorder);
            phone.setBorder(matteBorder);
        } else {
            name.setBorder(emptyBorder);
            phone.setBorder(emptyBorder);
        }
    }

    private void initData() {
        prevName = name.getText();
        prevPhone = phone.getText();
    }
}
