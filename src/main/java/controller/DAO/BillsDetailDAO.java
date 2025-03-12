/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.util.List;
import model.Bills;
import model.BillsDetail;

/**
 *
 * @author PC
 */
public interface BillsDetailDAO extends InterfaceDAO<BillsDetail>{
    List<BillsDetail> findAllByBill(Bills bills);
}
