/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import model.GoodsReceipt;

/**
 *
 * @author PC
 */
public interface GoodsReceiptDAO extends InterfaceDAO<GoodsReceipt>{
    GoodsReceipt findByDate(Date date);
}
