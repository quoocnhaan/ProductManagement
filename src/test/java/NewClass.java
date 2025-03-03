/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class NewClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Toggle Button Group Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Create toggle buttons
        JToggleButton button1 = new JToggleButton("Button 1");
        JToggleButton button2 = new JToggleButton("Button 2");
        JToggleButton button3 = new JToggleButton("Button 3");

        // Add buttons to ButtonGroup
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);

        // Add ActionListener to each button
        ActionListener toggleListener = new ActionListener() {
            JToggleButton previouslySelected = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                JToggleButton selectedButton = (JToggleButton) e.getSource();

                if (selectedButton.isSelected()) {
                    // Perform the "selected" action
                    System.out.println(selectedButton.getText() + " is selected");

                    // Unselect previously selected button, if any
                    if (previouslySelected != null && previouslySelected != selectedButton) {
                        previouslySelected.setSelected(false);
                        System.out.println(previouslySelected.getText() + " is unselected");
                    }
                    previouslySelected = selectedButton;
                } else {
                    // Perform the "unselected" action
                    System.out.println(selectedButton.getText() + " is unselected");
                    previouslySelected = null;
                }
            }
        };

        // Attach the listener to each button
        button1.addActionListener(toggleListener);
        button2.addActionListener(toggleListener);
        button3.addActionListener(toggleListener);

        // Add buttons to the frame
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
    }
}
