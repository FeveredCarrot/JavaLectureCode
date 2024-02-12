package org.example.week1_if_statements;

import java.util.Scanner;

import static input.InputUtils.*;

public class TestInput
{
    public static void main(String[] args) {
        // Java input without InputUtils library
        //Scanner scanner = new Scanner();
        //String name2 = scanner.nextLine();

        // Integer input without InputUtils
        //int number = scanner.nextInt();
        //scanner.next();

        // Using InputUtils for input
        String name = stringInput("Enter your name: ");
        System.out.println("Hello " + name);

        // Integer input
        int candyBars = intInput("How many candy bars?");

        // Makes sure integer is positive
        int people = positiveIntInput("How many people");

        // Boolean input. Use y, n, or yes, no for input
        boolean ok = yesNoInput("May I continue?");

        // Question parameter is optional for all of these
    }
}
