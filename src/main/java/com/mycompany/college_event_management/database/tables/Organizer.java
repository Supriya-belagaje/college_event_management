/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;

/**
 *
 * @author supru
 */

import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Organizer {

    public int organizerId;
    public String organizerName;
    public String organizerPhone;
    public String organizeremail;
    public String organizerUsername;
    public String organizerPassword;

    public Organizer(int organizerId, String organizerName, String organizerPhone, String organizeremail, String organizerUsername, String organizerPassword) {
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerPhone = organizerPhone;
        this.organizeremail = organizeremail;
        this.organizerUsername = organizerUsername;
        this.organizerPassword = organizerPassword;
    }
    public int getOrganizerId(){
        return organizerId;
    }


    public static int size() {
    try {
        ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT COUNT(organizer_id) FROM organizer");
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0; // Return 0 if there's an exception or no records found
}
    public static boolean deleteOrganizer(int organizerId) {
    try {
        // Create a SQL DELETE statement to remove the organizer from the database
        String query = "DELETE FROM Organizer WHERE organizer_id = ?";
        
        // Get a connection to the database and create a PreparedStatement
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

        // Set the organizer ID parameter in the prepared statement
        statement.setInt(1, organizerId);
        
        // Execute the delete operation
        int rowsAffected = statement.executeUpdate();
        
        // Close the statement and connection
        statement.close();
        
        // Check if any rows were affected (organizer deleted successfully)
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false to indicate deletion failure
    }
}


    // Static method to fetch an organizer by ID
    public static Organizer getOrganizerById(int id) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Organizer WHERE organizer_id = " + id);
            if (rs.next()) {
                return new Organizer(
                        rs.getInt("organizer_id"),
                        rs.getString("organizer_name"),
                        rs.getString("organizer_phone"),
                        rs.getString("organizer_email"),
                        rs.getString("organizer_username"),
                        rs.getString("organizer_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given ID not found
    }

    // Static method to fetch an organizer by username
    public static Organizer getOrganizerByUsername(String username) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Organizer WHERE organizer_username = '" + username + "'");
            if (rs.next()) {
                return new Organizer(
                        rs.getInt("organizer_id"),
                        rs.getString("organizer_name"),
                        rs.getString("organizer_phone"),
                        rs.getString("organizer_email"),
                        rs.getString("organizer_username"),
                        rs.getString("organizer_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given username not found
    }
    public static boolean insertorganizer(Organizer org) {
    try {
        String query ="INSERT INTO Organizer (organizer_name, organizer_phone, organizer_email, organizer_username, organizer_password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        statement.setString(1, org.organizerName);
        statement.setString(2, org.organizerPhone);
        statement.setString(3,org.organizeremail); 
        statement.setString(4, org.organizerUsername);
        statement.setString(5, org.organizerPassword);
        
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    public static List<Organizer> getAllOrganizers() {
    List<Organizer> organizers = new ArrayList<>();
    try {
        String query = "SELECT * FROM Organizer";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("organizer_id");
            String name = resultSet.getString("organizer_name");
            String phone = resultSet.getString("organizer_phone");
            String email = resultSet.getString("organizer_email");
            String username = resultSet.getString("organizer_username");
            String password = resultSet.getString("organizer_password");
            Organizer organizer = new Organizer(id, name, phone, email, username, password);
            organizers.add(organizer);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return organizers;
}
    
}




   