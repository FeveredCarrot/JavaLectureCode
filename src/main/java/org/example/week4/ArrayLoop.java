package org.example.week4;

public class ArrayLoop
{
    public static void main(String[] args)
    {
        // declare array of strings. the size cannot change but we can modify the array elements
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};

        // loop over every element in the array
        for (String day : days)
        {
            // print this array element
            System.out.println(day);
        }
    }
}
