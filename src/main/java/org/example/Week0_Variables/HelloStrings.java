package org.example.Week0_Variables;

public class HelloStrings
{
    public static void main(String[] args)
    {
        String name = "Carrot";
        String nameInUpperCase = name.toUpperCase();
        String nameInLowerCase = name.toLowerCase();
        System.out.println(nameInUpperCase);
        System.out.println(nameInLowerCase);

        int charactersInName = name.length();
        System.out.println("There are " + charactersInName + " characters in " + name);

        // Escape characters
        System.out.println("\tTab \nnewline \"quote\"");

        double pizzaRolls = 16;
        int people = 3;

        double rollsPerPerson = pizzaRolls / people;

        // Printf uses formatted string
        // Other way is to use String.format()
        // %.1f rounds to 1 decimal point
        System.out.printf("each person gets %.1f pizza rolls", rollsPerPerson);

        int pizzaSlices = 16;
        // Integer division rounds down to nearest integer
        int slicesPerPerson = pizzaSlices / people;
        System.out.printf("\neach person gets %d pizza slices", slicesPerPerson);
    }
}
