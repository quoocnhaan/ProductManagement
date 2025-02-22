/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewClass1 {

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Searchable Category Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create categories array
        String[] categories = {"Development", "Business", "IT & Software", "Personal Development", "Design", "Marketing"};

        // Create JComboBox with categories and set a fixed preferred size
        JComboBox<String> categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.setEditable(true);  // Make the combo box editable to allow text input

        // Set a fixed preferred size for the combo box (avoid resizing)
        categoryComboBox.setPreferredSize(new Dimension(300, 30));  // Set your preferred size here

        // Set a default maximum row count (to avoid a huge dropdown)
        categoryComboBox.setMaximumRowCount(5); // Set a limit on visible rows

        // Add a KeyListener to the JTextField part of the JComboBox to allow filtering
        JTextField textField = (JTextField) categoryComboBox.getEditor().getEditorComponent();
        textField.setColumns(10);  // Set the number of columns for the text field to avoid resizing
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                String filter = textField.getText().trim();

                // Clear all items
                categoryComboBox.removeAllItems();

                boolean matchFound = false;
                int matchCount = 0;

                // Add items that match the filter
                for (String category : categories) {
                    if (category.toLowerCase().contains(filter.toLowerCase())) {
                        categoryComboBox.addItem(category);
                        matchFound = true;
                        matchCount++;  // Count matches
                    }
                }

                // Adjust the dropdown height based on the number of matching results
                if (matchCount > 0) {
                    categoryComboBox.setMaximumRowCount(Math.min(matchCount, 5));  // Adjust rows dynamically, limit to 5
                    categoryComboBox.setPopupVisible(true);  // Show the dropdown
                } else {
                    categoryComboBox.setPopupVisible(false);  // Hide the dropdown when no match is found
                }

                // Set the text field back to the original text without resetting
                categoryComboBox.getEditor().setItem(filter);
            }
        });

        // Custom renderer for changing appearance and cursor
        categoryComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Set default background color and text color
                if (isSelected) {
                    label.setBackground(Color.YELLOW);  // Set background when selected
                    label.setForeground(Color.RED);     // Set text color when selected
                } else {
                    label.setBackground(Color.CYAN);    // Set default background color for unselected items
                    label.setForeground(Color.BLACK);   // Set default text color
                }

                // Change the cursor to hand when hovering
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));

                return label;
            }
        });

        // Handling key events (arrow keys and enter) for item selection
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP) {
                    // Pass the key event to JComboBox to navigate through the items
                    categoryComboBox.dispatchEvent(e);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // When the user presses enter, get the selected item
                    String selectedItem = (String) categoryComboBox.getSelectedItem();
                    if (selectedItem != null) {
                        textField.setText(selectedItem); // Set the selected item in the text field
                        categoryComboBox.setPopupVisible(false);  // Close the popup
                    }
                }
            }
        });

        // Add the combo box to a panel
        JPanel panel = new JPanel();
        panel.add(categoryComboBox);
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
