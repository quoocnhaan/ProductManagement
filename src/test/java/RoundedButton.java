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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {

    private Color currentColor = Color.decode("#4285F4"); // Default blue color
    private final Color hoverColor = Color.decode("#357AE8"); // Slightly darker blue for hover
    private final Color clickColor = Color.decode("#2C6CE2"); // Darker blue for click

    public RoundedButton(String text) {
        super(text);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setForeground(Color.WHITE); // White text
        setFont(new Font("Arial", Font.PLAIN, 14)); // Font style
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add mouse listeners for hover and click effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                currentColor = hoverColor; // Change to hover color
                repaint(); // Repaint to update the color
            }

            @Override
            public void mouseExited(MouseEvent e) {
                currentColor = Color.decode("#4285F4"); // Restore default color
                repaint(); // Repaint to update the color
            }

            @Override
            public void mousePressed(MouseEvent e) {
                currentColor = clickColor; // Change to click color
                repaint(); // Repaint to update the color
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentColor = hoverColor; // Return to hover color after click
                repaint(); // Repaint to update the color
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill button with the current background color (changes on hover/click)
        g2.setColor(currentColor);
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));

        // Set the font and paint the text
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();

        // Adjust the text position to center it vertically
        int x = (getWidth() - textWidth) / 2;
        int y = (getHeight() + textHeight) / 2 - fm.getDescent();

        g2.drawString(getText(), x, y);

        g2.dispose();
    }

    // Override to prevent the default rendering
    @Override
    public void setContentAreaFilled(boolean b) {
        // Do nothing to preserve custom painting
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Rounded Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create an instance of RoundedButton
        RoundedButton button = new RoundedButton("REFLEX");
        button.setPreferredSize(new Dimension(120, 40));

        frame.add(button);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
