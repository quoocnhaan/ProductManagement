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
    public List<Product> findByText(String name, List<String> brands, String price, String gender, String type, String sort) {
        // Start building the query
        StringBuilder queryString = new StringBuilder("FROM Product p WHERE 1=1");

        // Filter by name (if provided)
        if (name != null && !name.isEmpty()) {
            queryString.append(" AND p.name LIKE :searchName");
        }

        // Filter by brands (if provided)
        if (brands != null && !brands.isEmpty()) {
            queryString.append(" AND p.brand IN :searchBrands");
        }

        // Filter by price range (if provided)
        if (price != null && !price.isEmpty()) {
            switch (price) {
                case "<500k":
                    queryString.append(" AND p.price < 500000");
                    break;
                case "500k-2000k":
                    queryString.append(" AND p.price BETWEEN 500000 AND 2000000");
                    break;
                case "2000k-4000k":
                    queryString.append(" AND p.price BETWEEN 2000000 AND 4000000");
                    break;
                case ">4000k":
                    queryString.append(" AND p.price > 4000000");
                    break;
                default:
                    // No price filter applied
                    break;
            }
        }

        // Filter by gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            queryString.append(" AND p.gender = :searchGender");
        }

        // Filter by type (if provided)
        if (type != null && !type.isEmpty()) {
            queryString.append(" AND p.type = :searchType");
        }

        if (sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "Product Name A-Z":
                    queryString.append(" ORDER BY p.name ASC");
                    break;
                case "Product Name Z-A":
                    queryString.append(" ORDER BY p.name DESC");
                    break;
                case "Price Low to High":
                    queryString.append(" ORDER BY p.price ASC");
                    break;
                case "Price High to Low":
                    queryString.append(" ORDER BY p.price DESC");
                    break;
                default:
                    // No sort applied if sort is not provided or recognized
                    break;
            }
        }

        // Create query
        Query<Product> query = session.createQuery(queryString.toString(), Product.class);

        // Set parameters for name, brands, gender, and type
        if (name != null && !name.isEmpty()) {
            System.out.println(name);
            query.setParameter("searchName", "%" + name + "%");
        }
        if (brands != null && !brands.isEmpty()) {
            query.setParameter("searchBrands", brands);
        }
        if (gender != null && !gender.isEmpty()) {
            query.setParameter("searchGender", gender);
        }
        if (type != null && !type.isEmpty()) {
            query.setParameter("searchType", type);
        }

        // Return the result list
        return query.getResultList();
    }

}
