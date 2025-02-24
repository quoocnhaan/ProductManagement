/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filter;

/**
 *
 * @author PC
 */
import controller.Session.SharedData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import org.jdesktop.swingx.WrapLayout;

public class LanguageSelection extends JFrame {

    private JPanel buttonPanel;
    private JButton clearButton;

    public LanguageSelection() {
        setTitle("Host Language Selection");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel to hold the buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 10, 10));

        // Languages array
        String[] languages = {
            "English", "German", "Polish", "Italian", "French", "Spanish",
            "Sign", "Russian", "Portuguese", "Swedish", "Norwegian", "Hungarian",
            "Finnish", "Danish", "Czech", "Ukrainian", "Dutch", "Korean",
            "Turkish", "Hebrew", "thang lon thanh thai"
        };

        // Create buttons with custom style
        for (String language : languages) {
            RoundedToggleButton button = new RoundedToggleButton(language);

            buttonPanel.add(button);
        }
        buttonPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(buttonPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();

        verticalScrollBar.setUI(new CustomScrollBarUI());

        // Set scroll bar width to something smaller
        verticalScrollBar.setPreferredSize(new Dimension(8, Integer.MAX_VALUE));

        // Create clear button
        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all button selections
                Component[] components = buttonPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JToggleButton) {
                        JToggleButton toggleButton = (JToggleButton) component;
                        toggleButton.setSelected(false);
                        toggleButton.setBackground(Color.LIGHT_GRAY); // Reset color
                    }
                }
            }
        });

        // Layout setup
        setLayout(new BorderLayout());
        add(new JLabel("Host Language", JLabel.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(clearButton, BorderLayout.SOUTH);
    }

    public class CustomScrollBarUI extends BasicScrollBarUI {

        @Override
        protected void configureScrollBarColors() {
            // Set the track color (background)
            this.trackColor = new Color(255, 255, 255);  // Dark color for track

            // Set the thumb color (the scroll bar handle)
            this.thumbColor = new Color(187, 187, 187);  // Gray for thumb
            this.thumbDarkShadowColor = this.thumbColor;
            this.thumbHighlightColor = this.thumbColor;
            this.thumbLightShadowColor = this.thumbColor;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();  // Remove the decrease (up) button
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();  // Remove the increase (down) button
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;  // Invisible button with zero size
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Paint the thumb with rounded corners
            g2.setColor(thumbColor);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
            g2.dispose();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            // Paint the track (background) with the color we set in configureScrollBarColors
            g.setColor(trackColor);
            g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
        }
    }

    // Custom rounded toggle button class
    class RoundedToggleButton extends JToggleButton {

        public RoundedToggleButton(String text) {
            super(text);
            setContentAreaFilled(false);  // Remove default background painting
            setFocusPainted(false);  // Remove focus border
            setBackground(new Color(243, 244, 245));  // Default color
            setOpaque(false);  // Make sure we paint everything ourselves
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Add padding to the text
            setFont(new Font(SharedData.fontName, Font.PLAIN, 14));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            adjustButtonSize();  // Adjust size based on text
        }

        private void adjustButtonSize() {
            FontMetrics fontMetrics = getFontMetrics(getFont());
            int textWidth = fontMetrics.stringWidth(getText());
            int buttonWidth = textWidth > 40 ? textWidth : 40;  // Adding padding to button width (40px extra)
            setPreferredSize(new Dimension(buttonWidth + 30, 30));

        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Change color based on the selection state
            if (isSelected()) {
                g2.setColor(Color.ORANGE);  // Orange when selected
                setForeground(Color.WHITE);
            } else {
                g2.setColor(new Color(243, 244, 245));  // Default background
                setForeground(Color.BLACK);

            }

            // Paint the rounded button with radius 20
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

            // Draw the text after background to avoid text being painted over
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Border color (gray by default)
            g2.setColor(new Color(243, 244, 245));

            // Draw the rounded border
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);

            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LanguageSelection().setVisible(true);
            }
        });
    }
}
