package org.example.week10_apis.yelp;

public class YelpResponse
{
    // field for array of business objects
    Business[] businesses;
}

class Business
{
    // represents one business object

    // the actual api response gives more info than this, but we only need to specify the data we actually want to use
    public String name;
    public double rating;
    public Location location;

}

class Location
{
    // represent a location object
    public String city;
    public String address1;

    @Override
    public String toString() {
        return address1 + ", " + city;
    }
}