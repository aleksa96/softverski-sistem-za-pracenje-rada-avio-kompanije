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
public class City implements IGeneralEntity{

    private long id;
    private String name;
    private Country country;

    public City() {
    }

    public City(long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    City(int id) {
        this.id = id;
    }
    
    
    @Override
    public String getTableName() {
        return "city";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Country country = new Country(resultSet.getInt("countryid"));
            City c = new City(id, name, country);
            list.add(c);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + name + "', '" + country.getId() + "'";
    }

    @Override
    public String getAttributes() {
        return "name,countryid";
    }

    @Override
    public String setAttributes() {
        return "name='" + name + "', countryid='" + country.getId() + "'";
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
            return "countryid='" + country.getId() + "'";
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
}
