/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import domain.Airplane;
import domain.Airport;
import domain.Country;
import domain.Flight;
import domain.FlightClass;
import domain.Passenger;
import domain.User;
import forms.DialogAddNewFlight;
import forms.DialogAddNewPassenger;
import forms.DialogChangePassenger;
import forms.DialogFlight;
import forms.DialogGroupReservation;
import forms.DialogPassenger;
import forms.DialogSelectPassenger;
import forms.LoginForm;
import forms.MainForm;
import java.net.Socket;
import java.util.List;
import table.ModelTableFlight;
import table.ModelTablePassangerGroup;
import table.ModelTablePassangerSelect;
import table.ModelTablePassenger;
import table.ModelTableReservation;

/**
 *
 * @author Aleksa
 */
public class Controler {
    
    private static Controler instance;
    private LoginForm lf;
    private Socket socket;
    private User loggedUser;
    private DialogAddNewPassenger dialogAddNewPassenger;
    private DialogAddNewFlight dialogAddNewFlight;
    private List<Country> listCountries;
    private ModelTablePassenger mtp;
    private ModelTableFlight mtf;
    private List<Airplane> airplanes;
    private List<Airport> airports;
    private DialogPassenger dp;
    private DialogChangePassenger dcp;
    private Passenger passengerToChange;
    private DialogFlight dialogFlight;
    private List<FlightClass> listFlightClass;
    private MainForm mf;
    private List<Flight> listFlights;
    private ModelTableReservation mtr;
    private DialogSelectPassenger dialogSelectPassanger;
    private List<Passenger> passengerToSelect;
    private ModelTablePassangerSelect mtps;
    private Passenger selectedPassenger;
    private Flight flightToAdd;
    private DialogGroupReservation dialogGroupReservation;
    private ModelTablePassenger mtpg;
    private ModelTablePassangerGroup modelTableGroup;
    

    private Controler() {
    }

    public static Controler getInstance() {
        if(instance == null) instance = new Controler();
        return instance;
    }

    public LoginForm getLf() {
        return lf;
    }

    public void setLf(LoginForm lf) {
        this.lf = lf;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public DialogAddNewPassenger getDialogAddNewPassenger() {
        return dialogAddNewPassenger;
    }

    public void setDialogAddNewPassenger(DialogAddNewPassenger dialogAddNewPassenger) {
        this.dialogAddNewPassenger = dialogAddNewPassenger;
    }

    public List<Country> getListCountries() {
        return listCountries;
    }

    public void setListCountries(List<Country> listCountries) {
        this.listCountries = listCountries;
    }

    public ModelTablePassenger getMtp() {
        return mtp;
    }

    public void setMtp(ModelTablePassenger mtp) {
        this.mtp = mtp;
    }

    public DialogAddNewFlight getDialogAddNewFlight() {
        return dialogAddNewFlight;
    }

    public void setDialogAddNewFlight(DialogAddNewFlight dialogAddNewFlight) {
        this.dialogAddNewFlight = dialogAddNewFlight;
    }

    public ModelTableFlight getMtf() {
        return mtf;
    }

    public void setMtf(ModelTableFlight mtf) {
        this.mtf = mtf;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public DialogPassenger getDp() {
        return dp;
    }

    public void setDp(DialogPassenger dp) {
        this.dp = dp;
    }

    public DialogChangePassenger getDcp() {
        return dcp;
    }

    public void setDcp(DialogChangePassenger dcp) {
        this.dcp = dcp;
    }

    public Passenger getPassengerToChange() {
        return passengerToChange;
    }

    public void setPassengerToChange(Passenger passengerToChange) {
        this.passengerToChange = passengerToChange;
    }

    public DialogFlight getDialogFlight() {
        return dialogFlight;
    }

    public void setDialogFlight(DialogFlight dialogFlight) {
        this.dialogFlight = dialogFlight;
    }

    public List<FlightClass> getListFlightClass() {
        return listFlightClass;
    }

    public void setListFlightClass(List<FlightClass> listFlightClass) {
        this.listFlightClass = listFlightClass;
    }

    public MainForm getMf() {
        return mf;
    }

    public void setMf(MainForm mf) {
        this.mf = mf;
    }

    public List<Flight> getListFlights() {
        return listFlights;
    }

    public void setListFlights(List<Flight> listFlights) {
        this.listFlights = listFlights;
    }

    public ModelTableReservation getMtr() {
        return mtr;
    }

    public void setMtr(ModelTableReservation mtr) {
        this.mtr = mtr;
    }

    public DialogSelectPassenger getDialogSelectPassanger() {
        return dialogSelectPassanger;
    }

    public void setDialogSelectPassanger(DialogSelectPassenger dialogSelectPassanger) {
        this.dialogSelectPassanger = dialogSelectPassanger;
    }

    public List<Passenger> getPassengerToSelect() {
        return passengerToSelect;
    }

    public void setPassengerToSelect(List<Passenger> passengerToSelect) {
        this.passengerToSelect = passengerToSelect;
    }

    public ModelTablePassangerSelect getMtps() {
        return mtps;
    }

    public void setMtps(ModelTablePassangerSelect mtps) {
        this.mtps = mtps;
    }

    public Passenger getSelectedPassenger() {
        return selectedPassenger;
    }

    public void setSelectedPassenger(Passenger selectedPassenger) {
        this.selectedPassenger = selectedPassenger;
    }

    public Flight getFlightToAdd() {
        return flightToAdd;
    }

    public void setFlightToAdd(Flight flightToAdd) {
        this.flightToAdd = flightToAdd;
    }

    public DialogGroupReservation getDialogGroupReservation() {
        return dialogGroupReservation;
    }

    public void setDialogGroupReservation(DialogGroupReservation dialogGroupReservation) {
        this.dialogGroupReservation = dialogGroupReservation;
    }

    public ModelTablePassenger getMtpg() {
        return mtpg;
    }

    public void setMtpg(ModelTablePassenger mtpg) {
        this.mtpg = mtpg;
    }

    public ModelTablePassangerGroup getModelTableGroup() {
        return modelTableGroup;
    }

    public void setModelTableGroup(ModelTablePassangerGroup modelTableGroup) {
        this.modelTableGroup = modelTableGroup;
    }

    

    
    
    
    
}
