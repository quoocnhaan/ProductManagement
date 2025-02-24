/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller.DAO;

import model.Brand;

/**
 *
 * @author PC
 */
public interface BrandDAO extends InterfaceDAO<Brand>{
    Brand getByName(String name);
}
