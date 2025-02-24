/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.SearchSuggestion;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author PC
 */
public class SearchSuggestion_Component extends javax.swing.JPanel {

    /**
     * Creates new form SearchSuggestion_Component
     */
    private JPopupMenu menu;
    private PanelSearch search;

    public SearchSuggestion_Component() {
        initComponents();
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                txtSearch.setText(data.getText());
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new view.component.SearchSuggestion.MyTextField();

        txtSearch.setText("myTextField1");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        String text = "";
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
            text = search.getSelectedText();
            txtSearch.setText(text);
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
            text = search.getSelectedText();
            txtSearch.setText(text);
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            text = search.getSelectedText();
            txtSearch.setText(text);
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = txtSearch.getText().trim().toLowerCase();
            search.setData(search(text));
            if (search.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(txtSearch, 0, txtSearch.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
            search.clearSelected();
        }
    }//GEN-LAST:event_txtSearchMouseClicked

    // database !!!!
    private List<DataSearch> search(String search) {
        List<DataSearch> resultList = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL query to search for products with names similar to the search term

            List<Product> products = session.createQuery("FROM Product p WHERE p.name LIKE :search", Product.class)
                    .setParameter("search", "%" + search + "%")
                    .getResultList();

            for (Product product : products) {
                resultList.add(new DataSearch(product.getName(), false));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.SearchSuggestion.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
