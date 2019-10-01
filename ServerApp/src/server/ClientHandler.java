/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import controler.Controler;
import domain.Flight;
import domain.IGeneralEntity;
import domain.Passenger;
import domain.Reservation;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Operation;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Aleksa
 */
class ClientHandler extends Thread {

    Socket socket;
    boolean running = true;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (running) {
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) ois.readObject();
                processRequest(request);
            } catch (IOException ex) {
                System.out.println("Client disconnected.");
                running = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Client disconnected [class not found].");
                running = false;
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private void processRequest(Request request) {
        switch (request.getOperation()) {
            case Operation.LOGIN:
                handleLogIn(request);
                break;
            case Operation.GETCOUNTRY:
                handleGetCountry();
                break;
            case Operation.GETAIRPLANE:
                handleGetAirplane();
                break;
            case Operation.GETAIRPORT:
                handleGetAirport();
                break;
            case Operation.ADDNEWPASSENGER:
                handleAddNewPassenger(request);
                break;
            case Operation.GETPASSENGER:
                handleGetAllPassenger();
                break;
            case Operation.GETCOUNTRYTOCHANGE:
                handleGetCountryToChange();
                break;
            case Operation.CHANGEPASSENGER:
                handleChangePassenger(request);
                break;
            case Operation.DELETEPASSENGER:
                handleDeletePassenger(request);
                break;
            case Operation.GETFLIGHT:
                handleGetFlight();
                break;
            case Operation.ADDNEWFLIGHT:
                handleAddNewFlight(request);
                break;
            case Operation.DELETEFLIGHT:
                handleDeleteFlight(request);
                break;
            case Operation.GETFLIGHTCLASS:
                handleGetFlightClass();
                break;
            case Operation.GETCMBFLIGHT:
                handleGetCmbFlight();
                break;
            case Operation.GETRESERVATION:
                handleGetReservation();
                break;
            case Operation.GETPASSENGERTOSELECT:
                handleGetAllPassengerSelect();
                break;
            case Operation.ADDRESERVATION:
                handleAddReservation(request);
                break;
            case Operation.DELETERESERVATION:
                handleDeleteReservation(request);
                break;
            case Operation.GETPASSANGERGROUP:
                handleGroupPassanger();
                break;
            case Operation.SAVEGROUPRESERVATION:
                handleSaveGroup(request);
                break;

        }
    }

    public void sendResponse(Response response) {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(response);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleLogIn(Request request) {
        try {
            Response res;
            IGeneralEntity entity = Controler.getInstance().login((IGeneralEntity) request.getData());

            if (entity == null) {
                res = new Response(Operation.LOGIN, null, false);
            } else {
                res = new Response(Operation.LOGIN, entity, true);
            }

            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            Response res = new Response(Operation.LOGIN, null, false);
            sendResponse(res);
        }
    }

    private void handleGetCountry() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllCountries();
            if (list == null) {
                res = new Response(Operation.GETCOUNTRY, null, false);
            } else {
                res = new Response(Operation.GETCOUNTRY, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleGetAirplane() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllAirplane();
            if (list == null) {
                res = new Response(Operation.GETAIRPLANE, null, false);
            } else {
                res = new Response(Operation.GETAIRPLANE, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleGetAirport() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllAirport();
            if (list == null) {
                res = new Response(Operation.GETAIRPORT, null, false);
            } else {
                res = new Response(Operation.GETAIRPORT, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleAddNewPassenger(Request request) {
        Response res;
        try {
            Passenger passenger = (Passenger) request.getData();
            Controler.getInstance().addNewPassenger(passenger);
            res = new Response(Operation.ADDNEWPASSENGER, passenger, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.ADDNEWPASSENGER, null, false);
        }
        sendResponse(res);
    }

    private void handleGetAllPassenger() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllPassenger();
            if (list == null) {
                res = new Response(Operation.GETPASSENGER, null, false);
            } else {
                res = new Response(Operation.GETPASSENGER, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleGetCountryToChange() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllCountries();
            if (list == null) {
                res = new Response(Operation.GETCOUNTRYTOCHANGE, null, false);
            } else {
                res = new Response(Operation.GETCOUNTRYTOCHANGE, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleChangePassenger(Request request) {
        Response res;
        try {
            Passenger passenger = (Passenger) request.getData();
            Controler.getInstance().updatePassenger(passenger);
            res = new Response(Operation.CHANGEPASSENGER, passenger, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.CHANGEPASSENGER, null, false);
        }
        sendResponse(res);
    }

    private void handleDeletePassenger(Request request) {
        Response res;
        try {
            Passenger p = (Passenger) request.getData();
            Controler.getInstance().deletePassenger(p);
            res = new Response(Operation.DELETEPASSENGER, null, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.DELETEPASSENGER, null, false);
        }
        sendResponse(res);
    }

    private void handleGetFlight() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllFlight();
            if (list == null) {
                res = new Response(Operation.GETFLIGHT, null, false);
            } else {
                res = new Response(Operation.GETFLIGHT, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleAddNewFlight(Request request) {
        Response res;
        try {
            Flight flight = (Flight) request.getData();
            Controler.getInstance().addNewFlight(flight);
            res = new Response(Operation.ADDNEWFLIGHT, flight, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.ADDNEWFLIGHT, null, false);
        }
        sendResponse(res);
    }

    private void handleDeleteFlight(Request request) {
        Response res;
        try {
            Flight f = (Flight) request.getData();
            Controler.getInstance().deleteFlight(f);
            res = new Response(Operation.DELETEFLIGHT, null, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.DELETEFLIGHT, null, false);
        }
        sendResponse(res);
    }

    private void handleGetFlightClass() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllFlightClass();
            if (list == null) {
                res = new Response(Operation.GETFLIGHTCLASS, null, false);
            } else {
                res = new Response(Operation.GETFLIGHTCLASS, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleGetCmbFlight() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllFlight();
            if (list == null) {
                res = new Response(Operation.GETCMBFLIGHT, null, false);
            } else {
                res = new Response(Operation.GETCMBFLIGHT, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleGetReservation() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllReservation();
            if (list == null) {
                res = new Response(Operation.GETRESERVATION, null, false);
            } else {
                res = new Response(Operation.GETRESERVATION, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleGetAllPassengerSelect() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllPassenger();
            if (list == null) {
                res = new Response(Operation.GETPASSENGERTOSELECT, null, false);
            } else {
                res = new Response(Operation.GETPASSENGERTOSELECT, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleAddReservation(Request request) {
        Response res;
        try {
            Reservation r = (Reservation) request.getData();
            Controler.getInstance().addNewReservation(r);
            res = new Response(Operation.ADDRESERVATION, r, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.ADDRESERVATION, null, false);
        }
        sendResponse(res);
    }

    private void handleDeleteReservation(Request request) {
        Response res;
        try {
            Reservation r = (Reservation) request.getData();
            Controler.getInstance().deleteReservation(r);
            res = new Response(Operation.DELETERESERVATION, null, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.DELETERESERVATION, null, false);
        }
        sendResponse(res);
    }

    private void handleGroupPassanger() {
        try {
            Response res;
            List<IGeneralEntity> list = Controler.getInstance().getAllPassenger();
            if (list == null) {
                res = new Response(Operation.GETPASSANGERGROUP, null, false);
            } else {
                res = new Response(Operation.GETPASSANGERGROUP, list, true);
            }
            sendResponse(res);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleSaveGroup(Request request) {
        Response res;
        try {
            List<Reservation> list = (List<Reservation>) request.getData();
            Controler.getInstance().saveGroupReservation(list);
            res = new Response(Operation.SAVEGROUPRESERVATION, list, true);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            res = new Response(Operation.SAVEGROUPRESERVATION, null, false);
        }
        sendResponse(res);
    }

}
