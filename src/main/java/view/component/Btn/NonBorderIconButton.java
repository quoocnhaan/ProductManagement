/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.Btn;

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NonBorderIconButton extends JButton {

    private Color hoverBackgroundColor;
    private Color normalBackgroundColor;
    private Color normalTextColor;
    private Color hoverTextColor;
    private Color borderColor;

    public NonBorderIconButton(String text, ImageIcon icon) {
        super(text);

        // Set default properties
        setFocusPainted(false); // Remove focus border
        setContentAreaFilled(false); // Remove default background
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set hand cursor
        setFont(new Font("Roboto", Font.BOLD, 14)); // Custom font
        setIcon(icon);

        // Set normal and hover colors
        normalBackgroundColor = Color.WHITE; // Light background color
        hoverBackgroundColor = new Color(247, 249, 250);  // Slightly darker on hover
        normalTextColor = new Color(81, 84, 174); // Blue text
        hoverTextColor = new Color(247, 248, 252); // Same blue on hover (optional)
        borderColor = Color.WHITE;  // Light gray border color

        setForeground(normalTextColor); // Text color
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 12)); // Adjusted padding (40px on the left)
        setBackground(normalBackgroundColor);

        // Add hover effect listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackgroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalBackgroundColor);
            }
        });

        setHorizontalTextPosition(SwingConstants.RIGHT);  // Align text on the right of icon
        setIconTextGap(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the rounded background
        g2.setColor(getBackground() != null ? getBackground() : normalBackgroundColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Rounded corners (radius 15)

        // Draw the border
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15); // Border around the button

        // Paint the text/icon after background and border
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        // to-do: change the border color
        if (bg.equals(hoverBackgroundColor)) {
            borderColor = hoverBackgroundColor;  // Example: Change to a light blue when hovered
        } else {
            borderColor = Color.WHITE;  // Default border color when not hovered
        }
        repaint();
    }

}
