
import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {

    public CustomPanel() {
        setLayout(new BorderLayout());

        // Top-right Clear All Button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton clearAllButton = new JButton("Clear all");
        styleButton(clearAllButton);
        topPanel.add(clearAllButton);
        add(topPanel, BorderLayout.NORTH);

        // Center Content: Host Language and Clear Button
        JPanel centerPanel = new JPanel(new BorderLayout());
        JLabel hostLanguageLabel = new JLabel("Host Language");
        hostLanguageLabel.setFont(new Font("Arial", Font.BOLD, 16));  // Customize font size

        JPanel clearButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton clearButton = new JButton("Clear");
        styleClearButton(clearButton);
        clearButtonPanel.add(clearButton);

        centerPanel.add(hostLanguageLabel, BorderLayout.NORTH);
        centerPanel.add(clearButtonPanel, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(243, 244, 245));  // Background color
        button.setForeground(Color.DARK_GRAY);  // Text color
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));  // Padding
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void styleClearButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setForeground(Color.GRAY);  // Lighter color for "Clear"
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));  // Padding
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sample Layout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CustomPanel());
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
