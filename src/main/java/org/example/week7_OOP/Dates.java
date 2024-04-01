package org.example.week7_OOP;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates
{
    public static void main(String[] args)
    {
        // dates represent point in time. stored as long representing milliseconds since jan 1, 1970
        // creating a new Date defaults to the current moment
        Date now = new Date();
        System.out.println(now);

        // date/time represented as milliseconds
        Long milliseconds = now.getTime();
        System.out.println(milliseconds);

        // creating a new long needs L at end
        long numberOfMilliseconds = 1234566778765L;
        // pass milliseconds as constructor parameter to create a date at a specific time
        // can also pass in a sequence of ints for parameters of year, month, day, hour, minute, second, ms
        Date date = new Date(numberOfMilliseconds);
        System.out.println(date);

        // date.before(otherDate) returns boolean true if the date is before the other date
        // date.after is also a thing
        if (date.before(now))
        {
            System.out.println("2009 is earlier than now");
        }

        // use SimpleDateFormat object to format a date into a string with a specified format
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-YYYY"); // format is MM-dd-YYYY
        String formattedDate = dateFormatter.format(now); // format the now date into a formatted string
        System.out.println("The date is: " + formattedDate); // print the formatted date
    }
}
