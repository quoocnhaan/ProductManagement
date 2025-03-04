/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.component.CustomComponent;

import controller.Functional.Functional;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class CustomFrame extends JFrame {

    public CustomFrame() {
        // Set the title of the frame
        initComponents();

        setTitle("Custom JFrame");

        // Set the size of the frame (width: 1250, height: 900)
        setLocationRelativeTo(null);

        // Set the default close operation to DO_NOTHING_ON_CLOSE
        // so we can manually handle what happens when closing
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Add a window listener to handle custom close behavior
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom action before closing the window
                Functional.clearDataTemp();

                // Close the window
                dispose();
            }
        });
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>   
}
