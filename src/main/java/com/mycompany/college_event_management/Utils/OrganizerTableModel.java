/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.Utils;

/**
 *
 * @author supru
 */
import com.mycompany.college_event_management.database.tables.Organizer;
import javax.swing.table.AbstractTableModel;
import java.util.List;
public class OrganizerTableModel extends AbstractTableModel {
    private final List<Organizer> orgs;
    private final String[] columnNames = {"Organizer ID", "Orgnizer Name", "Organizer phone", "Organizer email", "Username"};

    public OrganizerTableModel(List<Organizer> orgs) {
        this.orgs = orgs;
    }

    @Override
    public int getRowCount() {
        return orgs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Organizer org = orgs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return org.organizerId;
            case 1:
                return org.organizerName;
            case 2:
                return org.organizerPhone;
            case 3:
                return org.organizeremail;
            case 4:
                return org.organizerUsername;
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}