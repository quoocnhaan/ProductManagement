/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import view.component.Btn.FilterButton;

/**
 *
 * @author PC
 */
public class ButtonGroupPanel extends JPanel {

    private FilterButton all;
    private FilterButton inStock;
    private FilterButton outStock;
    private ButtonGroup group;
    private DataTable_Component parent;

    public ButtonGroupPanel(List<String> names, DataTable_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        setPreferredSize(new Dimension(1250, 40));

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(240, 240, 240)));

        initData();
        addComponents();
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

    private void initData() {
        all = new FilterButton("All");
        all.setSelected(true);

        inStock = new FilterButton("In-Stock");
        outStock = new FilterButton("Out-of-Stock");
        group = new ButtonGroup();
    }

    private void addEvents() {
        // Assuming 'all', 'inStock', 'outStock' are JRadioButtons or JCheckBox
        ButtonGroup group = new ButtonGroup();
        group.add(all);
        group.add(inStock);
        group.add(outStock);

        all.addActionListener(e -> {
            if (all.isSelected()) {
                parent.transferData("All");
            }
        });

        inStock.addActionListener(e -> {
            if (inStock.isSelected()) {
                parent.transferData("In-Stock");
            }
        });

        outStock.addActionListener(e -> {
            if (outStock.isSelected()) {
                parent.transferData("Out-of-Stock");
            }
        });
    }

    private void addComponents() {
        group.add(all);
        add(all);

        group.add(inStock);
        add(inStock);

        group.add(outStock);
        add(outStock);
    }

    public void reset() {
        all.setSelected(true);
        inStock.setSelected(false);
        outStock.setSelected(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
