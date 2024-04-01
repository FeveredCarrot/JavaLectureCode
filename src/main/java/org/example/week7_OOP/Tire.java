package org.example.week7_OOP;

public class Tire implements Comparable<Tire> // implement the Comparable interface that the Collections.sort method uses
{
    // A tire object has a name, price, and number miles covered by warranty
    // these are all private fields so they can only be modified internally
    private String name;
    private double price;
    private int warrantyMiles;

    public Tire(String name, double price, int warrantyMiles)
    {
        this.name = name;
        this.price = price;
        this.warrantyMiles = warrantyMiles;
    }

    // calculates the price of the tire per 1000 miles of use out of the entire lifespan of the tire
    public double pricePerThousandMiles()
    {
        double pricePerThousand = (price / warrantyMiles) * 1000;
        return pricePerThousand;
    }

    // calculates the price for a set of 4 wheels
    public double costForSet()
    {
        return this.price * 4;
    }

    // override method for representing a Tire object as a String.
    // e.g. if you print a Tire object to console it will automatically use this method
    @Override
    public String toString()
    {
        return String.format("%s costs $%.2f per tire. Cost per 1000 miles is $%.2f", name, price, pricePerThousandMiles());
    }

    // this is the Comparison interface implementation
    // this is automatically used by the Collections.sort method to sort a list of Tire objects
    // this method defines how Tire objects will be sorted
    @Override
    public int compareTo(Tire other)
    {
        // tire objects will be sorted by their price per 1000 miles
        // simply use the Double comparison method for this
        // but if we wanted to create our own way of comparing things, then we just need to
        // return 0 if the objects are equal, -1 if this one is less than the other object, and 1 if it is greater
        return Double.compare(pricePerThousandMiles(), other.pricePerThousandMiles());
    }
}
