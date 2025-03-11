/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.ImportProduct.ImportProductDetails.Product_Component;

import controller.DAO.GoodsReceiptDAO;
import controller.DAO.GoodsReceiptDetailDAO;
import controller.DAO.InventoryDAO;
import controller.DAO.InventoryDetailDAO;
import controller.DAO.ProductDAO;
import controller.DAOImp.GoodsReceiptDAOImp;
import controller.DAOImp.GoodsReceiptDetailDAOImp;
import controller.DAOImp.InventoryDAOImp;
import controller.DAOImp.InventoryDetailDAOImp;
import controller.DAOImp.ProductDAOImp;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.GoodsReceipt;
import model.GoodsReceiptDetail;
import model.Inventory;
import model.InventoryDetail;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Product.ImportProduct.ImportProductDetails.ImportProductPage_Component;

/**
 *
 * @author PC
 */
public class ProductList_Component extends javax.swing.JPanel {

    private List<Product_Component> list = new ArrayList<>();
    private ImportProductPage_Component parent;

    public ProductList_Component(ImportProductPage_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new GridLayout(0, 1, 0, 10));
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
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addNewProduct(Product newProduct) {
        Product_Component product_Component = new Product_Component(newProduct, this);
        list.add(product_Component);
        add(product_Component);
//        repaint();
//        revalidate();
    }

//    public void saveImportProducts(double totalPrice) {
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            int totalQuantity = 0;
//            //double totalPrice = 0;
//
//            GoodsReceiptDAO goodsReceiptDAO = new GoodsReceiptDAOImp(session);
//            GoodsReceiptDetailDAO goodsReceiptDetailDAO = new GoodsReceiptDetailDAOImp(session);
//            ProductDAO productDAO = new ProductDAOImp(session);
//            InventoryDAO inventoryDAO = new InventoryDAOImp(session);
//            InventoryDetailDAO inventoryDetailDAO = new InventoryDetailDAOImp(session);
//
//            Date curDate = new java.sql.Date(System.currentTimeMillis());
//            GoodsReceipt goodsReceipt = goodsReceiptDAO.findByDate(curDate);
//            Inventory inventory = inventoryDAO.findByDate(curDate);
//
//            if (inventory == null) {
//                inventory = new Inventory(curDate, 0, true);
//                inventoryDAO.add(inventory);
//            }
//
//            if (goodsReceipt == null) {
//                // Create a new GoodsReceipt and save it before creating GoodsReceiptDetail
//                goodsReceipt = new GoodsReceipt(curDate, 0, 0, 0, 0, 0, true);
//                goodsReceiptDAO.add(goodsReceipt);  // Save the new GoodsReceipt first
//            }
//
//            for (Product_Component product_Component : list) {
//                Product product = product_Component.getProduct();
//
//                int quantity = Integer.parseInt(product_Component.getQuantity());
//                totalQuantity += quantity;
//
//                double importPrice = product_Component.getImportPriceValue();
//
//                Product existingProduct = productDAO.getByCodeAndPrice(product.getCode(), product.getImportPrice());
//                if (existingProduct != null) {
//                    // Update product quantity
//                    existingProduct.setAmount(existingProduct.getAmount() + quantity);
//                    productDAO.update(existingProduct);
//
//                    InventoryDetail inventoryDetail = inventoryDetailDAO.findByProduct(existingProduct.getId(), curDate);
//                    if (inventoryDetail == null) {
//                        inventoryDetail = new InventoryDetail(inventory, existingProduct, existingProduct.getImportPrice() * quantity, quantity, quantity, true);
//                        inventoryDetailDAO.add(inventoryDetail);
//                    } else {
//                        inventoryDetail.setAmountStart(inventoryDetail.getAmountStart() + quantity);
//                        inventoryDetail.setAmountEnd(inventoryDetail.getAmountEnd() + quantity);
//                        inventoryDetail.setPrice(inventoryDetail.getAmountStart() * existingProduct.getImportPrice());
//                    }
//
////                    GoodsReceiptDetail goodsReceiptDetail = goodsReceiptDetailDAO.findByProduct(existingProduct.getId(), curDate);
////                    goodsReceiptDetail.setAmount(goodsReceiptDetail.getAmount() + quantity);
////                    goodsReceiptDetail.setTotal(goodsReceiptDetail.getAmount() * importPrice);
//                    GoodsReceiptDetail goodsReceiptDetail = goodsReceiptDetailDAO.findByProduct(existingProduct.getId(), curDate);
//                    if (goodsReceiptDetail == null) {
//                        // If no existing GoodsReceiptDetail is found, create a new one
//                        goodsReceiptDetail = new GoodsReceiptDetail(goodsReceipt, existingProduct, quantity, importPrice * quantity, true);
//                        goodsReceiptDetailDAO.add(goodsReceiptDetail);
//                    } else {
//                        // If it exists, update the amount and total
//                        goodsReceiptDetail.setAmount(goodsReceiptDetail.getAmount() + quantity);
//                        goodsReceiptDetail.setTotal(goodsReceiptDetail.getAmount() * importPrice);
//                        goodsReceiptDetailDAO.update(goodsReceiptDetail);
//                    }
//
//                    goodsReceiptDetailDAO.add(goodsReceiptDetail);
//
//                } else {
//                    product.setAmount(quantity);
//                    productDAO.add(product);
//
//                    InventoryDetail inventoryDetail = inventoryDetailDAO.findByProduct(product.getId(), curDate);
//                    if (inventoryDetail == null) {
//                        inventoryDetail = new InventoryDetail(inventory, product, product.getImportPrice() * quantity, quantity, quantity, true);
//                        inventoryDetailDAO.add(inventoryDetail);
//                    } else {
//                        inventoryDetail.setAmountStart(inventoryDetail.getAmountStart() + quantity);
//                        inventoryDetail.setAmountEnd(inventoryDetail.getAmountEnd() + quantity);
//                        inventoryDetail.setPrice(inventoryDetail.getAmountStart() * product.getImportPrice());
//                    }
//                    GoodsReceiptDetail goodsReceiptDetail = new GoodsReceiptDetail(goodsReceipt, product, quantity, importPrice * quantity, true);
//                    goodsReceiptDetailDAO.add(goodsReceiptDetail);
//                }
//            }
//
//            // Update the GoodsReceipt with the total quantity and price after looping through all products
//            goodsReceipt.setAmount(goodsReceipt.getAmount() + totalQuantity);
//            goodsReceipt.setTotalPrices(goodsReceipt.getTotalPrices() + totalPrice);
//            goodsReceiptDAO.update(goodsReceipt);  // Update the existing GoodsReceipt
//
//            inventory.setAmount(inventory.getAmount() + totalQuantity);
//            inventoryDAO.update(inventory);
//
//        } catch (Exception e) {
//            System.out.println(e + getClass().getName());
//        }
//    }

