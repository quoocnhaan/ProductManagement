/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.Product_Component;

import controller.DAO.Product_SelectedDAO;
import controller.DAOImp.Product_SelectedDAOImp;
import controller.Functional.Functional;
import controller.Session.SharedData;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import model.Product;
import model.Product_Selected;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Btn.IconButton;
import view.component.CustomComponent.CustomCheckbox;
import view.component.Product.AddingProduct.EditProduct_Component;
import view.component.Product.Pagination.Pagination_Component;
import view.component.Product.Feature.SubFeature_Component;
import view.component.Product.Feature.ProductName_Component;
import view.component.Product.ProductPage_Component;

/**
 *
 * @author PC
 */
public class Product_Component extends javax.swing.JPanel {
    
    private CustomCheckbox customCheckbox;
    private IconButton editBtn;
    private Pagination_Component parent;
    private ProductPage_Component productPage_Component;
    private Product product;
    private boolean isChoosing;
    private Color mainColor = Color.WHITE;
    
    public Product_Component(Product product, Pagination_Component parent, boolean isChoosing) {
        initComponents();
        this.parent = parent;
        this.product = product;
        this.isChoosing = isChoosing;
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        addComponents(product);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        changeColor(true);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if (customCheckbox.isSelected()) {
            changeColor(true);
        } else {
            changeColor(false);
        }
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // open detail
    }//GEN-LAST:event_formMouseClicked
    
    private void addComponents(Product product) {
        
        boolean isAvailble = product.getProductStatus();
        
        customCheckbox = new CustomCheckbox(true);
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
            
            Product_Selected product_Selected = product_SelectedDAO.findByProduct(product);
            
            if (product_Selected != null) {
                customCheckbox.setSelected(product_Selected.isStatus());
            }
            
        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
        
        add(customCheckbox);
        
        ProductName_Component productName = new ProductName_Component(product.getName(), product.getCode(), Functional.convertByteArrayToIcon(product.getImg()));
        
        productName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                changeColor(true);
            }
            
            @Override
            public void mouseExited(MouseEvent evt) {
                if (customCheckbox.isSelected()) {
                    changeColor(true);
                } else {
                    changeColor(false);
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent evt) {
                //open view detail
            }
        });
        add(productName);
        
        List<String> features = new ArrayList<>();
        //"Brand", "Quantity", "Sale Price", "Discount", "Type", "Gender"

        features.add(product.getBrand().getName());
        features.add(product.getAmount() + "");
        features.add(formatPrice(product.getPrice()));
        features.add(product.getDiscount() + "");
        
        String typeString = "";
        int typeValue = product.getType();
        if (typeValue == 1) {
            typeString = "10ml";
        } else if (typeValue == 2) {
            typeString = "20ml";
        } else if (typeValue == 3) {
            typeString = "30ml";
        } else if (typeValue == 4) {
            typeString = "Full";
        }
        
        features.add(typeString);
        
        String genderString = "";
        int genderValue = product.getGender();
        if (genderValue == 1) {
            genderString = "Men";
        } else if (genderValue == 2) {
            genderString = "Women";
        } else if (genderValue == 3) {
            genderString = "Unisex";
        }
        features.add(genderString);
        
        for (int i = 0; i < features.size(); i++) {
            SubFeature_Component subFeature = new SubFeature_Component(features.get(i));
            
            subFeature.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    changeColor(true);
                }
                
                @Override
                public void mouseExited(MouseEvent evt) {
                    if (customCheckbox.isSelected()) {
                        changeColor(true);
                    } else {
                        changeColor(false);
                    }
                }
                
                @Override
                public void mouseClicked(MouseEvent evt) {
                    //open view detail
                }
            });
            
            add(subFeature);
            
        }
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/pencil.png"));
        editBtn = new IconButton("Edit", icon, false);
        if (!isAvailble) {
            editBtn.changeOutOfStockColor(!isAvailble);
        }
        if (!isChoosing) {
            add(editBtn);
        }
        
        if (!isAvailble) {
            mainColor = new Color(255, 207, 207);
            changeOutOfStockColor();
        }
    }
    
    public void changeColor(boolean isInside) {
        Color newColor = isInside ? Functional.adjustColorBrightness(mainColor, 0.97f) : mainColor;

        // Change the background of the Product_Component
        setBackground(newColor);

        // Iterate over all child components and change their background
        Component[] components = getComponents();
        for (Component component : components) {
            component.setBackground(newColor);
        }
        // Repaint the panel to ensure the new background is applied
        repaint();
    }
    
    public void changeOutOfStockColor() {
        // Change the background of the Product_Component
        setBackground(mainColor);

        // Iterate over all child components and change their background
        Component[] components = getComponents();
        for (Component component : components) {
            component.setBackground(mainColor);
        }
        // Repaint the panel to ensure the new background is applied
        repaint();
    }
    
    public void changeStatusCheckbox(boolean isCheck) {
        customCheckbox.setSelected(isCheck);
    }
    
    private void addEvents() {
        
        Product product = this.product;
        customCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    formMouseEntered();
                    SharedData.selectedAmount++;
                    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                        Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
                        if (!SharedData.beingSelected) {
                            Product_Selected product_Selected = new Product_Selected(product, true);
                            product_SelectedDAO.add(product_Selected);
                        } else {
                            Product_Selected product_Selected = product_SelectedDAO.findByProduct(product);
                            product_Selected.setStatus(true);
                            product_SelectedDAO.update(product_Selected);
                        }
                    } catch (Exception exception) {
                        System.out.println(exception + getClass().getName());
                    }
                    
                    if (customCheckbox.isFocusOwner()) {
                        productPage_Component.checkStatusSelectAllCheckbox();
                    }
                    
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    formMouseExited();
                    SharedData.selectedAmount--;
                    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                        Product_SelectedDAO product_SelectedDAO = new Product_SelectedDAOImp(session);
                        Product_Selected product_Selected = product_SelectedDAO.findByProduct(product);
                        if (!SharedData.beingSelected) {
                            product_SelectedDAO.delete(product_Selected.getId());
                        } else {
                            product_Selected.setStatus(false);
                            product_SelectedDAO.update(product_Selected);
                        }
                    } catch (Exception exception) {
                        System.out.println(exception + getClass().getName());
                    }
                    if (customCheckbox.isFocusOwner()) {
                        productPage_Component.checkStatusSelectAllCheckbox();
                    }
                }
                parent.updateSelectedAmount();
                parent.changeStatusDeleteButton(SharedData.selectedAmount != 0);
                productPage_Component.checkStatusEditButton();
            }
        });
        
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog addProductDialog = new JDialog((Frame) null, "Edit Product", true);  // true for modal
                addProductDialog.setSize(1250, 850);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen
                addProductDialog.setResizable(false);
                addProductDialog.add(new EditProduct_Component(parent, product, addProductDialog));
                
                addProductDialog.setVisible(true);
            }
        });
        
    }
    
    private void formMouseEntered() {
        changeColor(true);
    }
    
    private void formMouseExited() {
        changeColor(false);
    }
    
    public void changeStatusEditBtn(boolean b) {
        editBtn.setEnabled(b);
    }
    
    public boolean isSelected() {
        return customCheckbox.isSelected();
    }
    
    public void setProductPage_Component(ProductPage_Component productPage_Component) {
        this.productPage_Component = productPage_Component;
    }
    
    public Product getProduct() {
        return product;
    }
    
    private String formatPrice(double priceValue) {
        if (priceValue == 0) {
            return "0";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(priceValue);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
