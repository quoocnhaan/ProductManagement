/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Filter;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class FilterItem_Container extends javax.swing.JPanel {

    List<FilterItem> list;
    
    public FilterItem_Container() {
        initComponents();
        setLayout(new GridLayout(0, 1, 10, 10));
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

    private void addComponents() {
        String[] strings = {
            "English", "German", "Polish", "Italian", "French", "Spanish",
            "Sign", "Russian", "Portuguese", "Swedish", "Norwegian", "Hungarian",
            "Finnish", "Danish", "Czech", "Ukrainian", "Dutch", "Korean",
            "Turkish", "Hebrew", "thang lon thanh thai"
        };
        List<String> contents = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            contents.add(strings[i]);
        }

        list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            FilterItem filterItem = new FilterItem("Products", contents);
            add(filterItem);
            list.add(filterItem);
        }
    }
    
    public List<FilterItem> getAll() {
        return list;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
