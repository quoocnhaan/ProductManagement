/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Address {

    private String addressLine;
    private String dusctrict;
    private String city;
    private String flatName;

    public Address() {
    }

    public Address(String addressLine, String dusctrict, String city, String flatName) {
        this.addressLine = addressLine;
        this.dusctrict = dusctrict;
        this.city = city;
        this.flatName = flatName;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getDusctrict() {
        return dusctrict;
    }

    public void setDusctrict(String dusctrict) {
        this.dusctrict = dusctrict;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

}
