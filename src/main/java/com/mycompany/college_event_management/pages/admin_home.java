/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.EventTableModel;
import com.mycompany.college_event_management.Utils.OrganizerTableModel;
import com.mycompany.college_event_management.database.tables.Event;
import com.mycompany.college_event_management.database.tables.Organizer;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author supru
 */
public class admin_home extends javax.swing.JFrame {
//private List<String> Eventitems = new ArrayList<>();
//private List<String> org = new ArrayList<>();
//private List<String> organizerItems = new ArrayList<>();
    /**
     * Creates new form admin_home
     */
    public admin_home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

//        fetchRegisteredEvents();
        //fetchRegisteredOrganizers();
    }
//private void fetchRegisteredEvents(){
//        var allEvents = Event.getAllEvents();
//        System.err.println("allEvents" + allEvents.size());
//        //Table
//        EventTableModel model = new EventTableModel(allEvents);
//        eventtab.setModel(model);
//        
//        //Pannel with delete
//        for (Event e : allEvents) {
//          Eventitems.add(e.eventName);
//        }
//        refreshItemList();
//    }
//    
//    private void refreshItemList() {
//        eventlist.removeAll();
//
//        for (String item : Eventitems) {
//            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//            JLabel itemLabel = new JLabel(item);
//            JButton deleteButton = new JButton("Delete");
//            deleteButton.addActionListener((ActionEvent e) -> {
//                Eventitems.remove(item);
//                refreshItemList();
//                // Revalidate and repaint to ensure UI updates are displayed
//                eventlist.revalidate();
//                eventlist.repaint();
//            });
//
//            itemPanel.add(itemLabel);
//            itemPanel.add(deleteButton);
//            eventlist.add(itemPanel);
//            System.out.println("added "+ item);
//        }
//
//        // In case the list is empty, show a message
//        if (Eventitems.isEmpty()) {
//            eventlist.add(new JLabel("No items available."));
//        }
//    }
//    private void fetchRegisteredOrganizers() {
//    var allOrganizers = organizer.getAllOrganizers();
//    OrganizerTableModel model = new OrganizerTableModel(allOrganizers);
//    organizertab.setModel(model);
//    
//    for (organizer org : allOrganizers) {
//        org.add(org.organizerName); // Assuming 'name' is the field representing the organizer's name
//    }
//    
//    refresh();
//}
//
//    private void refresh() {
//    orglist.removeAll();
//
//    for (String item : organizerItems) {
//        JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        JLabel itemLabel = new JLabel(item);
//        JButton deleteButton = new JButton("Delete");
//        deleteButton.addActionListener((ActionEvent e) -> {
//            organizerItems.remove(item);
//            refreshItemList();
//            // Revalidate and repaint to ensure UI updates are displayed
//            orglist.revalidate();
//            orglist.repaint();
//        });
//
//        itemPanel.add(itemLabel);
//        itemPanel.add(deleteButton);
//        orglist.add(itemPanel);
//        System.out.println("added " + item);
//    }
//
//    // In case the list is empty, show a message
//    if (organizerItems.isEmpty()) {
//        orglist.add(new JLabel("No items available."));
//    }
//}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        partsview = new javax.swing.JButton();
        OrgView = new javax.swing.JButton();
        Venue = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        event_view = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        partsview.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        partsview.setText("View Participants");
        partsview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partsviewMouseClicked(evt);
            }
        });
        partsview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partsviewActionPerformed(evt);
            }
        });
        jPanel1.add(partsview, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 230, 60));

        OrgView.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrgView.setText("View Organizers");
        OrgView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrgViewMouseClicked(evt);
            }
        });
        OrgView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrgViewActionPerformed(evt);
            }
        });
        jPanel1.add(OrgView, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 230, 60));

        Venue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Venue.setText("View Venue");
        Venue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VenueMouseClicked(evt);
            }
        });
        Venue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenueActionPerformed(evt);
            }
        });
        jPanel1.add(Venue, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 230, 60));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Admin Panel");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 350, -1));

        back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 540, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        event_view.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        event_view.setText("View Events");
        event_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                event_viewMouseClicked(evt);
            }
        });
        event_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event_viewActionPerformed(evt);
            }
        });
        jPanel3.add(event_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 230, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 730, 290));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 800));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 210, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void event_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_event_viewMouseClicked
        // TODO add your handling code here:
        Eventlist_admin elist = new Eventlist_admin();
        elist.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_event_viewMouseClicked

    private void event_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event_viewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_event_viewActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        Login homePage = new Login();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void OrgViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrgViewMouseClicked
        // TODO add your handling code here:
        organizer_list org = new organizer_list();
        org.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_OrgViewMouseClicked

    private void OrgViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrgViewActionPerformed
        // TODO add your handling code here:
//        participantlist part = new participantlist();
//        part.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_OrgViewActionPerformed

    private void partsviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partsviewMouseClicked
        // TODO add your handling code here:
        Participant_list part = new Participant_list();
        part.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_partsviewMouseClicked

    private void partsviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partsviewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partsviewActionPerformed

    private void VenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VenueMouseClicked
        // TODO add your handling code here:
        Venuelist venue = new Venuelist();
        venue.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_VenueMouseClicked

    private void VenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenueActionPerformed

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
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OrgView;
    private javax.swing.JButton Venue;
    private javax.swing.JButton back;
    private javax.swing.JButton event_view;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton partsview;
    // End of variables declaration//GEN-END:variables
}
