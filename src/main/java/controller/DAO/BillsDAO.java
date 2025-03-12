/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.util.List;
import model.Bills;
import model.BillsPerDay;

/**
 *
 * @author PC
 */
public interface BillsDAO extends InterfaceDAO<Bills> {

    List<Bills> findByBillsPerDay(BillsPerDay billsPerDay);

    List<Bills> findByFilter(BillsPerDay billsPerDay, String sort, String paymentStatus, List<String> oderStatus);

}
