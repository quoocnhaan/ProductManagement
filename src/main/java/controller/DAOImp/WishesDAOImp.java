/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.WishesDAO;
import java.util.List;
import model.Wishes;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class WishesDAOImp implements WishesDAO {

    private Session session;

    public WishesDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Wishes t) {
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
    public Wishes get(int id) {
        return session.get(Wishes.class, id);
    }

    @Override
    public boolean update(Wishes t) {
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
            Wishes user = session.find(Wishes.class, id);
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
    public List<Wishes> getAll() {
        Query<Wishes> query = session.createQuery("FROM Wishes", Wishes.class);
        return query.list();
    }

    @Override
    public Wishes getByIndex(int index) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        // Check if the current year is a leap year
        if (isLeapYear(currentYear)) {
            // If the index is 60 or greater, shift it to account for Feb 29
            if (index >= 60) {
                index += 1;  // Shift the index to account for the leap day
            }
            System.out.println("hello");
        }

        Query<Wishes> query = session.createQuery("FROM Wishes w WHERE w.wish_index = :index", Wishes.class);
        query.setParameter("index", index);
        return query.uniqueResult();
    }

// Method to determine if a year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
