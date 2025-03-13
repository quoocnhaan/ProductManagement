/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Order.OrderDetails.OrderDetailContent.Product_Component;

import controller.DAO.BillsDAO;
import controller.DAO.BillsDetailDAO;
import controller.DAO.BillsPerDayDAO;
import controller.DAO.CustomerDAO;
import controller.DAO.InventoryDAO;
import controller.DAO.InventoryDetailDAO;
import controller.DAO.ProductDAO;
import controller.DAOImp.BillsDAOImp;
import controller.DAOImp.BillsDetailDAOImp;
import controller.DAOImp.BillsPerDayDAOImp;
import controller.DAOImp.CustomerDAOImp;
import controller.DAOImp.InventoryDAOImp;
import controller.DAOImp.InventoryDetailDAOImp;
import controller.DAOImp.ProductDAOImp;
import java.awt.GridLayout;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Address;
import model.Bills;
import model.BillsDetail;
import model.BillsPerDay;
import model.Customer;
import model.Inventory;
import model.InventoryDetail;
import model.OrderHistory;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.Order.OrderDetails.OrderDetailContent.OrderProductPage_Component;

/**
 *
 * @author PC
 */
public class ProductList_Component extends javax.swing.JPanel {
    
    private List<Product_Component> list = new ArrayList<>();
    private OrderProductPage_Component parent;
    private Bills bills;
    
    public ProductList_Component(OrderProductPage_Component parent) {
        initComponents();
        this.parent = parent;
        setLayout(new GridLayout(0, 1, 0, 10));
    }
    
    public ProductList_Component(OrderProductPage_Component parent, Bills bills) {
        initComponents();
        this.parent = parent;
        this.bills = bills;
        setLayout(new GridLayout(0, 1, 0, 10));
        initData();
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
    
    void updateTotal(double quantityValue) {
        parent.updateTotal(quantityValue);
    }
    
    public void removeProduct(Product_Component product_Component) {
        list.remove(product_Component);
        System.out.println("remove " + product_Component.getProduct().getName() + " from list");
        remove(product_Component);
        repaint();
        revalidate();
        parent.updateTotal(-product_Component.getTotalValue());
    }
    
    private void initData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        BillsDetailDAO billsDetailDAO = new BillsDetailDAOImp(session);
        
        List<BillsDetail> billsDetails = billsDetailDAO.findAllByBill(bills);
        
        for (BillsDetail billsDetail : billsDetails) {
            addNewProduct(billsDetail.getProduct(), billsDetail.getAmount());
        }
        session.close();
    }
    
    private void addNewProduct(Product product, int amount) {
        Product_Component product_Component = new Product_Component(product, this, amount);
        list.add(product_Component);
        add(product_Component);
        repaint();
        revalidate();
    }
    
