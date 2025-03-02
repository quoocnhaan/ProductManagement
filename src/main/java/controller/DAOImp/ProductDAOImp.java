/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.ProductDAO;
import java.util.List;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class ProductDAOImp implements ProductDAO {

    private Session session;

    public ProductDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Product t) {
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
    public Product get(int id) {
        return session.get(Product.class, id);
    }

    @Override
    public boolean update(Product t) {
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
            Product user = session.find(Product.class, id);
            user.setStatus(false);
            session.update(user);
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
    public List<Product> getAll() {
        Query<Product> query = session.createQuery("FROM Product p WHERE p.status IS TRUE", Product.class);
        return query.list();
    }

    @Override
    public List<Product> findByText(String text) {
        return session.createQuery("FROM Product p WHERE p.name LIKE :search", Product.class)
                .setParameter("search", "%" + text + "%")
                .getResultList();
    }
}
