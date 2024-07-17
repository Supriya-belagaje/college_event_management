/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.MD5;
import com.mycompany.college_event_management.database.tables.Participant;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name.setText("Name");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 170, 135, -1));

        phone.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        phone.setText("Phone");
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 220, 135, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        email.setText("Email");
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 270, 135, -1));

        user_name.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        user_name.setText("Username");
        getContentPane().add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 320, 135, -1));

        password.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        password.setText("Password");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 370, 135, -1));

        enter_name.setBackground(new java.awt.Color(255, 255, 204));
        enter_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(enter_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, 180, -1));

        enter_phone.setBackground(new java.awt.Color(255, 255, 204));
        enter_phone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        enter_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enter_phoneActionPerformed(evt);
            }
        });
        getContentPane().add(enter_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 220, 180, -1));

        enter_email.setBackground(new java.awt.Color(255, 255, 204));
        enter_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(enter_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 270, 180, -1));

        enter_username.setBackground(new java.awt.Color(255, 255, 204));
        enter_username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(enter_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 320, 180, -1));

        PASSWORD.setBackground(new java.awt.Color(255, 255, 204));
        PASSWORD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PASSWORD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PASSWORDActionPerformed(evt);
            }
        });
        getContentPane().add(PASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 370, 180, -1));

        signup.setBackground(new java.awt.Color(255, 255, 204));
        signup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signup.setText("Sign up");
        signup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupMouseClicked(evt);
            }
        });
        getContentPane().add(signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 490, -1, -1));

        cancel.setBackground(new java.awt.Color(255, 255, 204));
        cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
        getContentPane().add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 490, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Signup as a participant");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 80, -1, -1));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Want to organize an Event?");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText(" For more informations contact an admin....");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("admin@gmail.com");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 1000));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 620, 1000));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupMouseClicked
        // TODO add your handling code here:
        // Hash the password before inserting it into the database
        String hashedPassword = MD5.hashPassword(PASSWORD.getText());
        if(enter_name!=null && enter_phone!=null && enter_email!=null && enter_username!=null){
        Participant part = new Participant(0, enter_name.getText(),enter_phone.getText(),enter_email.getText(),enter_username.getText(),hashedPassword);
        part.insertIntoParticipant(part);
        JOptionPane.showMessageDialog(this, "Signup successful", "Success", JOptionPane.INFORMATION_MESSAGE);
        Login LPage = new Login();
                    LPage.setVisible(true);
                    this.dispose();
        }
        else
            JOptionPane.showMessageDialog(this, "Signup unsuccessful", "error", JOptionPane.INFORMATION_MESSAGE);
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

    private void enter_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enter_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enter_phoneActionPerformed

    private void PASSWORDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PASSWORDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PASSWORDActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel password;
    private javax.swing.JLabel phone;
    private javax.swing.JButton signup;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}