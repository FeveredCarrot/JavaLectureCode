package org.example.week4_lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static input.InputUtils.*;

public class GuestList
{
    public static void main(String[] args)
    {
        //Random rnd = new Random();
        //int randomNumber = rnd.nextInt(10); // 0-9
        //int randomNumberBetween1and10 = rnd.nextInt(10) + 1;

        // initialize guest list
        List<String> guestList = new ArrayList<>();

        // add guests to guestList until user is finished
        while (true)
        {
            String name = stringInput("Enter name of guest or enter to quit:");

            // when user is done they enter an empty string so we will break out of the while loop when that happens
            if (name.isEmpty())
            {
                break;
            }

            // can access the containsIgnoreCase method from the ToDoList class directly instead of copying it to this class
            // cause it is a public static method on the ToDoList class
            // public - the method is accessible to other classes
            // static - it is run directly from the class; does not need/use an instance of the ToDoList class
            if (ToDoList.containsIgnoreCase(guestList, name))
            {
                // if the guest is already in the list we dont add the duplicate
                System.out.println("You already added " + name);
            } else
            {
                // add the guest to the guestList if it is valid
                System.out.println("Adding " + name + " to list.");
                guestList.add(name);
            }
        }

        // sort the guest list alphabetically using built in sorting method
        Collections.sort(guestList);
        // print the guest list
        printGuestNames(guestList);

        // remove guests while we want to remove guests
        while (yesNoInput("Do you want to remove any guests?"))
        {
            System.out.println("Here are all the guests");
            printGuestNames(guestList);

            // get user input of the guest number to remove
            int index = positiveIntInput("Enter the number of the guest to remove");
            // the guest list numbers start at one, so we need to subtract one to get an index that starts at 0
            index--;
            // check for out of range index. we dont need to check if the index is less than zero
            // cause we are taking positiveIntInput.
            if (index < guestList.size())
            {
                String removedGuest = guestList.remove(index);
                System.out.println("Removed guest " + removedGuest);
            }
            else
            {
                // if the index is out of range then we just try again by restarting the loop
                System.out.println("Error - please enter a valid number of a guest");
            }

        }

        System.out.println("Final guest list: ");
        printGuestNames(guestList);

        System.out.println("Final guest count: " + guestList.size());

        selectPrizeWinner(guestList);
    }

    public static void selectPrizeWinner(List<String> guestList)
    {
        // If there are no guests we account for this edge case and just return
        if (guestList.isEmpty())
        {
            System.out.println("Warning - no guests - no-one to win the prize");
            return;
        }

        Random rng = new Random();
        int randomGuestIndex = rng.nextInt(guestList.size()); // grab a random index within the range of guestList elements

        // get the guest at the randomly selected index and store it as the prize winner
        String prizeWinner = guestList.get(randomGuestIndex);

        // display the prize winner
        System.out.println("Guest number " + (randomGuestIndex + 1) + ": " + prizeWinner + " wins a prize!");
    }

    public static void printGuestNames(List<String> guests)
    {
        // print each guest and their index
        for (int i = 0; i < guests.size(); i++)
        {
            // want to display the first guest as guest #1, so we just add one to the index.
            System.out.println(i+1 + ": " + guests.get(i));
        }
    }
}
