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
import domain.IGeneralEntity;
import domain.Passenger;
import domain.Reservation;
import java.util.List;
import so.AbstractGenericOperation;
import so.airplane.GetAllAirplaneSO;
import so.airport.GetAllAirportsSO;
import so.country.GetAllCountrySO;
import so.flight.AddNewFlightSO;
import so.flight.DeleteFlightSO;
import so.flight.GetAllFlightSO;
import so.flightclass.GetAllFlightClassSO;
import so.passenger.AddNewPassengerSO;
import so.passenger.DeletePassengerSO;
import so.passenger.GetAllPassengerSO;
import so.passenger.UpdatePassengerSO;
import so.reservation.AddNewReservationSO;
import so.reservation.DeleteReservationSO;
import so.reservation.GetAllReservationSO;
import so.reservation.SaveGroupReservationsSO;
import so.user.LoginUserSO;

/**
 *
 * @author Aleksa
 */
public class Controler {

    private static Controler instance;

    private Controler() {
    }

    public static Controler getInstance() {
        if (instance == null) {
            instance = new Controler();
        }
        return instance;
    }

    public IGeneralEntity login(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new LoginUserSO();
        so.templateExecute(entity);
        return ((LoginUserSO) so).getObject();
    }

    public List<IGeneralEntity> getAllCountries() throws Exception {
        AbstractGenericOperation so = new GetAllCountrySO();
        so.templateExecute(new Country());
        return ((GetAllCountrySO) so).getList();
    }

    public List<IGeneralEntity> getAllAirplane() throws Exception {
        AbstractGenericOperation so = new GetAllAirplaneSO();
        so.templateExecute(new Airplane());
        return ((GetAllAirplaneSO) so).getList();
    }

    public List<IGeneralEntity> getAllAirport() throws Exception {
        AbstractGenericOperation so = new GetAllAirportsSO();
        so.templateExecute(new Airport());
        return ((GetAllAirportsSO) so).getList();
    }

    public void addNewPassenger(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new AddNewPassengerSO();
        so.templateExecute(entity);
    }

    public List<IGeneralEntity> getAllPassenger() throws Exception {
        AbstractGenericOperation so = new GetAllPassengerSO();
        so.templateExecute(new Passenger());
        return ((GetAllPassengerSO) so).getList();
    }

    public void updatePassenger(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new UpdatePassengerSO();
        so.templateExecute(entity);
    }

    public void deletePassenger(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new DeletePassengerSO();
        so.templateExecute(entity);
    }

    public List<IGeneralEntity> getAllFlight() throws Exception {
        AbstractGenericOperation so = new GetAllFlightSO();
        so.templateExecute(new Flight());
        return ((GetAllFlightSO) so).getList();
    }

    public void addNewFlight(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new AddNewFlightSO();
        so.templateExecute(entity);
    }

    public void deleteFlight(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new DeleteFlightSO();
        so.templateExecute(entity);
    }

    public List<IGeneralEntity> getAllFlightClass() throws Exception {
        AbstractGenericOperation so = new GetAllFlightClassSO();
        so.templateExecute(new FlightClass());
        return ((GetAllFlightClassSO) so).getList();
    }

    public List<IGeneralEntity> getAllReservation() throws Exception {
        AbstractGenericOperation so = new GetAllReservationSO();
        so.templateExecute(new Reservation());
        return ((GetAllReservationSO) so).getList();
    }

    public void addNewReservation(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new AddNewReservationSO();
        so.templateExecute(entity);
    }

    public void deleteReservation(IGeneralEntity entity) throws Exception {
        AbstractGenericOperation so = new DeleteReservationSO();
        so.templateExecute(entity);
    }

    public void saveGroupReservation(List<Reservation> list) throws Exception {
        AbstractGenericOperation so = new AddNewReservationSO();
        for (IGeneralEntity entity : list) {
            so.templateExecute(entity);
        }

    }

}
