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
import static java.lang.ProcessHandle.current;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EventManager {
    
    public void markEventsAsCompleted() {
    List<Event> events = getAllEvents();
    LocalDate today = LocalDate.now();
    
    for (Event event : events) {
        LocalDate eventLocalDate = event.getEventDate().toLocalDate(); // Convert java.sql.Date to LocalDate
        
        if (eventLocalDate.isBefore(today)) {
            // Update the event in the database to mark it as completed
            markEventAsCompleted(event.getEventId());
        }
    }
}
    
    private List<Event> getAllEvents() {
        // Retrieve all events from the database
        return null;
        // Retrieve all events from the database
    }
    
    private void markEventAsCompleted(int eventId) {
        String query = "UPDATE Event SET completed = 1 WHERE event_id = ?";
        
        try (Connection connection = DatabaseManager.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, eventId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
