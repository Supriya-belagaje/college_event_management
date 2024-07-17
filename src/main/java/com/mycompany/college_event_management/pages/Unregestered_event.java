/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.EventTableModel;
import com.mycompany.college_event_management.database.AppState;
import com.mycompany.college_event_management.database.tables.Event;
import com.mycompany.college_event_management.database.tables.Venue;
import com.mycompany.college_event_management.database.tables.Register;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author supru
 */
public class Unregestered_event extends javax.swing.JFrame {
private List<String> items = new ArrayList<>();
    /**
     * Creates new form Unregestered_event
     */
    public Unregestered_event() {
        initComponents();
                setExtendedState(JFrame.MAXIMIZED_BOTH);

        fetchEvents();
    }
//    private void fetchEvents(){
//        var allEvents = Event.getEventsWithoutParticipants();
//        System.err.println("allEvents" + allEvents.size());
//        //Table
//        EventTableModel model = new EventTableModel(allEvents);
//        eventtab.setModel(model);
//        
//        //Pannel with delete
//        for (Event e : allEvents) {
//          items.add(e.eventName);
//        }
//        refreshItemList();
//    }
//    
//    private void refreshItemList() {
//        eventlist.removeAll();
//
//        for (String item : items) {
//            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//            JLabel itemLabel = new JLabel(item);
//            JButton deleteButton = new JButton("Delete");
//            deleteButton.addActionListener((ActionEvent e) -> {
//                items.remove(item);
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
//        if (items.isEmpty()) {
//            eventlist.add(new JLabel("No items available."));
//        }
//    }
    private void fetchEvents(){
        var allEvents = Event.getAllEvents();
        System.err.println("allEvents" + allEvents.size());
        //Table
        EventTableModel model = new EventTableModel(allEvents);
        eventtab.setModel(model);
        
        //Pannel with delete
        for (Event e : allEvents) {
          items.add(e.eventName);
        }
        refreshItemList();
    }
    
    private void refreshItemList() {
        eventlist.removeAll();

        for (String item : items) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel itemLabel = new JLabel(item);
            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener((ActionEvent e) -> {
                items.remove(item);
                refreshItemList();
                // Revalidate and repaint to ensure UI updates are displayed
                eventlist.revalidate();
                eventlist.repaint();
            });

            itemPanel.add(itemLabel);
            itemPanel.add(deleteButton);
            eventlist.add(itemPanel);
            System.out.println("added "+ item);
        }

        // In case the list is empty, show a message
        if (items.isEmpty()) {
            eventlist.add(new JLabel("No items available."));
        }
    }
    private void refreshUnregisteredEventsTable() {
    // Get the list of unregistered events
    List<Event> unregisteredEvents = Event.getEventsWithoutParticipants();
    
    // Update the table model with the new list of unregistered events
    EventTableModel model = (EventTableModel) eventtab.getModel();
    model.setRowCount(0); // Clear the table
    for (Event event : unregisteredEvents) {
        model.addRow(new Object[]{event.eventId, event.eventName, event.venueId, event.organizerId, event.eventDate, event.eventDescription});
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
        register = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventtab = new javax.swing.JTable();
        eventlist = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Event list");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 137, -1));

        register.setText("Register");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));

        eventtab.setModel(new javax.swing.table.DefaultTableModel(
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
        eventtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventtabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(eventtab);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 420));

        javax.swing.GroupLayout eventlistLayout = new javax.swing.GroupLayout(eventlist);
        eventlist.setLayout(eventlistLayout);
        eventlistLayout.setHorizontalGroup(
            eventlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        eventlistLayout.setVerticalGroup(
            eventlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(eventlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 30, 30));

        jButton3.setText("Back");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 520, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        participant_home r = new participant_home();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void eventtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventtabMouseClicked
        // TODO add your handling code here:
//        int row = eventtab.getSelectedRow();
//    if (row != -1) {
//        // Retrieve the table model from the event table
//        DefaultTableModel model = (DefaultTableModel) eventtab.getModel();
//        // Extract data from the selected row and populate the corresponding fields
//        eventId.setText(model.getValueAt(row, 0).toString());
//        eventname.setText(model.getValueAt(row, 1).toString());
//        venueid.setText(model.getValueAt(row, 2).toString());
//        orgid.setText(model.getValueAt(row, 3).toString());
//        date.setText(model.getValueAt(row, 4).toString());
//        desc.setText(model.getValueAt(row, 5).toString());
//    }
    }//GEN-LAST:event_eventtabMouseClicked

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        // TODO add your handling code here:
        
       int selectedRow = eventtab.getSelectedRow();
if (selectedRow != -1) { 
    // Retrieve the eventId from the selected row
    EventTableModel model = (EventTableModel) eventtab.getModel();
    int eventId = (int) model.getValueAt(selectedRow, 0); // Assuming eventId is in the first column (index 0)

    // Retrieve the participantId from the logged-in participant
    int participantId = AppState.logedingpart.getParticipantId();

    // Create a new registration object
    Register rej = new Register(0, eventId, participantId);

    // Attempt to register the participant for the event
    boolean registrationSuccessful = Register.insertreg(rej);
    // Check if registration was successful
    if (registrationSuccessful) {
        JOptionPane.showMessageDialog(this, "Participant registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        refreshUnregisteredEventsTable(); // Refresh the table if needed
    } else {
        JOptionPane.showMessageDialog(this, "Participant is already registered for this event.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    // If no row is selected, display a message to the user
    JOptionPane.showMessageDialog(this, "Please select an event", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_registerMouseClicked

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
            java.util.logging.Logger.getLogger(Unregestered_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Unregestered_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Unregestered_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Unregestered_event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Unregestered_event().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel eventlist;
    private javax.swing.JTable eventtab;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton register;
    // End of variables declaration//GEN-END:variables
}
