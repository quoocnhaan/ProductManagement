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
    public List<Product> findByText(String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort, String productStatus) {
        // Start building the query
        StringBuilder queryString = new StringBuilder("FROM Product p WHERE p.status IS TRUE");

        // Filter by name (if provided)
        if (name != null && !name.isEmpty()) {
            queryString.append(" AND p.name LIKE :searchName");
        }

        // Filter by brands (if provided)
        if (brands != null && !brands.isEmpty()) {
            queryString.append(" AND p.brand.name IN :searchBrands");
        }

        // Filter by price range (if provided)
        if (price != null && !price.isEmpty()) {
            queryString.append(" AND (");
            boolean first = true;
            for (String priceRange : price) {
                if (!first) {
                    queryString.append(" OR ");
                }
                switch (priceRange) {
                    case "<500k":
                        queryString.append("p.price < 500000");
                        break;
                    case "500k-2000k":
                        queryString.append("p.price BETWEEN 500000 AND 2000000");
                        break;
                    case "2000k-4000k":
                        queryString.append("p.price BETWEEN 2000000 AND 4000000");
                        break;
                    case ">4000k":
                        queryString.append("p.price > 4000000");
                        break;
                    default:
                        // No price filter applied for unknown values
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            queryString.append(" AND p.gender IN (");
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
            queryString.append(" AND p.type IN (");
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
                    queryString.append(" AND p.productStatus = TRUE");
                    break;
                case "Out-of-Stock":
                    queryString.append(" AND p.productStatus = FALSE");
                    break;
                case "All":
                    // No filter for "All" status, we don't need to add any condition here
                    break;
                default:
                    // If the status is unrecognized, no filter is applied
                    break;
            }
        }

        // Sorting logic
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
                    // No sorting applied for unrecognized sort options
                    break;
            }
        }

        // Create query
        Query<Product> query = session.createQuery(queryString.toString(), Product.class);

        // Set parameters for name and brands (since they use named parameters)
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
    public List<Product> getAllAvailable() {
        Query<Product> query = session.createQuery("FROM Product p WHERE p.status IS TRUE and p.productStatus IS TRUE", Product.class);
        return query.list();
    }

    @Override
    public List<Product> findByText(String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort) {
        // Start building the query
        StringBuilder queryString = new StringBuilder("FROM Product p WHERE p.status IS TRUE");

        // Filter by name (if provided)
        if (name != null && !name.isEmpty()) {
            queryString.append(" AND p.name LIKE :searchName");
        }

        // Filter by brands (if provided)
        if (brands != null && !brands.isEmpty()) {
            queryString.append(" AND p.brand.name IN :searchBrands");
        }

        // Filter by price range (if provided)
        if (price != null && !price.isEmpty()) {
            queryString.append(" AND (");
            boolean first = true;
            for (String priceRange : price) {
                if (!first) {
                    queryString.append(" OR ");
                }
                switch (priceRange) {
                    case "<500k":
                        queryString.append("p.price < 500000");
                        break;
                    case "500k-2000k":
                        queryString.append("p.price BETWEEN 500000 AND 2000000");
                        break;
                    case "2000k-4000k":
                        queryString.append("p.price BETWEEN 2000000 AND 4000000");
                        break;
                    case ">4000k":
                        queryString.append("p.price > 4000000");
                        break;
                    default:
                        // No price filter applied for unknown values
                        break;
                }
                first = false;
            }
            queryString.append(")");
        }

        // Filter by gender (if provided)
        if (gender != null && !gender.isEmpty()) {
            queryString.append(" AND p.gender IN (");
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
            queryString.append(" AND p.type IN (");
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

        queryString.append(" AND p.productStatus = TRUE");

        // Sorting logic
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
                    // No sorting applied for unrecognized sort options
                    break;
            }
        }

        // Create query
        Query<Product> query = session.createQuery(queryString.toString(), Product.class);

        // Set parameters for name and brands (since they use named parameters)
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
