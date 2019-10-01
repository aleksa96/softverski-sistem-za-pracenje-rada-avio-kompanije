/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Aleksa
 */
public interface IGeneralEntity extends Serializable {
    
    public String getTableName();

    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception;

    public String getValues();

    public String getAttributes();

    public String setAttributes();

    public String getDeleteCondition();

    public String getUpdateCondition();

    public String getSelectCondition();
    
}
