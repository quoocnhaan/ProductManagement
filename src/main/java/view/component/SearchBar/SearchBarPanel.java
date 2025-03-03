/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.SearchBar;

import controller.DAO.ProductDAO;
import controller.DAOImp.ProductDAOImp;
import controller.Session.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Btn.IconButton;
import view.component.Btn.MyButton;
import view.component.Filter.Filter_Component;
import view.component.PaginationWithSearchBar;
import view.component.Product.Product_Component.Product_Component;
import view.component.SearchSuggestion.SearchSuggestion_Component;

/**
 *
 * @author LENOVO
 */
public class SearchBarPanel extends javax.swing.JPanel {

    private SearchSuggestion_Component searchSuggestion_Component;
    private IconButton sortBtn;
    private IconButton filterBtn;
    private MyButton deleteBtn;
    private JPanel buttonPanel;
    private PaginationWithSearchBar parent;

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

        searchSuggestion_Component = new SearchSuggestion_Component(this);

        ImageIcon sortIcon = new ImageIcon(getClass().getResource("/icon/sort.png"));
        sortBtn = new IconButton("Sort by", sortIcon, true);

        ImageIcon filterIcon = new ImageIcon(getClass().getResource("/icon/filter.png"));
        filterBtn = new IconButton("Filter", filterIcon, true);

        ImageIcon bin = new ImageIcon(getClass().getResource("/icon/bin.png"));
        deleteBtn = new MyButton("");
        deleteBtn.setIcon(bin);
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
                // do something
            }
        });

        filterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addProductDialog = new JDialog((Frame) null, "Filter", true);  // true for modal
                addProductDialog.setSize(700, 900);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen

                addProductDialog.add(new Filter_Component());

                // Show the dialog
                addProductDialog.setVisible(true);
            }
        });


        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                    ProductDAO productDAO = new ProductDAOImp(session);
                    for (Product_Component object : SharedData.selectedProduct) {
                        if (object.isSelected()) {
                            productDAO.delete(object.getProduct().getId());
                        }
                    }
                } catch (Exception exception) {
                    System.out.println(exception + getClass().getName());
                }
                parent.resetDataWhenDeleted();
            }
        });

    }

    public void changeStatusDeleteButton(boolean b) {
        deleteBtn.setEnabled(b);
    }

    public void transferData(String text) {
        parent.transferData(text);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
