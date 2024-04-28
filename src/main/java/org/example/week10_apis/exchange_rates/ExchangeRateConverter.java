package org.example.week10_apis.exchange_rates;

import kong.unirest.Unirest;

import java.util.Map;

import static input.InputUtils.*;

public class ExchangeRateConverter
{
    public static void main(String[] args)
    {
        String url = "https://1150-exchange-rates.azurewebsites.net/latest"; // ?base=USD?symbols=EUR

        // basic way to call api and turn response into an object
        //RateResponse response = Unirest.get(url).asObject(RateResponse.class).getBody();

        // instead of embedding the parameters into the url, we can represent the query parameters as a dictionary
        // the keys are the parameter names, values are the parameter values.
        // values are stored as generic Object type because parameters can be of various types
        // set the base currency to USD and the exchange rates we want to only euros
        Map<String, Object> queryParameters = Map.of("base", "USD", "symbols", "EUR");

        // call api with parameters set from the dictionary we created
        // same as the basic way except one extra method call to .queryString(queryParameters)
        RateResponse response = Unirest.get(url)
                .queryString(queryParameters)
                .asObject(RateResponse.class)
                .getBody();

        String dateRequested = response.date;
        double rate = response.rates.EUR;
        double amountOfDollars = doubleInput("How many US Dollars to convert to Euros?");
        double euroEquivalent = amountOfDollars * rate;
        System.out.println("$" + amountOfDollars + " is equivalent to " + euroEquivalent + " Euros.");
        System.out.println("On " + dateRequested + " the exchange rate from USD to Euros is " + rate);
    }
}

// we basically look at the shape of the api response and can create corresponding classes that share the same shape
// this api returns a json string with three keys at the top level: "base", "date", and "rates"
// "base" and "date" both have values that are just strings
// but the value of "rates" is another json dictionary with keys that correspond to capitalized currency abbreviations
// such as AUD, GBP, CAD . . .
// the values for each entry of "rates" are the actual exchange rate of that currency expressed as a float
// we can express this shape by including a field of another java class that has the shape of the "rates" json object
class RateResponse
{
    public String base;
    public String date;
    public Rates rates;
}

// the rates entry of the api response is a json dictionary with exchange rates for the currencies we specify in the parameters
// we don't actually have to use/assign all the values from the json dictionary to the java object
// we can just get the value of the "EUR" key. everything else can be ignored without issue
// however, in this case, we only specified that we want the Euro exchange rate in the api call parameters
class Rates
{
    public double EUR;
}
