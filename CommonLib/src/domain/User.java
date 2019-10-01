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
public class User implements IGeneralEntity {

    private int userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public User() {
    }

    public User(int userID, String firstName, String lastName, String username, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(int id) {
        this.userID = id;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int userID = resultSet.getInt("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            User user = new User(userID, firstName, lastName, username, password);
            list.add(user);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + firstName + "', '" + lastName + "', '" + username + "', '" + password + "'";
    }

    @Override
    public String getAttributes() {
        return "firstName,lastName,username,password";
    }

    @Override
    public String setAttributes() {
        return "firstName='" + firstName + "', lastName='" + lastName + "', username='" + username + "', password='" + password + "'";
    }

    @Override
    public String getDeleteCondition() {
        return "id=" + userID;
    }

    @Override
    public String getUpdateCondition() {
        return "id=" + userID;
    }

    @Override
    public String getSelectCondition() {
        if (username != null) {
            return "username='" + username + "' and password='" + password + "'";
        } else {
            return "id=" + userID;
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
