/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.BillsPerDayDAO;
import java.sql.Date;
import java.util.List;
import model.BillsPerDay;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class BillsPerDayDAOImp implements BillsPerDayDAO {

    private Session session;

    public BillsPerDayDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(BillsPerDay t) {
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
    public BillsPerDay get(int id) {
        return session.get(BillsPerDay.class, id);
    }

    @Override
    public boolean update(BillsPerDay t) {
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
            BillsPerDay user = session.find(BillsPerDay.class, id);
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
    public List<BillsPerDay> getAll() {
        Query<BillsPerDay> query = session.createQuery("FROM BillsPerDay", BillsPerDay.class);
        return query.list();
    }

    @Override
    public BillsPerDay findByDate(Date date) {
        String hql = "FROM BillsPerDay b WHERE b.date = :date";

        // Create the query
        Query<BillsPerDay> query = session.createQuery(hql, BillsPerDay.class);

        // Set the parameter for the Product
        query.setParameter("date", date);

        // Get the single result (assuming there's only one matching entry due to the @OneToOne relationship)
        return query.uniqueResult();
    }

    @Override
    public List<BillsPerDay> findByDate(Date fromDate, Date toDate) {
        String hql;
        Query<BillsPerDay> query;

        // If toDate is null, only filter by fromDate
        if (toDate == null) {
            hql = "FROM BillsPerDay b WHERE b.date >= :fromDate";
            query = session.createQuery(hql, BillsPerDay.class);
            query.setParameter("fromDate", fromDate);
        } else {
            // Otherwise, filter by the date range
            hql = "FROM BillsPerDay b WHERE b.date BETWEEN :fromDate AND :toDate";
            query = session.createQuery(hql, BillsPerDay.class);
            query.setParameter("fromDate", fromDate);
            query.setParameter("toDate", toDate);
        }

        // Return the list of results
        return query.list();
    }
}
