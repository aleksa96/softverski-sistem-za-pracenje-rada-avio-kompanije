/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import db.DBConnection;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.Server;
import server.ServerThread;
import transfer.Operation;
import transfer.Response;
import util.Constants;
import util.SettingsLoader;

/**
 *
 * @author Aleksa
 */
public class MainForm extends javax.swing.JFrame {

    ServerSocket ss;
    ServerThread st;
    private Server server;

    
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        btnStopServer.setEnabled(false);
        lblStatus.setText("Server is not running.");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnStartServer = new javax.swing.JButton();
        btnStopServer = new javax.swing.JButton();
        lblPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        lblUrl = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server status");
        setMaximumSize(new java.awt.Dimension(400, 113));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Server status:");

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnStartServer.setText("Start server");
        btnStartServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServerActionPerformed(evt);
            }
        });

        btnStopServer.setText("Stop server");
        btnStopServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopServerActionPerformed(evt);
            }
        });

        lblPort.setText("Port:");

        txtPort.setText("9000");

        lblUrl.setText("URL:");

        txtUrl.setText("jdbc:mysql://localhost:3306/aviodatabase");

        lblUsername.setText("Username db:");

        txtUsername.setText("root");

        lblPassword.setText("Password db:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnStartServer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(btnStopServer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword)
                            .addComponent(lblUsername)
                            .addComponent(lblUrl)
                            .addComponent(lblPort))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPort)
                            .addComponent(txtUrl)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblStatus))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStartServer, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnStopServer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPort)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUrl)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblUsername))
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void btnStartServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServerActionPerformed
        String url = this.txtUrl.getText().trim();
        String username = this.txtUsername.getText().trim();
        String password = this.txtPassword.getText().trim();
        String port = this.txtPort.getText().trim();
        
        try {
            Integer.parseInt(port);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Port must be a number!");
            return;
        }
        
        SettingsLoader.getInstance().setProperty(Constants.URL, url);
        SettingsLoader.getInstance().setProperty(Constants.USERNAME, username);
        SettingsLoader.getInstance().setProperty(Constants.PASSWORD, password);
        SettingsLoader.getInstance().setProperty(Constants.PORT, port);
        
        try {
            SettingsLoader.getInstance().saveProperties();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Property could not be saved!");
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Properties saved!");
        if (st == null || !st.isAlive() ) {
            try {
                st = new ServerThread(Integer.parseInt(SettingsLoader.getInstance().getProperty(Constants.PORT)));
                st.start();

                DBConnection.getInstance().getConnection();

                this.lblStatus.setText("Server is running.");
                this.btnStartServer.setEnabled(false);
                this.btnStopServer.setEnabled(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Port " + SettingsLoader.getInstance().getProperty(Constants.PORT) + " is already taken.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Wrong parameters!");
                try {
                    st.stopServer();
                    st = null;
                } catch (IOException ex1) {
                    JOptionPane.showMessageDialog(this, "Failed to stop server!");
                    System.exit(0);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Server is already running.");
        }
        
        
        
//        try {
//            String portString = SettingsLoader.getInstance().getProperty("PORT");
//            int port = Integer.parseInt(portString);
//            ss = new ServerSocket(port);
//            st = new ServerThread(ss);
//            st.start();
//            setServerOn();
//            st.sendResponseToAll(new Response(Operation.SERVERSTATUS, null, true));
//        } catch (IOException ex) {
//            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnStartServerActionPerformed

    private void btnStopServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopServerActionPerformed
        try {
            st.stopServer();
            st = null;
            DBConnection.getInstance().closeConnection();
            this.lblStatus.setText("Server is not running.");
            this.btnStartServer.setEnabled(true);
            this.btnStopServer.setEnabled(false);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to close server.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed to close database.");
        }
    }//GEN-LAST:event_btnStopServerActionPerformed

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
                if ("Windows".equals(info.getName())) {
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
    private javax.swing.JButton btnStartServer;
    private javax.swing.JButton btnStopServer;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUrl;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUrl;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void setServerOn() {
        lblStatus.setText("Server is running.");
        btnStartServer.setEnabled(false);
        btnStopServer.setEnabled(true);
    }

    private void setServerOff() {
        lblStatus.setText("Server is not running.");
        btnStartServer.setEnabled(true);
        btnStopServer.setEnabled(false);
    }
}