/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct.ImportProductDetails.Product_Component;

import controller.Functional.Functional;
import controller.Session.SharedData;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import model.Product;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Feature.OneFeature_Component;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Feature.ProductName_Component;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Feature.QuantityFeature_Component;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Feature.SubFeature_Component;

/**
 *
 * @author PC
 */
public class Product_Component extends javax.swing.JPanel {

    private JButton deleteBtn;
    private Product product;
    private QuantityFeature_Component quantity;
    private SubFeature_Component price;
    private OneFeature_Component total;
    private ProductList_Component parent;
    private double totalValue;

    public Product_Component(Product product, ProductList_Component parent) {
        initComponents();
        this.parent = parent;
        this.product = product;
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        addComponents(product);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    private void addComponents(Product product) {

        ProductName_Component productName = new ProductName_Component(product.getName(), product.getType(), product.getCode(), Functional.convertByteArrayToIcon(product.getImg()));

        add(productName);

        quantity = new QuantityFeature_Component(this);
        quantity.setMaximumQuantity(100);
        add(quantity);

        price = new SubFeature_Component(product.getImportPrice(), 0);
        add(price);

        totalValue = product.getImportPrice();
        total = new OneFeature_Component(product.getImportPrice());
        add(total);

        deleteBtn = new JButton();
        add(deleteBtn);
    }

    private void addEvents() {
        Product_Component product_Component = this;
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.removeProduct(product_Component);
                if (!SharedData.browsedProduct.isEmpty()) {
                    Iterator<Product> iterator = SharedData.browsedProduct.iterator();
                    while (iterator.hasNext()) {
                        Product p = iterator.next();
                        if (p.getId() == product.getId()) {
                            iterator.remove();  // Safe removal during iteration
                        }
                    }
                }
            }
        });
    }

    public Product getProduct() {
        return product;
    }

    private void customComponents() {
        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bin.png"))); // NOI18N
        deleteBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteBtn.setBorderPainted(false);
        deleteBtn.setContentAreaFilled(false);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setFocusPainted(false);
    }

    public String getQuantity() {
        return quantity.getQuantity();
    }

    public double getImportPriceValue() {
        return product.getImportPrice();
    }

    public void updateTotal(int quantityValue) {
        double newTotal = price.getData() * quantityValue;
        total.updateTotal(newTotal);
        parent.updateTotal(newTotal - totalValue);
        totalValue = newTotal;
    }

    public double getTotalValue() {
        return totalValue;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
