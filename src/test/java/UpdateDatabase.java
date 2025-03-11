
import controller.DAO.InventoryDAO;
import controller.DAO.ProductDAO;
import controller.DAOImp.InventoryDAOImp;
import controller.DAOImp.ProductDAOImp;
import java.sql.Date;
import java.time.LocalDate;
import model.Inventory;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
public class UpdateDatabase {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//
//            Date date = Date.valueOf(LocalDate.now());
//
//            InventoryDAO inventoryDAO = new InventoryDAOImp(session);
//            ProductDAO productDAO = new ProductDAOImp(session);
//            
//            Product product = productDAO.get(88);
//
//            System.out.println(inventoryDAO.getOpeningInventory(product, date));

        } catch (Exception e) {
            
        }
    }
}
