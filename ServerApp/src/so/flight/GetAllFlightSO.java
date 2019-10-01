/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.flight;

import domain.Airplane;
import domain.Airport;
import domain.City;
import domain.Country;
import domain.Flight;
import domain.IGeneralEntity;
import domain.Passenger;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Aleksa
 */
public class GetAllFlightSO extends AbstractGenericOperation{

    private List<IGeneralEntity> list;
    
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Flight)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = db.getAll((IGeneralEntity) entity);
        
        for (IGeneralEntity e : list) {
            Flight f = (Flight) e;
            f.setAirplane((Airplane) db.getById(f.getAirplane()));
            f.setArrivalAirport((Airport) db.getById(f.getArrivalAirport()));
            f.setDepartureAirport((Airport) db.getById(f.getDepartureAirport()));
            
            f.getArrivalAirport().setCity((City) db.getById(f.getArrivalAirport().getCity()));
            f.getDepartureAirport().setCity((City) db.getById(f.getDepartureAirport().getCity()));
        }
    }
    
    public List<IGeneralEntity> getList() {
        return list;
    }
    
}
