package org.example.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddingList
{
    public static void main(String[] args)
    {
        // create a new arrayList
        // lists of primitives must use the classes that wrap the primitive e.g. Integer for ints
        List<Integer> classCodes = new ArrayList<>();

        // add three integers to the array
        classCodes.add(2545);
        classCodes.add(1150);
        classCodes.add(1250);

        System.out.println(classCodes); // prints the whole list
        System.out.println(classCodes.size()); // prints 3

        System.out.println(Collections.min(classCodes)); // prints 1150
        System.out.println(Collections.max(classCodes)); // prints 2545

        // loop over every integer in the list
        for (int classCode : classCodes)
        {
            // print this item in the list
            System.out.println("ITECH " + classCode);
        }
    }
}
