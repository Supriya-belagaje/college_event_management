/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.Utils;

/**
 *
 * @author supru
 */
import com.mycompany.college_event_management.database.tables.Event;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Date;

// Assuming the Event class is defined as mentioned
public class EventTableModel extends AbstractTableModel {

    private final List<Event> events;
    private final String[] columnNames = {"Event ID", "Event Name", "Venue", "Organizer ID", "Event Date", "Description"};

    public EventTableModel(List<Event> events) {
        this.events = events;
    }

    @Override
    public int getRowCount() {
        return events.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Event event = events.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return event.eventId;
            case 1:
                return event.eventName;
            case 2:
                return event.venue;
            case 3:
                return event.organizerId;
            case 4:
                return event.eventDate;
            case 5:
                return event.eventDescription;
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // If you want the date column to display in a specific format, you can override this method
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) {
            return Date.class; // Ensures the date is displayed in your JTable's default date format
        }
        return Object.class;
    }
}
