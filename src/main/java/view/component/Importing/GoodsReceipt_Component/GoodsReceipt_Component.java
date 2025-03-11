/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.GoodsReceipt_Component;

import controller.Functional.Functional;
import controller.Session.SharedData;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.border.LineBorder;
import model.GoodsReceipt;
import view.component.Btn.IconButton;
import view.component.Importing.Pagination.Pagination_Component;
import view.component.Importing.Feature.SubFeature_Component;
import view.component.Importing.Feature.GoodsReceiptId_Component;
import view.component.Importing.ImportProduct.ImportDetailsPage_Component;
import view.component.Importing.ProductPage_Component;

/**
 *
 * @author PC
 */
public class GoodsReceipt_Component extends javax.swing.JPanel {

    private IconButton editBtn;
    private Pagination_Component parent;
    private ProductPage_Component productPage_Component;
    private GoodsReceipt goodsReceipt;
    private Color mainColor = Color.WHITE;

    public GoodsReceipt_Component(GoodsReceipt goodsReceipt, Pagination_Component parent) {
        initComponents();
        this.parent = parent;
        this.goodsReceipt = goodsReceipt;
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        addComponents(goodsReceipt);
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
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        changeColor(true);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        changeColor(false);
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // open detail
    }//GEN-LAST:event_formMouseClicked

    private void addComponents(GoodsReceipt goodsReceipt) {

        GoodsReceiptId_Component productName = new GoodsReceiptId_Component(goodsReceipt.getId());

        productName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                changeColor(true);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                changeColor(false);
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                //open view detail
            }
        });
        add(productName);

        List<String> features = new ArrayList<>();

        features.add(goodsReceipt.getDate() + "");
        features.add(goodsReceipt.getAmount() + "");
        features.add(formatPrice(goodsReceipt.getTotalPrices()));
        features.add("True");

        for (int i = 0; i < features.size(); i++) {
            SubFeature_Component subFeature = new SubFeature_Component(features.get(i));

            subFeature.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    changeColor(true);
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    changeColor(false);
                }

                @Override
                public void mouseClicked(MouseEvent evt) {
                    //open view detail
                }
            });

            add(subFeature);
        }

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/pencil.png"));
        editBtn = new IconButton("Edit", icon, false);
        add(editBtn);

    }

    public void changeColor(boolean isInside) {
        Color newColor = isInside ? Functional.adjustColorBrightness(mainColor, 0.97f) : mainColor;

        // Change the background of the GoodsReceipt_Component
        setBackground(newColor);

        // Iterate over all child components and change their background
        Component[] components = getComponents();
        for (Component component : components) {
            component.setBackground(newColor);
        }
        // Repaint the panel to ensure the new background is applied
        repaint();
    }

    public void changeOutOfStockColor() {
        // Change the background of the GoodsReceipt_Component
        setBackground(mainColor);

        // Iterate over all child components and change their background
        Component[] components = getComponents();
        for (Component component : components) {
            component.setBackground(mainColor);
        }
        // Repaint the panel to ensure the new background is applied
        repaint();
    }

    private void addEvents() {

        GoodsReceipt goodsReceipt = this.goodsReceipt;

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addProductDialog = new JDialog((Frame) null, "Edit Product", true);  // true for modal
                addProductDialog.setSize(1250, 850);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen
                addProductDialog.setResizable(false);
                //addProductDialog.add(new EditProduct_Component(parent, goodsReceipt, addProductDialog));

                ImportDetailsPage_Component importDetailsPage_Component = new ImportDetailsPage_Component(parent, goodsReceipt, addProductDialog);
                addProductDialog.setResizable(false);
                addProductDialog.setUndecorated(true);
                importDetailsPage_Component.setBorder(new LineBorder(Color.GRAY, 1));
                addProductDialog.add(importDetailsPage_Component);

                addProductDialog.setVisible(true);

                SharedData.browsedProduct.clear();
            }
        });

    }

    private void formMouseEntered() {
        changeColor(true);
    }

    private void formMouseExited() {
        changeColor(false);
    }

    public void changeStatusEditBtn(boolean b) {
        editBtn.setEnabled(b);
    }

    public void setProductPage_Component(ProductPage_Component productPage_Component) {
        this.productPage_Component = productPage_Component;
    }

    public GoodsReceipt getGoodsReceipt() {
        return goodsReceipt;
    }

    private String formatPrice(double priceValue) {
        if (priceValue == 0) {
            return "0";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(priceValue);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
