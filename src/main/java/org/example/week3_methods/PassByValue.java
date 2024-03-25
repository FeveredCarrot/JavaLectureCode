package org.example.week3_methods;

import java.util.Arrays;

public class PassByValue
{
    public static void main(String[] args)
    {
        // integers are a value type so the miles variable value is copied into the changeToKM method
        int miles = 6;
        changeToKM(miles);
        System.out.println(miles); // prints "6"

        // strings are objects but they are immutable so they act similarly to value types
        String units = "miles";
        changeToMetricUnits(units);
        System.out.println(units); // print "miles" cause strings are special objects

        // arrays are objects so they are passed by reference.
        // a pointer to the array location in the heap is copied into the function
        // as such, modifications to the array inside the method are reflected back here where we look at the same location in memory
        double[] speeds = {4, 5, 10, 12};
        convertToKilometers(speeds);
        System.out.println(Arrays.toString(speeds)); // prints "[6.4, 8.0, 16.0, 19.200000000000003]"
    }

    // integer parameter value is copied to a new local variable on the stack when passed to this method.
    private static void changeToKM(int distance) // this int parameter literally holds an integer number
    {
        // this change is confined to the scope of this method
        distance += 10;
    }

    // strings are objects and as such are stored as references (memory addresses) in the stack,
    // but they are immutable so the data they point to is not allowed to be modified
    // therefore the only thing we can really do is assign this variable to a different reference to a different string
    // so the "units" local variable doesnt point to the same string anymore, so this new string is only seen here in this scope
    private static void changeToMetricUnits(String units)
    {
        units = "kilometers";
    }

    // arrays are reference types and are mutable
    // so we pass in the reference to a double array that's on the heap
    // then if we change a value in the array,
    // that changed value will be seen anywhere else that has a reference to the same array
    private static void convertToKilometers(double[] speeds)
    {
        for (int i = 0; i < speeds.length; i++)
        {
            double speed = speeds[i];
            double speedKm = speed * 1.6;
            speeds[i] = speedKm;
        }
    }
}
