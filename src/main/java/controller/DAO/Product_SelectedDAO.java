/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import java.util.List;
import model.Product;
import model.Product_Selected;

/**
 *
 * @author LENOVO
 */
public interface Product_SelectedDAO extends InterfaceDAO<Product_Selected> {

    List<Product_Selected> findByFilter(Date date, String name, List<String> brands, List<String> price, List<String> gender, List<String> type, String sort, String productStatus);

    Product_Selected findByProduct(Product product);

    void deleteByStatusFalse();

    boolean deleteAll();
}
