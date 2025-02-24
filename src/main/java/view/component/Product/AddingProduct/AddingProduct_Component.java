package view.component.Product.AddingProduct;

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

public class AddingProduct_Component extends javax.swing.JPanel {

//    public AddingProduct_Component(Employee employee) {
//        this.employee = employee;
//        initComponents();
//        initData(employee);
//        customComponents();
//        removeFocus();
//    }
    public AddingProduct_Component() {
        initComponents();
        initData();
        customComponents();
        setting();
        removeFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title0 = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        label14 = new javax.swing.JLabel();
        chooseImgBtn = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        type = new javax.swing.JComboBox<>();
        denyBtn = new javax.swing.JButton();
        confirmBtn = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();
        code = new javax.swing.JTextField();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        brand = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1120, 420));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        title0.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title0.setForeground(new java.awt.Color(152, 137, 232));
        title0.setText("Add New Product");

        label1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 0));
        label1.setText("PRODUCT NAME");

        label7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        label3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 0, 0));
        label3.setText("TYPE");

        label6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label6.setForeground(new java.awt.Color(0, 0, 0));
        label6.setText("BRAND");

        label16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label16.setForeground(new java.awt.Color(0, 0, 0));
        label16.setText("STATUS");

        img.setBackground(new java.awt.Color(255, 255, 255));
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfume4.png"))); // NOI18N
        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        img.setSize(180, 180);

        label14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label14.setForeground(new java.awt.Color(0, 0, 0));
        label14.setText("GENDER");

        chooseImgBtn.setBackground(new java.awt.Color(152, 137, 232));
        chooseImgBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chooseImgBtn.setForeground(new java.awt.Color(255, 255, 255));
        chooseImgBtn.setText("BROWSE");
        chooseImgBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chooseImgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgBtnActionPerformed(evt);
            }
        });

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("Enter product name");
        name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        gender.setBackground(new java.awt.Color(255, 255, 255));
        gender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        gender.setForeground(new java.awt.Color(0, 0, 0));
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MAN", "WOMEN", "UNISEX" }));

        type.setBackground(new java.awt.Color(255, 255, 255));
        type.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        type.setForeground(new java.awt.Color(0, 0, 0));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10ML", "20ML", "30ML", "FULL" }));

        denyBtn.setBackground(new java.awt.Color(255, 255, 255));
        denyBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        denyBtn.setForeground(new java.awt.Color(255, 0, 51));
        denyBtn.setText("CANCEL");
        denyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        denyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyBtnActionPerformed(evt);
            }
        });

        confirmBtn.setBackground(new java.awt.Color(152, 137, 232));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setText("SAVE");
        confirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        status.setBackground(new java.awt.Color(255, 255, 255));
        status.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        status.setForeground(new java.awt.Color(0, 0, 0));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IN STOCK", "OUT OF STOCK", "IN TRANSIT" }));

        code.setBackground(new java.awt.Color(255, 255, 255));
        code.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        code.setForeground(new java.awt.Color(0, 0, 0));
        code.setText("Enter product code");
        code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        label8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label8.setForeground(new java.awt.Color(0, 0, 0));
        label8.setText("PRODUCT CODE");

        label9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label9.setForeground(new java.awt.Color(0, 0, 0));
        label9.setText("PRICE");

        label10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label10.setForeground(new java.awt.Color(0, 0, 0));
        label10.setText("DISCOUNT (%)");

        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        price.setForeground(new java.awt.Color(0, 0, 0));
        price.setText("200000");
        price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        discount.setBackground(new java.awt.Color(255, 255, 255));
        discount.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        discount.setForeground(new java.awt.Color(0, 0, 0));
        discount.setText("5");
        discount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("FINAL PRICE");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DESCRIPTION");

        description.setBackground(new java.awt.Color(255, 255, 255));
        description.setColumns(20);
        description.setForeground(new java.awt.Color(0, 0, 0));
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("100000");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        brand.setBackground(new java.awt.Color(255, 255, 255));
        brand.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        brand.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(chooseImgBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(title0))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label7)
                        .addGap(104, 104, 104)
                        .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(label1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(label8))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(code)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(price)
                            .addComponent(discount)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(brand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label14)
                    .addComponent(label3)
                    .addComponent(label16)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title0)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chooseImgBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(label1))
                                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label8)
                                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label6)
                                            .addComponent(brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label16)))
                                        .addGap(32, 32, 32))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label3))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label14))
                                        .addGap(67, 67, 67)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4)
                                            .addComponent(label9))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label10)
                                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label7)
                        .addGap(242, 242, 242)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseImgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp"));

        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

            img.setIcon(Functional.scaleImg(img, imageIcon));
        }
    }//GEN-LAST:event_chooseImgBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
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
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Do you want to cancel?", "Confirm", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            close();
        }
    }//GEN-LAST:event_denyBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> brand;
    private javax.swing.JButton chooseImgBtn;
    private javax.swing.JTextField code;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton denyBtn;
    private javax.swing.JTextArea description;
    private javax.swing.JTextField discount;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JLabel title0;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables

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
    }
//
//    private void initData(  ) {
//        ImageIcon imgValue = Functional.convertByteArrayToIcon(employee.getImage());
//        this.img.setIcon(Functional.scaleImg(img, imgValue));
//
//        this.id.setText(employee.getEmployeeId() + "");
//        this.name.setText(employee.getName());
//        String genderValue = (employee.isGender()) ? "Nam" : "Nữ";
//        this.gender.setSelectedItem(genderValue);
//        this.dateOfBirth.setDate(employee.getDateOfBirth());
//        this.placeOfBirth.setSelectedItem(employee.getContact().getPermanentAddress());
//
//        this.profession.setSelectedItem(employee.getContracts().get(0).getJob().getProfession());
//        this.type.setSelectedItem(employee.getContracts().get(0).getJob().getType());
//        this.startDate.setDate(employee.getContracts().get(0).getJob().getStartDate());
//        this.attendanceId.setText(employee.getAttendanceInformation().getAttendanceId());
//        this.departmentName.setText(employee.getDepartment().getName());
//
//        differenceInDays = employee.getSenority();
//        if (differenceInDays >= 30) {
//            long differenceInMonths = differenceInDays / 30;
//            this.senority.setText(differenceInMonths + " tháng");
//        } else {
//            this.senority.setText(differenceInDays + " ngày");
//        }
//
//        this.title.setSelectedItem(employee.getRoleDetail().getRole().getName());
//
//        this.phone.setText(employee.getContact().getPersonalPhone());
//        this.email.setText(employee.getContact().getPersonalEmail());
//        this.otherEmail.setText(employee.getContact().getPersonalEmail());
//    }

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
}
