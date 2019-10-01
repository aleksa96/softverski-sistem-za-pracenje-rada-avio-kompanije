/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.country;

import domain.Country;
import domain.IGeneralEntity;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Aleksa
 */
public class GetAllCountrySO extends AbstractGenericOperation{
    private List<IGeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Country)) {
            throw new Exception("Object is not valid!");
        }
    }

    @Override
    protected void execute(Object entity) throws Exception {
        list = db.getAll((IGeneralEntity) entity);
    }

    public List<IGeneralEntity> getList() {
        return list;
    }
}
