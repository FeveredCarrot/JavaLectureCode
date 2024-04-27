package org.example.week9_databases.movies;

// Each movie has a name, number of stars, and a bool for if it's been watched yet
public class Movie
{
    private int id;
    private String name;
    private int stars;
    private boolean watched;

    // getters and setters for private fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public int getId() {
        return id;
    }

    // simple constructor for creating a new Movie
    Movie(String name, int stars, boolean watched)
    {
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }

    // constructor with id parameter for deserializing from database
    Movie(int id, String name, int stars, boolean watched)
    {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.watched = watched;
    }

    // String representation of a Movie entry
    @Override
    public String toString()
    {
        return "Movie name: " + name + ", Has watched? " + watched + ", Stars: " + stars;
    }
}
