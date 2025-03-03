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
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

public class FilterButton extends JToggleButton {

    private Color unselectedColor = new Color(240, 240, 240);
    private Color unselectedTextColor = new Color(102, 102, 102);

    private Color selectedColor = SharedData.mainColor;  // Green

    public FilterButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false); // No background fill
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor

        setFont(new Font("Roboto", Font.PLAIN, 15));

        setForeground(unselectedTextColor); // Default text color
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(100, 40));

        // Set the border
        setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, unselectedColor));

        addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                setForeground(unselectedTextColor);
                setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, unselectedColor));
            } else if (e.getStateChange() == ItemEvent.SELECTED) {
                setForeground(selectedColor);
                setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, selectedColor));
            }
        });

        addActionListener(e -> {
            System.out.println("Toggle 1 was clicked");
        });
    }
}
