package org.example.week3_methods;
import static input.InputUtils.stringInput;

public class HelloMethods
{
    // Main method.
    public static void main(String[] args)
    {
        String name = stringInput("What's your name?");
        String greeting = makeGreeting(name);
        System.out.println(greeting);
    }

    // in a larger program it's usually better to use a more descriptive variable/parameter name
    // rather than single letter variable names
    public static String makeGreeting(String n)
    {
        String greeting = "Hello " + n + "!";
        return greeting; // return the output message
    }
}
