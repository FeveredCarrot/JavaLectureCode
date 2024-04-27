package org.example.week9_databases.hello_databases;

import java.sql.*;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        // database URL. in a larger app this might point to somewhere on a network
        String url = "jdbc:sqlite:hello.sqlite";
        // connect to the database URL
        Connection connection = DriverManager.getConnection(url);

        // create an SQL statement object for this database
        Statement statement = connection.createStatement();

        // Create a new table with two columns: name, age
        // Literally pass a string with the SQL command into the Statement object to execute it
        //String createTableSQL = "CREATE TABLE cats (name TEXT, age INTEGER)";
        //statement.execute(createTableSQL);

        // insert a row into the table
        //String insertDataSQL = "INSERT INTO cats VALUES ('Maru', 10)";
        //statement.execute(insertDataSQL);

        // insert another row into the table
        //String insertDataSQL = "INSERT INTO cats VALUES ('Hello Kitty', 40)";
        //statement.execute(insertDataSQL);

        // for reading from a database, info is read into a ResultSet object from the Statement object
        // get all the rows from the cats table
        String getAllDataSQL = "SELECT * FROM cats";
        ResultSet allCats = statement.executeQuery(getAllDataSQL);

        // ResultSet.next() points the ResultSet to the next row in the table.
        // the first call to next() points the ResultSet to the first row in the table
        // when reaching the end of the table, next() returns false
        while (allCats.next())
        {
            // read the data from the current row the ResultSet is pointing to
            String name = allCats.getString("name");
            int age = allCats.getInt("age");
            // print the data that we just read from the database
            System.out.println(name + " is " + age + " years old.");
        }
    }
}
