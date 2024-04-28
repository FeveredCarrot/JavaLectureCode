package org.example.week10_apis.yelp;

import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;
import static input.InputUtils.*;

public class YelpSearch
{
    public static void main(String[] args)
    {
        // api request url
        String yelpURL = "https://api.yelp.com/v3/businesses/search";

        // we set a system environment variable that has our api key so we don't expose our secret data on github
        final String YELP_API_KEY = System.getenv("YELP_API_KEY");

        // get a search query to put into the api query parameters
        String typeOfRestaurant = stringInput("What type of food do you want?");

        // api query parameters
        // use the search term we get from the user in the query
        Map<String, Object> yelpQuery = Map.of(
                "term", typeOfRestaurant,
                "location", "Minneapolis,MN",
                "categories", "restaurants",
                "price", "1");

        // for authorization with an api key, we add the call to .header() with our api key to the chain of method calls
        // creates a YelpResponse object from the api call
        YelpResponse response = Unirest
                .get(yelpURL)
                .header("Authorization", "Bearer " + YELP_API_KEY)
                .queryString(yelpQuery)
                .asObject(YelpResponse.class)
                .getBody();

        // print out each business' info from the YelpResponse
        for (Business b : response.businesses)
        {
            System.out.println(b.name);
            System.out.println(b.rating);
            System.out.println(b.location);
        }
    }

}
