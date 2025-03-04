/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.Product_SelectedDAO;
import java.util.List;
import model.Product;
import model.Product_Selected;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LENOVO
 */
public class Product_SelectedDAOImp implements Product_SelectedDAO {

    private Session session;

    public Product_SelectedDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Product_Selected t) {
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
    public Product_Selected get(int id) {
        return session.get(Product_Selected.class, id);
    }

    @Override
    public boolean update(Product_Selected t) {
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
            Product_Selected user = session.find(Product_Selected.class, id);
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
    public List<Product_Selected> getAll() {
        Query<Product_Selected> query = session.createQuery("FROM Product_Selected p WHERE p.status IS TRUE", Product_Selected.class);
        return query.list();
    }

    @Override
    public List<Product_Selected> findByText(String name, List<String> brands, String price, String gender, String type, String sort) {
        // Start building the query
        StringBuilder queryString = new StringBuilder("FROM Product_Selected p WHERE 1=1");

        // Filter by name (if provided)
        if (name != null && !name.isEmpty()) {
            queryString.append(" AND p.product.name LIKE :searchName");
        }

        // Filter by brands (if provided)
        if (brands != null && !brands.isEmpty()) {
            queryString.append(" AND p.product.brand IN :searchBrands");
        }

        // Filter by price range (if provided)
        if (price != null && !price.isEmpty()) {
            switch (price) {
                case "<500k":
                    queryString.append(" AND p.product.price < 500000");
                    break;
                case "500k-2000k":
                    queryString.append(" AND p.product.price BETWEEN 500000 AND 2000000");
                    break;
                case "2000k-4000k":
                    queryString.append(" AND p.product.price BETWEEN 2000000 AND 4000000");
                    break;
                case ">4000k":
                    queryString.append(" AND p.product.price > 4000000");
                    break;
                default:
                    // No price filter applied
                    break;
            }
        }

        // Filter by gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            queryString.append(" AND p.product.gender = :searchGender");
        }

        // Filter by type (if provided)
        if (type != null && !type.isEmpty()) {
            queryString.append(" AND p.product.type = :searchType");
        }

        // Sorting logic
        if (sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "Product Name A-Z":
                    queryString.append(" ORDER BY p.product.name ASC");
                    break;
                case "Product Name Z-A":
                    queryString.append(" ORDER BY p.product.name DESC");
                    break;
                case "Price Low to High":
                    queryString.append(" ORDER BY p.product.price ASC");
                    break;
                case "Price High to Low":
                    queryString.append(" ORDER BY p.product.price DESC");
                    break;
                default:
                    // No sort applied if sort is not provided or recognized
                    break;
            }
        }

        // Create query
        Query<Product_Selected> query = session.createQuery(queryString.toString(), Product_Selected.class);

        // Set parameters for name, brands, gender, and type
        if (name != null && !name.isEmpty()) {
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

    @Override
    public Product_Selected findByProduct(Product product) {
        // Build the HQL query to fetch Product_Selected by Product
        String hql = "FROM Product_Selected p WHERE p.product = :product";

        // Create the query
        Query<Product_Selected> query = session.createQuery(hql, Product_Selected.class);

        // Set the parameter for the Product
        query.setParameter("product", product);

        // Get the single result (assuming there's only one matching entry due to the @OneToOne relationship)
        return query.uniqueResult();
    }

    @Override
    public void deleteByStatusFalse() {
        Transaction transaction = null;
        try {
            // Start the transaction
            transaction = session.beginTransaction();

            // Build the HQL delete query to remove Product_Selected where status is false
            String hql = "DELETE FROM Product_Selected p WHERE p.status = false";
            Query query = session.createQuery(hql);

            // Execute the query to delete
            int result = query.executeUpdate();

            // Commit the transaction if successful
            transaction.commit();

            // Optional: Check the result to see how many rows were affected
            if (result > 0) {
                System.out.println(result + " entries with status 'false' have been deleted.");
            } else {
                System.out.println("No entries with status 'false' found to delete.");
            }

        } catch (Exception e) {
            // Roll back the transaction in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();  // Log the exception for debugging
        }
    }
}
