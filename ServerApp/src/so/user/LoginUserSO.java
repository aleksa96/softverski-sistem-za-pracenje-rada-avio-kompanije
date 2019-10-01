/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.user;

import domain.IGeneralEntity;
import domain.User;
import so.AbstractGenericOperation;



/**
 *
 * @author Aleksa
 */
public class LoginUserSO extends AbstractGenericOperation {

    IGeneralEntity object;
    
    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof User)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        object = db.getById((IGeneralEntity) entity);
    }
    
    public IGeneralEntity getObject() {
        return object;
    }
    
}
