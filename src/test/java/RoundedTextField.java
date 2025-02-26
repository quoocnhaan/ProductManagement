
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedTextField extends JTextField {

    public RoundedTextField() {
        setOpaque(false);  // Allows custom painting
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));  // Adds padding
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
        g2.setColor(Color.BLUE);  // Change this color to any you want for the border
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20));

        g2.dispose();
    }
}
