/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import java.util.List;
import model.Product;

/**
 *
 * @author PC
 */
public interface ProductDAO extends InterfaceDAO<Product> {

    List<Product> findByFilter(Date date, String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort, String productStatus);

    List<Product> findByFilter(Date date, String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort);

    List<Product> getAllAvailable();

    List<Product> getProductsByDate(Date date);

    List<Product> getAvailableProductsByDate(Date date);
    
    Product getByCodeAndPrice(String code, double price);

    Double findPriceByProductAndDate(int productId, Date receiptDate);

}
