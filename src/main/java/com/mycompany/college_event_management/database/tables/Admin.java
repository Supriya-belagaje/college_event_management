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
public class Admin {
    public String adminUsername;
    public String adminPassword;
    public Admin( String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }
    public static Admin getAdminByUsername(String username) {
        try {
            ResultSet rs = DatabaseManager.getInstance().executeQuery("SELECT * FROM Admin WHERE admin_username = '" + username + "'");
            if (rs.next()) {
                return new Admin(
                        
                        rs.getString("admin_username"),
                        rs.getString("admin_password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if organizer with given username not found
    }
}

