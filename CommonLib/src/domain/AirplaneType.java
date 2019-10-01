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
public class AirplaneType implements IGeneralEntity{

    private long id;
    private String name;

    public AirplaneType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AirplaneType() {
    }

    public AirplaneType(int id) {
        this.id = id;
    }
    
    @Override
    public String getTableName() {
        return "airplanetype";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            AirplaneType at = new AirplaneType(id, name);
            list.add(at);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + name + "'";
    }

    @Override
    public String getAttributes() {
        return "name";
    }

    @Override
    public String setAttributes() {
        return "name='" + name + "'";
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

    @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
