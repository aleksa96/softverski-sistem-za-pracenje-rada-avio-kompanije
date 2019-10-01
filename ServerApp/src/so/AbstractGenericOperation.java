/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import db.DBConnection;
import db.IDBBroker;

/**
 *
 * @author Aleksa
 */
public abstract class AbstractGenericOperation {
    protected IDBBroker db;

    public AbstractGenericOperation() {
        db = new DBBroker();
    }

    public final void templateExecute(Object entity) throws Exception {
        try {
            validate(entity);
            startTransaction();
            execute(entity);
            commitTransaction();
        } catch (Exception ex) {
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void validate(Object entity) throws Exception;

    protected abstract void execute(Object entity) throws Exception;

    private void startTransaction() throws Exception {
        DBConnection.getInstance().getConnection().setAutoCommit(false);
    }

    private void commitTransaction() throws Exception {
        DBConnection.getInstance().commit();
    }

    private void rollbackTransaction() throws Exception {
        DBConnection.getInstance().rollback();
    }
}
