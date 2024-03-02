/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.college_event_management;

import com.mycompany.college_event_management.pages.Login;

/**
 *
 * @author supru
 */
public class College_event_management {

    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
         
    }
}
