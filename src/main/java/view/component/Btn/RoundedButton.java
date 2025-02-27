package view.component.Btn;

import controller.Functional.Functional;
import controller.Session.SharedData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private Color bg;
    private Color fg;
    private boolean isConfirm;

    public RoundedButton(String text, boolean isConfirm) {
        super(text);
        this.isConfirm = isConfirm;
        bg = isConfirm ? SharedData.mainColor : new Color(243, 244, 245);
        fg = isConfirm ? Color.white : Color.black;
        setContentAreaFilled(false);  // Remove default background painting
        setForeground(fg);
        setFocusPainted(false);  // Remove focus border
        setBackground(bg);  // Default background color
        setOpaque(false);  // Make sure we paint everything ourselves
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Add padding to the text
        setFont(new Font("Roboto", Font.PLAIN, 14));  // Set custom font
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  // Set hand cursor for hover
        adjustButtonSize();  // Adjust size based on the text

        // Add hover effect listener
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                if (isConfirm) {
                    setBackground(Functional.adjustColorBrightness(bg, 1.2f));  // Hover color
                    setForeground(Color.WHITE);
                } else {
                    setBackground(Functional.adjustColorBrightness(bg, 1.02f));  // Hover color
                    setForeground(Color.BLACK);
                }

                // Change text color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(bg);  // Hover color
                if (isConfirm) {
                    setForeground(Color.WHITE);
                } else {
                    setForeground(Color.black);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Functional.adjustColorBrightness(bg, 0.7f));  // Hover color
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(bg);  // Hover color
            }
        });
    }

    // Adjust the button size based on text width
    private void adjustButtonSize() {
        FontMetrics fontMetrics = getFontMetrics(getFont());
        int textWidth = fontMetrics.stringWidth(getText());
        int buttonWidth = textWidth > 40 ? textWidth : 40;  // Adding padding to button width
        setPreferredSize(new Dimension(buttonWidth + 30, 30));  // Adjust size
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set background color based on the button state (hover, press)
        g2.setColor(getBackground());

        // Paint the rounded button with a radius of 30
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Call the parent method to paint text and other components
        super.paintComponent(g2);
        g2.dispose();
    }
}
