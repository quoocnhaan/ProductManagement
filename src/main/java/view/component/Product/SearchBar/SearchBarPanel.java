/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.SearchBar;

import controller.DAO.ProductDAO;
import controller.DAO.Product_SelectedDAO;
import controller.DAOImp.ProductDAOImp;
import controller.DAOImp.Product_SelectedDAOImp;
import controller.Session.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import model.Product_Selected;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Btn.IconButton;
import view.component.Product.DeleteDialog.DeleteDialog_Component;
import view.component.Product.Filter.Filter_Component;
import view.component.Product.PaginationWithSearchBar;
import view.component.Product.SearchSuggestion.SearchSuggestion_Component;
import view.component.Product.Sort.SortPopup;

/**
 *
 * @author LENOVO
 */
public class SearchBarPanel extends javax.swing.JPanel {

    private SearchSuggestion_Component searchSuggestion_Component;
    private IconButton sortBtn;
    private IconButton filterBtn;
    private IconButton deleteBtn;
    private JPanel buttonPanel;
    private PaginationWithSearchBar parent;
    private JPopupMenu popupSort;
    private SortPopup sortPopup;
    private Filter_Component filter_Component;
    private DeleteDialog_Component deleteDialog_Component;
    private Map<String, List<String>> map;

    public SearchBarPanel(PaginationWithSearchBar parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        initMyComponents();
        customMyComponents();
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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

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

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    private void initMyComponents() {
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        popupSort = new JPopupMenu();

        popupSort.setBackground(Color.WHITE);
        popupSort.setPreferredSize(new Dimension(200, 200));
        popupSort.setBorder(new MatteBorder(1, 1, 1, 1, new Color(230, 230, 230)));

        sortPopup = new SortPopup(this);
        popupSort.add(sortPopup);

        searchSuggestion_Component = new SearchSuggestion_Component(this);

        filter_Component = new Filter_Component(this);
        deleteDialog_Component = new DeleteDialog_Component(this);

        ImageIcon sortIcon = new ImageIcon(getClass().getResource("/icon/sort.png"));
        sortBtn = new IconButton("Sort by", sortIcon, true);

        ImageIcon filterIcon = new ImageIcon(getClass().getResource("/icon/filter.png"));
        filterBtn = new IconButton("Filter", filterIcon, true);

        ImageIcon bin = new ImageIcon(getClass().getResource("/icon/bin.png"));
        deleteBtn = new IconButton("Delete", bin, true);
        deleteBtn.setEnabled(false);
    }

    private void customMyComponents() {
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(sortBtn);
        buttonPanel.add(filterBtn);
        buttonPanel.add(deleteBtn);

        add(searchSuggestion_Component, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.EAST);
    }

    private void addEvents() {
        sortBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupSort.show(sortBtn, 0, sortBtn.getHeight() + 5);
            }
        });

        // this is SearchBarPanel
        filterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addProductDialog = new JDialog((Frame) null, "Filter", true);  // true for modal
                addProductDialog.setSize(700, 900);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen
                addProductDialog.setResizable(false);
                addProductDialog.setUndecorated(true);
                filter_Component.setBorder(new LineBorder(Color.GRAY, 2));

                filter_Component.setDialog(addProductDialog);
                addProductDialog.add(filter_Component);

                // Show the dialog
                addProductDialog.setVisible(true);

                if (!isEmpty(map)) {
                    filterBtn.changeColor(true);
                } else {
                    filterBtn.changeColor(false);
                }
                transferData(map);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDialog addProductDialog = new JDialog((Frame) null, "Confirm", true);  // true for modal
                addProductDialog.setSize(488, 480);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen
                addProductDialog.setResizable(false);
                addProductDialog.setUndecorated(true);
                deleteDialog_Component.setBorder(new LineBorder(Color.GRAY, 2));
                deleteDialog_Component.setDialog(addProductDialog);
                deleteDialog_Component.setMessage();
                addProductDialog.add(deleteDialog_Component);

                addProductDialog.setVisible(true);

            }
        });

    }

    public void changeStatusDeleteButton(boolean b) {
        deleteBtn.setEnabled(b);
    }

    public void transferData(String text) {
        parent.transferData(text);
    }

    public void closePopup() {
        popupSort.setVisible(false);
    }

    public void sortByNameAscending() {
        parent.sortByNameAscending();
    }

    public void sortByNameDescending() {
        parent.sortByNameDescending();
    }

    public void sortByPriceLowToHigh() {
        parent.sortByPriceLowToHigh();
    }

    public void sortByPriceHighToLow() {
        parent.sortByPriceHighToLow();
    }

    public void resetSorting() {
        parent.resetSorting();
    }

    public void transferData(Map<String, List<String>> map) {
        parent.searchByFilter(map);
    }

    public void setData(Map<String, List<String>> map) {
        this.map = map;
    }

    public boolean isEmpty(Map<String, List<String>> map) {
        // Check if the map itself is empty
        if (map == null || map.isEmpty()) {
            return true; // The map is empty
        }

        // Iterate through the map to check if all lists are empty
        for (List<String> list : map.values()) {
            if (list != null && !list.isEmpty()) {
                return false; // Found at least one non-empty list
            }
        }

        // If all lists are empty
        return true;
    }

    public void resetSearchOptions() {
        searchSuggestion_Component.reset();
        filter_Component.reset();
        sortPopup.reset();
        parent.reset();
    }

    public void changeColorOfSortBtn(boolean b) {
        sortBtn.changeColor(b);
    }

    public void deleteSelectedItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ProductDAO productDAO = new ProductDAOImp(session);
            Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
            List<Product_Selected> products = product_SelectedDAO.getAll();

            for (Product_Selected product : products) {
                if (product.isStatus()) {
                    productDAO.delete(product.getProduct().getId());
                    product_SelectedDAO.delete(product.getId());
                }
            }
        } catch (Exception exception) {
            System.out.println(exception + getClass().getName());
        }
        parent.resetDataWhenDeleted();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
