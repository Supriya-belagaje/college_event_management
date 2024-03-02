/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;

/**
 *
 * @author supru
 */

import com.mycompany.college_event_management.database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Organizer {
    public int organizerId;
    public String organizerName;
    public String organizerPhone;
    public String organizerUsername;
    public String organizerPassword;

    public Organizer(int organizerId, String organizerName, String organizerPhone, String organizerUsername, String organizerPassword) {
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerPhone = organizerPhone;
        this.organizerUsername = organizerUsername;
        this.organizerPassword = organizerPassword;
    }


    // Static method to fetch an organizer by ID
    public static Organizer getOrganizerById(int id) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Organizer WHERE organizer_id = " + id);
            if (rs.next()) {
                return new Organizer(
                        rs.getInt("organizer_id"),
                        rs.getString("organizer_name"),
                        rs.getString("organizer_phone"),
                        rs.getString("orgasizer_username"),
                        rs.getString("organizer_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given ID not found
    }

    // Static method to fetch an organizer by username
    public static Organizer getOrganizerByUsername(String username) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Organizer WHERE orgasizer_username = '" + username + "'");
            if (rs.next()) {
                return new Organizer(
                        rs.getInt("organizer_id"),
                        rs.getString("organizer_name"),
                        rs.getString("organizer_phone"),
                        rs.getString("orgasizer_username"),
                        rs.getString("organizer_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given username not found
    }
}

