/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.GoodsReceiptDAO;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import model.GoodsReceipt;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author PC
 */
public class GoodsReceiptDAOImp implements GoodsReceiptDAO {

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

    @Override
    public GoodsReceipt findByDate(Date date) {
        String hql = "FROM GoodsReceipt g WHERE g.date = :date";

        // Create the query
        Query<GoodsReceipt> query = session.createQuery(hql, GoodsReceipt.class);

        // Set the parameter for the Product
        query.setParameter("date", date);

        // Get the single result (assuming there's only one matching entry due to the @OneToOne relationship)
        return query.uniqueResult();
    }

    @Override
    public List<GoodsReceipt> findByFilter(Date fromDate, Date toDate, String sort, String status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder queryString = new StringBuilder("FROM GoodsReceipt gr");

            // Add the paymentStatus filter if the status is not "All"
            boolean hasWhereClause = false;
            if (!"All".equalsIgnoreCase(status)) {
                queryString.append(" WHERE gr.paymentStatus = :status");
                hasWhereClause = true;
            }

            // Add date filtering for fromDate and toDate
            if (fromDate != null && toDate != null) {
                if (hasWhereClause) {
                    queryString.append(" AND");
                } else {
                    queryString.append(" WHERE");
                    hasWhereClause = true;
                }
                queryString.append(" gr.date BETWEEN :fromDate AND :toDate");
            } else if (fromDate != null) {
                if (hasWhereClause) {
                    queryString.append(" AND");
                } else {
                    queryString.append(" WHERE");
                    hasWhereClause = true;
                }
                queryString.append(" gr.date >= :fromDate");
            } else if (toDate != null) {
                if (hasWhereClause) {
                    queryString.append(" AND");
                } else {
                    queryString.append(" WHERE");
                }
                queryString.append(" gr.date <= :toDate");
            }

            // Add sorting logic based on the "sort" parameter
            if (sort != null && !sort.isEmpty()) {
                switch (sort) {
                    case "Price Low to High":
                        queryString.append(" ORDER BY gr.totalPrices ASC");
                        break;
                    case "Price High to Low":
                        queryString.append(" ORDER BY gr.totalPrices DESC");
                        break;
                    // Add other sorting cases if needed
                    default:
                        // If no matching sort case, leave query unchanged
                        break;
                }
            }

            // Create the query
            Query<GoodsReceipt> query = session.createQuery(queryString.toString(), GoodsReceipt.class);

            // Set the paymentStatus parameter only if the status is not "All"
            if (!"All".equalsIgnoreCase(status)) {
                Boolean paymentStatus = "Complete".equalsIgnoreCase(status);
                query.setParameter("status", paymentStatus); // Set parameter for Complete/Not Complete
            }

            // Set date parameters if provided
            if (fromDate != null) {
                query.setParameter("fromDate", fromDate);
            }
            if (toDate != null) {
                query.setParameter("toDate", toDate);
            }

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

}
