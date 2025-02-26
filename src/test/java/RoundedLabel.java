/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RoundedLabel extends JLabel {

    private Color borderColor = Color.LIGHT_GRAY;  // Border color

    public RoundedLabel(String text) {
        super(text);
        setOpaque(false);  // To allow custom painting
        setBorder(new EmptyBorder(5, 10, 5, 10));  // Padding around text
        setFont(new Font("Arial", Font.PLAIN, 16));  // Custom font and size
        setForeground(new Color(100, 100, 100)); // Set text color
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Enable anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color and fill the rounded rectangle
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        // Set border color and draw the rounded rectangle border
        g2.setColor(borderColor);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);

        // Call the superclass to paint the text
        super.paintComponent(g2);

        // Dispose of the graphics object to release resources
        g2.dispose();
    }

    @Override
    public void setBorder(Border border) {
        // Prevent changing the border to preserve the custom look
    }
}
