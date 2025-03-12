package view.component.CustomComponent;

import controller.Session.SharedData;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RoundedCard extends JPanel {

    private Color borderColor = Color.LIGHT_GRAY;  // Border color
    private JLabel titleLabel;
    private JLabel contentLabel;

    public RoundedCard(String title, String content) {
        setOpaque(false);  // To allow custom painting
        setBorder(new EmptyBorder(10, 10, 10, 10));  // Padding around panel
        setPreferredSize(new Dimension(220, 70));

        // Create title label
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Roboto", Font.PLAIN, 14));  // Custom font for title
        titleLabel.setForeground(new Color(100, 100, 100)); // Set title text color
        titleLabel.setBorder(new EmptyBorder(10, 10, 0, 10));  // Padding around title

        // Create content label
        contentLabel = new JLabel("<html>" + content.replaceAll("\n", "<br>") + "</html>");
        contentLabel.setFont(new Font("Roboto", Font.BOLD, 18));  // Custom font for content
        contentLabel.setForeground(new Color(60, 60, 60)); // Set content text color
        contentLabel.setBorder(new EmptyBorder(5, 10, 10, 10));  // Padding around content

        // Use BorderLayout to place title at the top and content in the center
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(contentLabel, BorderLayout.CENTER);
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

        // Draw a green top border, adjusting it to stay inside the rounded corners
        g2.setColor(SharedData.mainColor);
        int cornerRadius = 20;  // Same radius as the rounded corners

// Set the stroke to 1.5 for the line (top border)
        g2.setStroke(new BasicStroke(5f));
        g2.drawLine(cornerRadius / 2, -1, getWidth() - cornerRadius / 2 - 1, -1);  // Adjusted to fit inside the corners

// Set the stroke to 1 for the arcs (corners)
        g2.setStroke(new BasicStroke(2f));
        g2.drawArc(0, 0, cornerRadius, cornerRadius, 90, 90);  // Top-left corner arc
        g2.drawArc(getWidth() - cornerRadius - 1, 0, cornerRadius, cornerRadius, 0, 90);  // Top-right corner arc

        // Call the superclass to paint other components
        super.paintComponent(g2);

        // Dispose of the graphics object to release resources
        g2.dispose();
    }

    @Override
    public void setBorder(Border border) {
        // Prevent changing the border to preserve the custom look
    }

    public void updateValue(int totalValue) {
        contentLabel.setText(totalValue + "");
    }

    public void updateValue(double totalValue) {
        contentLabel.setText(formatPrice(totalValue) + " VNĐ");
    }

    private String formatPrice(double priceValue) {
        if (priceValue == 0) {
            return "0";
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(priceValue);
    }
}
