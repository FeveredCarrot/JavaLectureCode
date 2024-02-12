package org.example.week2_loops;


import input.InputUtils;

public class Square
{
    public static void main(String[] args)
    {
        int width = InputUtils.positiveIntInput("Enter the desired width of your square: ");
        int height = InputUtils.positiveIntInput("Enter the desired height of your square");
        // Using String.charAt to get the first character of the user input
        char squareMaterial = InputUtils.stringInput("Enter the material your square will be constructed of:").charAt(0);

        for (int y = 0; y < height; y++)
        {
            String row = "";
            for (int x = 0; x < width; x++)
            {
                row += squareMaterial;
            }
            System.out.println(row);
        }
    }
}
