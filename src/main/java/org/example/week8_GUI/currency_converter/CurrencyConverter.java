package org.example.week8_GUI.currency_converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.function.Consumer;

public class CurrencyConverter extends JFrame // extends JFrame cause this is a window
{
    private JTextField dollarsTextField;
    private JButton convertButton;
    private JLabel euroResultLabel;
    private JPanel mainPanel;
    // <String> - Specify that the comboBox contains Strings
    private JComboBox<String> currencyComboBox;
    private final String EUROS = "Euros";
    private final String POUNDS = "Pounds";
    private final Map<String, Double> exchangeRates = Map.of(EUROS, 0.84, POUNDS, 0.75);
    CurrencyConverter()
    {
        // boilerplate stuff
        setContentPane(mainPanel);
        // set window size in pixels
        setPreferredSize(new Dimension(640, 480));
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // set the convert button to default selection, so pressing enter will click the convert button
        getRootPane().setDefaultButton(convertButton);

        // set the comboBox to have "Euros" and "Pounds" as options
        currencyComboBox.addItem(EUROS);
        currencyComboBox.addItem(POUNDS);

        // intellij says you can pass in a method instead of an anonymous interface thing here
        // just passing the OnConvertButtonClicked() method itself as a parameter doesn't work,
        // so I pass in an anonymous function that just calls the OnConvertButtonClicked() method
        // like this: convertButton.addActionListener(x -> OnConvertButtonClicked());
        // there has to be a better way than this lol
        // like in c# you can just do something like button.onClicked += OnConvertButtonClicked;
        // ok I found that you can get a reference to a method with "::"
        // https://www.geeksforgeeks.org/double-colon-operator-in-java/
        // "The only difference it has from lambda expressions is that this uses
        // direct reference to the method by name instead of providing a delegate to the method."
        // pretty epic.
        convertButton.addActionListener(this::OnConvertButtonClicked);
    }

    // AddActionListener expects a method with one ActionEvent as a parameter, but we don't actually use it
    // if we used a lambda expression above we wouldn't need the unused parameter, but I like the :: solution better
    private void OnConvertButtonClicked(ActionEvent ae)
    {
        // what was typed in the dollarsTextField
        String dollarString = dollarsTextField.getText();
        try
        {
            // convert to number
            double dollars = Double.parseDouble(dollarString);

            // Use the comboBox to get the currency we are converting to
            // getSelectedItem returns an Object, so we must cast it to String
            String currencyName = (String)currencyComboBox.getSelectedItem();
            // can pass the currency name as the key to a hashmap containing the corresponding exchange rate
            double exchangeRate = exchangeRates.get(currencyName);

            // convert to euros/pounds
            double otherCurrencyAmount = dollars * exchangeRate;

            // display result in euroResultLabel
            String resultString = String.format("%.2f Dollars is equivalent to %.2f %s.",
                                                dollars, otherCurrencyAmount, currencyName);
            euroResultLabel.setText(resultString);

        } catch (NumberFormatException e)
        {
            // if the user enters an invalid number of dollars, show a pop-up error message
            JOptionPane.showMessageDialog(CurrencyConverter.this, "Please enter a valid number.");
        }
    }
}
