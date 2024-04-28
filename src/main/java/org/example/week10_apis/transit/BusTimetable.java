package org.example.week10_apis.transit;

import kong.unirest.Unirest;

public class BusTimetable
{
    public static void main(String[] args)
    {
        // api request url for northbound busses from MCTC
        String busTimesUrl = "https://svc.metrotransit.org/NexTrip/17940?format=json";

        // Call the api and get the response as a MetroTransitResponse object
        MetroTransitResponse response = Unirest
                .get(busTimesUrl)
                .asObject(MetroTransitResponse.class)
                .getBody();

        Bus[] busses = response.departures;

        // print column titles for the bus route table
        System.out.printf("%-10s %-40s %-20s\n", "Route", "Description", "Arrival Time");

        // print all Bus objects in the list of departures
        for (Bus bus : busses)
        {
            // using Bus.toString()
            System.out.println(bus);
        }
    }
}

// the api response is just an array of json objects
class MetroTransitResponse
{
    Bus[] departures;
}

class Bus
{
    public String departure_text;
    public String description;
    public String route_id;

    @Override
    public String toString()
    {
        // string representation of a bus
        // use string formatting to make it look nice in a table format
        String template = "%-10s %-40s %-20s";
        return String.format(template, route_id, description, departure_text);
    }
}