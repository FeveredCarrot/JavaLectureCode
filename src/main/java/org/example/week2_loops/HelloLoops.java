package org.example.week2_loops;

import java.util.Random;

public class HelloLoops
{
    final static String MONTH = "January";
    final static int NUM_DAYS = 31;
    public static void main(String[] args)
    {
        System.out.println("Here is every day in " + MONTH + ", in case you wanted to know:");

        // Loop over every integer day from 1 to 31
        // For loop: for (loop counter init; loop condition; post loop)
        for (int day = 1; day <= NUM_DAYS; day++)
        {

            // Numbers ending in 1, 2, or 3 end in st, nd, and rd respectively
            // Except for 11 12 and 13 because the english language is weird.
            // I'm probably forgetting some other exception to this rule but it looks good enough rn
            // Using String.valueOf to cast int to String
            // Using String.endsWith to get the ending digit
            if (String.valueOf(day).endsWith("1") && day != 11)
            {
                System.out.printf("%s %dst\n", MONTH, day);
            }
            else if (String.valueOf(day).endsWith("2") && day != 12)
            {
                System.out.printf("%s %dnd\n", MONTH, day);
            }
            else if (String.valueOf(day).endsWith("3") && day != 13)
            {
                System.out.printf("%s %drd\n", MONTH, day);
            } else
            {
                System.out.printf("%s %dth\n", MONTH, day);
            }

        }


    }
}
