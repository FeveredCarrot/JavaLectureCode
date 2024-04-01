package org.example.week7_OOP;

public class Pool
{
    // fields hold data together within the object
    // private fields are only directly accessible from within this class
    private String name;
    private double length;
    private String address;
    private double maxDepth;

    // public getter and setter methods give a more standardized way for this class to be modified from other classes
    // without just setting the fields to public
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        // dont set the length if it is an invalid length
        // this is an example of why getter and setter methods are a good idea compared to public fields
        if (length < 0 || length > 1000) return;
        this.length = length;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(double maxDepth) {
        this.maxDepth = maxDepth;
    }

    // Constructor. Creates and sets up an instance of a pool object.
    // like Pool p = new Pool(name, length);
    Pool(String name, double length)
    {
        this.name = name;
        this.length = length;
        this.address = "not provided";
        this.maxDepth = -1;
    }

    // Constructor overload. alternate way to create a pool object by providing more data initially
    Pool(String name, double length, String address, double maxDepth)
    {
        this.name = name;
        this.length = length;
        this.address = address;
        this.maxDepth = maxDepth;
    }

    // takes the number of laps to go around the pool and returns the corresponding travel distance
    public double distanceForLaps(int laps)
    {
        return laps * length;
    }

    // @Override decorator marks this method as one that is inherited from a parent class.
    // toString is inherited by all Objects. We can specify how this object is represented when it is cast to a String
    @Override
    public String toString()
    {
        return name + " pool: " + length + " meters long";
    }
}
