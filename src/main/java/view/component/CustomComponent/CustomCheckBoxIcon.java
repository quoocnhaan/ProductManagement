/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 *
 * @author PC
 */
public class CustomCheckBoxIcon implements Icon {

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        JCheckBox checkBox = (JCheckBox) c;  // Cast the component to JCheckBox
        boolean isSelected = checkBox.isSelected();  // Get the current state of the checkbox

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the border
        g2.setColor(Color.GRAY);  // Gray border color
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(x, y, getIconWidth() - 1, getIconHeight() - 1, 10, 10);

        // Draw background when checked
        if (isSelected) {
            g2.setColor(new Color(0, 128, 0));  // Green background
            g2.fillRoundRect(x + 1, y + 1, getIconWidth() - 2, getIconHeight() - 2, 10, 10);

            // Draw the smaller checkmark
            g2.setColor(Color.WHITE);  // White checkmark
            g2.setStroke(new BasicStroke(1));  // Thinner stroke for a smaller checkmark
            g2.drawLine(x + 4, y + 8, x + 7, y + 12);  // Smaller checkmark
            g2.drawLine(x + 7, y + 12, x + 12, y + 4);
        }

        g2.dispose();
    }

    @Override
    public int getIconWidth() {
        return 16;
    }

    @Override
    public int getIconHeight() {
        return 16;
    }
}
