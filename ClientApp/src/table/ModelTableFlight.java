/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import domain.Flight;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aleksa
 */
public class ModelTableFlight extends AbstractTableModel{

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    List<Flight> listFlights;

    public List<Flight> getListFlights() {
        return listFlights;
    }

    public void setListFlights(List<Flight> listFlights) {
        this.listFlights = listFlights;
    }

    public ModelTableFlight() {
        listFlights = new ArrayList<>();
    }
    
    
    @Override
    public int getRowCount() {
        return listFlights.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Flight f = listFlights.get(rowIndex);
        switch(columnIndex) {
            case 0: return f.getDepartureDate().format(dtf);
            case 1: return f.getArrivalDate().format(dtf);
            case 2: return f.getPrice();
            case 3: return f.getAirplane();
            case 4: return f.getDepartureAirport();
            case 5: return f.getArrivalAirport();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Departure date";
            case 1: return "Arrival date";
            case 2: return "Price";
            case 3: return "Airplane";
            case 4: return "Departure airport";
            case 5: return "Arrival airport";
            default: return "N/A";
        }
    }
    
    
    
}
