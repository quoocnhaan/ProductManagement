
import controller.Session.SharedData;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomPaginationWithProducts extends JFrame {

    private int currentPage = 1;
    private int itemsPerPage = 10;
    private int maxVisiblePages = 3; // Only show 3 page buttons at once
    private JButton prevButton, nextButton;
    private List<Product> products; // Product list
    private JPanel productPanel;
    private JPanel paginationPanel;
    private int totalPages;

    public CustomPaginationWithProducts() {
        // Set up frame
        setTitle("Pagination with Products");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize products (for demo purposes)
        products = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            products.add(new Product("Product " + i, i * 10));
        }

        // Calculate total pages
        totalPages = (int) Math.ceil((double) products.size() / itemsPerPage);

        // Panel to display products
        productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        add(productPanel, BorderLayout.CENTER);

        // Pagination panel
        paginationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(paginationPanel, BorderLayout.SOUTH);

        // Previous button
        prevButton = createPageButton("<");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage > 1) {
                    currentPage--;
                    updatePaginationControls();
                }
            }
        });
        //paginationPanel.add(prevButton);

        // Next button
        nextButton = createPageButton(">");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPage < totalPages) {
                    currentPage++;
                    updatePaginationControls();
                }
            }
        });
        // paginationPanel.add(nextButton);

        // Initial state update
        updatePaginationControls();

        // Show frame
        setVisible(true);
    }

    // Create a custom styled button with proper border radius and text visibility
    private JButton createPageButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded corners with radius 20
                super.paintComponent(g); // Ensure text is drawn
            }
        };
        button.setPreferredSize(new Dimension(40, 40));
        button.setFont(new Font("Roboto", Font.PLAIN, 18));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);  // Disable default button background
        button.setOpaque(false);
        button.setBackground(Color.WHITE);   // Set button background color
        button.setBorder(BorderFactory.createEmptyBorder()); // Remove default border
        button.setBorderPainted(false);      // Ensure the border isn't drawn
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    // Update pagination controls and product display
    private void updatePaginationControls() {
        // Enable/disable previous and next buttons
        prevButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage < totalPages);

        // Remove all existing page buttons
        paginationPanel.removeAll();
        paginationPanel.add(prevButton);

        // Display only 3 page buttons around the current page
        int startPage = Math.max(1, currentPage - maxVisiblePages / 2);
        int endPage = Math.min(totalPages, startPage + maxVisiblePages - 1);

        // Adjust startPage if close to the end
        if (endPage - startPage + 1 < maxVisiblePages) {
            startPage = Math.max(1, endPage - maxVisiblePages + 1);
        }

        // Add the visible page buttons
        for (int i = startPage; i <= endPage; i++) {
            final int page = i;
            JButton pageButton = createPageButton(String.valueOf(i));
            if (i == currentPage) {
                pageButton.setBackground(SharedData.mainColor); // Orange color
                pageButton.setForeground(Color.WHITE);
            } else {
                pageButton.setBackground(Color.WHITE);
                pageButton.setForeground(Color.BLACK);
            }

            pageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentPage = page;
                    updatePaginationControls();
                }
            });

            paginationPanel.add(pageButton);
        }

        paginationPanel.add(nextButton);

        // Revalidate and repaint pagination panel to update the display
        paginationPanel.revalidate();
        paginationPanel.repaint();

        // Display products for the current page
        displayProductsForCurrentPage();
    }

    // Display products based on the current page
    private void displayProductsForCurrentPage() {
        productPanel.removeAll(); // Clear existing product display
        int start = (currentPage - 1) * itemsPerPage;
        int end = Math.min(start + itemsPerPage, products.size());

        for (int i = start; i < end; i++) {
            Product product = products.get(i);
            JLabel productLabel = new JLabel(product.getName() + " - Quantity: " + product.getQuantity());
            productLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            productPanel.add(productLabel);
        }

        // Repaint and revalidate to show the updated products
        productPanel.revalidate();
        productPanel.repaint();
    }

    // Product class for name and quantity
    static class Product {

        private String name;
        private int quantity;

        public Product(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomPaginationWithProducts());
    }
}
