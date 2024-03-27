package org.example.week4_lists;

import java.util.List;

public class ListOf
{
    public static void main(String[] args)
    {
        // create an immutable (unchangeable) list of animals.
        List<String> animals = List.of("Cat", "Bird", "Zebra");
        System.out.println(animals);
        animals.add("Frog"); // throws error cause list.of creates immutable list. same with trying to remove an element
    }
}