    void updateTotal(double quantityValue) {
        parent.updateTotal(quantityValue);
    }

    public void removeProduct(Product_Component product_Component) {
        list.remove(product_Component);
        remove(product_Component);
        repaint();
        revalidate();
        parent.updateTotal(-product_Component.getTotalValue());
    }

    public void saveImportProducts(double totalPrice, double discount, double deliveryFee, double otherDiscount) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            int totalQuantity = 0;
            //double totalPrice = 0;

            GoodsReceiptDAO goodsReceiptDAO = new GoodsReceiptDAOImp(session);
            GoodsReceiptDetailDAO goodsReceiptDetailDAO = new GoodsReceiptDetailDAOImp(session);
            ProductDAO productDAO = new ProductDAOImp(session);
            InventoryDAO inventoryDAO = new InventoryDAOImp(session);
            InventoryDetailDAO inventoryDetailDAO = new InventoryDetailDAOImp(session);

            Date curDate = new java.sql.Date(System.currentTimeMillis());
            GoodsReceipt goodsReceipt = goodsReceiptDAO.findByDate(curDate);
            Inventory inventory = inventoryDAO.findByDate(curDate);

            if (inventory == null) {
                inventory = new Inventory(curDate, 0, true);
                inventoryDAO.add(inventory);
            }

