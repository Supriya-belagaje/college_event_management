package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.MD5;
import com.mycompany.college_event_management.database.AppState;
import com.mycompany.college_event_management.database.DatabaseManager;
import com.mycompany.college_event_management.database.tables.Admin;
import com.mycompany.college_event_management.database.tables.Organizer;
import com.mycompany.college_event_management.database.tables.Participant;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author supru
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/login.png")));
        //this.setSize(new Dimension(400, 300));
    }
    
     public void init() {
        try {
            // Get the singleton instance of DatabaseManager
            DatabaseManager dbManager = DatabaseManager.getInstance();
            
            // Execute a query
            ResultSet rs = dbManager.executeQuery("SELECT * FROM test");
            
            // Process the result set
            while (rs.next()) {
                // Handle each row of the result set
                String column1 = rs.getString("b");
                System.out.println(column1);
                // Process other columns as needed
            }
            
            // Close the result set
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        roleSelection = new javax.swing.JComboBox<>();
        signup = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(630, 400, 110, 20);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(630, 440, 68, 20);

        userName.setBackground(new java.awt.Color(255, 255, 204));
        userName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        getContentPane().add(userName);
        userName.setBounds(780, 400, 200, 26);

        password.setBackground(new java.awt.Color(255, 255, 204));
        password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password);
        password.setBounds(780, 440, 200, 26);

        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginButton.setText("Login");
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
        });
        getContentPane().add(LoginButton);
        LoginButton.setBounds(900, 490, 72, 27);

        roleSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Organizer", "Participant" }));
        roleSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleSelectionActionPerformed(evt);
            }
        });
        getContentPane().add(roleSelection);
        roleSelection.setBounds(720, 340, 90, 30);

        signup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signup.setText("Signup");
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(790, 510, 76, 27);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("New participant?");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(640, 510, 140, 30);

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        image.setText("jLabel5");
        image.setToolTipText("");
        getContentPane().add(image);
        image.setBounds(0, 0, 1290, 970);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:S
    }//GEN-LAST:event_userNameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void roleSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleSelectionActionPerformed
        // TODO add your handling code here:
        System.out.println(roleSelection.getSelectedItem());
    }//GEN-LAST:event_roleSelectionActionPerformed

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
       String pHash= null;
        switch(roleSelection.getSelectedItem().toString()){
           case "Admin":
               Admin ad = Admin.getAdminByUsername(userName.getText());
                if(ad == null){
                    System.out.println("Admin not found wrong user name " + userName.getText());
                    return;
                }
                pHash = MD5.hashPassword(password.getText());
                if(pHash.equals(ad.adminPassword)) {
                    System.out.println("Login successfull");
                    //Redirect to organizer page
                    admin_home adminPage = new admin_home();
                    adminPage.setVisible(true);
                    this.dispose();
                }
                else {
                    System.out.println("Wrong password");
                    //Update Error text here
                }
               break;
               
            case "Organizer":
                Organizer org = Organizer.getOrganizerByUsername(userName.getText());
                if(org == null){
                    System.out.println("Organizer not found wrong user name " + userName.getText());
                    return;
                }
                pHash = MD5.hashPassword(password.getText());
                if(pHash.equals(org.organizerPassword)) {
                    System.out.println("Login successfull");
                    AppState.logedinOrg = org;
                    //Redirect to organizer page
                    org_homepage secondPage = new org_homepage();
                    secondPage.setVisible(true);
                    this.dispose(); 
                }
                else {
                    System.out.println("Wrong password");
                    //Update Error text here
                }
               break;
            case "Participant":
                Participant part = Participant.getParticipantByUsername(userName.getText());
                if(part == null){
                    System.out.println("Participant not found!! wrong user name " + userName.getText());
                    return;
                }
                pHash = MD5.hashPassword(password.getText());
                if(pHash.equals(part.ParticipantPassword)) {
                    System.out.println("Login successfull");
                    AppState.logedingpart = part;
                    //Redirect to organizer page
                    participant_home sPage = new participant_home();
                    sPage.setVisible(true);
                    this.dispose(); 
                }
                else {
                    System.out.println("Wrong password");
                    //Update Error text here
                }
               break;
       }
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        // TODO add your handling code here:
                    p_signup signup = new p_signup();
                    signup.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_signupMouseClicked

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JComboBox<String> roleSelection;
    private javax.swing.JButton signup;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
