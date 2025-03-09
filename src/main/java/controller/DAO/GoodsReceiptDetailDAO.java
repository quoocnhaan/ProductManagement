/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import model.GoodsReceiptDetail;

/**
 *
 * @author PC
 */
public interface GoodsReceiptDetailDAO extends InterfaceDAO<GoodsReceiptDetail> {

    GoodsReceiptDetail findByProduct(int productId, Date date);

}
