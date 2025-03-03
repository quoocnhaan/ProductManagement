/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.Header;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.component.Btn.IconButton;
import view.component.Btn.RoundedButton;
import view.component.Product.AddingProduct.AddProduct_Component;

/**
 *
 * @author LENOVO
 */
public class HeaderTitle_Component extends javax.swing.JPanel {

    private RoundedButton createBtn;
    private IconButton exportBtn;
    private Header_Component parent;

    public HeaderTitle_Component(Header_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
        addComponents();
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

    private void addComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding around the main panel

        // Title on the left
        JLabel titleLabel = new JLabel("Product");
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 24)); // Set title font and size
        mainPanel.add(titleLabel, BorderLayout.WEST);

        // Panel to hold buttons on the right
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align buttons to the right
        buttonPanel.setBackground(Color.WHITE);

        // Add button
        createBtn = new RoundedButton("Create product", true, 15, 35);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/export.png"));
        exportBtn = new IconButton("Export", icon, true);

        // Add buttons to the panel
        buttonPanel.add(exportBtn);
        buttonPanel.add(createBtn);

        mainPanel.add(buttonPanel, BorderLayout.EAST);

        add(mainPanel);
    }

    private void addEvents() {
        HeaderTitle_Component headerTitle_Component = this;
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JDialog for the popup
                JDialog addProductDialog = new JDialog((Frame) null, "Add New Product", true);  // true for modal
                addProductDialog.setSize(1250, 900);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen

                addProductDialog.add(new AddProduct_Component(headerTitle_Component));

                addProductDialog.setVisible(true);
            }
        });
    }

    public void resetDataWhenAdded(int quantity) {
        parent.resetDataWhenAdded(quantity);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
