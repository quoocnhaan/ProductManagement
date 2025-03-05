/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;
import view.component.Product.Pagination.Pagination_Component;
import view.component.Product.SearchBar.SearchBarPanel;

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

    public void resetDataWhenDeleted() {
        pagination_Component.resetDataWhenDeleted();
    }

    public void resetDataWhenAdded() {
        pagination_Component.resetDataWhenAdded();
    }

    public void changeStatusDeleteButton(boolean b) {
        searchBarPanel.changeStatusDeleteButton(b);
    }

    public void transferData(String name) {
        pagination_Component.setName_Search(name);
        pagination_Component.updateData();
    }

    public void sortByNameAscending() {
        pagination_Component.setSort("Product Name A-Z");
        pagination_Component.updateData();
    }

    public void sortByNameDescending() {
        pagination_Component.setSort("Product Name Z-A");
        pagination_Component.updateData();
    }

    public void sortByPriceLowToHigh() {
        pagination_Component.setSort("Price Low to High");
        pagination_Component.updateData();
    }

    public void sortByPriceHighToLow() {
        pagination_Component.setSort("Price High to Low");
        pagination_Component.updateData();
    }

    public void resetSorting() {
        pagination_Component.setSort("");
        pagination_Component.updateData();
    }

    public void searchByFilter(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                switch (key) {
                    case "Brands":
                        pagination_Component.setBrands_Search(values);
                        break;
                    case "Prices":
                        pagination_Component.setPrice_Search(values);
                        break;
                    case "Genders":
                        pagination_Component.setGender_Search(values);
                        break;
                    case "Types":
                        pagination_Component.setType_Search(values);
                        break;
                    default:
                        // Handle any other filters or ignore unrecognized keys
                        System.out.println("Unrecognized filter: " + key);
                        break;
                }
            }
        }
        pagination_Component.updateData();
    }

    public void resetSearchOptions() {
        searchBarPanel.resetSearchOptions();
    }

    public void sortByStatus(String status) {
        pagination_Component.setStatus(status);
        pagination_Component.updateData();
    }

    public void reset() {
        parent.reset();
    }

    public void updateDataWhenEdit() {
        parent.updateDataWhenEdit();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
