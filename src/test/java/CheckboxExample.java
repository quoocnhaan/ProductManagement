
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxExample {

    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Checkbox Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new checkbox
        JCheckBox checkBox = new JCheckBox("Click me");

        // Add ItemListener to handle both click and setSelected cases
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (checkBox.isFocusOwner()) {
                        // Triggered by manual click
                        System.out.println("hello");
                    } else {
                        // Triggered by setSelected
                        System.out.println("hiii");
                    }
                }
            }
        });

        // Add checkbox to the frame
        frame.add(checkBox);

        // Set the frame's visibility
        frame.setVisible(true);

        // Simulate setSelected() action
        checkBox.setSelected(true);  // This will print "hiii"
    }
}
