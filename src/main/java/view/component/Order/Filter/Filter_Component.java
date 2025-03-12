/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.Filter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import view.component.Btn.RoundedButton;
import view.component.CustomComponent.CustomScrollBarUI;
import view.component.Order.SearchBar.SearchBarPanel;

/**
 *
 * @author PC
 */
public class Filter_Component extends javax.swing.JPanel {

    private FilterItem_Container filterItem_Container;
    private RoundedButton apply;
    private RoundedButton clear;
    private SearchBarPanel parent;
    private JDialog dialog;

    public Filter_Component(SearchBarPanel parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
        addComponents();
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

    private void addComponents() {

        filterItem_Container = new FilterItem_Container();

        JScrollPane scrollPane = new JScrollPane(filterItem_Container);
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
        verticalScrollBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 20));
        footer.setBackground(Color.WHITE);

        clear = new RoundedButton("Clear all", false, 30, 30);
        apply = new RoundedButton("Apply", true, 30, 30);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        // apply is a button in Filter_Component
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setData(filterItem_Container.getSelectedItems());
                if (dialog != null) {
                    dialog.dispose();  // This will close the dialog
                }
            }
        });

        footer.add(clear);
        footer.add(apply);

        add(scrollPane, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    public void setDialog(JDialog addProductDialog) {
        this.dialog = addProductDialog;
    }

    public void reset() {
        List<FilterItem> list = filterItem_Container.getAll();
        for (FilterItem filterItem : list) {
            filterItem.clear();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
