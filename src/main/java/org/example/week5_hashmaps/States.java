package org.example.week5_hashmaps;

import java.util.HashMap;

public class States
{
    public static void main(String[] args)
    {
        HashMap<String, String> stateAbbreviations = new HashMap<>();
        stateAbbreviations.put("Minnesota", "MN");
        stateAbbreviations.put("Wisconsin", "WI");
        stateAbbreviations.put("Michigan", "MI");

        System.out.println(stateAbbreviations); // prints the hashmap pairs in no guaranteed order

        System.out.println(stateAbbreviations.get("Minnesota")); // prints MN
        System.out.println(stateAbbreviations.get("Iowa")); // null

    }
}
