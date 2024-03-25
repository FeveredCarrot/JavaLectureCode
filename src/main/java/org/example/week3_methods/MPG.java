package org.example.week3_methods;
import static input.InputUtils.doubleInput;
public class MPG
{
    public static void main(String[] args)
    {
        // ask user for input and store in two double variables
        double miles = doubleInput("Enter number of miles driven:");
        double gas = doubleInput("Enter gallons of gas used:");

        // calculate miles per gallon using the method we created
        double mpg = milesPerGallon(miles, gas);
        // print the final mpg to console
        System.out.println("The MPG for this journey is " + mpg + " miles per gallon.");
    }

    // method takes two doubles, calculates the mpg, and returns the mpg as a double
    public static double milesPerGallon(double miles, double gallonsOfGas)
    {
        double mpg = miles / gallonsOfGas;
        return mpg;
    }
}
