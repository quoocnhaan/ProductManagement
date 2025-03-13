/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    private byte[] image1;

    @Lob
    private byte[] image2;

    @Lob
    private byte[] us;

    @Lob
    private byte[] aiu;

    @Column(nullable = false)
    private boolean status;

    public Images() {
    }

    public Images(byte[] image1, byte[] image2, byte[] us, byte[] aiu, boolean status) {
        this.image1 = image1;
        this.image2 = image2;
        this.us = us;
        this.aiu = aiu;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public byte[] getUs() {
        return us;
    }

    public void setUs(byte[] us) {
        this.us = us;
    }

    public byte[] getAiu() {
        return aiu;
    }

    public void setAiu(byte[] aiu) {
        this.aiu = aiu;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
