/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.Product.AddingProduct;

/**
 *
 * @author PC
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import controller.DAO.BrandDAO;
import controller.DAO.ProductDAO;
import controller.DAOImp.BrandDAOImp;
import controller.DAOImp.ProductDAOImp;
import controller.Functional.Functional;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Brand;
import model.Product;
import org.hibernate.Session;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import util.HibernateUtil;
import view.component.Btn.RoundedButton;
import view.component.CustomComponent.ImageLabel;
import view.component.CustomComponent.RoundedLabel;
import view.component.CustomComponent.RoundedTextArea;
import view.component.CustomComponent.RoundedTextField;

/**
 *
 * @author PC
 */
public class TestAddProduct extends javax.swing.JPanel {

    /**
     * Creates new form AddNewProduct_Component
     */
    public TestAddProduct() {
        initComponents();
        initData();
        customComponents();
        setting();
        removeFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        contentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new RoundedTextField();
        jLabel4 = new javax.swing.JLabel();
        code = new RoundedTextField();
        jLabel5 = new javax.swing.JLabel();
        price = new RoundedTextField();
        jLabel6 = new javax.swing.JLabel();
        discount = new RoundedTextField();
        jLabel7 = new javax.swing.JLabel();
        label12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        quantity = new RoundedTextField();
        brand = new javax.swing.JComboBox<>();
        label13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new RoundedTextArea();
        status = new javax.swing.JComboBox<>();
        cancelBtn = new RoundedButton("Cancel", false);
        confirmBtn = new RoundedButton("Save", true);
        finalPrice = new RoundedLabel("");
        jLabel1 = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        img = new ImageLabel(35);
        img.setSize(180, 180);
        uploadBtn = new RoundedButton("", true);
        jLabel14 = new javax.swing.JLabel();
        categoryPanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        
        setBackground(new java.awt.Color(250, 250, 250));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        
        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setPreferredSize(new java.awt.Dimension(748, 598));
        
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("General Information");
        
        jLabel3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Product Name");
        
        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        name.setForeground(new java.awt.Color(102, 102, 102));
        name.setText("Enter Product Name");
        
        jLabel4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Product Code");
        
        code.setBackground(new java.awt.Color(255, 255, 255));
        code.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        code.setForeground(new java.awt.Color(102, 102, 102));
        code.setText("Enter Product Code");
        
        jLabel5.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Sale Price");
        
        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        price.setForeground(new java.awt.Color(102, 102, 102));
        price.setText("100000 VND");
        
        jLabel6.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Discount %");
        
        discount.setBackground(new java.awt.Color(255, 255, 255));
        discount.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        discount.setForeground(new java.awt.Color(102, 102, 102));
        discount.setText("0");
        
        jLabel7.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Final Price");
        
        label12.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label12.setForeground(new java.awt.Color(0, 0, 0));
        label12.setText("Quantity");
        
        jLabel8.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Brand");
        
        quantity.setBackground(new java.awt.Color(255, 255, 255));
        quantity.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        quantity.setForeground(new java.awt.Color(102, 102, 102));
        quantity.setText("1");
        
        brand.setBackground(new java.awt.Color(255, 255, 255));
        brand.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        brand.setForeground(new java.awt.Color(102, 102, 102));
        
        label13.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        label13.setForeground(new java.awt.Color(0, 0, 0));
        label13.setText("Status");
        
        jLabel11.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Description");
        
        description.setBackground(new java.awt.Color(255, 255, 255));
        description.setColumns(20);
        description.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        description.setForeground(new java.awt.Color(102, 102, 102));
        description.setRows(5);
        jScrollPane1.setViewportView(description);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        status.setBackground(new java.awt.Color(255, 255, 255));
        status.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        status.setForeground(new java.awt.Color(102, 102, 102));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"In stock", "Out of stock", "In transit"}));
        
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        
        confirmBtn.setText("Save");
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });
        
        finalPrice.setBackground(new java.awt.Color(51, 51, 51));
        finalPrice.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        finalPrice.setForeground(new java.awt.Color(102, 102, 102));
        finalPrice.setText("");
        
        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel2))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addComponent(cancelBtn)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(confirmBtn))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4)))
                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(brand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(finalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(label13)
                                                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(discount, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                                                                .addComponent(jLabel6)
                                                                                .addComponent(label12)
                                                                                .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                                                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(17, 17, 17))))
        );
        contentPanelLayout.setVerticalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(quantity, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                        .addComponent(finalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(label13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelBtn)
                                        .addComponent(confirmBtn))
                                .addGap(54, 54, 54))
        );
        
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Create a New Product");
        
        imagePanel.setBackground(new java.awt.Color(255, 255, 255));
        
        jLabel12.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Product Image");
        
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfume4.png"))); // NOI18N

        uploadBtn.setBackground(new java.awt.Color(0, 0, 255));
        uploadBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        uploadBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadBtn.setText("Upload");
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });
        
        jLabel14.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("jLabel14");
        
        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imagePanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(uploadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagePanelLayout.setVerticalGroup(
                imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(imagePanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel12)
                                .addGroup(imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(imagePanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(imagePanelLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        
        categoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        
        jLabel15.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Category");
        
        jLabel16.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Type");
        
        type.setBackground(new java.awt.Color(255, 255, 255));
        type.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        type.setForeground(new java.awt.Color(102, 102, 102));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"10ml", "20ml", "30ml", "Full"}));
        
        jLabel9.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Gender");
        
        gender.setBackground(new java.awt.Color(255, 255, 255));
        gender.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
        gender.setForeground(new java.awt.Color(102, 102, 102));
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Men", "Women", "Unisex"}));
        
        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
                categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoryPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(gender, 0, 427, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15)
                                        .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        categoryPanelLayout.setVerticalGroup(
                categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoryPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(jLabel1))
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(categoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp"));
        
        int returnValue = fileChooser.showOpenDialog(this);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            
            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
            
            img.setIcon(Functional.scaleImg(img, imageIcon));
        }
    }
    
    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {
        
        int option = JOptionPane.showConfirmDialog(this, "Do you want to save ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                
                ProductDAO productDAO = new ProductDAOImp(session);
                BrandDAO brandDAO = new BrandDAOImp(session);
                
                String productName = name.getText();
                if (productName.equals("Enter product name")) {
                    JOptionPane.showMessageDialog(this, "Please enter Product Name !");
                    return;
                }
                
                String productCode = code.getText();
                if (productCode.equals("Enter product code")) {
                    JOptionPane.showMessageDialog(this, "Please enter Product Code !");
                    return;
                }
                String brandString = this.brand.getSelectedItem().toString();
                if (brandString.isBlank()) {
                    JOptionPane.showMessageDialog(this, "Please enter Product Brand !");
                    return;
                }
                
                Brand brand = brandDAO.getByName(brandString);
                if (brand == null) {
                    brand = new Brand(brandString, true);
                    brandDAO.add(brand);
                }
                
                double price = Double.parseDouble(this.price.getText());
                
                double discount = Double.parseDouble(this.discount.getText());
                
                int type = this.type.getSelectedIndex() + 1;
                int gender = this.type.getSelectedIndex() + 1;
                int productStatus = status.getSelectedIndex() + 1;
                String description = this.description.getText();
                
                ImageIcon newImg = (ImageIcon) img.getIcon();
                byte[] imgByte = Functional.convertIconToByteArray(newImg);
                
                Product product = new Product(productName, productCode, brand, gender, imgByte, price, description, 0, productStatus, type, true);
                
                productDAO.add(product);
                
                close();

//                ManageEmployeeInfo_Component.getInstance().updateData();
//                EmployeeInfo_Component.getInstance().getManagerInfo_Component().updateTotal(employeeDAO.getAll().size());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input !");
            }
        }
    }
    
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        int option = JOptionPane.showConfirmDialog(this, "Do you want to cancel?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            close();
        }
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {
        this.requestFocusInWindow();
    }
    
    private void initData() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            ProductDAO productDAO = new ProductDAOImp(session);
            BrandDAO brandDAO = new BrandDAOImp(session);
            
            List<Brand> items = brandDAO.getAll();
            
            for (Brand item : items) {
                brand.addItem(item.getName());
            }
        } catch (Exception e) {
        }
        String text = "<html>Please upload an image with a resolution of 180x180 or close to it for the best image quality.</html>";
        jLabel14.setText(text);
    }
    
    private void customComponents() {
        customJComboBox();
    }
    
    private void close() {
        Window parentWindow = SwingUtilities.getWindowAncestor(this);
        if (parentWindow != null) {
            parentWindow.dispose();
        }
    }
    
    private void setPlaceholder(final JTextField textField) {
        String placeholder = textField.getText();
        
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(java.awt.Color.BLACK);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(java.awt.Color.GRAY);
                }
            }
        });
        textField.setForeground(java.awt.Color.GRAY);
    }
    
    private void setting() {
        setPlaceholder(name);
        setPlaceholder(code);
        setPlaceholder(price);
        setPlaceholder(discount);
        setPlaceholder(quantity);
    }
    
    private void removeFocus() {
        this.addAncestorListener(new javax.swing.event.AncestorListener() {
            @Override
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formMouseClicked(null);
            }
            
            @Override
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            
            @Override
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });
    }
    
    private void customJComboBox() {
        brand.setMaximumRowCount(7);
        brand.setEditable(true);
        AutoCompleteDecorator.decorate(brand);
        
        brand.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    brand.getParent().requestFocusInWindow();
                }
            }
        });
        
        JTextField editor = (JTextField) brand.getEditor().getEditorComponent();
        
        editor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkForMatchingResult();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkForMatchingResult();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                checkForMatchingResult();
            }
            
            private void checkForMatchingResult() {
                String input = editor.getText();
                boolean matchFound = false;
                
                if (input.isBlank()) {
                    brand.hidePopup();
                    return;
                }
                
                for (int i = 0; i < brand.getItemCount(); i++) {
                    if (brand.getItemAt(i).toString().toLowerCase().startsWith(input.toLowerCase())) {
                        matchFound = true;
                        break;
                    }
                }
                
                if (matchFound) {
                    brand.showPopup();
                } else {
                    brand.hidePopup();
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> brand;
    private RoundedButton cancelBtn;
    private javax.swing.JPanel categoryPanel;
    private RoundedTextField code;
    private RoundedButton confirmBtn;
    private javax.swing.JPanel contentPanel;
    private RoundedTextArea description;
    private RoundedTextField discount;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JPanel imagePanel;
    private ImageLabel img;
    private javax.swing.JLabel jLabel1;
    private RoundedLabel finalPrice;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label12;
    private javax.swing.JLabel label13;
    private RoundedTextField name;
    private RoundedTextField price;
    private RoundedTextField quantity;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JComboBox<String> type;
    private RoundedButton uploadBtn;
    // End of variables declaration                   
}
