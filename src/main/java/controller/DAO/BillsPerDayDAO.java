/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import java.sql.Date;
import java.util.List;
import model.BillsPerDay;

/**
 *
 * @author PC
 */
public interface BillsPerDayDAO extends InterfaceDAO<BillsPerDay> {

    BillsPerDay findByDate(Date date);

    List<BillsPerDay> findByDate(Date fromDate, Date toDate);

}
