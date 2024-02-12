package org.example.week2_loops;

import java.util.Random;

public class RandomNumber
{
    public static void main(String[] args)
    {
        // Create RNG object
        Random random = new Random();

        // Instead of specifying a start and end range, you specify an origin and bounds, very weird
        // or if passing a single int parameter it goes from zero to int-1
        int randomNumber = 0;
        int numTries = 0;

        // In theory this has an infinitely small chance to just never exit the while loop
        while (randomNumber != 9)
        {
            randomNumber = random.nextInt(10);
            numTries++;
            System.out.println("Random number is " + (randomNumber + 1));
        }

        System.out.println("It took " + numTries + " tries to get 10");
    }
}
