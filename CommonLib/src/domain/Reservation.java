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
public class Reservation implements IGeneralEntity {

    private long id;
    private double price;
    private LocalDate reservationDate;
    private User user;
    private FlightClass fl;
    private Passenger passenger;
    private Flight flight;

    public Reservation(long id, double price, LocalDate reservationDate, User user, FlightClass fl, Passenger passenger, Flight flight) {
        this.id = id;
        this.price = price;
        this.reservationDate = reservationDate;
        this.user = user;
        this.fl = fl;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Reservation() {
    }

    @Override
    public String getTableName() {
        return "reservation";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            double price = resultSet.getDouble("price");
            LocalDate reservationDate = resultSet.getDate("reservationDate").toLocalDate();
            User user = new User(resultSet.getInt("userid"));
            FlightClass fl = new FlightClass(resultSet.getInt("flightclassid"));
            Passenger passenger = new Passenger(resultSet.getInt("passengerid"));
            Flight flight = new Flight(resultSet.getInt("flightid"));
            
            Reservation r = new Reservation(id, price, reservationDate, user, fl, passenger, flight);

            list.add(r);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + price + "', '" + reservationDate + "', '" + user.getUserID() + "', '" + fl.getId() + "', '" + passenger.getId() + "', '" + flight.getId() + "'";
    }

    @Override
    public String getAttributes() {
        return "price,reservationDate,userid,flightclassid,passengerid,flightid";
    }

    @Override
    public String setAttributes() {
        return "price='" + price + "', reservationDate='" + reservationDate + "', userid='" + user.getUserID() + "', flightclassid='" + fl.getId() + "', passengerid='" + passenger.getId() + "', flightid='" + flight.getId() + "'";
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FlightClass getFl() {
        return fl;
    }

    public void setFl(FlightClass fl) {
        this.fl = fl;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Reservation other = (Reservation) obj;
        if (!Objects.equals(this.reservationDate, other.reservationDate)) {
            return false;
        }
        if (!Objects.equals(this.fl, other.fl)) {
            return false;
        }
        if (!Objects.equals(this.passenger, other.passenger)) {
            return false;
        }
        if (!Objects.equals(this.flight, other.flight)) {
            return false;
        }
        return true;
    }

    

    

    

    

    

    

}
