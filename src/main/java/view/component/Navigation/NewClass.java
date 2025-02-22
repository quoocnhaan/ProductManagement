/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.Navigation;

import controller.DAO.NavigationItemDAO;
import controller.DAOImp.NavigationItemDAOImp;
import controller.Functional.Functional;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import model.NavigationItem;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author LENOVO
 */
public class NewClass {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            NavigationItemDAO navigationItemDAO = new NavigationItemDAOImp(session);

//            byte[] home_f = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/home_f.png")));
//            byte[] home_e = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/home_e.png")));
//
//            NavigationItem navigationItem = new NavigationItem("Home", home_f, home_e, true);
//
//            navigationItemDAO.add(navigationItem);
            byte[] product_f = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/product_f.png")));
            byte[] product_e = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/product_e.png")));

            NavigationItem navigationItem1 = new NavigationItem("Product", product_f, product_e, true);

            navigationItemDAO.add(navigationItem1);

            byte[] inventory_f = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/inventory_f.png")));
            byte[] inventory_e = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/inventory_e.png")));

            NavigationItem navigationItem2 = new NavigationItem("Inventory", inventory_f, inventory_e, true);

            navigationItemDAO.add(navigationItem2);

            byte[] importing_f = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/importing_f.png")));
            byte[] importing_e = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/importing_e.png")));

            NavigationItem navigationItem3 = new NavigationItem("Importing", importing_f, importing_e, true);

            navigationItemDAO.add(navigationItem3);

            byte[] invoice_f = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/invoice_f.png")));
            byte[] invoice_e = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/invoice_e.png")));

            NavigationItem navigationItem4 = new NavigationItem("Invoice", invoice_f, invoice_e, true);

            navigationItemDAO.add(navigationItem4);

            byte[] customer_f = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/customer_f.png")));
            byte[] customer_e = Functional.convertIconToByteArray(new ImageIcon(ClassLoader.getSystemResource("icon/customer_e.png")));

            NavigationItem navigationItem5 = new NavigationItem("Customer", customer_f, customer_e, true);

            navigationItemDAO.add(navigationItem5);

        } catch (Exception e) {
        }
    }
}
