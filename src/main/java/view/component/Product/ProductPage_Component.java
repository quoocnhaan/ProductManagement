/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product;

import java.awt.BorderLayout;
import java.util.List;
import view.component.Pagination.Pagination_Component;
import view.component.Product.Product_Component.ProductList_Component;
import view.component.Product.Product_Component.Product_Component;
import view.component.Product.Title.Title_Component;

/**
 *
 * @author PC
 */
public class ProductPage_Component extends javax.swing.JPanel {

    private Title_Component title_Component;
    private ProductList_Component productList_Component;
    private Pagination_Component parent;

    public ProductPage_Component(Pagination_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
        addComponents();
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
            .addGap(0, 1152, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addComponents() {
        title_Component = new Title_Component(this);
        productList_Component = new ProductList_Component();
        add(title_Component, BorderLayout.NORTH);
        add(productList_Component, BorderLayout.CENTER);
    }

    public void changeStatusCheckbox(boolean b) {
        productList_Component.changeStatusCheckbox(b);
    }

    public void updateData(List<Product_Component> list) {
        productList_Component.updateData(list);
        checkStatusSelectAllCheckbox();
    }

    public void changeStatusEditBtn(boolean b) {
        productList_Component.changeStatusEditBtn(b);
    }

    public void updateSelectedAmount() {
        parent.updateSelectedAmount();
    }

//    public int getSelectedAmount() {
//        return productList_Component.getSelectedAmount();
//    }
    
    public void checkStatusSelectAllCheckbox() {
        boolean isSelectAll = productList_Component.isSelectAll();
        title_Component.setSelected(isSelectAll);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
