
import controller.Session.SharedData;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class RoundedPanel extends JPanel {

    private Color borderColor = Color.LIGHT_GRAY;  // Border color
    private JLabel titleLabel;
    private JLabel contentLabel;

    public RoundedPanel(String title, String content) {
        setOpaque(false);  // To allow custom painting
        setBorder(new EmptyBorder(10, 10, 10, 10));  // Padding around panel

        // Create title label
        titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Roboto", Font.BOLD, 18));  // Custom font for title
        titleLabel.setForeground(new Color(60, 60, 60)); // Set title text color
        titleLabel.setBorder(new EmptyBorder(5, 5, 10, 5));  // Padding around title

        // Create content label
        contentLabel = new JLabel("<html>" + content.replaceAll("\n", "<br>") + "</html>");
        contentLabel.setFont(new Font("Roboto", Font.PLAIN, 14));  // Custom font for content
        contentLabel.setForeground(new Color(100, 100, 100)); // Set content text color
        contentLabel.setBorder(new EmptyBorder(10, 10, 10, 10));  // Padding around content

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

    public static void main(String[] args) {
        // Test the RoundedPanel with multiple panels
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Use GridLayout to arrange 3 panels in a 1x3 grid
        frame.setLayout(new GridLayout(1, 3, 10, 10));  // 1 row, 3 columns, 10px gaps

        // Create three RoundedPanel instances with different content
        RoundedPanel panel1 = new RoundedPanel("Panel 1", "This is the content of panel 1.");
        RoundedPanel panel2 = new RoundedPanel("Panel 2", "This is the content of panel 2.\nIt has multiple lines of text.");
        RoundedPanel panel3 = new RoundedPanel("Panel 3", "This is the content of panel 3.\nIt also has some longer text to display.");

        // Add the panels to the frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);

        // Make the frame visible
        frame.setVisible(true);
    }

}
