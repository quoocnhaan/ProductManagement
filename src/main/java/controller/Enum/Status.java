/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package controller.Enum;

import java.awt.Color;

/**
 *
 * @author LENOVO
 */
public enum Status {
    PENDING(Color.ORANGE),
    REJECTED(Color.RED),
    APPROVAL(Color.GREEN);

    private Color color;

    Status(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