            if (goodsReceipt == null) {
                // Create a new GoodsReceipt and save it before creating GoodsReceiptDetail
                goodsReceipt = new GoodsReceipt(curDate, 0, 0, 0, 0, 0, true);
                goodsReceiptDAO.add(goodsReceipt);  // Save the new GoodsReceipt first
            }

            for (Product_Component product_Component : list) {
                Product product = product_Component.getProduct();

                int quantity = Integer.parseInt(product_Component.getQuantity());
                totalQuantity += quantity;

                double importPrice = product_Component.getImportPriceValue();

                Product existingProduct = productDAO.getByCodeAndPrice(product.getCode(), product.getImportPrice());
                if (existingProduct != null) {
                    // Update product quantity
                    existingProduct.setAmount(existingProduct.getAmount() + quantity);
                    productDAO.update(existingProduct);

                    InventoryDetail inventoryDetail = inventoryDetailDAO.findByProduct(existingProduct.getId(), curDate);
                    if (inventoryDetail == null) {
                        inventoryDetail = new InventoryDetail(inventory, existingProduct, existingProduct.getImportPrice() * quantity, quantity, quantity, true);
                        inventoryDetailDAO.add(inventoryDetail);
                    } else {
                        inventoryDetail.setAmountStart(inventoryDetail.getAmountStart() + quantity);
                        inventoryDetail.setAmountEnd(inventoryDetail.getAmountEnd() + quantity);
                        inventoryDetail.setPrice(inventoryDetail.getAmountStart() * existingProduct.getImportPrice());
                    }

                    GoodsReceiptDetail goodsReceiptDetail = goodsReceiptDetailDAO.findByProduct(existingProduct.getId(), curDate);
                    if (goodsReceiptDetail == null) {
                        // If no existing GoodsReceiptDetail is found, create a new one
                        goodsReceiptDetail = new GoodsReceiptDetail(goodsReceipt, existingProduct, quantity, importPrice * quantity, true);
                        goodsReceiptDetailDAO.add(goodsReceiptDetail);
                    } else {
                        // If it exists, update the amount and total
                        goodsReceiptDetail.setAmount(goodsReceiptDetail.getAmount() + quantity);
                        goodsReceiptDetail.setTotal(goodsReceiptDetail.getAmount() * importPrice);
                        goodsReceiptDetailDAO.update(goodsReceiptDetail);
                    }

                    goodsReceiptDetailDAO.add(goodsReceiptDetail);

                } else {
                    product.setAmount(quantity);
                    productDAO.add(product);

                    InventoryDetail inventoryDetail = inventoryDetailDAO.findByProduct(product.getId(), curDate);
                    if (inventoryDetail == null) {
                        inventoryDetail = new InventoryDetail(inventory, product, product.getImportPrice() * quantity, quantity, quantity, true);
                        inventoryDetailDAO.add(inventoryDetail);
                    } else {
                        inventoryDetail.setAmountStart(inventoryDetail.getAmountStart() + quantity);
                        inventoryDetail.setAmountEnd(inventoryDetail.getAmountEnd() + quantity);
                        inventoryDetail.setPrice(inventoryDetail.getAmountStart() * product.getImportPrice());
                    }
                    GoodsReceiptDetail goodsReceiptDetail = new GoodsReceiptDetail(goodsReceipt, product, quantity, importPrice * quantity, true);
                    goodsReceiptDetailDAO.add(goodsReceiptDetail);
                }
            }

            // Update the GoodsReceipt with the total quantity and price after looping through all products
            goodsReceipt.setDiscount(goodsReceipt.getDiscount() + discount);
            goodsReceipt.setDelivertyFee(goodsReceipt.getDelivertyFee() + deliveryFee);
            goodsReceipt.setOtherDiscount(goodsReceipt.getOtherDiscount() + otherDiscount);
            goodsReceipt.setAmount(goodsReceipt.getAmount() + totalQuantity);
            goodsReceipt.setTotalPrices(goodsReceipt.getTotalPrices() + totalPrice);
            goodsReceiptDAO.update(goodsReceipt);  // Update the existing GoodsReceipt

            inventory.setAmount(inventory.getAmount() + totalQuantity);
            inventoryDAO.update(inventory);

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
