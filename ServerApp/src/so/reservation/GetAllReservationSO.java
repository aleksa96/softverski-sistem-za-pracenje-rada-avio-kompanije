/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.reservation;

import domain.Airport;
import domain.City;
import domain.Flight;
import domain.FlightClass;
import domain.IGeneralEntity;
import domain.Passenger;
import domain.Reservation;
import domain.User;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Aleksa
 */
public class GetAllReservationSO extends AbstractGenericOperation {

    private List<IGeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Reservation)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = db.getAll((IGeneralEntity) entity);

        for (IGeneralEntity e : list) {
            Reservation r = (Reservation) e;
            r.setUser((User) db.getById(r.getUser()));
            r.setFl((FlightClass) db.getById(r.getFl()));
            r.setPassenger((Passenger) db.getById(r.getPassenger()));
            r.setFlight((Flight) db.getById(r.getFlight()));
            
            Airport aa = r.getFlight().getArrivalAirport();
            Airport da = r.getFlight().getDepartureAirport();
            
            r.getFlight().setArrivalAirport((Airport) db.getById(aa));
            r.getFlight().setDepartureAirport((Airport) db.getById(da));
            
            r.getFlight().getArrivalAirport().setCity((City) db.getById(r.getFlight().getArrivalAirport().getCity()));
            r.getFlight().getDepartureAirport().setCity((City) db.getById(r.getFlight().getDepartureAirport().getCity()));
        }
    }

    public List<IGeneralEntity> getList() {
        return list;
    }

}
