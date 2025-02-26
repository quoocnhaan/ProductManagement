/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

import java.awt.Cursor;
import javax.swing.JCheckBox;

/**
 *
 * @author PC
 */
public class CustomCheckbox extends JCheckBox {

    public CustomCheckbox(boolean isSingle) {
        setOpaque(false); // Make the checkbox background transparent
        setFocusPainted(false);  // Remove the focus border

        // Set custom icons for checked and unchecked states
        setIcon(new CustomCheckBoxIcon());
        setSelectedIcon(new CustomCheckBoxIcon());

        // Set hand cursor when hovering over the checkbox
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
