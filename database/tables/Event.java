/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;
import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author supru
 */
public class Event {
    public int eventId;
    public String eventName;
    public String venue;
    public int organizerId;
    public Date eventDate;
    public String eventDescription;

    public Event(int eventId, String eventName, String venue, int organizerId, String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.venue = venue;
        this.organizerId = organizerId;
        this.eventDate = new Date(0);
        this.eventDescription = eventDescription;
    }
    
    public static  List<Event>  getAllEvents(){
        List<Event> events = new ArrayList<>();
        try {
            String query = "SELECT * FROM event";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("event_id");
                String name = resultSet.getString("event_name");
                String venue = resultSet.getString("venue");
                int organizer_id = resultSet.getInt("Organizer_id");
                Date event_date = resultSet.getDate("event_date");
                String event_description = resultSet.getString("event_description");
                Event event = new Event(id, name, venue, organizer_id, event_description);
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    // Getters and setters

    public static boolean insertEvent(Event event) {
        try {
            String query = "INSERT INTO event (event_name, venue, Organizer_id, event_date, event_description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            statement.setString(1, event.eventName);
            statement.setString(2, event.venue);
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

//    public static boolean updateEvent(Event event) {
//        try {
//            String query = "UPDATE event SET event_name = ?, venue = ?, Organizer_id = ?, event_date = ?, event_description = ? WHERE event_id = ?";
//            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
//            statement.setString(1, event.getEventName());
//            statement.setString(2, event.getVenue());
//            statement.setInt(3, event.getOrganizerId());
//            statement.setDate(4, event.getEventDate());
//            statement.setString(5, event.getEventDescription());
//            statement.setInt(6, event.getEventId());
//            int rowsUpdated = statement.executeUpdate();
//            return rowsUpdated > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

//    public static Event getEventById(int eventId) {
//        // Code to retrieve event from database by ID
//    }

    public Event(int i, String text, String text0, String text1, int organizerId, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
