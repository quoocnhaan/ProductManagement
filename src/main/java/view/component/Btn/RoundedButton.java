package view.component.Btn;

import controller.Functional.Functional;
import controller.Session.SharedData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private Color pressedColor = new Color(200, 200, 200);
    private Color defaultColor;
    public boolean isConfirmButton;

    public RoundedButton(String text, boolean isConfirmButton) {
        super(text);
        this.isConfirmButton = isConfirmButton;

        if (isConfirmButton) {
            defaultColor = SharedData.mainColor;  // Restore default color when mouse exits
            setForeground(Color.WHITE);
        } else {
            defaultColor = SharedData.btnDefaultColor;
            setForeground(Color.BLACK);
        }

        setBackground(defaultColor);
        setContentAreaFilled(false);  // Remove default background painting
        setFocusPainted(false);       // Remove focus border
        setOpaque(false);             // Make sure we paint everything ourselves
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Add padding to the text
        setFont(new Font("Arial", Font.PLAIN, 14));  // Set the font (using Arial as an example)
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adjustButtonSize();  // Adjust size based on text

        // Add MouseListener for hover and click effects
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(Functional.adjustColorBrightness(defaultColor, 0.8f));  // Change color when pressed
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(defaultColor);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(Functional.adjustColorBrightness(defaultColor, 1.05f));   // Change color on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultColor);  // Restore default color when mouse exits

            }
        });
    }

    private void adjustButtonSize() {
        FontMetrics fontMetrics = getFontMetrics(getFont());
        int textWidth = fontMetrics.stringWidth(getText());
        int buttonWidth = textWidth > 40 ? textWidth : 40;  // Adding padding to button width (40px extra)
        setPreferredSize(new Dimension(buttonWidth + 40, 40));
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // Use the current background color
//        g2.setColor(getBackground());
//
//        // Paint the rounded button with radius 20
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
//
//        // Draw the text after background to avoid text being painted over
//        super.paintComponent(g2);
//        g2.dispose();
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // Border color (gray by default)
//        g2.setColor(Color.white);
//
//        // Draw the rounded border
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//
//        g2.dispose();
//    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // Set the button to be fully transparent
//        g2.setComposite(AlphaComposite.Clear);
//        g2.fillRect(0, 0, getWidth(), getHeight());
//        g2.setComposite(AlphaComposite.SrcOver); // Reset composite to draw over it
//
//        // Use the current background color
//        g2.setColor(getBackground());
//
//        // Paint the rounded button
//        g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 30, 30);  // Leave a 1-pixel gap on all sides
//
//        // Draw the text
//        super.paintComponent(g);
//
//        g2.dispose();
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // Set the border color
//        g2.setColor(Color.WHITE);
//
//        // Draw the rounded border
//        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 30, 30);  // Leave a 1-pixel gap on all sides
//
//        g2.dispose();
//    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Clear the button area to ensure transparency
        g2.setComposite(AlphaComposite.Clear);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);  // Reset composite to paint over

        // Set the button background color
        g2.setColor(getBackground());

        // Fill rounded rectangle, slightly shifted
        g2.fillRoundRect(1, 0, getWidth() - 2, getHeight() - 1, 30, 30);

        // Draw the text after the background
        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the border color (white in this case)
        g2.setColor(Color.WHITE);

        // Draw the border with a slight shift to avoid overlap in the top-left corner
        g2.drawRoundRect(1, 0, getWidth() - 2, getHeight() - 1, 30, 30);

        g2.dispose();
    }

}
