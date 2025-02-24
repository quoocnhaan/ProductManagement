
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchSuggestionPanelExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Search Suggestion Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new BorderLayout());

            // Search bar (JTextField)
            JTextField searchBar = new JTextField();
            searchBar.setPreferredSize(new Dimension(300, 30));

            // Panel to show suggestions
            JPanel suggestionPanel = new JPanel();
            suggestionPanel.setLayout(new BoxLayout(suggestionPanel, BoxLayout.Y_AXIS));
            suggestionPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            suggestionPanel.setVisible(false);  // Initially hidden

            // Scroll pane to allow scrolling in the suggestion panel
            JScrollPane scrollPane = new JScrollPane(suggestionPanel);
            scrollPane.setPreferredSize(new Dimension(300, 150));
            scrollPane.setVisible(false);  // Initially hidden

            // Sample data for suggestions
            String[] suggestions = {"aa live", "aa", "aaa", "aastu", "aa internacional gặp santos fc"};

            // Add listener to the search bar to listen to text changes
            searchBar.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    updateSuggestions();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    updateSuggestions();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    updateSuggestions();
                }

                private void updateSuggestions() {
                    String text = searchBar.getText().trim();
                    suggestionPanel.removeAll();  // Clear previous suggestions

                    if (!text.isEmpty()) {
                        for (String suggestion : suggestions) {
                            if (suggestion.toLowerCase().startsWith(text.toLowerCase())) {
                                JLabel suggestionLabel = new JLabel(suggestion);
                                suggestionLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                                // Add mouse listener to capture clicks
                                suggestionLabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        searchBar.setText(suggestionLabel.getText());
                                        scrollPane.setVisible(false);  // Hide the suggestion panel after selection
                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent e) {
                                        suggestionLabel.setOpaque(true);
                                        suggestionLabel.setBackground(Color.LIGHT_GRAY);  // Highlight on hover
                                    }

                                    @Override
                                    public void mouseExited(MouseEvent e) {
                                        suggestionLabel.setOpaque(false);
                                        suggestionLabel.setBackground(null);  // Remove highlight
                                    }
                                });

                                suggestionPanel.add(suggestionLabel);
                            }
                        }

                        // If there are suggestions, show the suggestion panel
                        if (suggestionPanel.getComponentCount() > 0) {
                            scrollPane.setVisible(true);
                        } else {
                            scrollPane.setVisible(false);  // Hide if no suggestions
                        }

                        suggestionPanel.revalidate();
                        suggestionPanel.repaint();
                    } else {
                        scrollPane.setVisible(false);  // Hide if the search field is empty
                    }
                }
            });

            // Add components to the frame
            frame.add(searchBar, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
