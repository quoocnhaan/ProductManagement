
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private JPopupMenu menu;
    private JTextField txtSearch;
    private List<String> searchData;

    public Main() {
        initComponents();
        searchData = initializeSearchData();
    }

    private void initComponents() {
        setTitle("Search Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        txtSearch = new JTextField(20);
        add(txtSearch, BorderLayout.NORTH);

        // Create the popup menu for search suggestions
        menu = new JPopupMenu();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));

        txtSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                showPopupMenu();
            }
        });

        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent evt) {
                if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
                    updateSearchSuggestions();
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
                    navigateSuggestions(evt);
                } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    selectSuggestion();
                }
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);  // Center on screen
    }

    // This will show the popup menu if there are suggestions available
    private void showPopupMenu() {
        if (menu.getComponentCount() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
        }
    }

    // This will filter the search data based on the current text input
    private void updateSearchSuggestions() {
        String text = txtSearch.getText().trim().toLowerCase();
        menu.removeAll();

        if (!text.isEmpty()) {
            List<String> filteredData = filterSearchData(text);
            for (String suggestion : filteredData) {
                JMenuItem item = new JMenuItem(suggestion);
                item.setFocusable(false);
                item.addActionListener(e -> {
                    txtSearch.setText(suggestion);
                    menu.setVisible(false);
                    System.out.println("Selected: " + suggestion);
                });
                menu.add(item);
            }
        }

        if (menu.getComponentCount() > 0) {
            menu.show(txtSearch, 0, txtSearch.getHeight());
        } else {
            menu.setVisible(false);
        }
    }

    // Navigate through the suggestions using arrow keys
    private void navigateSuggestions(KeyEvent evt) {
        int size = menu.getComponentCount();
        if (size > 0) {
            int index = -1;
            Component selectedComponent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
            if (selectedComponent instanceof JMenuItem) {
                index = menu.getComponentIndex(selectedComponent);
            }

            if (evt.getKeyCode() == KeyEvent.VK_DOWN && index < size - 1) {
                menu.getComponent(index + 1).requestFocus();
            } else if (evt.getKeyCode() == KeyEvent.VK_UP && index > 0) {
                menu.getComponent(index - 1).requestFocus();
            }
        }
    }

    // This will select the current suggestion
    private void selectSuggestion() {
        Component focusedComponent = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        if (focusedComponent instanceof JMenuItem) {
            JMenuItem selectedItem = (JMenuItem) focusedComponent;
            txtSearch.setText(selectedItem.getText());
            menu.setVisible(false);
        }
    }

    // Initialize search data (instead of using a database)
    private List<String> initializeSearchData() {
        List<String> data = new ArrayList<>();
        data.add("Apple");
        data.add("Banana");
        data.add("Cherry");
        data.add("Date");
        data.add("Elderberry");
        data.add("Fig");
        data.add("Grapes");
        data.add("Honeydew");
        return data;
    }

    // Filter the search data based on user input
    private List<String> filterSearchData(String text) {
        List<String> filteredData = new ArrayList<>();
        for (String item : searchData) {
            if (item.toLowerCase().contains(text)) {
                filteredData.add(item);
            }
        }
        return filteredData;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
