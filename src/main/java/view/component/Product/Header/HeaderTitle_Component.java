/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Product.Header;

import controller.DAO.InventoryDAO;
import controller.DAO.InventoryDetailDAO;
import controller.DAO.ProductDAO;
import controller.DAOImp.InventoryDAOImp;
import controller.DAOImp.InventoryDetailDAOImp;
import controller.DAOImp.ProductDAOImp;
import controller.Functional.Functional;
import controller.Session.ExcelExporter;
import controller.Session.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import model.Inventory;
import model.InventoryDetail;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Btn.IconButton;
import view.component.Btn.RoundedButton;
import view.component.Product.ImportProduct.ImportDetailsPage_Component;

/**
 *
 * @author LENOVO
 */
public class HeaderTitle_Component extends javax.swing.JPanel {

    private RoundedButton createBtn;
    private IconButton exportBtn;
    private Header_Component parent;
    private IconButton transferBtn;

    public HeaderTitle_Component(Header_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new BorderLayout());
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

    private void addComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding around the main panel

        // Title on the left
        JLabel titleLabel = new JLabel("Product");
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 24)); // Set title font and size
        mainPanel.add(titleLabel, BorderLayout.WEST);

        // Panel to hold buttons on the right
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 0)); // Align buttons to the right
        buttonPanel.setBackground(Color.WHITE);

        // Add button
        createBtn = new RoundedButton("Import product", true, 15, 35);

        ImageIcon icon = new ImageIcon(getClass().getResource("/icon/export.png"));
        exportBtn = new IconButton("Export", icon, true);

        ImageIcon icon2 = new ImageIcon(getClass().getResource("/icon/transfer.png"));
        transferBtn = new IconButton("Close Day & Transfer", icon2, true);

        // Add buttons to the panel
        buttonPanel.add(transferBtn);
        buttonPanel.add(exportBtn);
        buttonPanel.add(createBtn);

        mainPanel.add(buttonPanel, BorderLayout.EAST);

        add(mainPanel);
    }

    private void addEvents() {
        HeaderTitle_Component headerTitle_Component = this;
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a JDialog for the popup

                JDialog addProductDialog = new JDialog((Frame) null, "Import Product", true);  // true for modal
                addProductDialog.setSize(1280, 730);
                addProductDialog.setResizable(false);
                addProductDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);  // Close only the dialog
                addProductDialog.setLocationRelativeTo(null);  // Center the popup on screen
                addProductDialog.setResizable(false);
                addProductDialog.setUndecorated(true);
                //addProductDialog.add(new ImportDetailsPage_Component(addProductDialog, headerTitle_Component));
                ImportDetailsPage_Component importDetailsPage_Component = new ImportDetailsPage_Component(addProductDialog, headerTitle_Component);

                importDetailsPage_Component.setBorder(new LineBorder(Color.GRAY, 2));
                addProductDialog.add(importDetailsPage_Component);
                addProductDialog.setVisible(true);
            }
        });

        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try (Session session = HibernateUtil.getSessionFactory().openSession()) {

                    ProductDAO productDAO = new ProductDAOImp(session);

                    List<Product> products = productDAO.getAll();

                    JFileChooser fileChooser = new JFileChooser();
                    // Set the default directory to Desktop
                    fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"), "Desktop"));

                    // Set file chooser to save dialog mode
                    fileChooser.setDialogTitle("Choose location to save the Excel file");
                    fileChooser.setSelectedFile(new File("products.xlsx")); // Default file name

                    int userSelection = fileChooser.showSaveDialog(null);

                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        String filePath = fileToSave.getAbsolutePath();

                        // Ensure the file has the correct extension
                        if (!filePath.toLowerCase().endsWith(".xlsx")) {
                            filePath += ".xlsx";
                        }

                        // Export the products to Excel
                        ExcelExporter.exportProductsToExcel(products, filePath);

                        JOptionPane.showMessageDialog(null, "Excel file created successfully !");
                        System.out.println("Excel file created: " + filePath);
                    } else {
                        System.out.println("File save operation was canceled.");
                    }

                } catch (Exception exception) {
                    System.out.println(exception + getClass().getName());
                }

            }
        });

        transferBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a confirmation dialog
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to transfer the inventory data to the next day?",
                        "Confirm Transfer",
                        JOptionPane.YES_NO_OPTION
                );

                if (result == JOptionPane.YES_OPTION) {
                    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                        // Get today's and next day's dates
                        Date today = Date.valueOf(LocalDate.now());
                        LocalDate nextDay = LocalDate.now().plusDays(1);
                        Date nextDayDate = Date.valueOf(nextDay);

                        // Fetch today's inventory
                        InventoryDAO inventoryDAO = new InventoryDAOImp(session);
                        Inventory inventory = inventoryDAO.findByDate(today);

                        // Fetch all inventory details for today's inventory
                        InventoryDetailDAO inventoryDetailDAO = new InventoryDetailDAOImp(session);
                        List<InventoryDetail> details = inventoryDetailDAO.findDetailsByInventory(inventory);

                        int totalAmount = 0;

                        // Compute total amount for today's inventory
                        for (InventoryDetail detail : details) {
                            totalAmount += detail.getAmountEnd();
                        }

                        // Check if inventory for the next day already exists
                        Inventory nextDayInventory = inventoryDAO.findByDate(nextDayDate);

                        if (nextDayInventory != null) {
                            // Delete all InventoryDetail records for the next day
                            inventoryDetailDAO.deleteAllByInventory(nextDayInventory);

                            // Update the next day's inventory total amount
                            nextDayInventory.setAmount(totalAmount);
                            inventoryDAO.update(nextDayInventory);

                            // Transfer today's InventoryDetail data to the next day
                            for (InventoryDetail detail : details) {
                                if (detail.getProduct().isStatus()) {
                                    InventoryDetail newDetail = new InventoryDetail();
                                    newDetail.setInventory(nextDayInventory);
                                    newDetail.setProduct(detail.getProduct());
                                    newDetail.setPrice(detail.getPrice());
                                    newDetail.setAmountStart(detail.getAmountEnd());  // Carry over amount_end as amount_start
                                    newDetail.setAmountEnd(detail.getAmountEnd());  // Initialize amount_end to 0 for the new day
                                    newDetail.setStatus(detail.isStatus());

                                    inventoryDetailDAO.add(newDetail);  // Save new inventory detail
                                }
                            }
                        } else {
                            // If the next day's inventory does not exist, create it
                            Inventory newInventory = new Inventory();
                            newInventory.setDate(nextDayDate);
                            newInventory.setStatus(inventory.isStatus());  // Carry over the same status
                            newInventory.setAmount(totalAmount);  // Total amount computed above
                            inventoryDAO.add(newInventory);

                            // Create new InventoryDetail records for the next day
                            for (InventoryDetail detail : details) {
                                if (detail.getProduct().isStatus()) {
                                    InventoryDetail newDetail = new InventoryDetail();
                                    newDetail.setInventory(newInventory);
                                    newDetail.setProduct(detail.getProduct());
                                    newDetail.setPrice(detail.getPrice());
                                    newDetail.setAmountStart(detail.getAmountEnd());  // Carry over amount_end as amount_start
                                    newDetail.setAmountEnd(detail.getAmountEnd());  // Initialize amount_end to 0 for the new day
                                    newDetail.setStatus(detail.isStatus());

                                    inventoryDetailDAO.add(newDetail);  // Save new inventory detail
                                }
                            }
                        }

                        JOptionPane.showMessageDialog(null, "Transfer data successfully!");

                    } catch (Exception exception) {
                        exception.printStackTrace();  // Handle exception
                    }
                } else {
                    System.out.println("Transfer canceled by the user.");
                }
            }
        });
    }

    public void resetDataWhenAdded() {
        parent.resetDataWhenAdded();
    }

    public void resetPageWhenCloseImport() {
        parent.resetPageWhenCloseImport();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
