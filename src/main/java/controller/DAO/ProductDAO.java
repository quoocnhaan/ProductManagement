/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.util.List;
import model.Product;

/**
 *
 * @author PC
 */
public interface ProductDAO extends InterfaceDAO<Product>{
    List<Product> findByText(String text);
}
