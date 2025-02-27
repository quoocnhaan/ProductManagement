/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.Btn;

import controller.Session.SharedData;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

/**
 *
 * @author PC
 */
public class RoundedToggleButton extends JToggleButton {
    
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
            g2.setColor(new Color(50, 94, 90));  // Orange when selected
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
    
//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        // Border color (gray by default)
//        g2.setColor(new Color(243, 244, 245));
//
//        // Draw the rounded border
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
//        
//        g2.dispose();
//    }
}
