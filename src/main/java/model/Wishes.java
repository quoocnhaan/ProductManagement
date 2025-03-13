/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "wishes")
public class Wishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int wish_index;

    private String wish;

    public Wishes() {
    }

    public Wishes(int wish_index, String wish) {
        this.wish_index = wish_index;
        this.wish = wish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWishIndex() {
        return wish_index;
    }

    public void setWishIndex(int index) {
        this.wish_index = index;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

}
