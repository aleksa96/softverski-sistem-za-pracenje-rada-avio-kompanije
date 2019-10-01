/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import controler.Controler;
import forms.LoginForm;
import java.net.Socket;

/**
 *
 * @author Aleksa
 */
public class Client {
    
    Socket s;
    LoginForm lf;
    
    
    public static void main(String[] args) {
        Client c = new Client();
        c.startClient();
    }

    private void startClient() {
        lf = new LoginForm();
        Controler.getInstance().setLf(lf);
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }
    
}
