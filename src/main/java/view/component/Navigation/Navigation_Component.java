/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Navigation;

import controller.Functional.Functional;
import controller.Session.SharedData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import model.NavigationItem;

/**
 *
 * @author LENOVO
 */
public class Navigation_Component extends javax.swing.JPanel {

    /**
     * Creates new form Navigation2_Component
     */
    private boolean isMouseInside = false;
    private boolean isSelected = false;
    ImageIcon foscusingIcon, exitedIcon;
    private String pageName;

    public Navigation_Component(NavigationItem navigationItem) {
        initComponents();
        initData(navigationItem);
        pageName = navigationItem.getName();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set radiant gradient if mouse is inside the panel, otherwise set white background
        if (isMouseInside || isSelected) {
            GradientPaint gradient = new GradientPaint(0, 0, new Color(153, 102, 255), getWidth(), getHeight(), new Color(177, 156, 217));
            g2d.setPaint(SharedData.mainColor);
            name.setForeground(Color.WHITE);
            name.setFont(new Font("Roboto", Font.PLAIN, 15));
            icon.setIcon(Functional.scaleImg(icon, foscusingIcon));
        } else {
            g2d.setColor(new Color(250, 250, 250)); // White background when mouse is outside
            name.setForeground(Color.BLACK);
            name.setFont(new Font("Roboto", Font.PLAIN, 14));
            icon.setIcon(Functional.scaleImg(icon, exitedIcon));
        }

        // Draw a rounded rectangle as the background
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
    }

    @Override
    protected void paintBorder(Graphics g) {
        if (isMouseInside || isSelected) {
            // Optional: Draw a border around the panel
            //g.setColor(new Color(177, 156, 217));
            g.setColor(SharedData.mainColor);

            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // Rounded border
        } else {
            g.setColor(Color.white);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

        setBackground(new java.awt.Color(253, 253, 253));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(154, 50));
        setMinimumSize(new java.awt.Dimension(154, 50));
        setPreferredSize(new java.awt.Dimension(154, 50));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        icon.setSize(25, 25);

        name.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("Product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        isMouseInside = true; // Set flag when the mouse enters
        repaint(); // Repaint the panel with gradient background
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        isMouseInside = false; // Unset flag when the mouse exits
        repaint(); // Repaint the panel with white background
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables

    private void initData(NavigationItem navigationItem) {
        this.name.setText(navigationItem.getName());

        this.foscusingIcon = Functional.convertByteArrayToIcon(navigationItem.getFocusingIcon());

        this.exitedIcon = Functional.convertByteArrayToIcon(navigationItem.getExitedIcon());
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        repaint();
    }

    public String getName() {
        return pageName;
    }
}
