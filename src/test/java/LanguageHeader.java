
import javax.swing.*;
import java.awt.*;

public class LanguageHeader extends JFrame {

    public LanguageHeader() {
        setTitle("Language Header Example");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Label for "Host Language"
        JLabel hostLabel = new JLabel("Host Language");
        hostLabel.setFont(new Font("SansSerif", Font.BOLD, 18));  // Set custom font for bold style

        // Clear button with underline using HTML
        JButton clearButton = new JButton("<html><u>Clear</u></html>");
        clearButton.setForeground(Color.GRAY); // Set text color to gray
        clearButton.setBorderPainted(false);  // Remove any painted border
        clearButton.setFocusPainted(false); // Disable focus painted border
        clearButton.setContentAreaFilled(false); // Remove button background
        clearButton.setOpaque(false); // Make button transparent
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Set hand cursor on hover

        // Add components to the main panel
        mainPanel.add(hostLabel, BorderLayout.WEST);  // Align "Host Language" to the left
        mainPanel.add(clearButton, BorderLayout.EAST);  // Align "Clear" button to the right

        // Add padding to the main panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the main panel to the frame
        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LanguageHeader::new);
    }
}
