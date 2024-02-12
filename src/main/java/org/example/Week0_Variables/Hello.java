package org.example.Week0_Variables;

// Class definition. Class name is the same as the tile name.
// Comments start with //
public class Hello
{   // Curly braces define code blocks and always come in pairs
    public static void main(String[] args)
    {
        // Strings must use double quotes, not single quotes.
        // Type sout to autocomplete System.out.println();
        System.out.println("Hello programmers!");

        // Variables
        String className = "Java Programming";  // String type is upper case in Java as opposed to C#

        int classCode = 2545;   // create integer variable

        // Java can implicitly cast int to String during string concatenation
        System.out.println("This class is " + classCode + " " + className);

        // floating point number variable
        double temperature = 10.4;
        System.out.println("Today's temperature is " + temperature + "F");

        double tempInC = (temperature - 32) * 5 / 9;
        System.out.println(tempInC + "C");

        // Booleans are boolean, not bool like in C#
        boolean condition = temperature < 32;

        if (condition)
        {
            System.out.println("It's below freezing!");
        }   // No semicolon
    }   // End of main method
}   // end of class definition
