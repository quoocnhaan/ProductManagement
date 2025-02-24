import javax.swing.*;
import java.awt.*;

public class InventoryUI extends JFrame {

    public InventoryUI() {
        // Set up the frame
        setTitle("Inventory UI");
        setSize(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create a panel for the layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding
        
        // Create label for "Inventory"
        JLabel inventoryLabel = new JLabel("Inventory");
        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inventoryLabel.setForeground(new Color(128, 128, 128)); // Gray color
        
        // Create label for the total item count
        JLabel totalLabel = new JLabel("14 Total");
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        totalLabel.setForeground(new Color(128, 128, 128)); // Gray color
        
        // Create a panel for inventory and total count
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(inventoryLabel);
        leftPanel.add(Box.createHorizontalStrut(5)); // Space between labels
        leftPanel.add(totalLabel);
        
        // Create an icon for the button (use your own icon path)
        ImageIcon listIcon = new ImageIcon("path_to_list_icon.png"); // Replace with your icon
        
        // Create a button with an icon and text
        JButton addItemButton = new JButton("+ Add Item");
        addItemButton.setIcon(listIcon);
        addItemButton.setForeground(Color.WHITE);
        addItemButton.setBackground(new Color(66, 133, 244)); // Blue background
        addItemButton.setFocusPainted(false); // Remove focus border
        addItemButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15)); // Padding
        addItemButton.setIconTextGap(8); // Space between icon and text

        // Right-align the button
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(addItemButton);
        
        // Add both components to the main panel
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(rightPanel, BorderLayout.EAST);

        // Add the panel to the frame
        add(panel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the UI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new InventoryUI());
    }
}
