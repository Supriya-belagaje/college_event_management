

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author supru
 */
package com.mycompany.college_event_management.database.tables;
import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Participant {
    public int ParticipantId;
    public String ParticipantName;
    public String ParticipantPhone;
    public String ParticipantUsername;
    public String ParticipantPassword;

    public Participant(int ParticipantId, String ParticipantName, String ParticipantPhone, String ParticipantUsername, String ParticipantPassword) {
        this.ParticipantId = ParticipantId;
        this.ParticipantName = ParticipantName;
        this.ParticipantPhone = ParticipantPhone;
        this.ParticipantUsername = ParticipantUsername;
        this.ParticipantPassword = ParticipantPassword;
    }


    // Static method to fetch an organizer by ID
    public static Participant getByParticipantId(int id) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Participant WHERE Participant_id = " + id);
            if (rs.next()) {
                return new Participant(
                        rs.getInt("Participant_id"),
                        rs.getString("Participant_name"),
                        rs.getString("Participant_phone"),
                        rs.getString("Participant_username"),
                        rs.getString("Participant_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given ID not found
    }

    // Static method to fetch an organizer by username
    public static Participant getParticipantByUsername(String username) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Participant WHERE Participant_username = '" + username + "'");
            if (rs.next()) {
                return new Participant(
                        rs.getInt("Participant_id"),
                        rs.getString("Participant_name"),
                        rs.getString("Participant_phone"),
                        rs.getString("Participant_username"),
                        rs.getString("Participant_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given username not found
    }
}


