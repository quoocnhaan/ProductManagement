import javax.swing.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.awt.*;

public class AutoCompleteExample extends JFrame {
    private JComboBox<String> comboBox;

    public AutoCompleteExample() {
        // Data for dropdown
        String[] items = {"Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes", "Strawberry", 
                          "Watermelon", "Kiwi", "Lemon", "Peach"};

        // Initialize ComboBox
        comboBox = new JComboBox<>(items);

        // Set the number of visible rows before scrolling
        comboBox.setMaximumRowCount(7);

        // Make the JComboBox editable to allow typing new items
        comboBox.setEditable(true);

        // Add autocomplete functionality to the ComboBox
        AutoCompleteDecorator.decorate(comboBox);

        // Set layout
        setLayout(new BorderLayout());
        add(comboBox, BorderLayout.NORTH);

        // JFrame settings
        setTitle("AutoComplete JComboBox Example with Scroll");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Run the application
        SwingUtilities.invokeLater(() -> {
            new AutoCompleteExample().setVisible(true);
        });
    }
}
