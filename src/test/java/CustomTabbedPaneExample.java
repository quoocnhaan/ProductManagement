
import javax.swing.*;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import java.awt.*;

public class CustomTabbedPaneExample {

    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Custom JTabbedPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.white);

        // Create a JTabbedPane and set the custom UI
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setUI(new CustomTabbedPaneUI());

        // Create the first panel and add components to it
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is Panel 1"));
        tabbedPane.addTab("Tab 1", panel1);

        // Create the second panel and add components to it
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));
        tabbedPane.addTab("Tab 2", panel2);

        // Add the JTabbedPane to the main panel
        main.add(tabbedPane);

        // Add the main panel to the frame
        frame.add(main);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Custom UI for JTabbedPane
    static class CustomTabbedPaneUI extends MetalTabbedPaneUI {

        private final Color selectedColor = new Color(0, 128, 0); // Green for selected tab
        private final Color unselectedColor = Color.GRAY; // Gray for unselected tabs

        @Override
        protected void installDefaults() {
            super.installDefaults();
            tabAreaInsets.right = 0; // Remove extra space between tabs and the content panel
            tabInsets = new Insets(10, 20, 10, 20); // Adjust insets for tabs to remove extra padding
            contentBorderInsets = new Insets(0, 0, 0, 0); // Remove space around the content panel
            tabAreaInsets.left = 30;
            tabPane.setFont(new Font("Roboto", Font.BOLD, 14));
        }

        @Override
        protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            // Set background to white for all tabs
            g.setColor(Color.WHITE);
            g.fillRect(x, y, w, h);
        }

        @Override
        protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected) {
            g.setFont(font);
            g.setColor(isSelected ? selectedColor : unselectedColor);
            g.drawString(title, textRect.x, textRect.y + metrics.getAscent());
        }

        @Override
        protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex, Rectangle iconRect, Rectangle textRect, boolean isSelected) {
            // No focus indicator
        }

        @Override
        protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
            // Draw the bottom border of the tabs on top of the line
            g.setColor(isSelected ? selectedColor : new Color(230, 230, 230));

            // Draw the bottom border of the tab (above the green line)
            g.fillRect(x, y + h - 2, w, 2); // Keep the 2-pixel-thick border
        }

        @Override
        protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
            // Cast Graphics to Graphics2D for more control
            Graphics2D g2 = (Graphics2D) g.create();

            // Set the color for the line (Green color)
            g2.setColor(new Color(240, 240, 240));

            // Set the stroke thickness to 3px
            g2.setStroke(new BasicStroke(2));

            // Calculate the area of the tabs (height of the tabs)
            int tabAreaHeight = calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);

            // Keep the line in the same position
            int y = tabAreaHeight - 1;

            // Draw a horizontal line across the width of the tabbed pane
            g2.drawLine(0, y, tabPane.getWidth(), y); // Draw the line under the tabs

            // Dispose of the Graphics2D object to free resources
            g2.dispose();

            // Ensure the tab's bottom border is drawn after the line (using the correct number of arguments)
            for (int i = 0; i < tabPane.getTabCount(); i++) {
                Rectangle rect = getTabBounds(i, new Rectangle());
                paintTabBorder(g, tabPlacement, i, rect.x, rect.y, rect.width, rect.height, i == selectedIndex);
            }
        }

        @Override
        protected void installListeners() {
            super.installListeners();
            // Change cursor when hovering over tabs
            tabPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                @Override
                public void mouseMoved(java.awt.event.MouseEvent e) {
                    int tabIndex = tabForCoordinate(tabPane, e.getX(), e.getY());
                    if (tabIndex >= 0) {
                        tabPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    } else {
                        tabPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            });
        }
    }
}
