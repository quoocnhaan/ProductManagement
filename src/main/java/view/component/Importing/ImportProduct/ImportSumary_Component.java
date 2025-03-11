/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import model.GoodsReceipt;

/**
 *
 * @author PC
 */
public class ImportSumary_Component extends javax.swing.JPanel {

    private boolean isEditing = false;
    private ImageIcon editIcon = new ImageIcon(getClass().getResource("/icon/edit.png"));
    private ImageIcon checkIcon = new ImageIcon(getClass().getResource("/icon/check.png"));
    private EmptyBorder emptyBorder = new EmptyBorder(1, 1, 1, 1);
    private MatteBorder matteBorder = new MatteBorder(0, 0, 1, 0, new Color(60, 63, 65));

    private GoodsReceipt goodsReceipt;

    private double discountValue;
    private double deliveryFeeValue;
    private double otherDiscountValue;

    private double subtotalValue;
    private double totalValue;
    private double paidValue;
    private double balanceValue;

    private String prevDiscount;
    private String prevDeliveryFee;
    private String prevOtherDiscount;

    private ImportDetails_Component parent;

    public ImportSumary_Component(ImportDetails_Component parent) {
        initComponents();
        totalValue = 0;
        subtotalValue = 0;
        this.parent = parent;
        customComponents();
        addEvents();
    }

    public ImportSumary_Component(ImportDetails_Component parent, GoodsReceipt goodsReceipt) {
        initComponents();
        this.goodsReceipt = goodsReceipt;
        totalValue = 0;
        subtotalValue = 0;
        this.parent = parent;
        customComponents();
        initData();
        addEvents();
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
        jLabel7 = new javax.swing.JLabel();
        paid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Importing Summary");

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
        subtotal.setText("0");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total");

        total.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 0));
        total.setText("0");

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
        discount.setText("0");
        discount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        deliveryFee.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        deliveryFee.setForeground(new java.awt.Color(131, 131, 131));
        deliveryFee.setText("0");
        deliveryFee.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        otherDiscount.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        otherDiscount.setForeground(new java.awt.Color(131, 131, 131));
        otherDiscount.setText("0");
        otherDiscount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Paid");

        paid.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        paid.setForeground(new java.awt.Color(0, 0, 0));
        paid.setText("0");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Balance");

        balance.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        balance.setForeground(new java.awt.Color(0, 0, 0));
        balance.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(balance))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deliveryFee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(otherDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(paid, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(total))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(paid))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(balance))
                .addContainerGap(37, Short.MAX_VALUE))
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
    private javax.swing.JLabel balance;
    private javax.swing.JButton cancel;
    private javax.swing.JTextField deliveryFee;
    private javax.swing.JTextField discount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField otherDiscount;
    private javax.swing.JLabel paid;
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

    void updateSumaryData(double price) {
        subtotalValue += price;
        subtotal.setText(formatPrice(subtotalValue));

        updateTotal();
    }

    private String formatPrice(double priceValue) {
        if (priceValue == 0) {
            return "0";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(priceValue);
    }

    private void updateTotal() {
        double total = ((subtotalValue + deliveryFeeValue) * (1 - discountValue / 100)) - otherDiscountValue;
        totalValue = total;
        this.total.setText(formatPrice(total));
    }

    private void addEvents() {
        discount.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText().replace(",", "");
                double value;

                try {
                    value = Double.parseDouble(text);

                    // Adjust value if it's out of bounds
                    if (value < 0) {
                        value = 0;
                        ((JTextField) input).setText("0");
                    } else if (value > 100) {
                        value = 100;
                        ((JTextField) input).setText("100");
                    } else {
                        ((JTextField) input).setText(formatPrice(value));
                    }
                    discountValue = value;
                } catch (NumberFormatException e) {
                    // If it's not a valid number, set the field to 1
                    discountValue = 0;
                    ((JTextField) input).setText("0");
                }
                updateTotal();
                return true; // Allow the input after correction
            }
        });

        deliveryFee.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText().replace(",", "");
                double value;

                try {
                    value = Double.parseDouble(text);

                    // Adjust value if it's out of bounds
                    if (value < 0) {
                        value = 0;
                        ((JTextField) input).setText("0");
                    } else {
                        ((JTextField) input).setText(formatPrice(value));
                    }
                    deliveryFeeValue = value;
                } catch (NumberFormatException e) {
                    // If it's not a valid number, set the field to 1
                    deliveryFeeValue = 0;
                    ((JTextField) input).setText("0");
                }

                // Call your action here after verifying
                updateTotal();
                return true; // Allow the input after correction
            }
        });

        otherDiscount.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText().replace(",", "");
                double value;

                try {
                    value = Double.parseDouble(text);

                    if (value < 0) {
                        value = 0;
                        ((JTextField) input).setText("0");
                    } else {
                        ((JTextField) input).setText(formatPrice(value));
                    }
                    otherDiscountValue = value;
                } catch (NumberFormatException e) {
                    // If it's not a valid number, set the field to 1
                    otherDiscountValue = 0;
                    ((JTextField) input).setText("0");
                }

                // Call your action here after verifying
                updateTotal();
                return true; // Allow the input after correction
            }
        });
    }

    public void updateTotal(double price) {
        subtotalValue += price;
        subtotal.setText(formatPrice(subtotalValue));

        double total = subtotalValue * (1 - discountValue / 100) + deliveryFeeValue - otherDiscountValue;
        totalValue = total;
        this.total.setText(formatPrice(total));

    }

    public double getTotalPrice() {
        return totalValue;
    }

    public double getDiscount() {
        return discountValue;
    }

    public double getDeliveryFee() {
        return deliveryFeeValue;
    }

    public double getOtherDiscount() {
        return otherDiscountValue;
    }

    public double getTotalPaid() {
        return paidValue;
    }

    public double getBalance() {
        return balanceValue;
    }

    private void initData() {
        discountValue = goodsReceipt.getDiscount();
        discount.setText(formatPrice(discountValue));

        deliveryFeeValue = goodsReceipt.getDelivertyFee();
        deliveryFee.setText(formatPrice(deliveryFeeValue));

        otherDiscountValue = goodsReceipt.getOtherDiscount();
        otherDiscount.setText(formatPrice(otherDiscountValue));

        paidValue = deliveryFeeValue;
    }

    void updateBalance(double paid) {
        paidValue += paid;
        balanceValue = totalValue - paidValue;
        this.paid.setText(formatPrice(paidValue));
        balance.setText(formatPrice(balanceValue));
    }
}
