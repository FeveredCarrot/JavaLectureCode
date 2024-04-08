package org.example.week8_GUI.hello_gui_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloGUI extends JFrame
{
    private JPanel mainPanel;
    private JButton clickMeButton;
    private JLabel myFirstLabel;

    HelloGUI()
    {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(640, 480));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /*
        // add an action that executes when the button is pressed
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // runs this code here when the button is clicked
                myFirstLabel.setText("Hello Gamers");
            }
        });
        */

        // intellij says that this works too
        // passing in an anonymous function as the action parameter. can do similar things in c# like (e) => (code)
        // seems like it does work and looks more readable than like creating an entire ActionListener object
        clickMeButton.addActionListener(e -> {
            // runs this code here when the button is clicked
            myFirstLabel.setText("Hello Gamers");
        });
    }
}
