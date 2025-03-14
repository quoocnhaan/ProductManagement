/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.Pagination;

import controller.DAO.BillsDAO;
import controller.DAO.BillsPerDayDAO;
import controller.DAOImp.BillsDAOImp;
import controller.DAOImp.BillsPerDayDAOImp;
import controller.Functional.Functional;
import controller.Session.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Bills;
import model.BillsPerDay;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Order.PaginationWithSearchBar;
import view.component.Order.ProductPage_Component;
import view.component.Order.Order_Component.Order_Component;

/**
 *
 * @author PC
 */
public class Pagination_Component extends javax.swing.JPanel {

    private Date fromDate = null;
    private Date toDate = null;
    private int currentPage = 1;
    private int itemsPerPage = 6;
    private int maxVisiblePages = 3; // Only show 3 page buttons at once
    private JButton prevButton, nextButton;
    private List<ProductPage_Component> productPages; // -> List ProductPage
    private List<Order_Component> products; // Product list
    private JPanel footer;
    private JPanel productPanel;
    private JPanel paginationPanel;
    private JPanel selectedPanel;
    private int totalPages;
    private PaginationWithSearchBar parent;

    private String sort;
    private String status = "All";
    private List<String> orderStatus;

    public Pagination_Component(PaginationWithSearchBar parent) {
        initComponents();
        this.parent = parent;

        SharedData.deletedProductInImport.clear();
        SharedData.selectedAmount = 0;
        SharedData.beingSelected = false;
        Functional.clearDataTemp();

        setLayout(new BorderLayout());
        initMyComponents();
        customMyComponents();
        addEvents();
        fetchData();
        computePages();
        initData();
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
        if (text.equals("< Previous")) {
            return new Dimension(80, 35);
        } else if (text.equals("Next >")) {
            return new Dimension(55, 35);
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

        displayProductsForCurrentPage();
    }

    private void displayProductsForCurrentPage() {
        productPanel.removeAll();
        int start = (currentPage - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, products.size());

        int pageIndex = (int) Math.ceil(end * 1.0 / itemsPerPage);

        if (pageIndex >= 1) {
            ProductPage_Component productPage_Component = productPages.get(pageIndex - 1);

            List<Order_Component> list = new ArrayList<>();

            for (int i = start; i < end; i++) {
                Order_Component product_Component = products.get(i);
                product_Component.setProductPage_Component(productPage_Component);
                list.add(product_Component);
            }
            productPage_Component.updateData(list);
            productPanel.add(productPage_Component);
        } else {
            productPanel.add(new ProductPage_Component(this));
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

    private void initMyComponents() {
        products = new ArrayList<>();
        productPages = new ArrayList<>();
        productPanel = new JPanel(new BorderLayout());
        selectedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        footer = new JPanel(new BorderLayout());
        prevButton = createPageButton("< Previous");
        nextButton = createPageButton("Next >");
        orderStatus = new ArrayList<>();
    }

    private void fetchData() {
        products.clear();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            BillsPerDayDAO billsPerDayDAO = new BillsPerDayDAOImp(session);
            BillsDAO billsDAO = new BillsDAOImp(session);

            List<BillsPerDay> billsPerDays = new ArrayList<>();

            if (fromDate == null) {
                billsPerDays = billsPerDayDAO.getAll();
            } else {
                billsPerDays = billsPerDayDAO.findByDate(fromDate, toDate);
            }

            billsPerDays.sort((b1, b2) -> Integer.compare(b2.getId(), b1.getId()));

            for (BillsPerDay billsPerDay : billsPerDays) {
                List<Bills> list = billsDAO.findByFilter(billsPerDay, sort, status, orderStatus);
                if (sort == null || sort.isBlank()) {
                    list.sort((b1, b2) -> Integer.compare(b2.getId(), b1.getId()));
                }
                for (Bills bills : list) {
                    products.add(new Order_Component(bills, this));
                }
            }

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }

    private void computePages() {
        totalPages = (int) Math.ceil((double) products.size() / itemsPerPage);
    }

    private void initData() {
        for (int i = 0; i < totalPages; i++) {
            ProductPage_Component productPage_Component = new ProductPage_Component(this);
            productPages.add(productPage_Component);
        }

        footer.add(paginationPanel, BorderLayout.EAST);
        footer.add(selectedPanel, BorderLayout.WEST);

        add(productPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private void customMyComponents() {
        selectedPanel.setBackground(Color.WHITE);

        footer.setBackground(Color.WHITE);
        footer.setBorder(new EmptyBorder(0, 15, 0, 15));

        paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        paginationPanel.setBackground(Color.WHITE);

    }

    private void addEvents() {
        // Prev button
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updatePaginationControls();
                }
            }
        });

        // Next button
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < totalPages) {
                    currentPage++;
                    updatePaginationControls();
                }
            }
        });
    }

    public void resetDataWhenAdded() {
        // if date is null -> fetch by sort
        // else -> fetch by date
        fetchData();
        //fetchData();
        computePages();
        updateProductPages();
        updatePaginationControls();
    }

    public void resetDataWhenEdit() {
        fetchData();
        //fetchData();
        updatePaginationControls();
        parent.updateData();
    }

    private void updateProductPages() {
        productPages.clear();
        for (int i = 0; i < totalPages; i++) {
            ProductPage_Component productPage_Component = new ProductPage_Component(this);
            productPages.add(productPage_Component);
        }
    }

    public void updateData() {
        currentPage = 1;
        fetchData();
        computePages();
        updateProductPages();
        updatePaginationControls();
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderStatus(List<String> selectedItems) {
        this.orderStatus = selectedItems;
    }

    public void setFromDate(Date sqlFromDate) {
        fromDate = sqlFromDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
