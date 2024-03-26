package org.example.week4;

import java.util.ArrayList;
import java.util.List;
import static input.InputUtils.*; // * <-- import everything thats in the InputUtils class

public class CountIncidences
{
    public static void main(String[] args)
    {
        // initialize a list of doubles
        // double is primitive so we need to use the Double class for array initialization
        List<Double> speeds = new ArrayList<>();
        int totalHours = 12;

        // loop from 0 to 11
        for (int hour = 0; hour < totalHours; hour++)
        {
            // store user double input
            double speed = positiveDoubleInput("Enter the internet speed for hour " + hour);
            // add the user input result to the end of the list
            speeds.add(speed);
        }

        System.out.println("All the speeds are:");


        // since we added 12 elements to the list, speeds.size() will always be 12
        // loop from 0 to 11.
        for (int hour = 0; hour < speeds.size(); hour++)
        {
            double speed = speeds.get(hour); // get the element in the list at a specific index
            System.out.printf("Hour: %d  Speed %.2f\n", hour, speed); // print the value with string formatting
        }

        // start counting zeros at zero
        int zeroCount = 0;

        // loop through each array element using enhanced for loop
        // count up any list element that is zero
        for (double speed : speeds)
        {
            // this comparison is scary. usually better to do the thing where you compare it to a small range of values
            // so if the speed is like 0.000000001 (float math can be weird) it still says "yea thats basically zero"
            // but this is okay for now cause we arent doing any fancy math to the speed
            if (speed == 0.0)
            {
                zeroCount++;
            }
        }

        // print the zero count
        System.out.println("Number of times the speed was zero (no connection): " + zeroCount);

        // remove all zeros from the list of speeds
        // trying to do this from within a
        while (speeds.contains(0.0))
        {
            speeds.remove(0.0);
        }

        System.out.println(speeds);

        double total = 0;
        // add up total speed with enhanced for loop
        for (double speed : speeds)
        {
            total += speed;
        }

        // calculate the average speed
        double average = total / speeds.size();

        System.out.println("The average speed is " + average);

    }

}
