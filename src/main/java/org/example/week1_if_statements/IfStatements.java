package org.example.week1_if_statements;

import input.InputUtils;

public class IfStatements
{
    public static void main(String[] args)
    {
        double temp = InputUtils.doubleInput("Enter today's temperature: ");

        // conditional inside if statement is a boolean
        //
        if (temp > 32)
        {
            System.out.println("It's above freezing");
        } else
        {
            System.out.println("It's below freezing");
        }

        if (temp == 32)
        {
            System.out.println("It's exactly 32 degrees");
        }

        if (temp != 0)
        {
            System.out.println("It's definitely not zero degrees");
        }

        if (temp <= 100)
        {
            System.out.println("It is 100 degrees or less");
        }
        else if (temp >= 100)
        {
            System.out.println("It is 100 degrees or more");
        }

        String college = InputUtils.stringInput("Which college do you attend?");

        // String equality is weird, so use .equals() or .equalsIgnoreCase() for most cases
        if (college.equalsIgnoreCase("MCTC"))
        {
            System.out.println("Wow we both go to MCTC");
        } else
        {
            System.out.println("Darn. MCTC is cooler");
        }

        String department = InputUtils.stringInput("Enter department code: ");

        // Use .length() to get the character count of a string.
        if (department.length() == 4)
        {
            System.out.println("Department code valid.");
            // Format department code to all caps
            System.out.println("Department: " + department.toUpperCase());
        } else
        {
            System.out.println("That code is invalid!");
        }
    }
}
