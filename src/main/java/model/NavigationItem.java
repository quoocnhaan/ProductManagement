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
@Table(name = "navigation_item")
public class NavigationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Lob
    @Column(name = "focusing_icon")
    private byte[] focusingIcon;

    @Lob
    @Column(name = "exited_icon")
    private byte[] exitedIcon;

    private boolean status;

    public NavigationItem() {
    }

    public NavigationItem(String name, byte[] focusingIcon, byte[] exitedIcon, boolean status) {
        this.name = name;
        this.focusingIcon = focusingIcon;
        this.exitedIcon = exitedIcon;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFocusingIcon() {
        return focusingIcon;
    }

    public void setFocusingIcon(byte[] focusingIcon) {
        this.focusingIcon = focusingIcon;
    }

    public byte[] getExitedIcon() {
        return exitedIcon;
    }

    public void setExitedIcon(byte[] exitedIcon) {
        this.exitedIcon = exitedIcon;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
