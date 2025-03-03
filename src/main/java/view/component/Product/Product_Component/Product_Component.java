/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.Product_Component;

import controller.Functional.Functional;
import controller.Session.SharedData;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.Product;
import view.component.Btn.IconButton;
import view.component.CustomComponent.CustomCheckbox;
import view.component.Product.Pagination.Pagination_Component;
import view.component.Product.Feature.SubFeature_Component;
import view.component.Product.Feature.ProductName_Component;
import view.component.Product.ProductPage_Component;

/**
 *
 * @author PC
 */
public class Product_Component extends javax.swing.JPanel {

    private CustomCheckbox customCheckbox;
    private IconButton editBtn;
    private Pagination_Component parent;
    private ProductPage_Component productPage_Component;
    private Product product;

    public Product_Component(Product product, Pagination_Component parent) {
        initComponents();
        this.parent = parent;
        this.product = product;
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        addComponents(product);
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
        if (customCheckbox.isSelected()) {
            changeColor(true);
        } else {
            changeColor(false);
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // open detail
    }//GEN-LAST:event_formMouseClicked

    private void addComponents(Product product) {

        customCheckbox = new CustomCheckbox(true);

        add(customCheckbox);

        ProductName_Component productName = new ProductName_Component(product.getName(), product.getCode(), Functional.convertByteArrayToIcon(product.getImg()));

        productName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                changeColor(true);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (customCheckbox.isSelected()) {
                    changeColor(true);
                } else {
                    changeColor(false);
                }
            }

            @Override
            public void mouseClicked(MouseEvent evt) {
                //open view detail
            }
        });
        add(productName);

        List<String> features = new ArrayList<>();
        //"Brand", "Quantity", "Sale Price", "Discount", "Type", "Gender"

        features.add(product.getBrand().getName());
        features.add(product.getAmount() + "");
        features.add(product.getPrice() + "");
        features.add("0");
        features.add("10ml");
        features.add("Man");

        for (int i = 0; i < features.size(); i++) {
            SubFeature_Component subFeature = new SubFeature_Component(features.get(i));

            subFeature.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    changeColor(true);
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    if (customCheckbox.isSelected()) {
                        changeColor(true);
                    } else {
                        changeColor(false);
                    }
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
        Color newColor = isInside ? new Color(247, 249, 250) : Color.WHITE;

        // Change the background of the Product_Component
        setBackground(newColor);

        // Iterate over all child components and change their background
        Component[] components = getComponents();
        for (Component component : components) {
            component.setBackground(newColor);
        }
        // Repaint the panel to ensure the new background is applied
        repaint();
    }

    public void changeColor() {
        Color newColor = new Color(247, 249, 250);

        // Change the background of the Product_Component
        setBackground(newColor);

        // Iterate over all child components and change their background
        Component[] components = getComponents();
        for (Component component : components) {
            component.setBackground(newColor);
        }
        // Repaint the panel to ensure the new background is applied
        repaint();
    }

    public void changeStatusCheckbox(boolean isCheck) {
        customCheckbox.setSelected(isCheck);
    }

    private void addEvents() {
        Product_Component product_Component = this;

        customCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    formMouseEntered();
                    SharedData.selectedAmount++;
                    if (!SharedData.beingSelected) {
                        SharedData.selectedProduct.add(product_Component);
                    }
                    if (customCheckbox.isFocusOwner()) {
                        productPage_Component.checkStatusSelectAllCheckbox();
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    formMouseExited();
                    SharedData.selectedAmount--;
                    if (!SharedData.beingSelected) {
                        SharedData.selectedProduct.remove(product_Component);
                    }
                    if (customCheckbox.isFocusOwner()) {
                        productPage_Component.checkStatusSelectAllCheckbox();
                    }
                }
                SharedData.selectedProduct.sort((p1, p2) -> Integer.compare(p1.getProduct().getId(), p2.getProduct().getId()));
                parent.updateSelectedAmount();
                parent.changeStatusDeleteButton(SharedData.selectedAmount != 0);
                productPage_Component.checkStatusEditButton();
            }
        });

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hello");
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

    public boolean isSelected() {
        return customCheckbox.isSelected();
    }

    public void setProductPage_Component(ProductPage_Component productPage_Component) {
        this.productPage_Component = productPage_Component;
    }

    public Product getProduct() {
        return product;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
