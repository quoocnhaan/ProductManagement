/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.BillsDAO;
import java.util.List;
import model.Bills;
import model.BillsPerDay;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class BillsDAOImp implements BillsDAO {

    private Session session;

    public BillsDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Bills t) {
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
    public Bills get(int id) {
        return session.get(Bills.class, id);
    }

    @Override
    public boolean update(Bills t) {
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
            Bills user = session.find(Bills.class, id);
            user.setStatus(false);
            session.update(user); // Xóa role
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
    public List<Bills> getAll() {
        Query<Bills> query = session.createQuery("FROM Bills", Bills.class);
        return query.list();
    }

    @Override
    public List<Bills> findByBillsPerDay(BillsPerDay billsPerDay) {
        String hql = "FROM Bills b WHERE b.billPerDay = :billsPerDay";
        Query<Bills> query = session.createQuery(hql, Bills.class);
        query.setParameter("billsPerDay", billsPerDay);
        return query.getResultList();
    }

    @Override
    public List<Bills> findByFilter(BillsPerDay billsPerDay, String sort, String paymentStatus, List<String> orderStatus) {
        StringBuilder hql = new StringBuilder("FROM Bills b WHERE b.billPerDay = :billsPerDay");

        // Add paymentStatus filter if provided
        if (paymentStatus != null && !paymentStatus.isEmpty()) {
            switch (paymentStatus) {
                case "Paid":
                    hql.append(" AND b.paidDate IS NOT NULL");
                    break;
                case "Unpaid":
                    hql.append(" AND b.paidDate IS NULL");
                    break;
                case "Cancelled":
                    hql.append(" AND b.status IS FALSE");
                    break;
            }
        }

        // Add orderStatus filter if provided
        if (orderStatus != null && !orderStatus.isEmpty()) {
            boolean first = true;
            StringBuilder statusConditions = new StringBuilder();

            for (String status : orderStatus) {
                if (!first) {
                    statusConditions.append(" OR ");
                }

                switch (status) {
                    case "Packed":
                        statusConditions.append("b.packedDate IS NOT NULL");
                        break;
                    case "Shipped":
                        statusConditions.append("b.shippedDate IS NOT NULL");
                        break;
                    case "Delivered":
                        statusConditions.append("b.deliveredDate IS NOT NULL");
                        break;
                }
                first = false;
            }

            // Only append the status conditions if they exist
            if (statusConditions.length() > 0) {
                hql.append(" AND (").append(statusConditions).append(")");
            }
        }

        // Add sorting based on BillsPerDay date and total price
        hql.append(" ORDER BY b.billPerDay.date DESC");

        // Add sorting based on total price
        if (sort != null && !sort.isEmpty()) {
            if (sort.equals("Price: Low to High")) {
                hql.append(", b.total ASC");
            } else if (sort.equals("Price: High to Low")) {
                hql.append(", b.total DESC");
            }
        }

        // Execute the query
        Query<Bills> query = session.createQuery(hql.toString(), Bills.class);
        query.setParameter("billsPerDay", billsPerDay);

        return query.getResultList();
    }

}
