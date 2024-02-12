package org.example.week2_loops;

import input.InputUtils;

public class WhileLoops
{
    public static void main(String[] args)
    {
        boolean moreCalculations = true;

        double number = 0;
        while (moreCalculations)
        {
            number += InputUtils.doubleInput("Add how much more number?");

            System.out.printf("Your number is now %.2f\n", number);

            if (number == 0.0)
            {
                System.out.println("You fool! You formed the forbidden number!");
                break;
                // break exits the while loop altogether
                // continue just skips to the next loop iteration
            }

            moreCalculations = InputUtils.yesNoInput("Do you dare continue adding more?");
        }

        if (number != 0.0)
        {
            System.out.println("Good call. You are lucky to have made it out alive with that much.");
        }
    }
}
