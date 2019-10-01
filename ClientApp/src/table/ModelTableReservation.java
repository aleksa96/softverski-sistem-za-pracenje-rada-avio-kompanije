/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import domain.Passenger;
import domain.Reservation;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aleksa
 */
public class ModelTableReservation extends AbstractTableModel{

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private List<Reservation> listReservation;

    public ModelTableReservation() {
        listReservation = new ArrayList<>();
    }
    
    @Override
    public int getRowCount() {
        return listReservation.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reservation r = listReservation.get(rowIndex);
        switch(columnIndex) {
            case 0: return r.getPrice();
            case 1: return r.getReservationDate().format(dtf);
            case 2: return r.getUser();
            case 3: return r.getFl();
            case 4: return r.getPassenger();
            case 5: return r.getFlight();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Price";
            case 1: return "Reservation date";
            case 2: return "User";
            case 3: return "Flight class";
            case 4: return "Passenger";
            case 5: return "Flight";
            default: return "N/A";
        }
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public void addReservaion(Reservation r) {
        listReservation.add(r);
        this.fireTableDataChanged();
    }
    public void removeReservaion(Reservation r) {
        listReservation.remove(r);
        this.fireTableDataChanged();
    }
    
    
}
