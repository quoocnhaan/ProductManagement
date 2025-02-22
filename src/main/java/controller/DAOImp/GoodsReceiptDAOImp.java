/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.GoodsReceiptDAO;
import java.util.List;
import model.GoodsReceipt;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class GoodsReceiptDAOImp implements GoodsReceiptDAO{
        private Session session;

    public GoodsReceiptDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(GoodsReceipt t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback nếu có lỗi xảy ra
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GoodsReceipt get(int id) {
        return session.get(GoodsReceipt.class, id);
    }

    @Override
    public boolean update(GoodsReceipt t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback nếu có lỗi
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            GoodsReceipt user = session.find(GoodsReceipt.class, id);
            session.delete(user); // Xóa role
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback nếu có lỗi
            }
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<GoodsReceipt> getAll() {
        Query<GoodsReceipt> query = session.createQuery("FROM GoodsReceipt", GoodsReceipt.class);
        return query.list();
    }
}
