/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import client.RequestGenerator;
import controler.Controler;
import domain.Flight;
import domain.FlightClass;
import domain.Passenger;
import domain.Reservation;
import domain.User;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import table.ModelTableFlight;
import table.ModelTableReservation;
import transfer.Operation;
import transfer.Request;

/**
 *
 * @author Aleksa
 */
public class MainForm extends javax.swing.JFrame {

    DialogFlight df;
    DialogPassenger dp;

    boolean newPassenger = false;
    Reservation reservation;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
        Controler.getInstance().setMf(this);
        lblLoggedUser.setText(Controler.getInstance().getLoggedUser().getLastName() + " " + Controler.getInstance().getLoggedUser().getFirstName());
        prepareCmbFlightClass();
        prepareCmbFlight();
        prepareTable();
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
        lblLoggedUser = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblPassenger = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbFlightClass = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbFlight = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservation = new javax.swing.JTable();
        btnAddReservation = new javax.swing.JButton();
        btnDeleteReservation = new javax.swing.JButton();
        btnMakeGroup = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemPassenger = new javax.swing.JMenuItem();
        menuItemFlight = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservation");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel1.setText("Logged user:");

        lblLoggedUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        btnSelect.setText("Select passenger");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jLabel2.setText("Passenger:");

        lblPassenger.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setText("Flight class:");

        cmbFlightClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFlightClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFlightClassActionPerformed(evt);
            }
        });

        jLabel4.setText("Flight:");

        cmbFlight.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFlightActionPerformed(evt);
            }
        });

        jLabel5.setText("Price:");

        tblReservation.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblReservation);

        btnAddReservation.setText("Add reservation");
        btnAddReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReservationActionPerformed(evt);
            }
        });

        btnDeleteReservation.setText("Delete reservation");
        btnDeleteReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteReservationActionPerformed(evt);
            }
        });

        btnMakeGroup.setText("Make group reservation");
        btnMakeGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeGroupActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        menuItemPassenger.setText("Passenger");
        menuItemPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPassengerActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPassenger);

        menuItemFlight.setText("Flight");
        menuItemFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFlightActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemFlight);

        menuItemLogout.setText("Logout");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFlightClass, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnMakeGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnAddReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeleteReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblLoggedUser)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(btnMakeGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lblPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cmbFlightClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddReservation)
                    .addComponent(btnDeleteReservation))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblLoggedUser))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPassengerActionPerformed
        dp = new DialogPassenger(this, true);
        Controler.getInstance().setDp(dp);
        dp.pack();
        dp.setLocationRelativeTo(null);
        dp.setVisible(true);
    }//GEN-LAST:event_menuItemPassengerActionPerformed

    private void menuItemFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFlightActionPerformed
        df = new DialogFlight(this, true);
        Controler.getInstance().setDialogFlight(df);
        df.pack();
        df.setLocationRelativeTo(null);
        df.setVisible(true);
    }//GEN-LAST:event_menuItemFlightActionPerformed

    private void cmbFlightClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFlightClassActionPerformed
        calculatePrice();
    }//GEN-LAST:event_cmbFlightClassActionPerformed

    private void cmbFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFlightActionPerformed
        calculatePrice();
    }//GEN-LAST:event_cmbFlightActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        DialogSelectPassenger dsp = new DialogSelectPassenger(this, true);
        Controler.getInstance().setDialogSelectPassanger(dsp);
        dsp.pack();
        dsp.setLocationRelativeTo(null);
        dsp.setVisible(true);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnAddReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReservationActionPerformed
        if (lblPassenger.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Passenger is not selected.");
        } else {
            double price = Double.parseDouble(lblPrice.getText());
            LocalDate resDate = LocalDate.now();
            User user = Controler.getInstance().getLoggedUser();
            FlightClass fc = (FlightClass) cmbFlightClass.getSelectedItem();
            Passenger p = Controler.getInstance().getSelectedPassenger();
            Flight flight = (Flight) cmbFlight.getSelectedItem();
            Reservation r = new Reservation(-1, price, resDate, user, fc, p, flight);

            List<Reservation> reservations = Controler.getInstance().getMtr().getListReservation();

            if (reservations.contains(r)) {
                JOptionPane.showMessageDialog(this, "Reservation has already exist.");
                return;
            }
            reservations.add(r);

            RequestGenerator.getInstance().sendRequest(new Request(Operation.ADDRESERVATION, r));

        }
    }//GEN-LAST:event_btnAddReservationActionPerformed

    private void btnDeleteReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteReservationActionPerformed
        int row = tblReservation.getSelectedRow();
        if (row != -1) {
            Reservation r = Controler.getInstance().getMtr().getListReservation().get(row);
            RequestGenerator.getInstance().sendRequest(new Request(Operation.DELETERESERVATION, r));
        } else {
            JOptionPane.showMessageDialog(this, "You need to select the reservation you want to delete.");
        }
    }//GEN-LAST:event_btnDeleteReservationActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        RequestGenerator.getInstance().sendRequest(new Request(Operation.GETRESERVATION, null));
        RequestGenerator.getInstance().sendRequest(new Request(Operation.GETCMBFLIGHT, null));


    }//GEN-LAST:event_formWindowGainedFocus

    private void btnMakeGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeGroupActionPerformed
        DialogGroupReservation dgp = new DialogGroupReservation(this, true);
        Controler.getInstance().setDialogGroupReservation(dgp);
        double price = Double.parseDouble(lblPrice.getText());
        FlightClass fc = (FlightClass) cmbFlightClass.getSelectedItem();
        Flight f = (Flight) cmbFlight.getSelectedItem();
        dgp.prepare(fc,f,price);
        dgp.pack();
        dgp.setLocationRelativeTo(null);
        dgp.setVisible(true);
    }//GEN-LAST:event_btnMakeGroupActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        try {
            RequestGenerator.getInstance().getSocket().close();
            LoginForm lf = new LoginForm();
            this.dispose();
            lf.setLocationRelativeTo(null);
            lf.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddReservation;
    private javax.swing.JButton btnDeleteReservation;
    private javax.swing.JButton btnMakeGroup;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox cmbFlight;
    private javax.swing.JComboBox cmbFlightClass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoggedUser;
    private javax.swing.JLabel lblPassenger;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JMenuItem menuItemFlight;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemPassenger;
    private javax.swing.JTable tblReservation;
    // End of variables declaration//GEN-END:variables

    private void prepareCmbFlightClass() {
        RequestGenerator.getInstance().sendRequest(new Request(Operation.GETFLIGHTCLASS, null));
    }

    public void prepareCmbFc() {
        List<FlightClass> fc = Controler.getInstance().getListFlightClass();
        cmbFlightClass.removeAllItems();
        for (FlightClass f : fc) {
            cmbFlightClass.addItem(f);
        }
    }

    private void prepareCmbFlight() {
        RequestGenerator.getInstance().sendRequest(new Request(Operation.GETCMBFLIGHT, null));
    }

    public void prepareCmb() {
        List<Flight> flights = Controler.getInstance().getListFlights();
        cmbFlight.removeAllItems();
        for (Flight f : flights) {
            cmbFlight.addItem(f);
        }
    }

    private void calculatePrice() {
        try {
            double price = 0;
            Flight flight = (Flight) cmbFlight.getSelectedItem();
            double flightPrice = flight.getPrice();
            FlightClass fc = (FlightClass) cmbFlightClass.getSelectedItem();
            if (fc.getName().equals("Economy")) {
                price = flightPrice;
            }
            if (fc.getName().equals("Bussiness")) {
                price = flightPrice * 1.5;
            }
            lblPrice.setText("" + price);
        } catch (Exception e) {
        }

    }

    private void prepareTable() {
        ModelTableReservation mtr = new ModelTableReservation();
        tblReservation.setModel(mtr);
        Controler.getInstance().setMtr(mtr);
        refreshTable();
    }

    public void refreshTable() {
        RequestGenerator.getInstance().sendRequest(new Request(Operation.GETRESERVATION, null));
    }

    void setSelectedPassenger() {
        lblPassenger.setText(Controler.getInstance().getSelectedPassenger() + "");
        Controler.getInstance().getDialogSelectPassanger().dispose();
    }

    void addFlight() {
        cmbFlight.addItem(Controler.getInstance().getFlightToAdd().toString());
    }
}
