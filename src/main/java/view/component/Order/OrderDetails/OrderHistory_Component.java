/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails;

import controller.Session.SharedData;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author PC
 */
public class OrderHistory_Component extends javax.swing.JPanel {

    Color unSelected = new Color(126, 126, 126);
    Color fg = new Color(153, 153, 153);
    ImageIcon clickIcon = new ImageIcon(getClass().getResource("/icon/dotc.png"));
    ImageIcon unclickIcon = new ImageIcon(getClass().getResource("/icon/dot.png"));

    public OrderHistory_Component() {
        initComponents();
        customComponents();
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
        paidText = new javax.swing.JLabel();
        paid = new javax.swing.JToggleButton();
        packed = new javax.swing.JToggleButton();
        packedText = new javax.swing.JLabel();
        shipped = new javax.swing.JToggleButton();
        shippedText = new javax.swing.JLabel();
        delivered = new javax.swing.JToggleButton();
        deliveredText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Order History");

        paidText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        paidText.setForeground(new java.awt.Color(153, 153, 153));
        paidText.setText("22 May, 2025");

        paid.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        paid.setForeground(new java.awt.Color(126, 126, 126));
        paid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dot.png"))); // NOI18N
        paid.setText("Paid");
        paid.setIconTextGap(1);

        packed.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        packed.setForeground(new java.awt.Color(126, 126, 126));
        packed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dot.png"))); // NOI18N
        packed.setText("Packed");
        packed.setIconTextGap(1);

        packedText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        packedText.setForeground(new java.awt.Color(153, 153, 153));
        packedText.setText("22 May, 2025");

        shipped.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        shipped.setForeground(new java.awt.Color(126, 126, 126));
        shipped.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dot.png"))); // NOI18N
        shipped.setText("Shipped");
        shipped.setIconTextGap(1);

        shippedText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        shippedText.setForeground(new java.awt.Color(153, 153, 153));
        shippedText.setText("22 May, 2025");

        delivered.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        delivered.setForeground(new java.awt.Color(126, 126, 126));
        delivered.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dot.png"))); // NOI18N
        delivered.setText("Delivered");
        delivered.setIconTextGap(1);

        deliveredText.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        deliveredText.setForeground(new java.awt.Color(153, 153, 153));
        deliveredText.setText("22 May, 2025");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(paid)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(packed)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(packedText)))
                        .addComponent(paidText)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shipped)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(shippedText)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delivered)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(deliveredText)))))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paidText)
                .addGap(25, 25, 25)
                .addComponent(packed, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(packedText)
                .addGap(25, 25, 25)
                .addComponent(shipped, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shippedText)
                .addGap(25, 25, 25)
                .addComponent(delivered, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deliveredText)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton delivered;
    private javax.swing.JLabel deliveredText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton packed;
    private javax.swing.JLabel packedText;
    private javax.swing.JToggleButton paid;
    private javax.swing.JLabel paidText;
    private javax.swing.JToggleButton shipped;
    private javax.swing.JLabel shippedText;
    // End of variables declaration//GEN-END:variables

    private void customComponents() {
        settings(paid);
        settings(packed);
        settings(shipped);
        settings(delivered);

        deliveredText.setForeground(Color.white);
        packedText.setForeground(Color.white);
        paidText.setForeground(Color.white);
        shippedText.setForeground(Color.white);
    }

    private void settings(JToggleButton button) {
        button.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }

    private void addEvents() {

        paid.addActionListener(e -> {
            if (paid.isSelected()) {
                if (paid.getIcon() instanceof ImageIcon) {
                    paid.setIcon(clickIcon);

                    paid.revalidate();
                    paid.repaint();
                }
                paid.setForeground(SharedData.mainColor);
                paidText.setForeground(fg);
            } else {
                if (paid.getIcon() instanceof ImageIcon) {
                    paid.setIcon(unclickIcon);

                    paid.revalidate();
                    paid.repaint();
                }
                paid.setForeground(unSelected);
                paidText.setForeground(Color.white);
            }
        });

        packed.addActionListener(e -> {
            if (packed.isSelected()) {
                if (packed.getIcon() instanceof ImageIcon) {
                    packed.setIcon(clickIcon);

                    packed.revalidate();
                    packed.repaint();
                }
                packed.setForeground(SharedData.mainColor);
                packedText.setForeground(fg);
            } else {
                if (packed.getIcon() instanceof ImageIcon) {
                    packed.setIcon(unclickIcon);

                    packed.revalidate();
                    packed.repaint();
                }
                packed.setForeground(unSelected);
                packedText.setForeground(Color.white);
            }
        });

        shipped.addActionListener(e -> {
            if (shipped.isSelected()) {
                if (shipped.getIcon() instanceof ImageIcon) {
                    shipped.setIcon(clickIcon);

                    shipped.revalidate();
                    shipped.repaint();
                }
                shipped.setForeground(SharedData.mainColor);
                shippedText.setForeground(fg);
            } else {
                if (shipped.getIcon() instanceof ImageIcon) {
                    shipped.setIcon(unclickIcon);

                    shipped.revalidate();
                    shipped.repaint();
                }
                shipped.setForeground(unSelected);
                shippedText.setForeground(Color.white);
            }
        });

        delivered.addActionListener(e -> {
            if (delivered.isSelected()) {
                if (delivered.getIcon() instanceof ImageIcon) {
                    delivered.setIcon(clickIcon);

                    delivered.revalidate();
                    delivered.repaint();
                }
                delivered.setForeground(SharedData.mainColor);
                deliveredText.setForeground(fg);
            } else {
                if (delivered.getIcon() instanceof ImageIcon) {
                    delivered.setIcon(unclickIcon);

                    delivered.revalidate();
                    delivered.repaint();
                }
                delivered.setForeground(unSelected);
                deliveredText.setForeground(Color.white);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Example coordinates
        int x = 50;       // X position of the line
        int yStart = 70;  // Starting Y position
        int yEnd = 310;   // Ending Y position

        drawVerticalLine(g2d, x, yStart, yEnd);
    }

    public void drawVerticalLine(Graphics2D g2d, int x, int yStart, int yEnd) {
        // Set the color and stroke for the line
        g2d.setColor(fg);  // You can change the color as needed
        g2d.setStroke(new BasicStroke(1));  // Set line thickness

        // Draw the vertical line from yStart to yEnd at position x
        g2d.drawLine(x, yStart, x, yEnd);
    }
}
