package view.component.Product.ImportProduct.ImportProductDetails.Product_Component.Feature;

import controller.Functional.Functional;
import javax.swing.ImageIcon;
import view.component.CustomComponent.ImageLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author PC
 */
public class ProductName_Component extends javax.swing.JPanel {

    /**
     * Creates new form SubFeature_Component
     */
    public ProductName_Component(String name, String code, ImageIcon icon) {
        initComponents();
        this.name.setText(name);
        this.code.setText(code);
        img.setIcon(Functional.scaleImg(img, icon));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        img = new ImageLabel(15);
        img.setSize(60, 60);
        name = new javax.swing.JLabel();
        code = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_e.png"))); // NOI18N
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        name.setFont(new java.awt.Font("Rotobo", 1, 15)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("Nike Air");

        code.setForeground(new java.awt.Color(102, 102, 102));
        code.setText("Code: LQN2002");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(code, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(name)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(code)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JLabel code;
    private ImageLabel img;
    private javax.swing.JLabel name;
    // End of variables declaration                   
}
