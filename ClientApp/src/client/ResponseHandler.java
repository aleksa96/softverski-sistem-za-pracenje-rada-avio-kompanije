/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import controler.Controler;
import domain.Airplane;
import domain.Airport;
import domain.Country;
import domain.Flight;
import domain.FlightClass;
import domain.Passenger;
import domain.Reservation;
import domain.User;
import forms.DialogFlight;
import forms.LoginForm;
import forms.MainForm;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.Operation;
import transfer.Response;

/**
 *
 * @author Aleksa
 */
public class ResponseHandler extends Thread {

    Socket socket;
    LoginForm lf;
    ObjectInputStream ois;
    MainForm mf;

    public ResponseHandler(Socket socket, LoginForm lf) {
        this.socket = socket;
        this.lf = lf;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                Response response = (Response) ois.readObject();
                processResponse(response);
            } catch (IOException ex) {
                interrupt();
                Logger.getLogger(ResponseHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ResponseHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void processResponse(Response response) {
        switch (response.getOperation()) {
            case Operation.SERVERSTATUS:
                handleServerStatus(response);
                break;
            case Operation.LOGIN:
                handleLogIn(response);
                break;
            case Operation.GETCOUNTRY:
                handleGetCountry(response);
                break;
            case Operation.GETAIRPLANE:
                handleGetAirplane(response);
                break;
            case Operation.GETAIRPORT:
                handleGetAirport(response);
                break;
            case Operation.ADDNEWPASSENGER:
                handleAddNewPassenger(response);
                break;
            case Operation.GETPASSENGER:
                handleGetAllPassenger(response);
                break;
            case Operation.GETCOUNTRYTOCHANGE:
                handleGetCountryToChange(response);
                break;
            case Operation.CHANGEPASSENGER:
                handleChangePassenger(response);
                break;
            case Operation.DELETEPASSENGER:
                handleDeletePassenger(response);
                break;
            case Operation.GETFLIGHT:
                handleGetFlight(response);
                break;
            case Operation.ADDNEWFLIGHT:
                handleAddNewFlight(response);
                break;
            case Operation.DELETEFLIGHT:
                handleDeleteFlight(response);
                break;
            case Operation.GETFLIGHTCLASS:
                handleGetAllFlightClass(response);
                break;
            case Operation.GETCMBFLIGHT:
                handleCmbFlight(response);
                break;
            case Operation.GETRESERVATION:
                handleGetAllReservation(response);
                break;
            case Operation.GETPASSENGERTOSELECT:
                handleGetPassengerToSelect(response);
                break;
            case Operation.ADDRESERVATION:
                handleAddReservation(response);
                break;
            case Operation.DELETERESERVATION:
                handleDeleteReservation(response);
                break;
            case Operation.GETPASSANGERGROUP:
                handlePassengerGroup(response);
                break;
            case Operation.SAVEGROUPRESERVATION:
                handleSaveGroup(response);
                break;
        }
    }

    private void handleServerStatus(Response response) {
        if (!response.isOk()) {
            lf.enableLogIn();
        } else {
            lf.disableLogIn();
        }
    }

    private void handleLogIn(Response response) {
        if (response.isOk()) {
            User u = (User) response.getData();
            Controler.getInstance().setLoggedUser(u);
            JOptionPane.showMessageDialog(lf, "Welcome.");
            mf = new MainForm();
            lf.dispose();
            mf.setLocationRelativeTo(null);
            mf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(lf, "Invalid credentials.");
        }
    }

    private void handleGetCountry(Response response) {
        List<Country> countries = (List<Country>) response.getData();
        Controler.getInstance().setListCountries(countries);
        Controler.getInstance().getDialogAddNewPassenger().prepareCMBCountry();

    }

    private void handleGetAirplane(Response response) {
        List<Airplane> airplanes = (List<Airplane>) response.getData();
        Controler.getInstance().setAirplanes(airplanes);
        Controler.getInstance().getDialogAddNewFlight().prepareCMBAirplane();
    }

    private void handleGetAirport(Response response) {
        List<Airport> airports = (List<Airport>) response.getData();
        Controler.getInstance().setAirports(airports);
        Controler.getInstance().getDialogAddNewFlight().prepareCMBAirport();
    }

    private void handleAddNewPassenger(Response response) {
        if (response.isOk()) {
            Controler.getInstance().getDialogAddNewPassenger().addPassengerSucces();
            Controler.getInstance().getDp().refreshTable();
            Controler.getInstance().getDialogAddNewPassenger().dispose();
        } else {
            Controler.getInstance().getDialogAddNewPassenger().addPassengerError();
        }
    }

    private void handleGetAllPassenger(Response response) {
        List<Passenger> passengers = (List<Passenger>) response.getData();
        Controler.getInstance().getMtp().setListPassenger(passengers);
        Controler.getInstance().getMtp().fireTableDataChanged();
    }

    private void handleGetCountryToChange(Response response) {
        List<Country> countries = (List<Country>) response.getData();
        Controler.getInstance().getDcp().prepareCmbCountry(countries);
    }

    private void handleChangePassenger(Response response) {
        if (response.isOk()) {
            Controler.getInstance().getDcp().changePassengerSuccess();
            Controler.getInstance().getDp().refreshTable();
            Controler.getInstance().getDcp().dispose();
        } else {
            Controler.getInstance().getDcp().changePassengerError();
        }
    }

    private void handleDeletePassenger(Response response) {
        if (response.isOk()) {
            Controler.getInstance().getDp().refreshTable();
            JOptionPane.showMessageDialog(mf, "Passenger has been deleted.");
        } else {
            JOptionPane.showMessageDialog(mf, "Passenger could not be deleted.");
        }
    }

    private void handleGetFlight(Response response) {
        List<Flight> flights = (List<Flight>) response.getData();
        Controler.getInstance().getMtf().setListFlights(flights);
        Controler.getInstance().getMtf().fireTableDataChanged();

    }

    private void handleAddNewFlight(Response response) {
        DialogFlight df = Controler.getInstance().getDialogFlight();
        if (response.isOk()) {
            JOptionPane.showMessageDialog(df, "Flight has been created.");
            df.refreshTable();
            Controler.getInstance().getDialogAddNewFlight().dispose();
        } else {
            JOptionPane.showMessageDialog(df, "Flight has not been created.");
        }
    }

    private void handleDeleteFlight(Response response) {
        if (response.isOk()) {
            Controler.getInstance().getDialogFlight().refreshTable();
            JOptionPane.showMessageDialog(mf, "Flight has been deleted.");
        } else {
            JOptionPane.showMessageDialog(mf, "Flight could not be deleted.");
        }
    }

    private void handleGetAllFlightClass(Response response) {
        List<FlightClass> fc = (List<FlightClass>) response.getData();
        Controler.getInstance().setListFlightClass(fc);
        Controler.getInstance().getMf().prepareCmbFc();
    }

    private void handleCmbFlight(Response response) {
        List<Flight> flights = (List<Flight>) response.getData();
        Controler.getInstance().setListFlights(flights);
        Controler.getInstance().getMf().prepareCmb();
    }

    private void handleGetAllReservation(Response response) {
        List<Reservation> reservations = (List<Reservation>) response.getData();
        Controler.getInstance().getMtr().setListReservation(reservations);
        Controler.getInstance().getMtr().fireTableDataChanged();
    }

    private void handleGetPassengerToSelect(Response response) {
        List<Passenger> passengers = (List<Passenger>) response.getData();
        Controler.getInstance().getMtps().setListPassenger(passengers);
        Controler.getInstance().getMtps().fireTableDataChanged();
    }

    private void handleAddReservation(Response response) {
        if (response.isOk()) {
            JOptionPane.showMessageDialog(mf, "Reservation has been created.");
            mf.refreshTable();
        } else {
            JOptionPane.showMessageDialog(mf, "Reservation has not been created.");
        }
    }

    private void handleDeleteReservation(Response response) {
        if (response.isOk()) {
            Controler.getInstance().getMf().refreshTable();
            JOptionPane.showMessageDialog(mf, "Reservation has been deleted.");
        } else {
            JOptionPane.showMessageDialog(mf, "Reservation could not be deleted.");
        }
    }

    private void handlePassengerGroup(Response response) {
        List<Passenger> passengers = (List<Passenger>) response.getData();
        Controler.getInstance().getMtpg().setListPassenger(passengers);
        Controler.getInstance().getMtpg().fireTableDataChanged();
    }

    private void handleSaveGroup(Response response) {
        if (response.isOk()) {
            JOptionPane.showMessageDialog(mf, "Group reservation has been added.");
            Controler.getInstance().getDialogGroupReservation().dispose();
            Controler.getInstance().getMf().refreshTable();
        }
    }

}
