/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.Btn;

import controller.Session.SharedData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;

/**
 *
 * @author PC
 */
public class SortButton extends JToggleButton {

    private Color unselectedColor = Color.WHITE;
    private Color unselectedTextColor = Color.BLACK;

    private Color selectedColor = SharedData.mainColor;  // Green

    public SortButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false); // No background fill
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor

        setFont(new Font("Roboto", Font.PLAIN, 15));

        setForeground(unselectedTextColor); // Default text color
        setBackground(unselectedColor);
        setPreferredSize(new Dimension(100, 40));

        addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                setForeground(unselectedTextColor);
                setFont(new Font("Roboto", Font.PLAIN, 15));
            } else if (e.getStateChange() == ItemEvent.SELECTED) {
                setForeground(selectedColor);
                setFont(new Font("Roboto", Font.BOLD, 16));
            }
        });

        addActionListener(e -> {
            System.out.println("Toggle 1 was clicked");
        });
    }
}
