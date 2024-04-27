package org.example.week9_databases.movies;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Database
{
    private final String databasePath;

    Database(String databasePath)
    {
        this.databasePath = databasePath;

        // connect to the database.
        // use try with block to automatically close the database connection when the code block ends
        try (Connection connection = DriverManager.getConnection(databasePath);
             // create a Statement object to execute SQL with
             Statement statement = connection.createStatement();)
        {
            // create the movies table if not already created.
            // each row in the table will contain an id, name, number of stars, and if it's been watched
            // first value in each row is marked as primary key and will auto set to a unique id if not manually specified
            // unique keyword asserts the value is unique for every row
            // check keyword asserts the value complies with the provided conditional before adding a row
            String command = "CREATE TABLE IF NOT EXISTS movies(" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT UNIQUE CHECK(length(name) >=1), " +
                    "stars INTEGER CHECK(stars >=0 AND stars <= 5), " +
                    "watched BOOLEAN)";

            // execute the SQL command
            statement.execute(command);
        } catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error creating movie DB table because " + e);
        }
    }

    // takes the row being read from a database table and reconstructs it into a Movie object
    // this was being repeated a lot so I just extracted it to private method
    private Movie deserializeMovie(ResultSet movieResults) throws SQLException
    {
        // store the row values into variables
        int id = movieResults.getInt("id");
        String name = movieResults.getString("name");
        int stars = movieResults.getInt("stars");
        boolean watched = movieResults.getBoolean("watched");

        // deserialize the data we read from the database into an actual Movie object
        // note we are passing in the primary key id from this row in the database
        Movie movie = new Movie(id, name, stars, watched);
        // return our created Movie object
        return movie;
    }

    public void addNewMovie(Movie movie)
    {
        // SQL command string uses ? to indicate places to insert variable values
        // since we are letting the id primary key set itself, we must specify which values we are inserting
        String insertSQL = "INSERT INTO movies (name, stars, watched) VALUES (?, ?, ?)";

        // open the database
        try (Connection connection = DriverManager.getConnection(databasePath);
             // use a PreparedStatement object to securely insert values into an SQL command
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);)
        {
            // first value is movie name, second is stars, third is isWatched
            // these go to the first, second, and third ? spots respectively
            // parameterIndex starts at 1 for some reason
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getStars());
            preparedStatement.setBoolean(3, movie.isWatched());

            // write the new movie to the database
            preparedStatement.execute();
        }
        catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error adding movie " + movie + " because " + e);
        }
    }

    public List<Movie> getAllMovies()
    {
        // open the database
        try (Connection connection = DriverManager.getConnection(databasePath);
        Statement statement = connection.createStatement())
        {
            // get all the movies in the table ordered by their name alphabetically
            ResultSet movieResults = statement.executeQuery("SELECT * FROM movies ORDER BY name");

            // initialize a list of Movie objects
            List<Movie> movies = new ArrayList<>();

            // read each movie row in the table
            while (movieResults.next())
            {
                // convert the row into a Movie object
                Movie movie = deserializeMovie(movieResults);
                // add the newly created Movie into the list of movies
                movies.add(movie);
            }

            // return our list of Movie objects we reconstructed from the database
            return movies;
        } catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error fetching all movies because " + e);
            return null;
        }
    }

    public List<Movie> getAllMoviesByWatched(boolean watchedStatus)
    {
        // get all movies with the indicated watchedStatus
        String SQLCommand = "SELECT * FROM movies WHERE watched = ?";

        // connect to the database
        try(Connection connection = DriverManager.getConnection(databasePath);
            PreparedStatement preparedStatement = connection.prepareStatement(SQLCommand);)
        {
            // set the watched boolean in the SQL statement to the watchedStatus parameter
            preparedStatement.setBoolean(1, watchedStatus);

            ResultSet movieResults = preparedStatement.executeQuery();
            List<Movie> movies = new ArrayList<>();

            while (movieResults.next())
            {
                // convert the row into a Movie object
                Movie movie = deserializeMovie(movieResults);
                // add the newly created movie into the list of movies
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error fetching movies because " + e);
            return null;
        }
    }

    public void updateMovie(Movie movie)
    {
        // set the stars and watched status of movies with this name
        String sqlCommand = "UPDATE movies SET stars = ?, watched = ? WHERE id = ?";

        // connect to the sql database
        try (Connection connection = DriverManager.getConnection(databasePath);
        PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);)
        {
            // assign the values from the Movie to the prepared statement values
            preparedStatement.setInt(1, movie.getStars());
            preparedStatement.setBoolean(2, movie.isWatched());
            preparedStatement.setInt(3, movie.getId());

            // execute the sql command to update the movie row
            preparedStatement.execute();
        } catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error updating movie " + movie + "  because " + e);
        }
    }

    public void deleteMovie(Movie movie)
    {
        // sql command to delete a movie by name
        String sqlCommand = "DELETE FROM movies WHERE id = ?";

        // open the sqlite database
        try (Connection connection = DriverManager.getConnection(databasePath);
        PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand))
        {
            preparedStatement.setInt(1, movie.getId());
            preparedStatement.execute();
        } catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error deleting movie " + movie + "  because " + e);
        }
    }

    public List<Movie> search(String searchTerm)
    {
        String sql = "SELECT * FROM movies WHERE UPPER(name) LIKE UPPER(?)";

        // connect to sqlite database
        try(Connection connection = DriverManager.getConnection(databasePath);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);)
        {
            // use '%' characters to tell sql to look for partial matches too
            preparedStatement.setString(1, "%" + searchTerm + "%");

            // execute the sql search
            ResultSet movieResults = preparedStatement.executeQuery();

            // instantiate a list of movies
            List<Movie> movies = new ArrayList<>();

            // fill the list with Movies that match the search query
            while (movieResults.next())
            {
                // read database row into a Movie object
                Movie movie = deserializeMovie(movieResults);

                movies.add(movie);
            }

            // return the list of Movies that match the search
            return movies;
        } catch (SQLException e) // catch any SQL errors and print an error message
        {
            System.out.println("Error searching movies because " + e);
            return null;
        }
    }
}
