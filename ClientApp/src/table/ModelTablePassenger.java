/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import domain.Passenger;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aleksa
 */
public class ModelTablePassenger extends AbstractTableModel{

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    List<Passenger> listPassenger;

    public List<Passenger> getListPassenger() {
        return listPassenger;
    }

    public void setListPassenger(List<Passenger> listPassenger) {
        this.listPassenger = listPassenger;
    }

    public ModelTablePassenger() {
        listPassenger = new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return listPassenger.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Passenger p = listPassenger.get(rowIndex);
        switch(columnIndex) {
            case 0: return p.getPassport();
            case 1: return p.getFirstName();
            case 2: return p.getLastName();
            case 3: return p.getDateOfBirth().format(dtf);
            case 4: return p.getStreet();
            case 5: return p.getEmail();
            case 6: return p.getPhone();
            case 7: return p.getCountry().getName();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Passport";
            case 1: return "First name";
            case 2: return "Last name";
            case 3: return "Date of birth";
            case 4: return "Street";
            case 5: return "Email";
            case 6: return "Phone";
            case 7: return "Country";
            default: return "N/A";
        }
    }

    public void removePassenger(Passenger p) {
        listPassenger.remove(p);
        this.fireTableDataChanged();
    }

    public void addPassenger(Passenger p) {
        listPassenger.add(p);
        this.fireTableDataChanged();
    }
    
}
