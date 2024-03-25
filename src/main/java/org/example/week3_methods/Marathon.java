package org.example.week3_methods;

public class Marathon
{
    public static void main(String[] args)
    {
        double currentDistance = 1;
        double targetDistance = 26.2;
        double percentIncrease = 1.10;

        // run the method
        marathonSchedule(currentDistance, targetDistance, percentIncrease);
    }

    // put this code in a method
    public static void marathonSchedule(double currentDistance, double targetDistance, double percentIncrease)
    {
        int week = 1;

        // loop until currentDistance is greater than the target distance
        while (currentDistance < targetDistance)
        {
            System.out.println(week + " " + currentDistance);
            // could do currentDistance *= percentIncrease as shorthand for this
            currentDistance = currentDistance * percentIncrease;
            week++;
        }

        // Print the distance a final time
        System.out.println(week + " " + currentDistance);
    }
}
