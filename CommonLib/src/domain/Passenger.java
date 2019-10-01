/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Aleksa
 */
public class Passenger implements IGeneralEntity{

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String street;
    private String email;
    private String phone;
    private Country country;
    private int passport;

    public Passenger(long id, String firstName, String lastName, LocalDate dateOfBirth, String street, String email, String phone, Country country,int passport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.passport = passport;
    }

    public Passenger() {
    }

    public Passenger(int id) {
        this.id = id;
    }
    
    @Override
    public String getTableName() {
        return "passenger";
    }

    @Override
    public List<IGeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<IGeneralEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            LocalDate dateOfBirth = resultSet.getDate("dateOfBirth").toLocalDate();
            String street = resultSet.getString("street");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            Country c = new Country(resultSet.getInt("countryid"));
            int passport = resultSet.getInt("passport");
            Passenger p = new Passenger(id, firstName, lastName, dateOfBirth, street, email, phone, c,passport);
            list.add(p);
        }
        return list;
    }

    @Override
    public String getValues() {
        return "'" + firstName + "', '" + lastName + "', '" + dateOfBirth + "', '" + street + "', '" + email + "', '" + phone + "', '" + country.getId() + "', '" + passport + "'" ;
    }

    @Override
    public String getAttributes() {
        return "firstName,lastName,dateOfBirth,street,email,phone,countryid,passport";
    }

    @Override
    public String setAttributes() {
        return "firstName='" + firstName + "', lastName='" + lastName + "', dateOfBirth='" + dateOfBirth + "', street='" + street + "', email='" + email + "', phone='" + phone + "', countryid='" + country.getId() + "', passport='" + passport + "'" ;
    }

    @Override
    public String getDeleteCondition() {
        return "id=" + id;
    }

    @Override
    public String getUpdateCondition() {
        return "id=" + id;
    }

    @Override
    public String getSelectCondition() {
        return "id=" + id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName; //To change body of generated methods, choose Tools | Templates.
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passenger other = (Passenger) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.passport != other.passport) {
            return false;
        }
        
        return true;
    }

    
    
    
    
}
