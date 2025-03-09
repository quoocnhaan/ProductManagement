/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing;

import java.awt.BorderLayout;
import java.sql.Date;
import view.component.Importing.Pagination.Pagination_Component;
import view.component.Importing.SearchBar.SearchBarPanel;

/**
 *
 * @author PC
 */
public class PaginationWithSearchBar extends javax.swing.JPanel {

    private SearchBarPanel searchBarPanel;
    private Pagination_Component pagination_Component;
    private DataTable_Component parent;

    public PaginationWithSearchBar(DataTable_Component parent) {
        initComponents();
        this.parent = parent;

        setLayout(new BorderLayout(0, 15));

        searchBarPanel = new SearchBarPanel(this);
        pagination_Component = new Pagination_Component(this);

        add(searchBarPanel, BorderLayout.NORTH);
        add(pagination_Component, BorderLayout.CENTER);
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void resetDataWhenAdded() {
        pagination_Component.resetDataWhenAdded();
    }

    public void sortByPriceLowToHigh() {
        pagination_Component.setSort("Price Low to High");
        pagination_Component.updateDataBySort();
    }

    public void sortByPriceHighToLow() {
        pagination_Component.setSort("Price High to Low");
        pagination_Component.updateDataBySort();
    }

    public void resetSorting() {
        pagination_Component.setSort("");
        pagination_Component.updateData();
    }

    public void resetSearchOptions() {
        searchBarPanel.resetSearchOptions();       
    }

    public void updateData() {
        if (parent != null) {
            parent.updateData();
        }
    }

    public void sortByDate(Date sqlDate) {
        pagination_Component.setToday(sqlDate);
        pagination_Component.updateDataByDate();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
