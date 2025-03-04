/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.Filter;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JToggleButton;
import org.jdesktop.swingx.WrapLayout;
import view.component.Btn.RoundedToggleButton;

/**
 *
 * @author PC
 */
public class Content extends javax.swing.JPanel {

    private FilterItem parent;
    private List<RoundedToggleButton> result;

    public Content(List<String> contents, FilterItem parent) {
        initComponents();
        this.parent = parent;
        result = new ArrayList<>();
        setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));
        addComponents(contents);
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
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addComponents(List<String> contents) {
        for (String language : contents) {
            RoundedToggleButton button = new RoundedToggleButton(language);
            add(button);
            result.add(button);
        }
    }

    public void clear() {
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof JToggleButton) {
                JToggleButton toggleButton = (JToggleButton) component;
                toggleButton.setSelected(false);
                toggleButton.setBackground(new Color(243, 244, 245));
            }
        }
    }

    public List<String> getSelectedItems() {
        List<String> temp = new ArrayList<>();
        for (RoundedToggleButton button : result) {
            if (button.isSelected()) {
                temp.add(button.getText());
            }
        }
        return temp;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
