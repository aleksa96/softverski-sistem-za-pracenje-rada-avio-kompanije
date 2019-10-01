/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.IGeneralEntity;
import java.util.List;

/**
 *
 * @author Aleksa
 */
public interface IDBBroker {
    
    IGeneralEntity getById(IGeneralEntity entity) throws Exception;
    
    List<IGeneralEntity> getAll(IGeneralEntity entity) throws Exception;
    
    int save(IGeneralEntity entity) throws Exception;
    
    void delete(IGeneralEntity entity) throws Exception;
    
    void edit(IGeneralEntity entity) throws Exception;
    
    List<IGeneralEntity> getByCondition(IGeneralEntity entity) throws Exception;
    
}
