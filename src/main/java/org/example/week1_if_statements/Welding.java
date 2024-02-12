package org.example.week1_if_statements;

import static input.InputUtils.yesNoInput;

public class Welding
{
    public static void main(String[] args)
    {
        boolean cottonClothes = yesNoInput("Are you wearing cotton clothes?");
        boolean woolClothes = yesNoInput("Are you wearing wool clothes?");
        boolean closedToeShoes = yesNoInput("are you wearing closed toe shoes?");

        if ((cottonClothes || woolClothes) && closedToeShoes)
        {
            System.out.println("You are prepared to weld. Go get em'");
        } else if (!(cottonClothes || woolClothes))
        {
            System.out.println("You should be wearing cotton or wool clothes!");
        } else
        {
            System.out.println("You should be wearing closed toe shoes!");
        }
    }
}
