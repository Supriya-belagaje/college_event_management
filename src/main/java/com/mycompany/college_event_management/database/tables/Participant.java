

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author supru
 */
package com.mycompany.college_event_management.database.tables;

import com.mycompany.college_event_management.database.AppState;
import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Participant {

    public int ParticipantId;
    public String ParticipantName;
    public String ParticipantPhone;
    public String Participantemail;
    public String ParticipantUsername;
    public String ParticipantPassword;

    public Participant(int ParticipantId, String ParticipantName, String ParticipantPhone, String Participantemail, String ParticipantUsername, String ParticipantPassword) {
        this.ParticipantId = ParticipantId;
        this.ParticipantName = ParticipantName;
        this.ParticipantPhone = ParticipantPhone;
        this.Participantemail = Participantemail;
        this.ParticipantUsername = ParticipantUsername;
        this.ParticipantPassword = ParticipantPassword;
    }

    // Static method to fetch an organizer by ID
    
    public int getParticipantId() {
        return ParticipantId;
}
    
    public static boolean deleteParticipant(int participantId) {
    try {
        // Construct the SQL DELETE statement
        String query = "DELETE FROM participants WHERE participant_id = ?";
        
        // Prepare a PreparedStatement with the DELETE query
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        
        // Bind the participant ID parameter
        statement.setInt(1, participantId);
        
        // Execute the delete operation
        int rowsDeleted = statement.executeUpdate();
        
        // Check if any rows were deleted
        if (rowsDeleted > 0) {
            System.out.println("Participant deleted successfully.");
            return true; // Participant deleted successfully
        } else {
            System.out.println("Participant not found or delete operation failed.");
            return false; // Participant not found or delete operation failed
        }
    } catch (SQLException e) {
        System.err.println("Error deleting participant: " + e.getMessage());
        e.printStackTrace();
        return false; // Error occurred during delete operation
    }
}


    public static Participant getByParticipantId(int id) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Participant WHERE Participant_id = " + id);
            if (rs.next()) {
                return new Participant(
                        rs.getInt("Participant_id"),
                        rs.getString("Participant_name"),
                        rs.getString("Participant_phone"),
                        rs.getString("Participant_email"),
                        rs.getString("Participant_username"),
                        rs.getString("Participant_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given ID not found
    }
    public static List<Participant> getAllParticipants() {
    List<Participant> participants = new ArrayList<>();
    try {
        String query = "SELECT * FROM participant";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("participant_id");
            String name = resultSet.getString("participant_name");
            String phone = resultSet.getString("participant_phone");
            String email = resultSet.getString("participant_email");
            String username = resultSet.getString("participant_username");
            String password = resultSet.getString("participant_password");
            Participant participant = new Participant(id, name, phone, email, username, password);
            participants.add(participant);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return participants;
}

    
    // Static method to insert a participant into the database
    public static boolean insertIntoParticipant(Participant participants) {
        try {
            String query = "INSERT INTO Participant (Participant_name, Participant_phone, Participant_username, Participant_email, Participant_password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, participants.ParticipantName);
            statement.setString(2, participants.ParticipantPhone);
            statement.setString(3, participants.ParticipantUsername);
            statement.setString(4, participants.Participantemail);
            statement.setString(5, participants.ParticipantPassword);
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Static method to fetch a participant by username
    public static Participant getParticipantByUsername(String username) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Participant WHERE Participant_username = '" + username + "'");
            if (rs.next()) {
                return new Participant(
                        rs.getInt("Participant_id"),
                        rs.getString("Participant_name"),
                        rs.getString("Participant_phone"),
                        rs.getString("Participant_username"),
                        rs.getString("Participant_email"),
                        rs.getString("Participant_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if participant with given username not found
    }

    // Static method to fetch all participant details
    public static boolean updateParticipant(Participant participant) {
    try {
        // Create SQL query to update participant information
        String query = "UPDATE Participant SET Participant_name = ?, Participant_phone = ?, Participant_email = ?, Participant_username = ?, Participant_password = ? WHERE Participant_id = ?";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
//        public String ParticipantName;
//    public String ParticipantPhone;
//    public String Participantemail;
//    public String ParticipantUsername;
//    public String ParticipantPassword;
        // Set parameters for the query
        statement.setString(1, participant.ParticipantName);
        statement.setString(2, participant.Participantemail);
        statement.setString(3, participant.ParticipantUsername);
        statement.setString(4, participant.ParticipantUsername);
        statement.setString(5, participant.ParticipantPassword);
        statement.setInt(6, participant.ParticipantId);
        
        // Execute the update query
        int rowsUpdated = statement.executeUpdate();
        
        // Close the statement
        statement.close();
        
        // Return true if participant was updated successfully
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false if an error occurs
    }
}

}

