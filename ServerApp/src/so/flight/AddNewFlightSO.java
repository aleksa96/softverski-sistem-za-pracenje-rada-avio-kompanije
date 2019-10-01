/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.flight;

import domain.Flight;
import domain.IGeneralEntity;
import so.AbstractGenericOperation;

/**
 *
 * @author Aleksa
 */
public class AddNewFlightSO extends AbstractGenericOperation{

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Flight)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        db.save((IGeneralEntity) entity);
    }
    
}
