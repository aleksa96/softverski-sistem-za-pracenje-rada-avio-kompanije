/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Response;

/**
 *
 * @author Aleksa
 */
public class ServerThread extends Thread {

    public static List<ClientHandler> clients;
    private ServerSocket ss;
    private int port;

    public ServerThread(int port) throws IOException {
        this.port = port;
        ss = new ServerSocket(port);
        this.clients = new ArrayList<>();
               
    }

    
    
    public ServerThread() {

    }

    public ServerThread(ServerSocket ss) {
        this.ss = ss;
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.println("Server started.");
        System.out.println("Waiting for new clients...");
        while (!isInterrupted()) {
            try {
                Socket s = ss.accept();
                System.out.println("Client connected.");
                ClientHandler ch = new ClientHandler(s);
                clients.add(ch);
                ch.start();
            } catch (IOException ex) {
                System.out.println("Server stopped.");
                this.interrupt();
            }
        }
    }

    public void stopServer() throws IOException {
        ss.close();
        for (ClientHandler client : clients) {
            client.getSocket().close();
        }
    }

    public void sendResponseToAll(Response response) {
        for (ClientHandler client : clients) {
            client.sendResponse(response);
        }
    }

}
