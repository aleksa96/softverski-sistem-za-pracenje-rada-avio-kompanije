/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Request;

/**
 *
 * @author Aleksa
 */
public class RequestGenerator {
    
    Socket socket;
    ObjectOutputStream oos;
    private static RequestGenerator instance;

    private RequestGenerator() {
    }

    public Socket getSocket() {
        return socket;
    }

    public static RequestGenerator getInstance() {
        if(instance == null) instance = new RequestGenerator();
        return instance;
    }
    
    public void sendRequest(Request request) {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(request);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(RequestGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
}
