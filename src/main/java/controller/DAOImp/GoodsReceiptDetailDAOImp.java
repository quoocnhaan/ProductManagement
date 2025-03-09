/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.GoodsReceiptDetailDAO;
import java.sql.Date;
import java.util.List;
import model.GoodsReceipt;
import model.GoodsReceiptDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class GoodsReceiptDetailDAOImp implements GoodsReceiptDetailDAO {

    private Session session;

    public GoodsReceiptDetailDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(GoodsReceiptDetail t) {
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
    public GoodsReceiptDetail get(int id) {
        return session.get(GoodsReceiptDetail.class, id);
    }

    @Override
    public boolean update(GoodsReceiptDetail t) {
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
            GoodsReceiptDetail user = session.find(GoodsReceiptDetail.class, id);
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
    public List<GoodsReceiptDetail> getAll() {
        Query<GoodsReceiptDetail> query = session.createQuery("FROM GoodsReceiptDetail", GoodsReceiptDetail.class);
        return query.list();
    }

    @Override
    public GoodsReceiptDetail findByProduct(int productId, Date date) {
        String hql = "FROM GoodsReceiptDetail grd WHERE grd.product.id = :productId AND grd.goodsReceipt.date = :date AND grd.product.status IS TRUE";
        Query<GoodsReceiptDetail> query = session.createQuery(hql, GoodsReceiptDetail.class);
        query.setParameter("productId", productId);
        query.setParameter("date", date);
        return query.uniqueResult();
    }

    @Override
    public List<GoodsReceiptDetail> findAllByGoodsReceipt(GoodsReceipt goodsReceipt) {
        Query<GoodsReceiptDetail> query = session.createQuery(
                "FROM GoodsReceiptDetail WHERE goodsReceipt = :goodsReceipt", GoodsReceiptDetail.class);
        query.setParameter("goodsReceipt", goodsReceipt);
        return query.getResultList();
    }
}
