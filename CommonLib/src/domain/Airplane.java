/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aleksa
 */
public class Airplane implements IGeneralEntity{

    private long id;
    private String manufacturer;
    private String model;
    private int seats;
    private String fuelType;
    private AirplaneType airplaneType;

    Airplane(int id) {
        this.id = id;
    }
    
    
    @Override
    public String getTableName() {
        return "airplane";
    }

    public Airplane(long id, String manufacturer, String model, int seats, String fuelType, AirplaneType airplaneType) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.seats = seats;
        this.fuelType = fuelType;
        this.airplaneType = airplaneType;
    }

    public Airplane() {
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String manufacturer = resultSet.getString("manufacturer");
            String model = resultSet.getString("model");
            int seats = resultSet.getInt("numberofseats");
            String fuelType = resultSet.getString("fuelType");
            AirplaneType at = new AirplaneType(resultSet.getInt("AirplaneTypeID"));
            Airplane a = new Airplane(id, manufacturer, model, seats, fuelType, at);
            list.add(a);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + manufacturer + "', '" + model + "', '" + seats + "', '" + fuelType + "', '" + airplaneType.getId() + "'" ;
    }

    @Override
    public String getAttributes() {
        return "manufacturer,model,seats,fuelType,airplanetypeid";
    }

    @Override
    public String setAttributes() {
        return "manufacturer='" + manufacturer + "', model='" + model + "', seats='" + seats + "', fuelType='" + fuelType + "', airplaneTypeid='" + airplaneType.getId() + "'" ;
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
        if (id == -1) {
            return "airplaneTypeid='" + airplaneType.getId() + "'";
        } else {
            return "id=" + id;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    @Override
    public String toString() {
        return manufacturer + " " + model; //To change body of generated methods, choose Tools | Templates.
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
        final Airplane other = (Airplane) obj;
        if (this.seats != other.seats) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.fuelType, other.fuelType)) {
            return false;
        }
        return true;
    }
    
    
    
}
