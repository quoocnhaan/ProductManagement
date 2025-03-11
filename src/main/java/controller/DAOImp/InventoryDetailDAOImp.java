/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.DAOImp;

import controller.DAO.InventoryDetailDAO;
import java.sql.Date;
import java.util.List;
import model.Inventory;
import model.InventoryDetail;
import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class InventoryDetailDAOImp implements InventoryDetailDAO {

    private Session session;

    public InventoryDetailDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public boolean add(InventoryDetail t) {
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
    public InventoryDetail get(int id) {
        return session.get(InventoryDetail.class, id);
    }

    @Override
    public boolean update(InventoryDetail t) {
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
            InventoryDetail user = session.find(InventoryDetail.class, id);
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
    public List<InventoryDetail> getAll() {
        Query<InventoryDetail> query = session.createQuery("FROM InventoryDetail", InventoryDetail.class);
        return query.list();
    }

    @Override
    public InventoryDetail findByProduct(int productId, Date inventoryDate) {
        String queryString = "SELECT id "
                + "FROM InventoryDetail id "
                + "JOIN id.product p "
                + "JOIN id.inventory i "
                + "WHERE p.id = :productId AND i.date = :inventoryDate AND p.status IS TRUE";

        Query<InventoryDetail> query = session.createQuery(queryString, InventoryDetail.class);
        query.setParameter("productId", productId);
        query.setParameter("inventoryDate", inventoryDate);

        // Return the result list
        return query.uniqueResultOptional().orElse(null);
    }

    @Override
    public List<InventoryDetail> findDetailsByInventory(Inventory inventory) {
        Query<InventoryDetail> query = session.createQuery(
                "FROM InventoryDetail id WHERE id.inventory = :inventory AND id.status IS TRUE", InventoryDetail.class);
        query.setParameter("inventory", inventory);
        return query.getResultList();
    }

    @Override
    public void deleteAllByInventory(Inventory inventory) {
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("DELETE FROM InventoryDetail WHERE inventory = :inventory");
            query.setParameter("inventory", inventory);
            int result = query.executeUpdate();
            transaction.commit();
            System.out.println("Deleted " + result + " records for the specified inventory.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public int getTotalAmountEndByInventory(Inventory inventory) {
        List<InventoryDetail> inventoryDetails = findDetailsByInventory(inventory);
        return inventoryDetails.stream().mapToInt(InventoryDetail::getAmountEnd).sum();
    }
}
