/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.util.List;
import model.Product;
import model.Product_Selected;

/**
 *
 * @author LENOVO
 */
public interface Product_SelectedDAO extends InterfaceDAO<Product_Selected> {

    List<Product_Selected> findByText(String name, List<String> brands, String price, String gender, String type, String sort);

    Product_Selected findByProduct(Product product);

    void deleteByStatusFalse();
}
