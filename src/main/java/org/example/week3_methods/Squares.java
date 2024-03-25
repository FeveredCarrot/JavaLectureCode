package org.example.week3_methods;
import static input.InputUtils.doubleInput;
public class Squares
{
    public static void main(String[] args)
    {
        // get user input for a number
        double number = doubleInput("Please enter a number and then ill square it");
        // run the square method and store its return value
        double squared = square(number);
        // print the resulting square number to console
        System.out.println("The square of " + number + " is " + squared);
    }

    // return a double value instead of printing the square, so the method can be reused for other purposes elsewhere
    public static double square(double number)
    {
        double squareNumber = number * number;
        return squareNumber;
    }
}
