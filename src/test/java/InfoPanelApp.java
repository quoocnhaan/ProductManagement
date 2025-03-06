
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanelApp {

    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private int panelCount = 0;
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 300;

    public InfoPanelApp() {
        JFrame frame = new JFrame("Info Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 900);

        // Main panel that will contain info panels
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout()); // Allows dynamic growing of panels
        mainPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); // Initial size

        // ScrollPane to wrap the mainPanel
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setPreferredSize(new Dimension(800, 600));  // Scroll pane initial size
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add button
        JButton addButton = new JButton("Add Info Panel");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInfoPanel();
            }
        });

        // Layout the frame
        frame.setLayout(new FlowLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(addButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void addInfoPanel() {
        // Create info panel with customer details
        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        infoPanel.setLayout(new GridLayout(2, 1)); // Layout for name and phone

        JLabel nameLabel = new JLabel("Customer Name: ");
        JLabel phoneLabel = new JLabel("Phone Number: ");

        infoPanel.add(nameLabel);
        infoPanel.add(phoneLabel);

        // Add the info panel to the main panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = panelCount;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(infoPanel, gbc);

        // Increment the panel count
        panelCount++;

        // Adjust the preferred size of mainPanel dynamically based on the number of panels
        int newHeight = panelCount * PANEL_HEIGHT;
        mainPanel.setPreferredSize(new Dimension(PANEL_WIDTH, newHeight));

        mainPanel.revalidate(); // Adjust main panel size dynamically
        mainPanel.repaint();    // Repaint the panel to reflect the size change
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InfoPanelApp::new);
    }
}
