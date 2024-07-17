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
public class FeedbackSummary {
    public int feedbackId;
    public int eventId;
    public int participantId;
    public int rating;
    public String comments;
    public Date feedbackDate;
    public String eventName;

    public FeedbackSummary(int feedbackId, int eventId, int participantId, int rating, String comments, Date feedbackDate, String eventName) {
        this.feedbackId = feedbackId;
        this.eventId = eventId;
        this.participantId = participantId;
        this.rating = rating;
        this.comments = comments;
        this.feedbackDate = feedbackDate;
        this.eventName = eventName;
    }
    
    public static List<FeedbackSummary> getAllFeedbackWithEventNamesForOrganizer(int organizerId) {
    List<FeedbackSummary> feedbackList = new ArrayList<>();
    try {
        String query = "SELECT f.feedback_id, f.event_id, f.participant_id, f.rating, f.comments, f.feedback_date, e.name as event_name " +
                       "FROM feedback f " +
                       "JOIN event e ON f.event_id = e.event_id " +
                       "WHERE e.organizer_id = ? " + // Filter by organizer ID
                       "GROUP BY e.name";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
        statement.setInt(1, organizerId); // Set organizer ID parameter
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int feedbackId = resultSet.getInt("feedback_id");
            int eventId = resultSet.getInt("event_id");
            int participantId = resultSet.getInt("participant_id");
            int rating = resultSet.getInt("rating");
            String comments = resultSet.getString("comments");
            Date feedbackDate = resultSet.getDate("feedback_date");
            String eventName = resultSet.getString("event_name");

            FeedbackSummary feedbackSummary = new FeedbackSummary(feedbackId, eventId, participantId, rating, comments, feedbackDate, eventName);
            feedbackList.add(feedbackSummary);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return feedbackList;
}


    // Getters and setters
}

