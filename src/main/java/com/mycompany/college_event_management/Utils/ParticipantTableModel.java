/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.Utils;

import com.mycompany.college_event_management.database.tables.Participant;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author supru
 */
public class ParticipantTableModel extends AbstractTableModel {
     private final List<Participant> parts;
    private final String[] columnNames = {"Participant ID", "Participant Name", "Participant phone", "Participant email", "Username"};

    public ParticipantTableModel(List<Participant> parts) {
        this.parts = parts;
    }

    @Override
    public int getRowCount() {
        return parts.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Participant event = parts.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return event.ParticipantId;
            case 1:
                return event.ParticipantName;
            case 2:
                return event.ParticipantPhone;
            case 3:
                return event.Participantemail;
            case 4:
                return event.ParticipantUsername;
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
