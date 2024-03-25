package org.example.week3_methods;
import static input.InputUtils.intInput;
import static input.InputUtils.doubleInput;
public class Lemonade
{

    public static void main(String[] args)
    {
        // call one generalized method twice to reduce repeated code
        // instead of writing two separate methods for each specific product
        double lemonadeProfit = calculateProfitForProduct("lemonade");
        System.out.println("Lemonade profit = $" + lemonadeProfit);

        double cookieProfit = calculateProfitForProduct("cookies");
        System.out.println("Cookie profit = $" + cookieProfit);
    }

    // generalized method takes the product name as input and adjusts its prompts accordingly
    public static double calculateProfitForProduct(String productName)
    {
        double suppliesCost = doubleInput("How much did you spend on " + productName + " supplies?");
        double salePrice = doubleInput("What did you sell one " + productName + " for?");
        int numberSold = intInput("How many " + productName + " did you sell?");

        double profit = (numberSold * salePrice) - suppliesCost;
        return profit;
    }
}
