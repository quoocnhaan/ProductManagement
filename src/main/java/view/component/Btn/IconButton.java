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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class IconButton extends JButton {

    private Color hoverBackgroundColor;
    private Color normalBackgroundColor;
    private Color normalTextColor;
    private Color hoverTextColor;
    private Color borderColor;
    private boolean hasBorder;

    public IconButton(String text, ImageIcon icon, boolean hasBorder) {
        setText(text);
        this.hasBorder = hasBorder;

        // Set default properties
        setFocusPainted(false); // Remove focus border
        setContentAreaFilled(false); // Remove default background
        setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set hand cursor
        setFont(new Font("Roboto", Font.BOLD, 14)); // Custom font
        setIcon(icon);

        // Set normal and hover colors
        borderColor = hasBorder ? new Color(239, 239, 239) : Color.WHITE;

        normalBackgroundColor = Color.WHITE;
        hoverBackgroundColor = new Color(247, 249, 250);
        normalTextColor = hasBorder ? new Color(72, 71, 80) : new Color(81, 84, 174);
        hoverTextColor = new Color(247, 248, 252);

        setForeground(normalTextColor); // Text color
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 12)); // Adjusted padding
        setBackground(normalBackgroundColor);

        // Add hover effect listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (hasBorder) {
                    setBackground(new Color(250, 250, 250)); // Change background to yellow if hasBorder
                } else {
                    setBackground(hoverBackgroundColor); // Change background to hover color
                    borderColor = hoverBackgroundColor; // Also change border color to hover color
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalBackgroundColor); // Reset to normal background
                borderColor = hasBorder ? new Color(239, 239, 239) : Color.WHITE; // Reset border color
            }
        });

        addPropertyChangeListener("enabled", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                boolean isEnabled = (boolean) evt.getNewValue();
                if (isEnabled) {
                    setForeground(normalTextColor);
                } else {
                    setForeground(new Color(143, 143, 143));
                }
            }
        });

        setHorizontalTextPosition(SwingConstants.RIGHT);  // Align text on the right of icon
        setIconTextGap(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Rounded background

        // Draw the border only if hasBorder is true
        if (hasBorder) {
            g2.setColor(borderColor); // Set border color
            g2.setStroke(new BasicStroke(2f)); // Set border thickness
            g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 15, 15); // Draw the border
        }

        // Paint the text/icon after background and border
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        repaint();
    }
}
