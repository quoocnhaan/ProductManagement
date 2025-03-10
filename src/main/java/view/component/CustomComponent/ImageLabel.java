/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

/**
 *
 * @author PC
 */
import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class ImageLabel extends JLabel {

    private int radius;

    public ImageLabel(int radius) {
        this.radius = radius;
        setOpaque(false); // Make the background transparent for custom painting
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Enable anti-aliasing

        // Set background color
        g2.setColor(new Color(247, 248, 251));
        // Draw a rounded rectangle as the background
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        // Clip the image to the rounded rectangle
        g2.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        // Draw the icon image
        if (getIcon() != null) {
            ImageIcon icon = (ImageIcon) getIcon();
            Image img = icon.getImage();
            g2.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        // Paint text and other components (if any)
        super.paintComponent(g2);

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
