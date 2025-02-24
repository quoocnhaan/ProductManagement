/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.BrandDAO;
import java.util.List;
import model.Brand;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class BrandDAOImp implements BrandDAO {

    private Session session;

    public BrandDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Brand t) {
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
    public Brand get(int id) {
        return session.get(Brand.class, id);
    }

    @Override
    public boolean update(Brand t) {
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
            Brand user = session.find(Brand.class, id);
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
    public List<Brand> getAll() {
        Query<Brand> query = session.createQuery("FROM Brand", Brand.class);
        return query.list();
    }

    @Override
    public Brand getByName(String name) {
        return session.createQuery("FROM Brand WHERE name = :name", Brand.class)
                .setParameter("name", name)
                .uniqueResult();
    }
}
