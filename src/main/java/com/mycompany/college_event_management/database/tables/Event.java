/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;
import com.mycompany.college_event_management.database.AppState;
import com.mycompany.college_event_management.database.DatabaseManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import jdk.jfr.Description;


/**
 *
 * @author supru
 */
public class Event {
    
    public int eventId;
    public String eventName;
    public int venueId;
    public int organizerId;
    public Date eventDate;
    public String eventDescription;
    

    public Event(int eventId, String eventName, int venueId, int organizerId,Date eventDate, String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.venueId = venueId;
        this.organizerId = organizerId;
        this.eventDate =  eventDate;
        this.eventDescription = eventDescription;
    }
    public static Event getEventById(int eventId) throws SQLException {
    Event event = null;
    String query = "SELECT * FROM event WHERE event_id = ?";
    try (PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query)) {
        statement.setInt(1, eventId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("event_id");
            String name = resultSet.getString("name");
            int venueId = resultSet.getInt("venue_id");
            int organizerId = resultSet.getInt("Organizer_id");
            Date eventDate = resultSet.getDate("event_date");
            String eventDescription = resultSet.getString("event_description");
            event = new Event(id, name, venueId, organizerId, eventDate, eventDescription);
        }
    }
    return event;
}
     public Date getEventDate() {
        return this.eventDate;
    }
     public int getEventId() {
        return this.eventId;
    }

    public static  List<Event>  getAllEvents(){
        List<Event> events = new ArrayList<>();
        try {
            String query = "SELECT * FROM event";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("event_id");
                String name = resultSet.getString("name");
                int venueId = resultSet.getInt("venue_id");
                int organizer_id = resultSet.getInt("Organizer_id");
                Date event_date = resultSet.getDate("event_date");
                String event_description = resultSet.getString("event_description");
                Event event;
                event = new Event(id, name, venueId, organizer_id, event_date, event_description);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
    public static List<Event> getEventsWithParticipants() {
    List<Event> events = new ArrayList<>();
    
    try {
                int ParticipantId = AppState.logedingpart.getParticipantId();
                String query = "SELECT e.* " +
               "FROM Event e " +
               "JOIN Registration pr ON e.event_id = pr.event_id " + // Add space before WHERE
               "WHERE pr.participant_id = ?";

        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        
        statement.setInt(1, ParticipantId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int eventId = resultSet.getInt("event_id");
            String eventName = resultSet.getString("name");
            int venueId = resultSet.getInt("venue_id");
                int organizer_id = resultSet.getInt("Organizer_id");
                Date event_date = resultSet.getDate("event_date");
                String event_description = resultSet.getString("event_description");
            // Retrieve other event details as needed
            Event event;
            event = new Event(eventId, eventName, venueId, organizer_id, event_date, event_description);
            events.add(event);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return events;
}
    
    public static List<Event> getEventsWithoutParticipants() {
    List<Event> events = new ArrayList<>();
    
    try {
                int ParticipantId = AppState.logedingpart.getParticipantId();
                String query = "SELECT e.* "+
                "FROM Event e "+
                "LEFT JOIN Registration pr ON e.event_id = pr.event_id "+
                "WHERE pr.participant_id != ?";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        
        statement.setInt(1, ParticipantId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int eventId = resultSet.getInt("event_id");
            String eventName = resultSet.getString("name");
            int venueId = resultSet.getInt("venue_id");
                int organizer_id = resultSet.getInt("Organizer_id");
                Date event_date = resultSet.getDate("event_date");
                String event_description = resultSet.getString("event_description");
            // Retrieve other event details as needed
            Event event;
            event = new Event(eventId, eventName, venueId, organizer_id, event_date, event_description);
            events.add(event);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return events;
}
    public static boolean updateEvent(Event updatedEvent) {
        try {
            // Get database connection
            Connection connection = DatabaseManager.getInstance().getConnection();
            
            // SQL query to update event details
            String query = "UPDATE event SET name = ?, venue_id = ?, organizer_id = ?, event_date = ?, event_description = ? WHERE event_id = ?";
            
            // Create PreparedStatement
            PreparedStatement statement = connection.prepareStatement(query);
            
            // Set parameters
            statement.setString(1, updatedEvent.eventName);
            statement.setInt(2, updatedEvent.venueId);
            statement.setInt(3, updatedEvent.organizerId);
            statement.setDate(4, new java.sql.Date(updatedEvent.eventDate.getTime()));
            statement.setString(5, updatedEvent.eventDescription);
            statement.setInt(6, updatedEvent.eventId);
            
            // Execute update
            int rowsAffected = statement.executeUpdate();
            
            // Close statement and connection
            statement.close();
            //connection.close();
            
            // Return true if at least one row was affected, indicating a successful update
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an error occurs
        }
    }

     public static List<Event> getEventsByOrganizerId() {
    List<Event> events = new ArrayList<>();

    try {
        // Retrieve the logged-in organizer's ID
        int organizerId = AppState.logedinOrg.getOrganizerId();

        // Create the SQL query with a placeholder for the organizer_id parameter
        String query = "SELECT * FROM Event WHERE organizer_id = ?";

        // Get the database connection
        Connection connection = DatabaseManager.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(query);

        // Set the value of the organizer_id parameter
        statement.setInt(1, organizerId);

        // Execute the query
        ResultSet resultSet = statement.executeQuery();

        // Iterate through the result set and create Event objects
        while (resultSet.next()) {
            int id = resultSet.getInt("event_id"); // Assuming the event ID column is named 'event_id'
            String name = resultSet.getString("name"); // Adjust column name as per your table schema
            int venueId = resultSet.getInt("venue_id");
            Date eventDate = resultSet.getDate("event_date");
            String eventDescription = resultSet.getString("event_description");

            Event event = new Event(id, name, venueId, organizerId, eventDate, eventDescription);
            events.add(event);
        }

        // Clean up resources
//        resultSet.close();
//        statement.close();
//        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return events;
}

     // Getters and setters

    public static boolean insertEvent(Event event) {
    try {
        String query = "INSERT INTO event (name, venue_id, Organizer_id, event_date, event_description) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        statement.setString(1, event.eventName);
        statement.setInt(2, event.venueId);
        statement.setInt(3, event.organizerId);
        statement.setDate(4, event.eventDate);
        statement.setString(5, event.eventDescription);
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}


//   public static boolean updateEvent(Event event) {
//        try {
//            String query = "UPDATE event SET event_name = ?, venue = ?, Organizer_id = ?, event_date = ?, event_description = ? WHERE event_id = ?";
//          PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
//            statement.setString(1, event.eventName);
//           statement.setInt(2, event.venueId);
//         statement.setInt(3, event.organizerId);
//            statement.setDate(4, event.eventDate);
//           statement.setString(5, event.eventDescription);
//           statement.setInt(6, event.eventId);
//           int rowsUpdated = statement.executeUpdate();
//           return rowsUpdated > 0;
//       } catch (SQLException e) {
//           e.printStackTrace();
//       }
//           return false;
//       }
   public static List<Event> getCompletedEvents() {
    List<Event> completedEvents = new ArrayList<>();
    String query = "SELECT * FROM event WHERE event_date < CURDATE()";

    try (Connection connection = DatabaseManager.getInstance().getConnection();
         PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int eventId = resultSet.getInt("event_id");
            String eventName = resultSet.getString("name");
            int venueId = resultSet.getInt("venue_id");
            int organizerId = resultSet.getInt("organizer_id");
            Date eventDate = resultSet.getDate("event_date");
            String eventDescription = resultSet.getString("event_description");
            Event event = new Event(eventId, eventName, venueId, organizerId, eventDate, eventDescription);
            completedEvents.add(event);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return completedEvents;
}
   
   public static boolean deleteEvent(int eventId) {
 try {
 String query = "DELETE FROM event WHERE event_id = ?";
 PreparedStatement statement = 
DatabaseManager.getInstance().getConnection().prepareStatement(query);
 statement.setInt(1, eventId);
 
 int rowsDeleted = statement.executeUpdate();
 return rowsDeleted > 0;
 } catch (SQLException e) {
 e.printStackTrace();
 }
 return false;
}

   public static boolean isEventOver(int eventId) {
        try {
            Event event = getEventById(eventId);
            if (event != null) {
                LocalDate eventDate = event.getEventDate().toLocalDate();
                LocalDate today = LocalDate.now();
                return today.isAfter(eventDate);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return false; // Return false if the event with the given ID is not found or if an exception occurs
    }
   public static boolean isFeedbackSubmitted(int eventId, int participantId) {
    try {
        // Create SQL query to check if feedback is already submitted
        String query = "SELECT COUNT(*) FROM feedback WHERE event_id = ? AND participant_id = ?";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

        // Set parameters for the query
        statement.setInt(1, eventId);
        statement.setInt(2, participantId);

        // Execute the query to count the number of rows
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }

        // Close the statement and result set
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
   
   
   
   


//    }

//    public static Event getEventById(int eventId) {
//        // Code to retrieve event from database by ID
//    }

    public Event(int i, String text, String text0, String text1, int organizerId, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    private Event(int id, String name, String venue, int organizer_id, Date event_date, String event_description) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}