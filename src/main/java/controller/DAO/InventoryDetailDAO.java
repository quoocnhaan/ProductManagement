/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import java.util.List;
import model.InventoryDetail;
import model.Product;

/**
 *
 * @author PC
 */
public interface InventoryDetailDAO extends InterfaceDAO<InventoryDetail>{
    InventoryDetail findByProduct(int productId, Date date);
}