    public void updateImportProducts(Bills bills, Customer customer, Address address, OrderHistory orderHistory, double deliveryFree, double totalPaid, double discount, double otherDiscount, double totalPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Date today = Date.valueOf(LocalDate.now());
        BillsPerDayDAO billsPerDayDAO = new BillsPerDayDAOImp(session);
        BillsDAO billsDAO = new BillsDAOImp(session);
        BillsDetailDAO billsDetailDAO = new BillsDetailDAOImp(session);
        ProductDAO productDAO = new ProductDAOImp(session);
        InventoryDAO inventoryDAO = new InventoryDAOImp(session);
        InventoryDetailDAO inventoryDetailDAO = new InventoryDetailDAOImp(session);
        CustomerDAO customerDAO = new CustomerDAOImp(session);
        
        Inventory inventory = inventoryDAO.findByDate(today);
        
        BillsPerDay billsPerDay = billsPerDayDAO.findByDate(today);
        if (billsPerDay == null) {
            billsPerDay = new BillsPerDay(today, 0, 0, true);
        }

        // create a new bills
        if (bills == null) {
            
            billsPerDayDAO.add(billsPerDay);
            
            customer.setAddressLine(address.getAddressLine());
            customer.setCity(address.getCity());
            customer.setDisctrict(address.getDusctrict());
            customer.setFlatName(address.getFlatName());
            
            customerDAO.add(customer);
            
            double totalCost = 0;
            int totalAmount = 0;
            bills = new Bills(billsPerDay, totalPrice, 0, totalPaid, orderHistory.getPaidDate(), orderHistory.getPackedDate(), orderHistory.getShippedDate(), orderHistory.getDeliveredDate(), discount, deliveryFree, otherDiscount, customer, true);
            billsDAO.add(bills);
            for (Product_Component product_Component : list) {
                int amount = Integer.parseInt(product_Component.getQuantity());
                totalAmount += amount;
                Product product = productDAO.get(product_Component.getProduct().getId());
                totalCost += amount * product.getImportPrice();
                product.setAmount(product.getAmount() - amount);
                product.setProductStatus(product.getAmount() != 0);
                productDAO.update(product);
                
                InventoryDetail inventoryDetail = inventoryDetailDAO.findByProduct(product.getId(), today);
                inventoryDetail.setAmountEnd(inventoryDetail.getAmountEnd() - amount);
                inventoryDetail.setPrice(inventoryDetail.getAmountEnd() * inventoryDetail.getProduct().getPrice());
                inventoryDetailDAO.update(inventoryDetail);
                
                BillsDetail billsDetail = new BillsDetail(bills, product_Component.getProduct(), amount, product_Component.getProduct().getPrice(), amount * product_Component.getProduct().getPrice(), true);
                billsDetailDAO.add(billsDetail);
            }
            billsPerDay.setAmount(billsPerDay.getAmount() + 1);
            bills.setProfit(totalPrice - totalCost);
            billsDAO.update(bills);
            inventory.setAmount(inventory.getAmount() - totalAmount);
            inventoryDAO.update(inventory);
            
        } else {
            if (bills != null) { //save some new infomations for bills
                
                Customer newCustomer = new Customer(customer.getName(), customer.getPhoneNumber(), true);
                newCustomer.setAddressLine(address.getAddressLine());
                newCustomer.setCity(address.getCity());
                newCustomer.setDisctrict(address.getDusctrict());
                newCustomer.setFlatName(address.getFlatName());
                
                customerDAO.add(newCustomer);
                
                Bills curBills = billsDAO.get(bills.getId());
                curBills.setCustomer(newCustomer);
                curBills.setDeliveredDate(orderHistory.getDeliveredDate());
                curBills.setPaidDate(orderHistory.getPaidDate());
                curBills.setPackedDate(orderHistory.getPackedDate());
                curBills.setShippedDate(orderHistory.getShippedDate());
                
                curBills.setDelivertyFee(deliveryFree);
                curBills.setDiscount(discount);
                curBills.setOtherDiscount(otherDiscount);
                curBills.setDeposit(totalPaid);
                curBills.setProfit((totalPrice - curBills.getTotal()) + curBills.getProfit());
                curBills.setTotal(totalPrice);
                
                billsDAO.update(bills);               
            }
        }
        billsPerDayDAO.update(billsPerDay);
        session.close();
    }
    
    public void unfulfilledOrder(Bills bills, Customer customer, Address address, OrderHistory orderHistory, double deliveryFee, double totalPaid, double discount, double otherDiscount, double totalPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Date today = Date.valueOf(LocalDate.now());
        
        BillsPerDayDAO billsPerDayDAO = new BillsPerDayDAOImp(session);
        BillsDAO billsDAO = new BillsDAOImp(session);
        BillsDetailDAO billsDetailDAO = new BillsDetailDAOImp(session);
        ProductDAO productDAO = new ProductDAOImp(session);
        InventoryDAO inventoryDAO = new InventoryDAOImp(session);
        InventoryDetailDAO inventoryDetailDAO = new InventoryDetailDAOImp(session);
        
        BillsPerDay billsPerDay = billsPerDayDAO.get(bills.getBillPerDay().getId());
        
        Inventory inventory = inventoryDAO.findByDate(today);
        
        if (bills != null) {
            // This block is for handling the cancellation of a bill.
            List<BillsDetail> billsDetails = billsDetailDAO.findAllByBill(bills); // Fetch all bill details for the given bill

            for (BillsDetail detail : billsDetails) {
                Product product = productDAO.get(detail.getProduct().getId());

                // Restore product stock
                int canceledAmount = detail.getAmount();
                product.setAmount(product.getAmount() + canceledAmount);
                product.setProductStatus(product.getAmount() != 0); // Update product status
                productDAO.update(product);

                // Restore inventory
                InventoryDetail inventoryDetail = inventoryDetailDAO.findByProduct(product.getId(), today);
                inventoryDetail.setAmountEnd(inventoryDetail.getAmountEnd() + canceledAmount);
                inventoryDetail.setPrice(inventoryDetail.getAmountEnd() * inventoryDetail.getProduct().getPrice());
                inventoryDetailDAO.update(inventoryDetail);
            }

            // Update inventory to reflect the restored amounts
            inventory.setAmount(inventory.getAmount() + billsDetails.stream().mapToInt(BillsDetail::getAmount).sum());
            inventoryDAO.update(inventory);

            // Optionally, you can remove the bill if cancellation means it no longer exists
            billsDAO.delete(bills.getId());  // If you want to remove the bill from the database after cancellation
            billsPerDay.setAmount(billsPerDay.getAmount() - 1);
            
            billsDAO.update(bills);
            billsPerDayDAO.update(billsPerDay);
        }
        
        session.close();
    }
    
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

