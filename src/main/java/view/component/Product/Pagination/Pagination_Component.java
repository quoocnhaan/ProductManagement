/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.Pagination;

import controller.DAO.ProductDAO;
import controller.DAO.Product_SelectedDAO;
import controller.DAOImp.ProductDAOImp;
import controller.DAOImp.Product_SelectedDAOImp;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Product;
import model.Product_Selected;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.CustomComponent.CustomCheckbox;
import view.component.Product.PaginationWithSearchBar;
import view.component.Product.ProductPage_Component;
import view.component.Product.Product_Component.Product_Component;

/**
 *
 * @author PC
 */
public class Pagination_Component extends javax.swing.JPanel {

    private int currentPage = 1;
    private int itemsPerPage = 6;
    private int maxVisiblePages = 3; // Only show 3 page buttons at once
    private JButton prevButton, nextButton;
    private List<ProductPage_Component> productPages; // -> List ProductPage
    private List<Product_Component> products; // Product list
    private JPanel footer;
    private JPanel productPanel;
    private JPanel paginationPanel;
    private JPanel selectedPanel;
    private JLabel totalSelected;
    private CustomCheckbox checkbox;
    private int totalPages;
    private PaginationWithSearchBar parent;

    private String status;

    private String name_Search;

    private List<String> brands_Search;
    private List<String> price_Search;
    private List<String> gender_Search;
    private List<String> type_Search;

    private String sort;

    public Pagination_Component(PaginationWithSearchBar parent) {
        initComponents();
        this.parent = parent;
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
            return new Dimension(70, 35);
        } else if (text.equals("Next >")) {
            return new Dimension(45, 35);
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

            List<Product_Component> list = new ArrayList<>();

            for (int i = start; i < end; i++) {
                Product_Component product_Component = products.get(i);
                product_Component.setProductPage_Component(productPage_Component);
                list.add(product_Component);

            }
            productPage_Component.updateData(list);
            productPage_Component.checkStatusSelectAllCheckbox();
            productPanel.add(productPage_Component);
        } else {
            productPanel.add(new ProductPage_Component(this));
        }

        // Repaint and revalidate to show the updated products
        productPanel.revalidate();
        productPanel.repaint();
    }

    public void updateSelectedAmount() {
        totalSelected.setText(SharedData.selectedAmount + " selected");
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
        totalSelected = new JLabel("0 selected");
        checkbox = new CustomCheckbox(true);
        prevButton = createPageButton("< Previous");
        nextButton = createPageButton("Next >");
        brands_Search = new ArrayList<>();
        price_Search = new ArrayList<>();
        gender_Search = new ArrayList<>();
        type_Search = new ArrayList<>();
        status = "All";
    }

    private void fetchData() {
        products.clear();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ProductDAO productDAO = new ProductDAOImp(session);
            List<Product> productList = productDAO.getAll();
            for (Product product : productList) {
                products.add(new Product_Component(product, this));
            }

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }

    private void resetSearchOptions() {
        name_Search = "";
        brands_Search.clear();
        price_Search.clear();
        gender_Search.clear();
        type_Search.clear();
        sort = "";
        status = "All";
        parent.resetSearchOptions();
    }

    private void fetchDataWithOptions() {
        products.clear();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ProductDAO productDAO = new ProductDAOImp(session);
            List<Product> productList = productDAO.findByText(name_Search, brands_Search, price_Search, gender_Search, type_Search, sort, status);
            for (Product product : productList) {
                products.add(new Product_Component(product, this));
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

        selectedPanel.add(checkbox);
        selectedPanel.add(totalSelected);

        footer.add(paginationPanel, BorderLayout.EAST);
        footer.add(selectedPanel, BorderLayout.WEST);

        add(productPanel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private void customMyComponents() {
        selectedPanel.setBackground(Color.WHITE);

        footer.setBackground(Color.WHITE);
        footer.setBorder(new EmptyBorder(0, 15, 0, 15));

        totalSelected.setFont(new Font("Roboto", Font.PLAIN, 15));

        paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        paginationPanel.setBackground(Color.WHITE);

    }

    private void addEvents() {
        checkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPage = 1;
                if (checkbox.isSelected()) {
                    SharedData.beingSelected = true;
                    fetchDataInSelectedProduct();
                } else {
                    SharedData.beingSelected = false;
                    fetchData();
                    updateSelectedProduct();
                }
                resetSearchOptions();
                computePages();
                updateProductPages();
                updatePaginationControls();
            }

            private void updateSelectedProduct() {
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
                    product_SelectedDAO.deleteByStatusFalse();
                } catch (Exception e) {
                    System.out.println(e + getClass().getName());
                }
            }
        });

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

    public void resetDataWhenDeleted() {
        if (SharedData.beingSelected) {
            fetchDataInSelectedProductWithOptions();
            if (products.isEmpty()) {
                checkbox.doClick();
                SharedData.selectedAmount = 0;
                updateSelectedAmount();
                return;
            }
        } else {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
                product_SelectedDAO.deleteAll();
            } catch (Exception e) {
                System.out.println(e + getClass().getName());
            }
            fetchDataWithOptions();
        }
        computePages();

        computeCurrentPage();

        updateProductPages();
        updatePaginationControls();
        SharedData.selectedAmount = 0;
        updateSelectedAmount();
        parent.updateData();
    }

    public void resetDataWhenAdded() {
        if (!SharedData.beingSelected) {
            fetchDataWithOptions();
            computePages();
            updateProductPages();
            updatePaginationControls();
        }
    }

    public void resetDataWhenEdit() {
        if (!SharedData.beingSelected) {
            fetchDataWithOptions();
        } else {
            fetchDataInSelectedProductWithOptions();
        }
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

    public void changeStatusDeleteButton(boolean b) {
        parent.changeStatusDeleteButton(b);
    }

    public void updateData() {
        currentPage = 1;
        if (SharedData.beingSelected) {
            fetchDataInSelectedProductWithOptions();
        } else {
            fetchDataWithOptions();
        }
        computePages();
        updateProductPages();
        updatePaginationControls();
    }

    private void fetchDataInSelectedProduct() {
        products.clear();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product_SelectedDAO productDAO = new Product_SelectedDAOImp(session);
            List<Product_Selected> productList = productDAO.getAll();
            for (Product_Selected product : productList) {
                products.add(new Product_Component(product.getProduct(), this));
            }

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }

    private void fetchDataInSelectedProductWithOptions() {
        products.clear();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product_SelectedDAO productDAO = new Product_SelectedDAOImp(session);
            List<Product_Selected> productList = productDAO.findByText(name_Search, brands_Search, price_Search, gender_Search, type_Search, sort, status);
            for (Product_Selected product : productList) {
                products.add(new Product_Component(product.getProduct(), this));
            }

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }

    public void setName_Search(String name_Search) {
        this.name_Search = name_Search;
    }

    public void setBrands_Search(List<String> brands_Search) {
        this.brands_Search = brands_Search;
    }

    public void setPrice_Search(List<String> price_Search) {
        this.price_Search = price_Search;
    }

    public void setGender_Search(List<String> gender_Search) {
        this.gender_Search = gender_Search;
    }

    public void setType_Search(List<String> type_Search) {
        this.type_Search = type_Search;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    private void computeCurrentPage() {
        if (totalPages != 0 && totalPages < currentPage) {
            currentPage = currentPage - (currentPage - totalPages);
        } else if (totalPages == 0) {
            currentPage = 1;
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
