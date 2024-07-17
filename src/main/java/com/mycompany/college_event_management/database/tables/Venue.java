/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;

import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author supru
 */
public class Venue {
    public int venueId;
    public String Name;
    public int Capacity;

public Venue(int venueId, String Name, int Capacity) {
        this.venueId = venueId;
        this.Name = Name;
        this.Capacity = Capacity;
    }

public static boolean updateVenue(Venue venue) {
        try {
            // Create SQL query to update venue in the database
            String query = "UPDATE venue SET venue_name = ?, capacity = ? WHERE venue_id = ?";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

            // Set parameters for the query
            statement.setString(1, venue.Name);
            statement.setInt(2, venue.Capacity);
            statement.setInt(3, venue.venueId);

            // Execute the update query
            int rowsAffected = statement.executeUpdate();

            // Close the statement
            statement.close();

            // Return true if the venue was updated successfully
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an error occurs
        }
    }
public static  List<Venue>  getAllVenue(){
        List<Venue> Venues = new ArrayList<>();
        try {
            String query = "SELECT * FROM venue";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int Venue_id = resultSet.getInt("venue_id");
                String venue_name = resultSet.getString("venue_name");
                int capacity = resultSet.getInt("Capacity");
                Venue venue;
                venue = new Venue(Venue_id, venue_name, capacity);
                Venues.add(venue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Venues;
    }
public static boolean insertvenue(Venue venue) {
        try {
            String query = "INSERT INTO venue (venue_name, Capacity) VALUES (?, ?)";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, venue.Name);
            statement.setInt(2, venue.Capacity);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}
        public static List<Integer> getAllVenueIds() {
    List<Integer> venueIds = new ArrayList<>();
    try {
        String query = "SELECT venue_id FROM venue";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int venueId = resultSet.getInt("venue_id");
            venueIds.add(venueId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return venueIds;
}
        // Assuming you have a method in your Venue class to delete a venue by ID
public static boolean deleteVenue(int venueId) {
    try {
        // Create SQL query to delete venue from the database
        String query = "DELETE FROM venue WHERE venue_id = ?";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

        // Set the venue ID parameter
        statement.setInt(1, venueId);

        // Execute the query to delete the venue
        int rowsDeleted = statement.executeUpdate();

        // Close the statement
        statement.close();

        // Return true if venue was deleted successfully
        return rowsDeleted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false if an error occurs
    }
}


    }

    



