package org.example.Week0_Variables;

public class Temp
{

    public static void main(String[] args)
    {
        String currentMonth = "January";
        int dayOfMonth = 11;
        double forecastHigh = 19.4;
        double forecastLow = -3.7;

        double highLowDifference = forecastHigh - forecastLow;

        // %d for integer, %s for string, %f for double. add . for rounding/clamping length
        System.out.printf("On %d %s the difference between high and low temperature is %.2f", dayOfMonth, currentMonth, highLowDifference);
    }

}
