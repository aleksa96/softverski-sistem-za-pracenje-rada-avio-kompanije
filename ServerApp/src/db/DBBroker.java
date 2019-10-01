/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domain.IGeneralEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Aleksa
 */
public class DBBroker implements IDBBroker{

    @Override
    public IGeneralEntity getById(IGeneralEntity entity) throws Exception {
        List<IGeneralEntity> list;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "select * from " + entity.getTableName() + " where " + entity.getSelectCondition();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            statement.close();
            return list.get(0);
        } catch (Exception ex) {
            throw new Exception("Ne postoji!");
        }
    }

    @Override
    public List<IGeneralEntity> getAll(IGeneralEntity entity) throws Exception {
        List<IGeneralEntity> list;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "select * from " + entity.getTableName();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public int save(IGeneralEntity entity) throws Exception {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "insert into " + entity.getTableName() + "(" + entity.getAttributes() + ")" + " values(" + entity.getValues() + ")";
            PreparedStatement preparedStatement = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs != null && rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void delete(IGeneralEntity entity) throws Exception {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "delete from " + entity.getTableName() + " where " + entity.getDeleteCondition();
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void edit(IGeneralEntity entity) throws Exception {
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "update " + entity.getTableName() + " set " + entity.setAttributes() + " where " + entity.getUpdateCondition();
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            conn.commit();
            statement.close();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<IGeneralEntity> getByCondition(IGeneralEntity entity) throws Exception {
        List<IGeneralEntity> list;
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            String query = "select * from " + entity.getTableName() + " where " + entity.getSelectCondition();
            System.out.println(query);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
}
