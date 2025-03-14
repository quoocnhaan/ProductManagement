package view.component.CustomComponent;

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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.EmptyBorder;

public class RoundedTextField extends JTextField {

    private Color borderColor = Color.LIGHT_GRAY;  // Default border color
    private Color focusedBorderColor = new Color(0, 150, 255); // Border color when focused

    public RoundedTextField() {
        setOpaque(false); // Make the text field non-opaque to allow custom painting
        setBorder(new EmptyBorder(5, 10, 5, 10)); // Add padding inside the text field

        // Add a FocusListener to change the border color when focused
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                borderColor = focusedBorderColor; // Change to focused color
                repaint(); // Repaint the text field to apply the new border color
            }

            @Override
            public void focusLost(FocusEvent e) {
                borderColor = Color.LIGHT_GRAY; // Revert to default color
                repaint(); // Repaint the text field to revert the border color
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Enable anti-aliasing for smoother corners
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the background color and paint the rounded rectangle
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20));

        // Draw the text on top of the custom background
        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Enable anti-aliasing for smoother border
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the border color and draw the rounded rectangle
        g2.setColor(borderColor);  // Change this color to any you want for the border
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20));

        g2.dispose();
    }
}
