package org.example.week4_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Removing
{
    public static void main(String[] args)
    {
        List<String> classNames = new ArrayList<>();
        classNames.add("Programming logic");
        classNames.add("Web Client Server");
        classNames.add("Project Management");
        classNames.add("Info Tech Concepts");

        // just prints the whole array with each element at once
        System.out.println(classNames);

        // multiple ways to go about looping over a list
        // enhanced for loop is fast and readable. similar to foreach loop in C#
        for (String name : classNames)
        {
            System.out.println(name);
        }

        System.out.println();

        // regular for loop is useful for when you need the index of the element ur working with
        for (int i = 0; i < classNames.size(); i++)
        {
            // index
            System.out.println(classNames.get((i)));
        }

        System.out.println();

        // While loop is useful for adding/removing elements of an array
        // if the number of elements is changed within a for loop, it can result in some undesirable behavior or errors
        /*while (!classNames.isEmpty())
        {
            String name = classNames.remove(0);
            System.out.println(name);
        }*/

        System.out.println();

        // can sort alphabetically using Collections.sort method
        // im assuming that the String class implements some sort of "comparison" interface that the sort method uses
        // cause thats how it works in C#. so like any class can define how it gets sorted by implementing that interface
        // ya hovering over the sort method it says that the elements must implement the "Comparable" interface
        Collections.sort(classNames);

        System.out.println(classNames);

        // theres also a shuffle method which reorders the list randomly
        // these methods are void because lists are reference types so they can just be modified within the sort/shuffle methods
        // and we will see the results of that when we look at the list again
        Collections.shuffle(classNames);

        System.out.println(classNames);

        // can remove an element by value
        classNames.remove("Project Management");
        System.out.println(classNames);

        // or can remove by index
        // if we have a list of ints and want to remove by value, we have to pass it Integer.valueOf(int value)
        // otherwise itll just think we are trying to give it an index
        classNames.remove(1);
        System.out.println(classNames);

        // List.remove returns a boolean representing if it was succesful in removing that element
        boolean wasRemoved = classNames.remove("gfsjgbnhje");
        System.out.println(classNames + " " + wasRemoved);

        // List.set inserts the value at the given index
        classNames.set(1, "System Analysis");
        System.out.println(classNames);

        String search = "C# Programming";
        // List.contains is easy way to search for an element in a list
        if (classNames.contains(search))
        {
            System.out.println("The list contains c#");
        } else
        {
            System.out.println("The list does not contain c#");
        }

        System.out.println(classNames.size());
        classNames.clear(); // clear removes all elements in the list
        System.out.println(classNames);
        System.out.println(classNames.size()); // size - how many elements are in the list
        System.out.println(classNames.isEmpty()); // isEmpty - boolean - is the list empty?
    }

}
