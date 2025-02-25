/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author PC
 */
public class CustomScrollBarUI extends BasicScrollBarUI {

    private boolean isHovered = false;
    private boolean isClicked = false;

    // Method to update hover state
    public void setHovered(boolean isHovered) {
        this.isHovered = isHovered;
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    @Override
    protected void configureScrollBarColors() {
        // Set the track color (background)
        this.trackColor = new Color(255, 255, 255);  // White for track

        // Set the default thumb color (non-hover)
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

        // Change thumb color based on hover state
        if (isClicked) {
            g2.setColor(new Color(50, 50, 50));  // Darker color when clicked
        } else if (isHovered) {
            g2.setColor(new Color(100, 100, 100));  // Slightly darker color when hovered
        } else {
            g2.setColor(thumbColor);  // Default thumb color
        }

        // Paint the thumb with rounded corners
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
