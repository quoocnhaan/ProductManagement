/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.Product_BrowseDAO;
import java.util.List;
import model.Product_Browsed;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class Product_BrowseDAOImp implements Product_BrowseDAO {

    private Session session;

    public Product_BrowseDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Product_Browsed t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product_Browsed get(int id) {
        return session.get(Product_Browsed.class, id);
    }

    @Override
    public boolean update(Product_Browsed t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            Product_Browsed user = session.find(Product_Browsed.class, id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Product_Browsed> getAll() {
        Query<Product_Browsed> query = session.createQuery("FROM Product_Browsed", Product_Browsed.class);
        return query.list();
    }

    @Override
    public boolean deleteAll() {
        Transaction transaction = null;
        try {
            // Start the transaction
            transaction = session.beginTransaction();

            // Build the HQL delete query to remove all entries in Product_Selected
            String hql = "DELETE FROM Product_Browsed";
            Query query = session.createQuery(hql);

            // Execute the query to delete all entries
            int result = query.executeUpdate();

            // Commit the transaction if successful
            transaction.commit();

            // Optional: Check the result to see how many rows were deleted
            System.out.println(result + " entries have been deleted from Product_Selected.");

        } catch (Exception e) {
            // Roll back the transaction in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();  // Log the exception for debugging
        }
        return true;
    }

}
