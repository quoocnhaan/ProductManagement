/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Pagination;

import controller.DAO.ProductDAO;
import controller.DAOImp.ProductDAOImp;
import controller.Session.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Product.ProductPage_Component;
import view.component.Product.Product_Component.Product_Component;

/**
 *
 * @author PC
 */
public class CustomPagination extends javax.swing.JPanel {

    private int currentPage = 1;
    private int itemsPerPage = 2;
    private int maxVisiblePages = 3; // Only show 3 page buttons at once
    private JButton prevButton, nextButton;
    private ProductPage_Component productPage_Component;
    private List<Product_Component> products; // Product list
    private JPanel productPanel;
    private JPanel paginationPanel;
    private int totalPages;

    public CustomPagination() {
        initComponents();
        setLayout(new BorderLayout());

        products = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ProductDAO productDAO = new ProductDAOImp(session);
            List<Product> productList = productDAO.getAll();
            for (Product product : productList) {
                products.add(new Product_Component(product));
            }

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }

        productPage_Component = new ProductPage_Component();
        // Initialize products (for demo purposes)
        // Calculate total pages
        totalPages = (int) Math.ceil((double) products.size() / itemsPerPage);

        // Panel to display products
        productPanel = new JPanel(new BorderLayout());
        productPanel.add(productPage_Component);
        add(productPanel, BorderLayout.CENTER);

        // Pagination panel
        paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        paginationPanel.setBackground(Color.WHITE);
        add(paginationPanel, BorderLayout.SOUTH);

        // Previous button
        prevButton = createPageButton("< Previous");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updatePaginationControls();
                }
            }
        });
        //paginationPanel.add(prevButton);

        // Next button
        nextButton = createPageButton("Next >");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < totalPages) {
                    currentPage++;
                    updatePaginationControls();
                }
            }
        });
        // paginationPanel.add(nextButton);

        // Initial state update
        updatePaginationControls();
    }

    // Create a custom styled button with proper border radius and text visibility
    private JButton createPageButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners with radius 20
                super.paintComponent(g); // Ensure text is drawn
            }
        };
        button.setPreferredSize(getAdjustButtonSize(text));
        button.setFont(new Font("Roboto", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);  // Disable default button background
        button.setOpaque(false);
        button.setBackground(Color.WHITE);   // Set button background color
        button.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        button.setBorderPainted(false);      // Ensure the border isn't drawn
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    private Dimension getAdjustButtonSize(String text) {
        if (text.equals("Next >") || text.equals("< Previous")) {
            return new Dimension(70, 35);
        }
        return new Dimension(35, 35);

    }

    // Update pagination controls and product display
    private void updatePaginationControls() {
        // Enable/disable previous and next buttons
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage < totalPages);

        // Remove all existing page buttons
        paginationPanel.removeAll();
        paginationPanel.add(prevButton);

        // Display only 3 page buttons around the current page
        int startPage = Math.max(1, currentPage - maxVisiblePages / 2);
        int endPage = Math.min(totalPages, startPage + maxVisiblePages - 1);

        // Adjust startPage if close to the end
        if (endPage - startPage + 1 < maxVisiblePages) {
            startPage = Math.max(1, endPage - maxVisiblePages + 1);
        }

        // Add the visible page buttons
        for (int i = startPage; i <= endPage; i++) {
            final int page = i;
            JButton pageButton = createPageButton(String.valueOf(i));
            if (i == currentPage) {
                pageButton.setBackground(SharedData.mainColor); // Orange color
                pageButton.setForeground(Color.WHITE);
            } else {
                pageButton.setBackground(Color.WHITE);
                pageButton.setForeground(Color.BLACK);
            }

            pageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentPage = page;
                    updatePaginationControls();
                }
            });

            paginationPanel.add(pageButton);
        }

        paginationPanel.add(nextButton);

        // Revalidate and repaint pagination panel to update the display
        paginationPanel.revalidate();
        paginationPanel.repaint();

        // Display products for the current page
        displayProductsForCurrentPage();
    }

    // Display products based on the current page
    private void displayProductsForCurrentPage() {
        int start = (currentPage - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, products.size());
        List<Product_Component> list = new ArrayList<>();

        for (int i = start; i < end; i++) {
            list.add(products.get(i));
            productPage_Component.updateData(list);
        }
        // Repaint and revalidate to show the updated products
        productPanel.revalidate();
        productPanel.repaint();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
