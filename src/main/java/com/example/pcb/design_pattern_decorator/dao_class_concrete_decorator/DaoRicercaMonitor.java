package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.io.IOException;
import java.sql.*;

public class DaoRicercaMonitor {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private  final int ricercavalore;

    public DaoRicercaMonitor(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws SQLException, IOException {
        Connection connection= DBConnectionAmazon.getDBConnectionAmazon();
        Statement statement;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {

            throw new SQLException(e);
        }


        String ricercaMonitor="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"monitor'" ;
        try {

            ResultSet queryMonitorResult=statement.executeQuery(ricercaMonitor);

            while(queryMonitorResult.next()){
                this.risultatoRicerca = queryMonitorResult.getString(1);
                this.risultatoCaratteristica = queryMonitorResult.getString(2);
            }


        } catch (SQLException e) {
            throw new SQLException(e);
        }


    }


    public String returnComponenteMonitor() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaMonitor() {
        return risultatoCaratteristica;
    }
}
