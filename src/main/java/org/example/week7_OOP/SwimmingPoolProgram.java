package org.example.week7_OOP;

public class SwimmingPoolProgram
{
    public static void main(String[] args)
    {
        // create a new instance of the Pool class using the Pool constructor
        Pool ymca = new Pool("YMCA", 50);

        // use the object instance method to get the distance of going 6 laps around the pool
        double totalSwam = ymca.distanceForLaps(6);
        System.out.println("The total distance is " + totalSwam + " meters.");

        // create another Pool instance.
        // This one has different data even though it is the same class as the ymca pool because it is a different instance
        Pool como = new Pool("Como Park", 25);
        System.out.println(como.distanceForLaps(10));
        System.out.println(como);

        // use constructor overload to initialize the pool with more stuff
        Pool edina = new Pool("Edina", 50, "2222 Edina Road", 12);

        // this third instance is still a Pool object but has its own data separate from the other Pool instances
        double distance = edina.distanceForLaps(12);
        System.out.println(distance);
        System.out.println(edina);
    }
}
