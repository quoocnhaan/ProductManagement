
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AutoCompleteComboBoxExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AutoComplete ComboBox Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Sample brand list
            List<String> brands = new ArrayList<>();
            brands.add("Apple");
            brands.add("Samsung");
            brands.add("Sony");
            brands.add("LG");
            brands.add("OnePlus");

            JComboBox<String> comboBox = new JComboBox<>(brands.toArray(new String[0]));
            comboBox.setEditable(true);

            // Add AutoCompleteDecorator to the comboBox
            AutoCompleteDecorator.decorate(comboBox);

            // Get the editor component (the text field) to monitor changes
            JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();

//            editor.addKeyListener(new KeyAdapter() {
//                @Override
//                public void keyReleased(KeyEvent e) {
//                    // Check if the key is the UP or DOWN arrow key
//                    if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
//                        // Move caret to the end of the text when a result is selected
//                        editor.setCaretPosition(editor.getText().length());
//                    }
//                }
//            });
            editor.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    checkForMatchingResult();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    checkForMatchingResult();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    checkForMatchingResult();
                }

                // Method to check if there's any matching result
                private void checkForMatchingResult() {
                    String input = editor.getText();
                    boolean matchFound = false;

                    // If the input is empty (blank), hide the popup and return early
                    if (input.isBlank()) {
                        comboBox.hidePopup();
                        return; // prevent further matching checks if the input is empty
                    }

                    // Check for matching results
                    for (int i = 0; i < comboBox.getItemCount(); i++) {
                        if (comboBox.getItemAt(i).toString().toLowerCase().startsWith(input.toLowerCase())) {
                            matchFound = true;
                            break;
                        }
                    }

                    // Show or hide the popup based on whether a match was found
                    if (matchFound) {
                        comboBox.showPopup();
                    } else {
                        comboBox.hidePopup();
                    }
                }
            });

            frame.add(comboBox, BorderLayout.CENTER);
            frame.setSize(400, 200);
            frame.setVisible(true);
        });
    }
}
