package org.example.week3_methods;
import static input.InputUtils.intInput;
public class Credits
{
    public static void main(String[] args)
    {
        // get required and earned credits from user input and store in int variables
        int required = intInput("How many credits does your program require?");
        int earned = intInput("How many credits have you earned?");

        // use the method we created to calculate credits to graduate
        int needed = howManyCreditsToGraduate(required, earned);

        // print the result to console
        System.out.println("You need " + needed + " credits");
    }

    // method takes two int parameters as input and returns an int of the credits needed to graduate
    public static int howManyCreditsToGraduate(int creditsNeeded, int creditsEarned)
    {
        int creditsToGraduate = creditsNeeded - creditsEarned;
        return creditsToGraduate;
    }
}
