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
        JFrame frame = new JFrame("Toggle Button Group");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create buttons
        JToggleButton allButton = new JToggleButton("All");
        JToggleButton unfulfilledButton = new JToggleButton("Unfulfilled");
        JToggleButton unpaidButton = new JToggleButton("Unpaid");
        JToggleButton paidButton = new JToggleButton("Paid");
        JToggleButton openButton = new JToggleButton("Open");
        JToggleButton closeButton = new JToggleButton("Close");

        // Create ButtonGroup to ensure only one button is selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(allButton);
        group.add(unfulfilledButton);
        group.add(unpaidButton);
        group.add(paidButton);
        group.add(openButton);
        group.add(closeButton);

        // Add buttons to frame
        frame.add(allButton);
        frame.add(unfulfilledButton);
        frame.add(unpaidButton);
        frame.add(paidButton);
        frame.add(openButton);
        frame.add(closeButton);

        frame.setSize(400, 100);
        frame.setVisible(true);
    }
}
