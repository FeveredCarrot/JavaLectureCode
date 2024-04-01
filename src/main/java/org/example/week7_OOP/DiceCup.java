package org.example.week7_OOP;

import java.util.ArrayList;
import java.util.List;

// basically just a collection of dice which we can roll together
public class DiceCup
{
    private List<Dice> allDice;

    // constuctor populates the list of dice with the number of dice specified in the parameter
    public DiceCup(int numberOfDice)
    {
        allDice = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++)
        {
            Dice die = new Dice();
            allDice.add(die);
        }
    }

    // rolls all of the dice and returns the total value
    public int rollAll()
    {
        int total = 0;
        for (Dice die : allDice)
        {
            total += die.roll();
        }
        return total;
    }
}
