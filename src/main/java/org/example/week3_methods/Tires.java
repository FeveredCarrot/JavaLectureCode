package org.example.week3_methods;

import static input.InputUtils.*;

public class Tires
{
    public static void main(String[] args)
    {
        int numberOfTiresToCompare = positiveIntInput("Enter number of tires to compare: ");
        String[] tireReports = new String[numberOfTiresToCompare];

        // fill tireReports array with reports
        for (int t = 0; t < numberOfTiresToCompare; t++)
        {
            String report = getTireInfo();
            tireReports[t] = report;
        }

        // print all the collected data at the end
        printReportTable(tireReports);
    }

    public static void printReportTable(String[] reports)
    {
        // print all reports
        for (String report : reports)
        {
            System.out.println(report);
        }
    }

    // reuse this method to collect report data multiple times
    public static String getTireInfo()
    {
        String tireName = stringInput("Enter name of tire");
        double price = doubleInput("Enter price for " + tireName);
        double miles = doubleInput("Enter warranty miles for " + tireName);

        double pricePerThousandMiles = price / miles * 1000;
        return "The " + tireName + " tire costs $" + pricePerThousandMiles + " dollars per thousand miles.";
    }
}
