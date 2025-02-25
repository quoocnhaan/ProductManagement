/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class CustomCheckboxExample extends JFrame {

    public CustomCheckboxExample() {
        // Create the frame
        setTitle("Custom Checkbox Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Create a panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10));  // Vertical layout with space between components
        panel.setBackground(Color.WHITE);  // Set panel background color

        // Create custom checkboxes
        JCheckBox checkbox1 = createCustomCheckBox("#H35624367");
        JCheckBox checkbox2 = createCustomCheckBox("#H35624368");
        JCheckBox checkbox3 = createCustomCheckBox("#H35624369");

        // Add checkboxes to the panel
        panel.add(checkbox1);
        panel.add(checkbox2);
        panel.add(checkbox3);

        // Add the panel to the frame
        add(panel);

        // Make frame visible
        setVisible(true);
    }

    private JCheckBox createCustomCheckBox(String text) {
        JCheckBox checkbox = new JCheckBox(text);
        checkbox.setOpaque(false); // Make the checkbox background transparent
        checkbox.setFocusPainted(false);  // Remove the focus border

        // Set custom icons for checked and unchecked states
        checkbox.setIcon(new CustomCheckBoxIcon(false));
        checkbox.setSelectedIcon(new CustomCheckBoxIcon(true));

        // Set hand cursor when hovering over the checkbox
        checkbox.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return checkbox;
    }

    // Custom icon class for the checkbox
    class CustomCheckBoxIcon implements Icon {

        private boolean checked;

        public CustomCheckBoxIcon(boolean checked) {
            this.checked = checked;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw the border
            g2.setColor(Color.GRAY);  // Gray border color
            g2.setStroke(new BasicStroke(2));
            g2.drawRoundRect(x, y, getIconWidth() - 1, getIconHeight() - 1, 10, 10);

            // Draw background when checked
            if (checked) {
                g2.setColor(new Color(0, 128, 0));  // Green background
                g2.fillRoundRect(x + 1, y + 1, getIconWidth() - 2, getIconHeight() - 2, 10, 10);

                // Draw the smaller checkmark
                g2.setColor(Color.WHITE);  // White checkmark
                g2.setStroke(new BasicStroke(2));  // Thinner stroke for a smaller checkmark
                g2.drawLine(x + 4, y + 8, x + 7, y + 12);  // Smaller checkmark
                g2.drawLine(x + 7, y + 12, x + 12, y + 4);
            }

            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return 16;
        }

        @Override
        public int getIconHeight() {
            return 16;
        }
    }

    public static void main(String[] args) {
        // Run the custom checkbox example
        SwingUtilities.invokeLater(CustomCheckboxExample::new);
    }
}
