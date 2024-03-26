package org.example.week4;

import java.util.ArrayList;
import java.util.List;
import static input.InputUtils.*;

public class ToDoList
{
    public static void main(String[] args)
    {
        List<String> todoList = new ArrayList<>();

        // use while loop to gather user input.
        // while loop is good cause we are changing the size of the list (adding elements) and dont know how many we are adding
        while (true)
        {
            // grab user input and store it in a string
            String data = stringInput("Type a task you need to do, or Enter to quit");

            // if the user sends an empty string, we are done and can break out of the while loop
            if (data.isEmpty())
            {
                break;
            }

            // check if this task is already in the list
            if (containsIgnoreCase(todoList, data))
            {
                System.out.println("You already added that!");
            } else
            {
                // if it isnt a duplicate, add it to the list
                todoList.add(data);
            }
        }

        System.out.println("Thank you, your tasks are:");

        // print each task from the list
        for (String input: todoList)
        {
            System.out.println(input);
        }

        // print the size of the list/number of tasks
        System.out.println("You have " + todoList.size() + " tasks to do.");
    }

    // search for an item in a String list case without being case sensitive
    // this method is also used by the Guestlist class
    public static boolean containsIgnoreCase(List<String> list, String data)
    {
        // loop over each item in the list to search for a matching string
        for (String item : list)
        {
            // if this item is equal to the search string (ignoring case) then we return true
            if (item.equalsIgnoreCase(data))
            {
                return true;
            }
        }
        // return false if we didnt find a matching string
        return false;
    }
}
