package com.mycompany.college_event_management.database.tables;

import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class feedback {
    public int feedbackId;
    public int eventId;
    public int participantId;
    public int rating;
    public String comments;
    public Date feedbackDate;
    
//    public feedback(int eventId) {
//        this.eventId = eventId;
//    }

        public feedback(int feedbackId, int eventId, int participantId, int rating, String comments, Date feedbackDate) {
        this.feedbackId = feedbackId;
        this.eventId = eventId;
        this.participantId = participantId;
        this.rating = rating;
        this.comments = comments;
        this.feedbackDate = feedbackDate;
    }
        
        


    public static List<feedback> getAllFeedback() {
        List<feedback> feedbackList = new ArrayList<>();
        try {
            String query = "SELECT * FROM feedback";
            PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int feedbackId = resultSet.getInt("feedback_id");
                int eventId = resultSet.getInt("event_id");
                int participantId = resultSet.getInt("participant_id");
                int rating = resultSet.getInt("rating");
                String comments = resultSet.getString("comments");
                Date feedbackDate = resultSet.getDate("feedback_date");

                feedback feedback = new feedback(feedbackId, eventId, participantId, rating, comments, feedbackDate);
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    public static boolean submitFeedback(int eventId, int participantId, int rating, java.lang.String comments) {
         try {
        // Create SQL query to insert feedback into the database
        String query = "INSERT INTO feedback (event_id, participant_id, rating, comments, feedback_date) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
        PreparedStatement statement = DatabaseManager.getInstance().getConnection().prepareStatement(query);

        // Set parameters for the query
        statement.setInt(1, eventId);
        statement.setInt(2, participantId);
        statement.setInt(3, rating);
        statement.setString(4, comments);

        // Execute the query to insert feedback
        int rowsInserted = statement.executeUpdate();

        // Close the statement
        statement.close();

        // Return true if feedback was inserted successfully
        return rowsInserted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false; // Return false if an error occurs
    }
}
}
