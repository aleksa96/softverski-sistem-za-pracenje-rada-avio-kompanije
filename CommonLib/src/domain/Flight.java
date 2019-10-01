/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aleksa
 */
public class Flight implements IGeneralEntity {

    private long id;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double length;
    private int duration;
    private String description;
    private double price;
    private Airplane airplane;
    private Airport arrivalAirport;
    private Airport departureAirport;

    public Flight() {
    }

    public Flight(long id, LocalDate arrivalDate, LocalDate departureDate, double length, int duration, String description, double price, Airplane airplane, Airport arrivalAirport, Airport departureAirport) {
        this.id = id;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.length = length;
        this.duration = duration;
        this.description = description;
        this.price = price;
        this.airplane = airplane;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }

    public Flight(int id) {
        this.id = id;
    }

    @Override
    public String getTableName() {
        return "flight";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            LocalDate arrivalDate = resultSet.getDate("arrivalDate").toLocalDate();
            LocalDate departureDate = resultSet.getDate("departureDate").toLocalDate();
            double length = resultSet.getDouble("length");
            int duration = resultSet.getInt("duration");
            String description = resultSet.getString("description");
            double price = resultSet.getDouble("price");
            Airplane airplane = new Airplane(resultSet.getInt("airplaneid"));
            Airport arrivalAirport = new Airport(resultSet.getInt("arrivalairportid"));
            Airport departureAirport = new Airport(resultSet.getInt("departureairportid"));

            Flight f = new Flight(id, arrivalDate, departureDate, length, duration, description, price, airplane, arrivalAirport, departureAirport);
            list.add(f);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + arrivalDate + "', '" + departureDate + "', '" + length + "', '" + duration + "', '" + description + "', '" + price + "', '" + airplane.getId() + "', '" + arrivalAirport.getId() + "', '" + departureAirport.getId() + "'";
    }

    @Override
    public String getAttributes() {
        return "arrivalDate,departureDate,length,duration,description,price,airplaneid,arrivalAirportid,departureAirportid";
    }

    @Override
    public String setAttributes() {
        return "arrivalDate='" + arrivalDate + "', departureDate='" + departureDate + "', length='" + length + "', duration='" + duration + "', description='" + description + "', price='" + price + "', airplaneid='" + airplane.getId() + "', arrivalAirportid='" + arrivalAirport.getId() + "', departureAirportid='" + departureAirport.getId() + "'";

    }

    @Override
    public String getDeleteCondition() {
        return "id=" + id;
    }

    @Override
    public String getUpdateCondition() {
        return "id=" + id;
    }

    @Override
    public String getSelectCondition() {
        return "id=" + id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    @Override
    public String toString() {
        return departureAirport.getCity().getName() + " - " + arrivalAirport.getCity().getName();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.arrivalDate, other.arrivalDate)) {
            return false;
        }
        if (!Objects.equals(this.departureDate, other.departureDate)) {
            return false;
        }

        return true;
    }

    
    
    

}
