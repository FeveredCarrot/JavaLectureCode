package org.example.week7_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static input.InputUtils.*;

// the main class for the tire comparison program
public class TireComparisons
{
    public static void main(String[] args)
    {
        /*
        Tire example = new Tire("Bridgestone", 40, 10000);
        System.out.println("$" + example.pricePerThousandMiles());
        System.out.println(example);
        System.out.println(example.costForSet());
        */

        // create new list of Tires
        List<Tire> tireList = new ArrayList<Tire>();

        // Have the user add a number of tires to the list
        do
        {
            // user creates a new tire object
            Tire tire = getTireInfo();
            // add it to the tire list
            tireList.add(tire);
        } while (yesNoInput("More tires to add to compare?")); // repeat until the user is satisfied

        // sort the tires by cost. this works because the Tire class implements the Comparable interface
        Collections.sort(tireList);

        // print the report
        printReportTable(tireList);
    }

    private static void printReportTable(List<Tire> tireList)
    {
        // for each tire, print its name and cost for a full set
        for (Tire tire : tireList)
        {
            System.out.println(tire + ": Cost per set of 4 is $" + tire.costForSet());
        }
    }

    private static Tire getTireInfo()
    {
        // prompt user for each piece of info about the tire
        String name = stringInput("Enter name of tire:");
        double price = positiveDoubleInput("Enter price of " + name + "?");
        int mileWarranty = positiveIntInput("Enter number of miles warranty?");

        // use the collected data to create a new tire using its constructor
        Tire tire = new Tire(name, price, mileWarranty);
        return tire;
    }
}
