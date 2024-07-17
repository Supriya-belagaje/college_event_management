/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.EventTableModel;
import com.mycompany.college_event_management.database.tables.Event;
import static com.mycompany.college_event_management.database.tables.Event.deleteEvent;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Eventlist_admin extends javax.swing.JFrame {

    /**
     * Creates new form Eventlist_admin
     */
    private List<String> items = new ArrayList<>();
    public Eventlist_admin() {
        initComponents();
                setExtendedState(JFrame.MAXIMIZED_BOTH);

        fetchEvents();
    }
        private void fetchEvents(){
        var allEvents = Event.getAllEvents();
        System.err.println("allEvents" + allEvents.size());
        //Table
        EventTableModel model = new EventTableModel(allEvents);
        eventtab.setModel(model);
        
        //Pannel with delete
//        for (Event e : allEvents) {
//          items.add(e.eventName);
//        }
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
    private void clearInputFields() {
    // Clear the input fields to prepare for the next update
    event_id.setText("");
    Event_Name.setText("");
    Venue_id.setText("");
    Org_id.setText("");
    date.setText(null);
    Description.setText("");
}
//private void refreshEventTable() {
//    // Assuming you have a table model for events named eventTableModel
//    List<Event> eventData = Event.getAllEvents(); // Fetch the latest event data from the database
//EventTableModel.setEventData(eventData); // Set the updated event data to the table model
//EventTableModel.fireTableDataChanged(); // Notify the table that the data has changed
// // Notify the table that the data has changed
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
        jScrollPane2 = new javax.swing.JScrollPane();
        eventtab = new javax.swing.JTable();
        eventlist = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        event_id = new javax.swing.JTextField();
        Event_Name = new javax.swing.JTextField();
        Org_id = new javax.swing.JTextField();
        Venue_id = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 510, -1));
        jPanel1.add(eventlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        back.setText("back");
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
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 550, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("All Events");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 210, -1));

        event_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        event_id.setText("Event_id");
        event_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                event_idActionPerformed(evt);
            }
        });
        jPanel1.add(event_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        Event_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Event_Name.setText("Event_Name");
        Event_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Event_NameActionPerformed(evt);
            }
        });
        jPanel1.add(Event_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        Org_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Org_id.setText("Org_id");
        Org_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Org_idActionPerformed(evt);
            }
        });
        jPanel1.add(Org_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        Venue_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Venue_id.setText("Venue_id");
        Venue_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Venue_idActionPerformed(evt);
            }
        });
        jPanel1.add(Venue_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        date.setText("Date");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Description");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Venue_id");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Org_id");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Event_Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Event_id");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        Description.setColumns(20);
        Description.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Description.setRows(5);
        Description.setText("Description");
        jScrollPane1.setViewportView(Description);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 230, 50));

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });
        jPanel1.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, -1, -1));

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1720, 1220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        admin_home home = new admin_home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void event_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_event_idActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            
    int eventId = Integer.parseInt(event_id.getText());
    String eventName = Event_Name.getText();
    int venueId = Integer.parseInt(Venue_id.getText());
    int organizerId = Integer.parseInt(Org_id.getText());
    String eventDateText = date.getText(); // Assuming date is a JTextField for entering the event date as text
    String eventDescription = Description.getText();

    // Parse event date
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format according to your text field input format
    java.util.Date utilDate = dateFormat.parse(eventDateText); // Parse the input date string
    long milliseconds = utilDate.getTime(); // Get the number of milliseconds since January 1, 1970, 00:00:00 GMT
    java.sql.Date eventDate = new java.sql.Date(milliseconds); 

    // Create an Event object with the updated details
    Event updatedEvent = new Event(eventId, eventName, venueId, organizerId, eventDate, eventDescription);
    
    // Call the updateEvent method to update the event in the database
    boolean updateSuccessful = Event.updateEvent(updatedEvent);
    
    // Check if the update was successful and display appropriate message
    if (updateSuccessful) {
        JOptionPane.showMessageDialog(this, "Event updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        // Optionally, you can clear the input fields or perform other actions after successful update
        clearInputFields();
    } else {
        JOptionPane.showMessageDialog(this, "Failed to update event. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
} catch (NumberFormatException | ParseException e) {
    // Handle the case where parsing fails or date string is invalid
    e.printStackTrace(); // Log the exception or display an error message to the user
    JOptionPane.showMessageDialog(this, "Invalid input. Please check your inputs and try again.", "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_UpdateActionPerformed

    private void Event_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Event_NameActionPerformed

    private void Org_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Org_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Org_idActionPerformed

    private void Venue_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Venue_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Venue_idActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void eventtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventtabMouseClicked
        // TODO add your handling code here:
        // Assuming this code is inside an ActionListener or a ListSelectionListener
int selectedRowIndex = eventtab.getSelectedRow();
if (selectedRowIndex != -1) {
    int eventId = (int) eventtab.getValueAt(selectedRowIndex, 0);
    String eventName = (String) eventtab.getValueAt(selectedRowIndex, 1);
    int venueId = (int) eventtab.getValueAt(selectedRowIndex, 2);
    int organizerId = (int) eventtab.getValueAt(selectedRowIndex, 3);
    Date eventDate = (Date) eventtab.getValueAt(selectedRowIndex, 4);
    String eventDescription = (String) eventtab.getValueAt(selectedRowIndex, 5);

    event_id.setText(String.valueOf(eventId));
    Event_Name.setText(eventName);
    Venue_id.setText(String.valueOf(venueId));
    Org_id.setText(String.valueOf(organizerId));
    date.setText(eventDate.toString());
    Description.setText(eventDescription);
} else {
    // Clear text fields if no row is selected
    clearInputFields();
}

    }//GEN-LAST:event_eventtabMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete this event?", "Confirmation",
        JOptionPane.YES_NO_OPTION);

if (confirmed == JOptionPane.YES_OPTION) {
    int eventIdToDelete = Integer.parseInt(event_id.getText()); // Assuming eventIdTextField is the field where the user enters the event ID

    // Call the deleteEvent method to delete the event
    boolean deletionSuccessful = deleteEvent(eventIdToDelete);

    // Check if the deletion was successful and show appropriate message
    if (deletionSuccessful) {
        JOptionPane.showMessageDialog(this, "Event deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Optionally, you can clear the input fields or update the UI after deletion
        clearInputFields();
        //refreshEventData(); // Update the table or UI to reflect the deletion
    } else {
        JOptionPane.showMessageDialog(this, "Failed to delete event. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Eventlist_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eventlist_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eventlist_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eventlist_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Eventlist_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextArea Description;
    private javax.swing.JTextField Event_Name;
    private javax.swing.JTextField Org_id;
    private javax.swing.JButton Update;
    private javax.swing.JTextField Venue_id;
    private javax.swing.JButton back;
    private javax.swing.JTextField date;
    private javax.swing.JTextField event_id;
    private javax.swing.JPanel eventlist;
    private javax.swing.JTable eventtab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void updateEvent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
