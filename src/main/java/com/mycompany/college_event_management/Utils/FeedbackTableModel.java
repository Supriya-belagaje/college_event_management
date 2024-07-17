/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.Utils;

import com.mycompany.college_event_management.database.tables.Event;
import com.mycompany.college_event_management.database.tables.feedback;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author supru
 */

public class FeedbackTableModel extends AbstractTableModel {
private final List<feedback> feedbacks;
    //private final String[] columnNames = {'feedback_id' ,'event_id', 'participant_id', 'rating', 'comments', 'feedback_date'};
    private final String[] columnNames = {"feedback_id", "event_id", "participant_id", "rating ", "comments", "feedback_date"};

    public FeedbackTableModel(List<feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }
    @Override
    public int getRowCount() {
        return feedbacks.size();
    }

    @Override
    public int getColumnCount() {
return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    // Check if the row index is within the bounds of the feedbacks list
    if (rowIndex < 0 || rowIndex >= feedbacks.size()) {
        return null;
    }

    feedback feed = feedbacks.get(rowIndex);
    switch (columnIndex) {
        case 0:
            return feed.feedbackId;
        case 1:
            return feed.eventId;
        case 2:
            return feed.participantId;
        case 3:
            return feed.rating;
        case 4:
            return feed.comments;
        case 5:
            return feed.feedbackDate;
        default:
            return null;
    }
}
    
}
