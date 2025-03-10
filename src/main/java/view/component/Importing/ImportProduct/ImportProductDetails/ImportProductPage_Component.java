/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.ImportProduct.ImportProductDetails;

import controller.DAO.GoodsReceiptDAO;
import controller.DAO.ProductDAO;
import controller.DAO.Product_SelectedDAO;
import controller.DAOImp.GoodsReceiptDAOImp;
import controller.DAOImp.ProductDAOImp;
import controller.DAOImp.Product_SelectedDAOImp;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import model.GoodsReceipt;
import model.Product;
import model.Product_Selected;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.CustomComponent.CustomScrollBarUI;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.ProductList_Component;
import view.component.Importing.ImportProduct.ImportProductDetails.Product_Component.Title.Title_Component;

;

/**
 *
 * @author PC
 */
public class ImportProductPage_Component extends javax.swing.JPanel {

    private Title_Component title_Component;
    private ProductList_Component productList_Component;
    private ImportProductContent_Component parent;

    public ImportProductPage_Component(ImportProductContent_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
        addComponents();
    }

    public ImportProductPage_Component(ImportProductContent_Component parent, GoodsReceipt goodsReceipt) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
        addComponents(goodsReceipt);
    }

    private void addComponents() {
        title_Component = new Title_Component();
        productList_Component = new ProductList_Component(this);

        JScrollPane scrollPane = new JScrollPane(productList_Component);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

        CustomScrollBarUI customScrollBarUI = new CustomScrollBarUI();
        verticalScrollBar.setUI(customScrollBarUI);

        verticalScrollBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                customScrollBarUI.setHovered(true);  // Set hover to true
                verticalScrollBar.repaint();  // Repaint to update color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                customScrollBarUI.setHovered(false);  // Set hover to false
                verticalScrollBar.repaint();  // Repaint to update color
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {  // Check if it's a left click
                    customScrollBarUI.setClicked(true);  // Set clicked to true
                    verticalScrollBar.repaint();  // Repaint to update color
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {  // Check if it's a left click
                    customScrollBarUI.setClicked(false);  // Set clicked to false
                    verticalScrollBar.repaint();  // Repaint to update color
                }
            }
        });

        // Set scroll bar width to something smaller
        verticalScrollBar.setPreferredSize(new Dimension(6, Integer.MAX_VALUE));

        add(title_Component, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    void addNewProduct(Product newProduct) {
        productList_Component.addNewProduct(newProduct);
    }

    void addBrowsedProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
            ProductDAO productDAO = new ProductDAOImp(session);

            List<Product_Selected> products = product_SelectedDAO.getAll();

            System.out.println("browsed product size: " + products.size());

            for (Product_Selected product : products) {
                Product product1 = productDAO.get(product.getProduct().getId());
                addNewProduct(product1);
                System.out.println("added browsed product");
                updateTotal(product1.getImportPrice());
            }
            repaint();
            revalidate();
        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }

    void saveImportProducts(double totalPrice, double discount, double deliveryFee, double otherDiscount) {
        productList_Component.saveImportProducts(totalPrice, discount, deliveryFee, otherDiscount);
    }

    public void updateTotal(double price) {
        parent.updateTotal(price);
    }

    private void addComponents(GoodsReceipt goodsReceipt) {
        title_Component = new Title_Component();
        productList_Component = new ProductList_Component(this, goodsReceipt);

        JScrollPane scrollPane = new JScrollPane(productList_Component);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

        CustomScrollBarUI customScrollBarUI = new CustomScrollBarUI();
        verticalScrollBar.setUI(customScrollBarUI);

        verticalScrollBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                customScrollBarUI.setHovered(true);  // Set hover to true
                verticalScrollBar.repaint();  // Repaint to update color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                customScrollBarUI.setHovered(false);  // Set hover to false
                verticalScrollBar.repaint();  // Repaint to update color
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {  // Check if it's a left click
                    customScrollBarUI.setClicked(true);  // Set clicked to true
                    verticalScrollBar.repaint();  // Repaint to update color
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {  // Check if it's a left click
                    customScrollBarUI.setClicked(false);  // Set clicked to false
                    verticalScrollBar.repaint();  // Repaint to update color
                }
            }
        });

        // Set scroll bar width to something smaller
        verticalScrollBar.setPreferredSize(new Dimension(6, Integer.MAX_VALUE));

        add(title_Component, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateImportProducts(GoodsReceipt goodsReceipt, double discount, double otherDiscount, double totalPrice) {
        productList_Component.updateImportProducts(goodsReceipt, discount, otherDiscount, totalPrice);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
