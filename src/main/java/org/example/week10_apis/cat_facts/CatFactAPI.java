package org.example.week10_apis.cat_facts;

import kong.unirest.Unirest;

public class CatFactAPI
{
    public static void main(String[] args)
    {
        // I was getting some annoying warnings that are apparently from Unirest trying to use cookies
        // I found this solution that simply disables the use of cookies for Unirest
        // https://stackoverflow.com/questions/32442318/how-to-avoid-sending-cookie-header-in-java-unirest-requests
        Unirest.config().enableCookieManagement(false);

        // url of the api to make requests to
        String url = "https://catfact.ninja/fact";
        // get data from the url as a raw json string
        // json objects are basically just dictionaries. they consist of a list of key value pairs
        // the keys are always just strings, but the values can be a few things
        // https://www.w3schools.com/js/js_json_datatypes.asp
        // the values can be strings, numbers, booleans, null values, arrays, or even other json objects
        // getBody just does the final processing/conversions
        //String fact = Unirest.get(url).asString().getBody();

        // print the raw json response we got from the api
        //System.out.println(fact);

        // get data from the url as a CatFact object
        // the object is automatically created by matching the json key names to the object's field names
        // and setting the object's field values to the corresponding json values
        // use the .asObject(class) parameter to define what type of object we are trying to create from the api request
        CatFact catFact = Unirest.get(url).asObject(CatFact.class).getBody(); // getBody() still just does final conversion

        // print the fact string
        System.out.println(catFact.fact);

        // print the length of the catFact string as provided by the api
        System.out.println(catFact.length);
    }
}

class CatFact
{
    // field names correspond to json dictionary keys in the api response
    public String fact;
    public int length;
}