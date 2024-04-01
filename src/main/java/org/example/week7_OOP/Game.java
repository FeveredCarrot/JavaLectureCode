package org.example.week7_OOP;

import java.util.ArrayList;
import java.util.List;

import static input.InputUtils.*;

// main class for the Knockout Dice Game
public class Game
{
    // declare a list of players and diceCup fields that are accessible class wide
    private DiceCup diceCup;
    private List<Player> players;

    public static void main(String[] args)
    {
        // Instantiate an instance of the game from the static main method
        Game knockout = new Game();
        // Play the game until complete
        knockout.startGame();
        // after game is finished, print the results
        knockout.printGameResults();
    }

    // do some initial setup before playing the game
    public void startGame()
    {
        // create a diceCup to use
        diceCup = new DiceCup(2);

        // create the players that will play the game
        int numberOfPlayers = positiveIntInput("How many players?");
        players = createPlayers(numberOfPlayers);

        // set each player's knockout number
        setKnockoutNumbers();

        // play the game
        play();
    }

    // clear the player list and then populate it with a number of players
    private List<Player> createPlayers(int numberOfPlayers)
    {
        // set the players field to a new empty list
        players = new ArrayList<>();

        // create numberOfPlayers players
        for (int x = 0; x < numberOfPlayers; x++)
        {
            // get the player's name and then create a player with that name
            String name = stringInput("Enter player " + (x+1) + "'s name");
            Player player = new Player(name);
            // add the player to the list of players
            players.add(player);
        }
        // return the list of players, which is also just the player list field
        return players;
    }

    private void setKnockoutNumbers()
    {
        // for each player, prompt them for their knockout number
        for (Player p : players)
        {
            int knockoutNumber;
            // retry getting the player's knockout number if their input is outside the valid range
            do
            {
                knockoutNumber = intInput("Player " + p.getName() + ", enter your knockout number:");
            } while (knockoutNumber < 6 || knockoutNumber > 9); // check if valid knockout number

            // set this player's knockout number
            p.setKnockoutNumber(knockoutNumber);
        }
    }

    private void play()
    {
        int playerIndex = 0;
        int totalPlayers = players.size();

        // play a round of the game until there is only one player left
        while (moreThanOnePlayersInPlay())
        {
            // get the player who's turn it is
            Player currentPlayer = players.get(playerIndex);

            // if this player is knocked out, skip their turn
            if (currentPlayer.isKnockedOut())
            {
                System.out.println("Sorry, " + currentPlayer.getName() + " you are knocked out.");
            }
            else
            {
                // otherwise, roll the dice once the player is ready
                stringInput("Player " + currentPlayer.getName() + ", press enter to roll.");
                // roll dice in dice cup, knocking out player if it is their knockout number
                String turnResult = currentPlayer.playTurn(diceCup);
                // print the result of this turn
                System.out.println(turnResult);
            }

            // move to the next player
            // modulo totalPlayers so that we loop back to the first player after reaching the last player in the list
            playerIndex = (playerIndex + 1) % totalPlayers;
        }
    }

    private boolean moreThanOnePlayersInPlay()
    {
        // loop over each player and count how many are not yet knocked out
        int totalInPlay = 0;
        for (Player p : players)
        {
            if (!p.isKnockedOut())
            {
                totalInPlay++;
            }
        }

        // print the number of players still in the game
        System.out.println("There are " + totalInPlay + " player(s) in the game.");

        // return whether there is more than one player left
        return totalInPlay > 1;
    }

    private void printGameResults()
    {
        // loop over each player
        for (Player player : players)
        {
            // if they are knocked out, print that they are knocked out
            if (player.isKnockedOut())
            {
                System.out.println("Player " + player.getName() + " was knocked out.");
            }
            // otherwise, they are the last player, AKA the winner
            else
            {
                System.out.println("Player " + player.getName() + " IS THE WINNER!!!");
            }
        }
    }
}


