/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.component.Importing.Header;

import controller.DAO.GoodsReceiptDAO;
import controller.DAO.GoodsReceiptDetailDAO;
import controller.DAOImp.GoodsReceiptDAOImp;
import controller.DAOImp.GoodsReceiptDetailDAOImp;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.util.List;
import model.GoodsReceipt;
import model.GoodsReceiptDetail;
import org.hibernate.Session;
import util.HibernateUtil;
import view.component.CustomComponent.RoundedCard;

/**
 *
 * @author LENOVO
 */
public class Card_Component extends javax.swing.JPanel {

    private RoundedCard total;
    private RoundedCard totalPrice;
    private RoundedCard quantity;
    private RoundedCard totalPaid;
    private int totalValue = 0;
    private int quantityValue = 0;
    private double totalPriceValue = 0;
    private double totalPaidValue = 0;

    public Card_Component() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setBackground(Color.WHITE);

        initData();
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

    private void initData() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            GoodsReceiptDAO goodsReceiptDAO = new GoodsReceiptDAOImp(session);
            GoodsReceiptDetailDAO goodsReceiptDetailDAO = new GoodsReceiptDetailDAOImp(session);

            List<GoodsReceipt> list = goodsReceiptDAO.getAll();

            for (GoodsReceipt goodsReceipt : list) {
                List<GoodsReceiptDetail> details = goodsReceiptDetailDAO.findAllByGoodsReceipt(goodsReceipt);
                for (GoodsReceiptDetail detail : details) {
                    totalPaidValue += detail.getPaid();
                }
                totalPriceValue += goodsReceipt.getTotalPrices();
                quantityValue += goodsReceipt.getAmount();
                totalPaidValue += goodsReceipt.getDelivertyFee();
            }
            totalValue = list.size();

            total = new RoundedCard("Total Importing", totalValue + "");

            totalPrice = new RoundedCard("Total Importing Price", formatPrice(totalPriceValue) + " VNĐ");

            totalPaid = new RoundedCard("Total Importing Paid", formatPrice(totalPaidValue) + " VNĐ");

            quantity = new RoundedCard("Total Quantity", quantityValue + "");

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
    }

    private void addComponents() {
        add(total);
        add(totalPrice);
        add(totalPaid);
        add(quantity);
    }

    public void updateData() {
        quantityValue = 0;
        totalPriceValue = 0;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            GoodsReceiptDAO goodsReceiptDAO = new GoodsReceiptDAOImp(session);

            List<GoodsReceipt> list = goodsReceiptDAO.getAll();
            GoodsReceiptDetailDAO goodsReceiptDetailDAO = new GoodsReceiptDetailDAOImp(session);

            for (GoodsReceipt goodsReceipt : list) {
                List<GoodsReceiptDetail> details = goodsReceiptDetailDAO.findAllByGoodsReceipt(goodsReceipt);
                for (GoodsReceiptDetail detail : details) {
                    totalPaidValue += detail.getPaid();
                }
                totalPriceValue += goodsReceipt.getTotalPrices();
                quantityValue += goodsReceipt.getAmount();
                totalPaidValue += goodsReceipt.getDelivertyFee();
            }

            totalValue = list.size();
            total.updateValue(totalValue);
            totalPrice.updateValue(totalPriceValue);
            totalPaid.updateValue(totalPaidValue);
            quantity.updateValue(quantityValue);

        } catch (Exception e) {
            System.out.println(e + getClass().getName());
        }
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
