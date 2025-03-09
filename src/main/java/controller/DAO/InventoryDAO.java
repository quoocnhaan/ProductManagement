/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import java.util.List;
import model.Inventory;
import model.Product;

/**
 *
 * @author PC
 */
public interface InventoryDAO extends InterfaceDAO<Inventory> {

    Inventory findByDate(Date date);

    List<Product> findByFiter(Date date, String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort, String productStatus);

    List<Product> findByFiter(Date date, String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort, List<Product> products);

    List<Product> getAllProducts(Date date);
}
