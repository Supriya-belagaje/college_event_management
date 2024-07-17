/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;

import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author supru
 */
public class Register {
    public int Registration_id;
    public int Event_id;
    public int Participant_id;
    
    public Register(int Registration_id, int Event_id, int Participant_id) {
        this.Registration_id = Registration_id;
        this.Event_id = Event_id;
        this.Participant_id = Participant_id;
}
    public static boolean insertreg(Register reg) {
        try {
             String checkQuery = "SELECT * FROM registration WHERE Event_id = ? AND Participant_id = ?";
        PreparedStatement checkStatement = DatabaseManager.getInstance().getConnection().prepareStatement(checkQuery);
        checkStatement.setInt(1, reg.Event_id);
        checkStatement.setInt(2, reg.Participant_id);
        ResultSet resultSet = checkStatement.executeQuery();
        
        // If a record exists, participant has already registered for the event
        if (resultSet.next()) {
            // You can handle this case as needed (e.g., show a message to the user)
            System.out.println("Participant already registered for the event.");
            //JOptionPane.showMessageDialog(this, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Return false indicating registration failed
        }
        
            String query = "INSERT INTO registration (Event_id, Participant_id) VALUES (?, ?)";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            statement.setInt(1, reg.Event_id);
            statement.setInt(2, reg.Participant_id);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
}
    public static boolean deleteEventParticipant(int eventId, int participantId) {
    try {
        String query = "DELETE FROM event_participant WHERE event_id = ? AND participant_id = ?";
             PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

        
        statement.setInt(1, eventId);
        statement.setInt(2, participantId);
        
        int rowsAffected = statement.executeUpdate();
      
        statement.close();
        return rowsAffected > 0;
    } 
    catch (SQLException e) {
        e.printStackTrace();
        return false; 
    }
}
    public static boolean unregisterFromEvent(int eventId, int participantId) {
    try {
        // Create SQL query to delete registration entry
        String query = "DELETE FROM registration WHERE event_id = ? AND participant_id = ?";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

        // Set parameters for the query
        statement.setInt(1, eventId);
        statement.setInt(2, participantId);

        // Execute the query to delete the registration
        int rowsDeleted = statement.executeUpdate();

        // Close the statement
        statement.close();

        // Return true if registration was deleted successfully
        return rowsDeleted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false if an error occurs
    }
}


}
