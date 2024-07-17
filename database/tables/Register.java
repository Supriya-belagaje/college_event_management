/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.college_event_management.database.tables;

/**
 *
 * @author supru
 */
public class Register {
    public int organizerId;
    public String organizerName;
    public String organizerPhone;
    public String organizeremail;
    public String organizerUsername;
    public String organizerPassword;

    public Register(int organizerId, String organizerName, String organizerPhone,String organizeremail, String organizerUsername, String organizerPassword) {
        this.organizerId = organizerId;
        this.organizerName = organizerName;
        this.organizerPhone = organizerPhone;
        this.organizeremail = organizeremail;
        this.organizerUsername = organizerUsername;
        this.organizerPassword = organizerPassword;
    }

    
}
