/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;

public class RoundedLabel extends JLabel {

    private int radius;

    public RoundedLabel(int radius) {
        this.radius = radius;
        setOpaque(false); // Make the background transparent for custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enable anti-aliasing

        // Set background color
        g2.setColor(getBackground());
        // Draw a rounded rectangle as the background
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Paint the text and other components
        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set border color (if any)
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

        g2.dispose();
    }
}
