/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import client.RequestGenerator;
import controler.Controler;
import domain.Country;
import domain.Passenger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import transfer.Operation;
import transfer.Request;

/**
 *
 * @author Aleksa
 */
public class DialogAddNewPassenger extends javax.swing.JDialog {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    
    /**
     * Creates new form DialogAddNewPassenger
     */
    public DialogAddNewPassenger(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        populateCMBCountry();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDateOfBirth = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtStreet = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        cmbCountry = new javax.swing.JComboBox<>();
        btnAddPassenger = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPassport = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Passenger");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Add new passenger"));

        jLabel1.setText("First name:");

        jLabel2.setText("Last name:");

        jLabel3.setText("Date of birth:");

        jLabel4.setText("Street:");

        jLabel5.setText("Email:");

        jLabel6.setText("Phone:");

        jLabel7.setText("Country:");

        cmbCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddPassenger.setText("Add");
        btnAddPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPassengerActionPerformed(evt);
            }
        });

        jLabel8.setText("Passport:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddPassenger, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDateOfBirth)
                            .addComponent(txtLastName)
                            .addComponent(txtFirstName)
                            .addComponent(txtStreet)
                            .addComponent(txtEmail)
                            .addComponent(txtPhone)
                            .addComponent(cmbCountry, 0, 279, Short.MAX_VALUE)
                            .addComponent(txtPassport))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPassport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddPassenger, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPassengerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPassengerActionPerformed
        if (txtDateOfBirth.getText().isEmpty() || txtEmail.getText().isEmpty() || txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtPassport.getText().isEmpty() || txtPhone.getText().isEmpty() || txtStreet.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "You need to enter all fields.");
        } else {

            String pass = txtPassport.getText();
            if (pass.length() != 8) {
                JOptionPane.showMessageDialog(this, "Passport must have 8 numbers.");
                return;
            }
            boolean hasAlphaPass = pass.matches(".*[a-zA-Z]+.*");
            if(hasAlphaPass) {
                JOptionPane.showMessageDialog(this, "Passport must have only numbers.");
                return;
            }
            int passport = Integer.parseInt(pass);
            if(passport < 0) {
                JOptionPane.showMessageDialog(this, "Passport must be positive.");
                return;
            }


            String firstName = txtFirstName.getText();
            boolean hasDigit = firstName.matches(".*\\d+.*");
            if(hasDigit) {
                JOptionPane.showMessageDialog(this, "First name must have only letters.");
                return;
            }
            
            String lastName = txtLastName.getText();
            boolean hasDigitLast = lastName.matches(".*\\d+.*");
            if(hasDigitLast) {
                JOptionPane.showMessageDialog(this, "Last name must have only letters.");
                return;
            }
            
            String date = txtDateOfBirth.getText();
            LocalDate dateOfBirth;
            try {
                dateOfBirth = LocalDate.parse(date, dtf);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Date must be in format: dd.MM.yyyy");
                return;
            }
            
            String street = txtStreet.getText();
            
            String email = txtEmail.getText();
            if(email.startsWith("@")) {
                JOptionPane.showMessageDialog(this, "Email must be in format: smth@smth.smth.");
                return;
            }
            if(email.endsWith("@")) {
                JOptionPane.showMessageDialog(this, "Email must be in format: smth@smth.smth.");
                return;
            }
            if(!email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Email must be in format: smth@smth.smth.");
                return;
            }
            
            String phone = txtPhone.getText();
            boolean hasAlphaPhone = phone.matches(".*[a-zA-Z]+.*");
            if(hasAlphaPhone) {
                JOptionPane.showMessageDialog(this, "Phone must have only numbers.");
                return;
            }
            
            
            Country c = (Country) cmbCountry.getSelectedItem();
            
            Passenger passenger = new Passenger(-1, firstName, lastName, dateOfBirth, street, email, phone, c, passport);
            
            List<Passenger> passengers = Controler.getInstance().getMtp().getListPassenger();
            
            boolean flag = false;
            for (Passenger p : passengers) {
                if(p.getPassport() == passport) flag = true;
            }
            if(flag) {
                JOptionPane.showMessageDialog(this, "Passenger has already exist.");
                return;
            }
            RequestGenerator.getInstance().sendRequest(new Request(Operation.ADDNEWPASSENGER, passenger));
            
        }
    }//GEN-LAST:event_btnAddPassengerActionPerformed

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
            java.util.logging.Logger.getLogger(DialogAddNewPassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAddNewPassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAddNewPassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAddNewPassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAddNewPassenger dialog = new DialogAddNewPassenger(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPassenger;
    private javax.swing.JComboBox<Object> cmbCountry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPassport;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtStreet;
    // End of variables declaration//GEN-END:variables

    private void populateCMBCountry() {
        RequestGenerator.getInstance().sendRequest(new Request(Operation.GETCOUNTRY, null));
    }

    public void prepareCMBCountry() {
        List<Country> countries = Controler.getInstance().getListCountries();
        cmbCountry.removeAllItems();
        for (Country country : countries) {
            cmbCountry.addItem(country);
        }
    }

    public void addPassengerSucces() {
        JOptionPane.showMessageDialog(this, "Passenger is created.");
    }

    public void addPassengerError() {
        JOptionPane.showMessageDialog(this, "Passenger is not created.");
    }

    public void prepareCMBCountry(List<Country> countries) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
