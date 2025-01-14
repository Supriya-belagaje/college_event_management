/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.MD5;
import com.mycompany.college_event_management.database.tables.Organizer;
import com.mycompany.college_event_management.database.tables.Participant;
import javax.swing.JFrame;

/**
 *
 * @author supru
 */
public class p_signup extends javax.swing.JFrame {

    /**
     * Creates new form p_signup
     */
    public p_signup() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        enter_name = new javax.swing.JTextField();
        enter_phone = new javax.swing.JTextField();
        enter_email = new javax.swing.JTextField();
        enter_username = new javax.swing.JTextField();
        PASSWORD = new javax.swing.JPasswordField();
        signup = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setText("Name");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 51, 135, -1));

        phone.setText("Phone");
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, 135, -1));

        email.setText("Email");
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 119, 135, -1));

        user_name.setText("User_name");
        getContentPane().add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 153, 135, -1));

        password.setText("Password");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 187, 135, -1));

        enter_name.setText("jTextField1");
        getContentPane().add(enter_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 45, 71, -1));

        enter_phone.setText("jTextField2");
        getContentPane().add(enter_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 79, 71, -1));

        enter_email.setText("jTextField3");
        getContentPane().add(enter_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 113, 71, -1));

        enter_username.setText("jTextField4");
        getContentPane().add(enter_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 147, 71, -1));

        PASSWORD.setText("jPasswordField1");
        getContentPane().add(PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 181, -1, -1));

        signup.setText("Sign up");
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 263, -1, -1));

        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 6, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        // TODO add your handling code here:
        // Hash the password before inserting it into the database
        String hashedPassword = MD5.hashPassword(PASSWORD.getText());
        Participant part = new Participant(0, enter_name.getText(),enter_phone.getText(),enter_email.getText(),enter_username.getText(),hashedPassword);
        part.insertIntoParticipant(part);
        Login LPage = new Login();
                    LPage.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_signupMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
                    Login LPage = new Login();
                    LPage.setVisible(true);
                    this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

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
            java.util.logging.Logger.getLogger(p_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(p_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(p_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(p_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new p_signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PASSWORD;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel email;
    private javax.swing.JTextField enter_email;
    private javax.swing.JTextField enter_name;
    private javax.swing.JTextField enter_phone;
    private javax.swing.JTextField enter_username;
    private javax.swing.JLabel name;
    private javax.swing.JLabel password;
    private javax.swing.JLabel phone;
    private javax.swing.JButton signup;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
