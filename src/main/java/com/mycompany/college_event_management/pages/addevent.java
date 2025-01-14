/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.EventTableModel;
import com.mycompany.college_event_management.Utils.VenueTableModel;
import com.mycompany.college_event_management.database.AppState;
import com.mycompany.college_event_management.database.tables.Event;
import com.mycompany.college_event_management.database.tables.Venue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author supru
 */
public class addevent extends javax.swing.JFrame {
private List<String> items = new ArrayList<>();
    /**
     * Creates new form addevent
     */
    public addevent() {
        initComponents();
        fetchvenue();
    }
//    private void fetchvenue(){
        private void fetchvenue(){
        var Allvenue = Venue.getAllVenue();
        System.err.println("allParticipants" + Allvenue.size());
        //Table
        VenueTableModel model = new VenueTableModel(Allvenue);
        venuetab.setModel(model);
                setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Pannel with delete
        for (Venue p : Allvenue) {
          items.add(p.Name);
        }
        refreshItemList();
    }
    private void refreshItemList() {
        venuelist.removeAll();

        for (String item : items) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel itemLabel = new JLabel(item);
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener((ActionEvent e) -> {
                items.remove(item);
                refreshItemList();
                // Revalidate and repaint to ensure UI updates are displayed
                venuelist.revalidate();
                venuelist.repaint();
            });

            itemPanel.add(itemLabel);
            itemPanel.add(deleteButton);
            venuelist.add(itemPanel);
            System.out.println("added "+ item);
        }

        // In case the list is empty, show a message
        if (items.isEmpty()) {
            venuelist.add(new JLabel("No items available."));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        submit = new javax.swing.JButton();
        vid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namelab = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        venuelist = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        venuetab = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.MatteBorder(null)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane2.setViewportView(desc);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 308, -1, -1));

        submit.setText("Submit");
        submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitMouseClicked(evt);
            }
        });
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel2.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, -1));

        vid.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        vid.setText("venue Id");
        jPanel2.add(vid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 142, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Date");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 80, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Venue Id");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, -1));

        namelab.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namelab.setText("Event Name");
        jPanel2.add(namelab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, -1));

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.setText("Name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, -1));

        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setText("date");
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 120, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Description");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 380, 460));

        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 590, -1, -1));
        jPanel1.add(venuelist, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 10, 10));

        venuetab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(venuetab);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, 450));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Create Event");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1750, 1010));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
                org_homepage org = new org_homepage();
                org.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

    private void submitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitMouseClicked
        // TODO add your handling code here:
       try {
    int venueId = Integer.parseInt(vid.getText());
    // Parse the date string to convert it into a java.sql.Date object
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date utilDate = dateFormat.parse(date.getText());
    java.sql.Date eventDate = new java.sql.Date(utilDate.getTime());

    // Use the organizer ID from the logged-in organizer
    int organizerId = AppState.logedinOrg.getOrganizerId();
    
    Event ev = new Event(0, name.getText(), venueId, organizerId, eventDate, desc.getText());
    boolean inserted = Event.insertEvent(ev);
    
    if (inserted) {
        JOptionPane.showMessageDialog(this, "Event inserted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        org_homepage homePage = new org_homepage();
        homePage.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to insert event.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integer values for venue ID and organizer ID.", "Error", JOptionPane.ERROR_MESSAGE);
} catch (ParseException e) {
    JOptionPane.showMessageDialog(this, "Invalid date format. Please enter date in YYYY-MM-DD format.", "Error", JOptionPane.ERROR_MESSAGE);
} catch (IllegalArgumentException e) {
    e.printStackTrace(); // Handle any other exceptions
}



    }//GEN-LAST:event_submitMouseClicked

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
            java.util.logging.Logger.getLogger(addevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addevent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addevent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField date;
    private javax.swing.JTextArea desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name;
    private javax.swing.JLabel namelab;
    private javax.swing.JButton submit;
    private javax.swing.JPanel venuelist;
    private javax.swing.JTable venuetab;
    private javax.swing.JTextField vid;
    // End of variables declaration//GEN-END:variables
}
