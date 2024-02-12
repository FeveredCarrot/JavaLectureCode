package org.example.week2_loops;

import java.util.Arrays;

public class HelloArrays
{
    public static void main(String[] args)
    {
        // use of new keyword is similar to C#
        // Specify fixed size array of 3 ints
        int[] numbers = new int[3];

        // Assign values to array
        numbers[0] = 1;
        numbers[1] = 3;
        numbers[2] = 2;

        // Can also declare like this
        int numbersTwo[] = new int[2];

        // Can assign values during initialization
        int[] numbersThree = {1, 2, 3};

        // Arrays.toString() to get a human readable format of an array
        System.out.println("Your original numbers are: " + Arrays.toString(numbers));

        System.out.println("But today we are doubling your numbers!");
        for (int i=0; i < numbers.length; i++)
        {
            numbers[i] *= 2;
            System.out.println(numbers[i]);
        }
    }
}
