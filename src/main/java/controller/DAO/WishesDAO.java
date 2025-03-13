/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import model.Wishes;

/**
 *
 * @author PC
 */
public interface WishesDAO extends InterfaceDAO<Wishes>{
    Wishes getByIndex(int index);
}
