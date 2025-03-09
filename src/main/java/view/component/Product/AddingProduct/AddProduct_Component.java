/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.AddingProduct;

import controller.DAO.BrandDAO;
import controller.DAOImp.BrandDAOImp;
import controller.Functional.Functional;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
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
import view.component.CustomComponent.ImageLabel;
import view.component.CustomComponent.RoundedTextArea;
import view.component.CustomComponent.RoundedTextField;
import view.component.Product.ImportProduct.ImportProductDetails.ImportProductContent_Component;

/**
 *
 * @author PC
 */
public class AddProduct_Component extends javax.swing.JPanel {

    private ImportProductContent_Component parent;

    public AddProduct_Component(ImportProductContent_Component parent) {
        initComponents();
        this.parent = parent;
        settings();
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
        importPrice = new RoundedTextField();
        jLabel6 = new javax.swing.JLabel();
        salePrice = new RoundedTextField();
        jLabel8 = new javax.swing.JLabel();
        brand = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new RoundedTextArea();
        cancelBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imagePanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        img = new ImageLabel(35);
        uploadBtn = new javax.swing.JButton();
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

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("General Information");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Product Name");

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(102, 102, 102));
        name.setText("Enter Product Name");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Product Code");

        code.setBackground(new java.awt.Color(255, 255, 255));
        code.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        code.setForeground(new java.awt.Color(102, 102, 102));
        code.setText("Enter Product Code");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Import Price");

        importPrice.setBackground(new java.awt.Color(255, 255, 255));
        importPrice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        importPrice.setForeground(new java.awt.Color(102, 102, 102));
        importPrice.setText("10,000");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sale Price");

        salePrice.setBackground(new java.awt.Color(255, 255, 255));
        salePrice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        salePrice.setForeground(new java.awt.Color(102, 102, 102));
        salePrice.setText("10,000");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Brand");

        brand.setBackground(new java.awt.Color(255, 255, 255));
        brand.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        brand.setForeground(new java.awt.Color(102, 102, 102));

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Description");

        description.setBackground(new java.awt.Color(255, 255, 255));
        description.setColumns(20);
        description.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        description.setForeground(new java.awt.Color(102, 102, 102));
        description.setRows(5);
        jScrollPane1.setViewportView(description);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());

        cancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(51, 51, 51));
        cancelBtn.setText("Cancel");
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        confirmBtn.setBackground(new java.awt.Color(0, 51, 255));
        confirmBtn.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("Save");
        confirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
                contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4)))
                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(importPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel8))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(salePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6)))
                                                        .addComponent(brand, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentPanelLayout.createSequentialGroup()
                                                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                                .addComponent(importPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(salePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60))
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
        uploadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        type.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        type.setForeground(new java.awt.Color(102, 102, 102));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"10ml", "20ml", "30ml", "Full"}));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Gender");

        gender.setBackground(new java.awt.Color(255, 255, 255));
        gender.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
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
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(categoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>                           

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();

        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp"));
        fileChooser.setCurrentDirectory(new File(desktopPath));

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
                BrandDAO brandDAO = new BrandDAOImp(session);

                // Validate product name
                String productName = name.getText().trim();
                if (productName == null || productName.isEmpty() || productName.equals("Enter Product Name")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Product Name!");
                    return;
                }

                // Validate product code
                String productCode = code.getText().trim();
                if (productCode == null || productCode.isEmpty() || productCode.equals("Enter Product Code")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Product Code!");
                    return;
                }

                // Validate brand
                String brandString = this.brand.getSelectedItem() != null ? this.brand.getSelectedItem().toString() : "";
                if (brandString.isBlank()) {
                    JOptionPane.showMessageDialog(this, "Please select a valid Product Brand!");
                    return;
                }

                Brand brand = brandDAO.getByName(brandString);
                if (brand == null) {
                    brand = new Brand(brandString, true);
                    brandDAO.add(brand);
                }

                // Validate price
                double salePriceValue;
                try {
                    salePriceValue = Double.parseDouble(this.salePrice.getText().replace(",", ""));
                    if (salePriceValue <= 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Price!");
                    return;
                }

                // Validate type selection
                int type = this.type.getSelectedIndex() + 1;
                if (type <= 0) {
                    JOptionPane.showMessageDialog(this, "Please select a valid Product Type!");
                    return;
                }

                // Validate gender selection
                int gender = this.gender.getSelectedIndex() + 1;
                if (gender <= 0) {
                    JOptionPane.showMessageDialog(this, "Please select a valid Gender!");
                    return;
                }

                // Validate description
                String description = this.description.getText().trim();
                if (description == null || description.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Product Description!");
                    return;
                }

                // Validate image
                ImageIcon newImg = (ImageIcon) img.getIcon();
                byte[] imgByte = Functional.convertIconToByteArray(newImg);
                if (imgByte == null || imgByte.length == 0) {
                    JOptionPane.showMessageDialog(this, "Please upload a valid image!");
                    return;
                }

                double importPriceValue;
                try {
                    importPriceValue = Double.parseDouble(this.importPrice.getText().replace(",", ""));
                    if (importPriceValue <= 0) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid Price!");
                    return;
                }

                Product newProduct = new Product(productName, productCode, brand, 0, gender, imgByte, salePriceValue, importPriceValue, description, 100, true, type, true);
                parent.transferData(newProduct, importPriceValue);

                close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid Input! Please check your data and try again.");
                JOptionPane.showMessageDialog(this, e);
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

    private String formatPrice(double priceValue) {
        if (priceValue == 0) {
            return "N/A";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(priceValue);
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

    private void setPlaceholderDefault(final JTextField textField) {
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

    private void settings() {
        importPrice.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText().replace(",", "");
                try {
                    double value = Double.parseDouble(text);

                    // Adjust value if it's out of bounds
                    if (value < 10000) {
                        ((JTextField) input).setText(formatPrice(10000));
                        return true;
                    }
                    ((JTextField) input).setText(formatPrice(value));
                } catch (NumberFormatException e) {
                    // If it's not a valid number, set the field to 1
                    ((JTextField) input).setText(formatPrice(10000));
                }
                return true;
            }
        });

        salePrice.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText().replace(",", "");
                try {
                    double value = Double.parseDouble(text);

                    // Adjust value if it's out of bounds
                    if (value < 10000) {
                        ((JTextField) input).setText(formatPrice(10000));
                        return true;
                    }
                    ((JTextField) input).setText(formatPrice(value));
                } catch (NumberFormatException e) {
                    System.out.println(e);
                    // If it's not a valid number, set the field to 1
                    ((JTextField) input).setText(formatPrice(10000));
                }
                return true;
            }
        });
    }

    private void setting() {
        setPlaceholderDefault(name);
        setPlaceholderDefault(code);
        setPlaceholderDefault(importPrice);
        setPlaceholderDefault(salePrice);
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
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel categoryPanel;
    private RoundedTextField code;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JPanel contentPanel;
    private RoundedTextArea description;
    private RoundedTextField salePrice;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JPanel imagePanel;
    private ImageLabel img;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private RoundedTextField name;
    private RoundedTextField importPrice;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JButton uploadBtn;
    // End of variables declaration                   
}
