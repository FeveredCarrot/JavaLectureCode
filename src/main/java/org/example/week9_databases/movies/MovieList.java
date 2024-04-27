package org.example.week9_databases.movies;

import java.util.List;

import static input.InputUtils.*;

public class MovieList
{
    static final String DB_PATH = "jdbc:sqlite:movie_watchlist.sqlite";
    private static Database database;
    public static void main(String[] args)
    {
        database = new Database(DB_PATH);
        // CRUD
        addNewMovies();
        checkIfWatchedAndRate();
        deleteWatchedMovies();
        displayAllMovies();
        searchMovie();
    }

    public static int getRatingOutOfFive()
    {
        String prompt = "What is your rating, in stars out of 5?";
        int rating = positiveIntInput(prompt);
        while (rating < 0 || rating > 5)
        {
            System.out.println("Error - Enter a value between 0 and 5");
            rating = positiveIntInput(prompt);
        }
        return rating;
    }

    public static String getNonEmptyMovieName()
    {
        String name = stringInput("Enter the movie name:");
        // if the user enters a blank name, keep prompting them for a name
        while (name.isEmpty())
        {
            System.out.println("Error - enter a name");
            name = stringInput("Enter the movie name");
        }

        // return the non-empty movie name
        return name;
    }

    public static void addNewMovies()
    {
        // Get user input to construct a new Movie
        // keep adding movies until the user is finished
        while (yesNoInput("Add a movie to the watchlist?"))
        {
            // Collect user input
            String movieName = getNonEmptyMovieName();
            boolean movieWatched = yesNoInput("Have you seen this movie yet?");
            int movieStars = 0;
            if (movieWatched)
            {
                movieStars = getRatingOutOfFive();
            }

            // use the collected user input to create a Movie object
            Movie movie = new Movie(movieName, movieStars, movieWatched);
            // write the movie to the database
            database.addNewMovie(movie);
        }
    }

    public static void displayAllMovies()
    {
        // read the list of movies from the database
        List<Movie> movies = database.getAllMovies();

        // if there aren't any movies just print an error and leave the method
        if (movies.isEmpty())
        {
            System.out.println("No movies.");
            return;
        }

        // print out each movie if there are any
        for (Movie movie : movies)
        {
            System.out.println(movie);
        }
    }

    public static void checkIfWatchedAndRate()
    {
        // get all movies we havent watched as a List of Movie objects
        List<Movie> unwatchedMovies = database.getAllMoviesByWatched(false);

        // loop over each unwatched movie.
        for (Movie movie: unwatchedMovies)
        {
            // ask user if they have now seen the movie
            boolean hasWached = yesNoInput("Have you watched " + movie.getName() + " yet?");

            // if the user has, then prompt them to rate the movie
            if (hasWached)
            {
                // update the Movie with a new rating and set it to watched
                int stars = positiveIntInput("What is your rating for " + movie.getName() + " out of 5?");
                movie.setWatched(true);
                movie.setStars(stars);

                // modify the movie row in the database with the new rating and watched status
                database.updateMovie(movie);
            }
        }
    }

    public static void deleteWatchedMovies()
    {
        System.out.println("Here are all the movies you have seen");

        // get a list of Movies that the user has seen
        List<Movie> watchedMovies = database.getAllMoviesByWatched(true);

        for (Movie movie : watchedMovies)
        {
            // for every movie the user has seen, prompt them to delete the movie
            boolean delete = yesNoInput("Delete " + movie.getName() + "?");
            if (delete)
            {
                // if the user wants to delete the movie, delete it from the database
                database.deleteMovie(movie);
            }
        }
    }

    public static void searchMovie()
    {
        String movieName = stringInput("Enter movie name: ");

        // search the database for movies that match the user's search
        // and store the results in a list of Movies
        List<Movie> movieMatches = database.search(movieName);

        // if there are no matches, print an error and leave the method
        if (movieMatches.isEmpty())
        {
            System.out.println("No matches");
            return;
        }

        // print out all the matches
        for (Movie movie : movieMatches)
        {
            System.out.println(movie);
        }
    }
}
