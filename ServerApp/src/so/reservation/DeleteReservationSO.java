/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.reservation;

import domain.IGeneralEntity;
import domain.Reservation;
import so.AbstractGenericOperation;

/**
 *
 * @author Aleksa
 */
public class DeleteReservationSO extends AbstractGenericOperation{

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Reservation)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        db.delete((IGeneralEntity) entity);
    }
    
}
