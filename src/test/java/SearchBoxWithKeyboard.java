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

public class SearchBoxWithKeyboard extends JFrame {
    private JTextField searchField;
    private JPopupMenu popupMenu;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;
    private int selectedIndex = -1; // Track currently selected index

    public SearchBoxWithKeyboard() {
        setTitle("Search Box with Keyboard Navigation");
        setLayout(new FlowLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        searchField = new JTextField(20);
        popupMenu = new JPopupMenu();
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        popupMenu.add(new JScrollPane(resultList));

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Handle arrow keys
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    selectedIndex = (selectedIndex + 1) % resultList.getModel().getSize();
                    resultList.setSelectedIndex(selectedIndex);
                    resultList.ensureIndexIsVisible(selectedIndex);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    selectedIndex = (selectedIndex - 1 + resultList.getModel().getSize()) % resultList.getModel().getSize();
                    resultList.setSelectedIndex(selectedIndex);
                    resultList.ensureIndexIsVisible(selectedIndex);
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (selectedIndex != -1) {
                        searchField.setText(resultList.getSelectedValue());
                        popupMenu.setVisible(false); // Hide the popup after selection
                    }
                } else {
                    // Regular search logic, update matching results
                    String searchText = searchField.getText().trim();
                    updatePopup(searchText);
                }
            }
        });

        add(searchField);
        setVisible(true);
    }

    private void updatePopup(String query) {
        listModel.clear();
        if (query.isEmpty()) {
            popupMenu.setVisible(false);
            return;
        }

        // Sample data, replace with actual search results
        String[] sampleResults = {"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape"};
        for (String result : sampleResults) {
            if (result.toLowerCase().contains(query.toLowerCase())) {
                listModel.addElement(result);
            }
        }

        if (!listModel.isEmpty()) {
            resultList.setSelectedIndex(0); // Default select the first result
            selectedIndex = 0;
            popupMenu.show(searchField, 0, searchField.getHeight());
        } else {
            popupMenu.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SearchBoxWithKeyboard::new);
    }
}
