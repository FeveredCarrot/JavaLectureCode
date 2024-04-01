package org.example.week7_OOP;

import java.util.Random;

// Dice is a simple object that has one method for rolling a 6 sided die
public class Dice
{
    // init the Random variable as a field so we don't create a new one every roll
    Random rnd = new Random();
    public int roll()
    {
        // get a randome number from 1-6 and return it
        return rnd.nextInt(6) + 1;
    }
}
