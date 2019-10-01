/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aleksa
 */
public class Airport implements IGeneralEntity{

    private long id;
    private String name;
    private int capacity;
    private double laneLength;
    private double laneWidth;
    private City city;

    public Airport(long id, String name, int capacity, double laneLength, double laneWidth, City city) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.laneLength = laneLength;
        this.laneWidth = laneWidth;
        this.city = city;
    }

    public Airport() {
    }

    Airport(int id) {
        this.id = id;
    }
    
    @Override
    public String getTableName() {
        return "airport";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int capacity = resultSet.getInt("capacity");
            double laneLength = resultSet.getDouble("laneLength");
            double laneWidth = resultSet.getDouble("laneWidth");
            City city = new City(resultSet.getInt("cityid"));
            Airport a = new Airport(id, name, capacity, laneLength, laneWidth, city);
            list.add(a);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + name + "', '" + capacity + "', '" + laneLength + "', '" + laneWidth + "', '" + city.getId() + "'" ;
    }

    @Override
    public String getAttributes() {
        return "name,capacity,laneLength,laneWidth,cityid";
    }

    @Override
    public String setAttributes() {
        return "name='" + name + "', capacity='" + capacity + "', laneLength='" + laneLength + "', laneWidth='" + laneWidth + "', cityid='" + city.getId() + "'" ;
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
        final Airport other = (Airport) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
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
            return "cityid='" + city.getId() + "'";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getLaneLength() {
        return laneLength;
    }

    public void setLaneLength(double laneLength) {
        this.laneLength = laneLength;
    }

    public double getLaneWidth() {
        return laneWidth;
    }

    public void setLaneWidth(double laneWidth) {
        this.laneWidth = laneWidth;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
