package org.example.week3_methods;

import java.util.Arrays;

public class CorporateSponsors
{
    public static void main (String[] args)
    {
        // modify array and make stings upper case
        String[] sponsors = {"ikea", "at&t", "cvs", "3m"};

        // loop over array and convert each string to upper case
        for (int i =0; i < sponsors.length; i++)
        {
            String sponsor = sponsors[i];
            sponsor = sponsor.toUpperCase();
            sponsors[i] = sponsor;
        }

        System.out.println(Arrays.toString(sponsors));
    }
}
