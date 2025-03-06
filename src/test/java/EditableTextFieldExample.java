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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditableTextFieldExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Editable JTextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Create the JTextField
        JTextField textField = new JTextField("Right-to-left text");
        textField.setEditable(false); // Make it non-editable
        textField.setColumns(20);
        textField.setEnabled(false); // Initially disabled to behave like a JLabel
        textField.setBorder(BorderFactory.createEmptyBorder()); // No border initially
        textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Set right-to-left text orientation
        textField.setDisabledTextColor(Color.BLACK); // Ensure the text is visible when disabled

        // Create the Edit button
        JButton editButton = new JButton("Edit");

        // Create the OK button
        JButton okButton = new JButton("OK");

        // Action listener for the Edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setEnabled(true); // Enable the text field
                textField.setEditable(true); // Make it editable
                textField.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add border
                textField.requestFocus(); // Focus the text field for editing
            }
        });

        // Action listener for the OK button
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setEditable(false); // Make it non-editable
                textField.setEnabled(false); // Disable it to remove text selection
                textField.setBorder(BorderFactory.createEmptyBorder()); // Remove border
            }
        });

        // Add components to the frame
        frame.add(textField);
        frame.add(editButton);
        frame.add(okButton);

        frame.setVisible(true);
    }
}
