/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.Utils;

import com.mycompany.college_event_management.database.tables.Venue;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author supru
 */
public class VenueTableModel extends AbstractTableModel {
    private final List<Venue> venue;
    private final String[] columnNames = {"Venue ID", "Venue Name", "Venue Capacity"};

    public VenueTableModel(List<Venue> venue) {
        this.venue = venue;
    }

    @Override
    public int getRowCount() {
        return venue.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venue ve = venue.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ve.venueId;
            case 1:
                return ve.Name;
            case 2:
                return ve.Capacity;
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
}
