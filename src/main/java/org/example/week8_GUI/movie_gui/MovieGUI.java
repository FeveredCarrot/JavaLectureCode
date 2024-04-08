package org.example.week8_GUI.movie_gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class MovieGUI extends JFrame
{
    private JPanel mainPanel;
    private JTextField movieTitleTextField;
    private JSlider ratingSlider;
    private JCheckBox wouldSeeAgainCheckbox;
    private JLabel sliderValueLabel;
    private JLabel movieOpinionLabel;
    private JButton quitButton;

    MovieGUI()
    {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(400, 200));
        pack();
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        configureEventHandlers();
    }

    private void configureEventHandlers()
    {
        // using lambda expressions so we dont need to pass an event parameter to the updateOpinion method
        // other option would be making it a default parameter like updateOpinion(EventObject e = null)
        // but apparently java doesnt support default parameters
        // https://stackoverflow.com/questions/997482/does-java-support-default-parameter-values 1
        // so id have to make an overload for the updateOpinion method that just calls the original method
        // but that feels more messy than just doing this

        // add action listeners to movie rating options
        ratingSlider.addChangeListener(a -> updateOpinion());

        wouldSeeAgainCheckbox.addActionListener(a -> updateOpinion());

        // quit app when clicking the quit button
        quitButton.addActionListener(a -> quitApplicationPrompt());

        // add listeners to the movie title text field
        movieTitleTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // because we used lambda expression earlier, we don't need to try to pass some sort of EventObject here
                // or cast the DocumentEvent to some other thing before passing it to updateOpinion
                // or make an overload for updateOpinion that takes no parameters
                // just call the method, boom
                updateOpinion();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // same here
                updateOpinion();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // ignore
            }
        });
    }

    // this gets called any time the user changes any of the movie rating options
    private void updateOpinion()
    {
        // get movie name from the text input field
        String movieName = movieTitleTextField.getText();

        // if movie name hasnt been entered, set the movie opinion text to a default value
        if (movieName.isEmpty())
        {
            movieOpinionLabel.setText("Movie opinion");
            return;
        }

        int rating = ratingSlider.getValue();
        boolean seeAgain = wouldSeeAgainCheckbox.isSelected();

        String template = "You rated %s %d stars. You %s see again";

        // sets seeAgainString to "would" when seeAgain is true, otherwise sets it to "would not"
        // same syntax as C#
        String seeAgainString = seeAgain ? "would" : "would not";

        String opinion = String.format(template, movieName, rating, seeAgainString);

        movieOpinionLabel.setText(opinion);
    }

    private void quitApplicationPrompt()
    {
        // show a pop-up and get the user's selection as an int
        int userSelection = JOptionPane.showConfirmDialog(MovieGUI.this,
                "Are you sure you want to quit?", "Quit",
                JOptionPane.OK_CANCEL_OPTION);

        // if the user selected ok, close the app
        if (userSelection == JOptionPane.OK_OPTION)
        {
            dispose();
        }
    }
}
