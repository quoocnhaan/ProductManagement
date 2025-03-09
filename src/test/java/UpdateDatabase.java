
import controller.DAO.InventoryDAO;
import controller.DAOImp.InventoryDAOImp;
import java.sql.Date;
import java.time.LocalDate;
import model.Inventory;
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

            Date date = Date.valueOf(LocalDate.now());

            InventoryDAO inventoryDAO = new InventoryDAOImp(session);
            Inventory inventory = new Inventory(date, 0, true);

            inventoryDAO.add(inventory);

        } catch (Exception e) {
        }
    }
}
