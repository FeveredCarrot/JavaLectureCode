package org.example.week4_lists;

import java.util.ArrayList;
import java.util.List;

public class Lists
{
    public static void main(String[] args)
    {
        // arrayList is most basic. internally its just an array. elements are stored next to each other in memory.
        // but this makes altering the array awkward cause elements often need to be copied and moved around in memory
        // vectors are similar to arrayLists but are thread safe
        // can also make a linkedList which each element need not be next to each other in memory
        // each element holds a reference to the next and previous element.
        // linked lists can be more or less performant depending on the situation
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Clara");
        arrayList.add("MCTC");

        // loop over the arrayList with enhanced for loop and print info about each element
        for (String s : arrayList)
        {
            System.out.println(s);
            System.out.println(s.toUpperCase());
            System.out.println(s.length());
        }
    }
}
