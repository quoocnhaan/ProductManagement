/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.SearchBar;

import com.toedter.calendar.JDateChooser;
import controller.DAO.InventoryDAO;
import controller.DAO.InventoryDetailDAO;
import controller.DAO.ProductDAO;
import controller.DAO.Product_SelectedDAO;
import controller.DAOImp.InventoryDAOImp;
import controller.DAOImp.InventoryDetailDAOImp;
import controller.DAOImp.ProductDAOImp;
import controller.DAOImp.Product_SelectedDAOImp;
import controller.Session.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import model.Inventory;
import model.InventoryDetail;
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
    private JDateChooser date;
    private boolean isChoosing;
    private boolean isProgrammaticChange = false;
    
    public SearchBarPanel(PaginationWithSearchBar parent, boolean isChoosing) {
        initComponents();
        this.isChoosing = isChoosing;
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
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        
        popupSort = new JPopupMenu();
        
        date = new JDateChooser();
        
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
        setBorder(new EmptyBorder(0, 10, 0, 10));
        
        buttonPanel.setBackground(Color.WHITE);
        
        date.setBackground(Color.white);
        date.setFont(new Font("Rotobo", Font.PLAIN, 14));
        date.setDate(Date.valueOf(LocalDate.now()));
        date.setPreferredSize(new Dimension(150, 35));
        
        if (!isChoosing) {
            buttonPanel.add(date);
        }
        buttonPanel.add(sortBtn);
        buttonPanel.add(filterBtn);
        if (!isChoosing) {
            buttonPanel.add(deleteBtn);
        }
        
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
                addProductDialog.setSize(700, 500);
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
        
        date.addPropertyChangeListener("date", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("date") && !isProgrammaticChange) {
                    // This block will only run if the date was changed by the user
                    java.util.Date selectedDate = ((com.toedter.calendar.JDateChooser) evt.getSource()).getDate();
                    
                    if (selectedDate != null) {
                        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                        //SharedData.date = sqlDate;
                        parent.sortByDate(sqlDate);
                    }
                }
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
        isProgrammaticChange = true;
        date.setDate(Date.valueOf(LocalDate.now()));
        isProgrammaticChange = false;
        filter_Component.reset();
        filterBtn.changeColor(false);
        sortPopup.reset();
        
        parent.reset();
    }
    
    public void changeColorOfSortBtn(boolean b) {
        sortBtn.changeColor(b);
    }
    
    public void deleteSelectedItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Date date = Date.valueOf(LocalDate.now());
            ProductDAO productDAO = new ProductDAOImp(session);
            Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
            InventoryDAO inventoryDAO = new InventoryDAOImp(session);
            InventoryDetailDAO inventoryDetailDAO = new InventoryDetailDAOImp(session);
            
            Inventory inventory = inventoryDAO.findByDate(date);
            List<InventoryDetail> inventoryDetails = inventoryDetailDAO.findDetailsByInventory(inventory);
            
            List<Product_Selected> products = product_SelectedDAO.getAll();
            int amount = 0;
            for (Product_Selected product : products) {
                if (product.isStatus()) {
                    productDAO.delete(product.getProduct().getId());
                    product_SelectedDAO.delete(product.getId());
                    
                    for (InventoryDetail detail : inventoryDetails) {
                        if (detail.getProduct().getId() == product.getProduct().getId()) {
                            amount += detail.getAmountEnd();
                            InventoryDetail inventoryDetail = inventoryDetailDAO.get(detail.getId());
                            inventoryDetailDAO.delete(inventoryDetail.getId());
                        }
                    }
                }
            }
            inventory.setAmount(inventory.getAmount() - amount);
            inventoryDAO.update(inventory);
            
        } catch (Exception exception) {
            System.out.println(exception + getClass().getName());
        }
        parent.resetDataWhenDeleted();
        deleteBtn.setEnabled(false);
    }
    
    public void updateSearchData() {
        searchSuggestion_Component.updateSearchData();
    }
    
    public void resetSearchOptionsWhenCloseImport() {
        searchSuggestion_Component.reset();
        isProgrammaticChange = true;
        date.setDate(Date.valueOf(LocalDate.now()));
        isProgrammaticChange = false;
        deleteBtn.setEnabled(false);
        filter_Component.reset();
        filterBtn.changeColor(false);
        sortPopup.reset();
        parent.reset();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
