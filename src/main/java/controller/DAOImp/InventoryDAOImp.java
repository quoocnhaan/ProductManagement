/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.InventoryDAO;
import java.sql.Date;
import java.util.List;
import model.Inventory;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class InventoryDAOImp implements InventoryDAO {

    private Session session;

    public InventoryDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(Inventory t) {
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
    public Inventory get(int id) {
        return session.get(Inventory.class, id);
    }

    @Override
    public boolean update(Inventory t) {
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
            Inventory user = session.find(Inventory.class, id);
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
    public List<Inventory> getAll() {
        Query<Inventory> query = session.createQuery("FROM Inventory", Inventory.class);
        return query.list();
    }

    @Override
    public Inventory findByDate(Date date) {
        String queryString = "SELECT i FROM Inventory i WHERE i.date = :date";

        Query<Inventory> query = session.createQuery(queryString, Inventory.class);
        query.setParameter("date", date);

        // Return the result or null if not found
        return query.uniqueResultOptional().orElse(null);
    }

    // In Inventory
    @Override
    public List<Product> getAllProducts(Date date) {
        // Define the query string to fetch all products from InventoryDetail based on the provided date
        String queryString = "SELECT id.product FROM InventoryDetail id "
                + "JOIN id.inventory i "
                + "WHERE i.date = :searchDate AND id.product.status IS TRUE";

        // Create the query
        Query<Product> query = session.createQuery(queryString, Product.class);

        // Set the search date parameter
        query.setParameter("searchDate", date);

        // Return the list of products
        return query.getResultList();
    }

    @Override
    public List<Product> findByFiter(Date date, String name, List<String> brands, List<String> priceRanges, List<String> gender, List<String> type, String sort, String productStatus) {
        // Start building the query string
        StringBuilder queryString = new StringBuilder("SELECT id.product FROM InventoryDetail id "
                + "JOIN id.inventory i "
                + "WHERE i.date = :searchDate AND id.product.status IS TRUE");

        // Filter by name (if provided)
        if (name != null && !name.isEmpty()) {
            queryString.append(" AND id.product.name LIKE :searchName");
        }

        // Filter by brands (if provided)
        if (brands != null && !brands.isEmpty()) {
            queryString.append(" AND id.product.brand.name IN :searchBrands");
        }

        // Filter by price range (if provided)
        if (priceRanges != null && !priceRanges.isEmpty()) {
            queryString.append(" AND (");
            boolean first = true;
            for (String priceRange : priceRanges) {
                if (!first) {
                    queryString.append(" OR ");
                }
                switch (priceRange) {
                    case "<500k":
                        queryString.append("id.price < 500000");
                        break;
                    case "500k-2000k":
                        queryString.append("id.price BETWEEN 500000 AND 2000000");
                        break;
                    case "2000k-4000k":
                        queryString.append("id.price BETWEEN 2000000 AND 4000000");
                        break;
                    case ">4000k":
                        queryString.append("id.price > 4000000");
                        break;
                    default:
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            queryString.append(" AND id.product.gender IN (");
            boolean first = true;
            for (String g : gender) {
                if (!first) {
                    queryString.append(", ");
                }
                switch (g) {
                    case "Men":
                        queryString.append("1");
                        break;
                    case "Women":
                        queryString.append("2");
                        break;
                    case "Unisex":
                        queryString.append("3");
                        break;
                    default:
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by type (if provided)
        if (type != null && !type.isEmpty()) {
            queryString.append(" AND id.product.type IN (");
            boolean first = true;
            for (String t : type) {
                if (!first) {
                    queryString.append(", ");
                }
                switch (t) {
                    case "10ml":
                        queryString.append("1");
                        break;
                    case "20ml":
                        queryString.append("2");
                        break;
                    case "30ml":
                        queryString.append("3");
                        break;
                    case "Full":
                        queryString.append("4");
                        break;
                    default:
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by product status
        if (productStatus != null && !productStatus.isEmpty()) {
            switch (productStatus) {
                case "In-Stock":
                    queryString.append(" AND id.product.productStatus = TRUE");
                    break;
                case "Out-of-Stock":
                    queryString.append(" AND id.product.productStatus = FALSE");
                    break;
                case "All":
                    // No filter for "All" status
                    break;
                default:
                    break;
            }
        }

        // Sorting logic
        if (sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "Product Name A-Z":
                    queryString.append(" ORDER BY id.product.name ASC");
                    break;
                case "Product Name Z-A":
                    queryString.append(" ORDER BY id.product.name DESC");
                    break;
                case "Price Low to High":
                    queryString.append(" ORDER BY id.price ASC");
                    break;
                case "Price High to Low":
                    queryString.append(" ORDER BY id.price DESC");
                    break;
                default:
                    break;
            }
        }
        // Create the query
        Query<Product> query = session.createQuery(queryString.toString(), Product.class);

        // Set parameters
        query.setParameter("searchDate", date);
        if (name != null && !name.isEmpty()) {
            query.setParameter("searchName", "%" + name + "%");
        }
        if (brands != null && !brands.isEmpty()) {
            query.setParameter("searchBrands", brands);
        }

        // Return the result list
        return query.getResultList();
    }

    @Override
    public List<Product> findByFiter(Date date, String name, List<String> brands, List<String> priceRanges, List<String> gender, List<String> type, String sort) {
        // Start building the query string
        StringBuilder queryString = new StringBuilder("SELECT id.product FROM InventoryDetail id "
                + "JOIN id.inventory i "
                + "WHERE i.date = :searchDate AND id.product.status IS TRUE");

        // Filter by name (if provided)
        if (name != null && !name.isEmpty()) {
            queryString.append(" AND id.product.name LIKE :searchName");
        }

        // Filter by brands (if provided)
        if (brands != null && !brands.isEmpty()) {
            queryString.append(" AND id.product.brand.name IN :searchBrands");
        }

        // Filter by price range (if provided)
        if (priceRanges != null && !priceRanges.isEmpty()) {
            queryString.append(" AND (");
            boolean first = true;
            for (String priceRange : priceRanges) {
                if (!first) {
                    queryString.append(" OR ");
                }
                switch (priceRange) {
                    case "<500k":
                        queryString.append("id.price < 500000");
                        break;
                    case "500k-2000k":
                        queryString.append("id.price BETWEEN 500000 AND 2000000");
                        break;
                    case "2000k-4000k":
                        queryString.append("id.price BETWEEN 2000000 AND 4000000");
                        break;
                    case ">4000k":
                        queryString.append("id.price > 4000000");
                        break;
                    default:
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            queryString.append(" AND id.product.gender IN (");
            boolean first = true;
            for (String g : gender) {
                if (!first) {
                    queryString.append(", ");
                }
                switch (g) {
                    case "Men":
                        queryString.append("1");
                        break;
                    case "Women":
                        queryString.append("2");
                        break;
                    case "Unisex":
                        queryString.append("3");
                        break;
                    default:
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by type (if provided)
        if (type != null && !type.isEmpty()) {
            queryString.append(" AND id.product.type IN (");
            boolean first = true;
            for (String t : type) {
                if (!first) {
                    queryString.append(", ");
                }
                switch (t) {
                    case "10ml":
                        queryString.append("1");
                        break;
                    case "20ml":
                        queryString.append("2");
                        break;
                    case "30ml":
                        queryString.append("3");
                        break;
                    case "Full":
                        queryString.append("4");
                        break;
                    default:
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by product status
        queryString.append(" AND id.product.productStatus = TRUE");

        // Sorting logic
        if (sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "Product Name A-Z":
                    queryString.append(" ORDER BY id.product.name ASC");
                    break;
                case "Product Name Z-A":
                    queryString.append(" ORDER BY id.product.name DESC");
                    break;
                case "Price Low to High":
                    queryString.append(" ORDER BY id.price ASC");
                    break;
                case "Price High to Low":
                    queryString.append(" ORDER BY id.price DESC");
                    break;
                default:
                    break;
            }
        }
        // Create the query
        Query<Product> query = session.createQuery(queryString.toString(), Product.class);

        // Set parameters
        query.setParameter("searchDate", date);
        if (name != null && !name.isEmpty()) {
            query.setParameter("searchName", "%" + name + "%");
        }
        if (brands != null && !brands.isEmpty()) {
            query.setParameter("searchBrands", brands);
        }

        // Return the result list
        return query.getResultList();
    }

}
