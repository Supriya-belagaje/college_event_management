/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.college_event_management.pages;

import com.mycompany.college_event_management.Utils.EventTableModel;
import com.mycompany.college_event_management.database.tables.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author supru
 */
public class Events extends javax.swing.JFrame {

    /**
     * Creates new form Events
     */
    private List<String> items = new ArrayList<>();
    public Events() {
        initComponents();
        fetchEvents();

    }
    private void fetchEvents(){
        var allEvents = Event.getEventsByOrganizerId();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventtab = new javax.swing.JTable();
        eventlist = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Events");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 96, -1));

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
        jScrollPane1.setViewportView(eventtab);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 375, 275));
        getContentPane().add(eventlist, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Events.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Events().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel eventlist;
    private javax.swing.JTable eventtab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
