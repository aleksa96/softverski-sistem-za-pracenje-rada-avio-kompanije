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
public class Country implements IGeneralEntity {

    private long id;
    private String name;
    private int population;
    private String position;

    public Country(long id, String name, int population, String position) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.position = position;
    }

    public Country() {
    }

    public Country(int id) {
        this.id = id;
    }

    @Override
    public String getTableName() {
        return "country";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int population = resultSet.getInt("population");
            String position = resultSet.getString("position");
            Country c = new Country(id, name, population, position);
            list.add(c);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + name + "', '" + population + "', '" + position + "'";
    }

    @Override
    public String getAttributes() {
        return "name,population,position";
    }

    @Override
    public String setAttributes() {
        return "name='" + name + "', population='" + population + "', position='" + position + "'";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
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
        final Country other = (Country) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    
}
