package org.example.week7_OOP;

// object representing a player in the game. holds player info together and methods relating to the player
public class Player
{
    // player object has a name, knockout number, and knockout state
    private String name;
    private boolean knockedOut;
    private int knockoutNumber;


    // constructor just sets the player name
    public Player(String name)
    {
        this.name = name;
        // players always start the game not knocked out
        this.knockedOut = false;
    }

    // roll the dice cup and find the outcome of this players turn
    public String playTurn(DiceCup diceCup)
    {
        // roll all the dice in the dice cup and get the total number
        int score = diceCup.rollAll();

        // figure out if the player is knocked out by this score
        if (playerKnockedOut(score))
        {
            knockedOut = true;
        }

        // create a template for the turn result string that we will return later
        String resultTemplate = "Player %s rolled a total of %d and %s knocked out. (Your knockout number was %d)";

        // if the player was knocked out, we say "was knocked out", otherwise "was not knocked out"
        String knockedOutOrNot = "was not";
        if (knockedOut)
        {
            knockedOutOrNot = "was";
        }
        // format the string for the turn result and return the formatted string
        String result = String.format(resultTemplate, name, score, knockedOutOrNot, knockoutNumber);
        return result;
    }

    // if the score is equal to this player's knockout number, they are knocked out
    public boolean playerKnockedOut(int score)
    {
        if (score == knockoutNumber)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // auto generated getter and setter methods for the private fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }

    public void setKnockedOut(boolean knockedOut) {
        this.knockedOut = knockedOut;
    }

    public int getKnockoutNumber() {
        return knockoutNumber;
    }

    public void setKnockoutNumber(int knockoutNumber) {
        this.knockoutNumber = knockoutNumber;
    }
}
