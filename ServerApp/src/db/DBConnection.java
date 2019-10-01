/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.SettingsLoader;

/**
 *
 * @author Aleksa
 */
public class DBConnection {
    
    private final Connection connection;
    private static DBConnection instance;

    private DBConnection() throws SQLException {
        String url = SettingsLoader.getInstance().getProperty("URL");
        String username = SettingsLoader.getInstance().getProperty("USERNAME");
        String password = SettingsLoader.getInstance().getProperty("PASSWORD");

        connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    public void closeConnection() throws SQLException {
        connection.close();
        instance = null;
    }
    
}
