package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.sql.*;

public class DaoRicercaCpuIntel {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public DaoRicercaCpuIntel(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws SQLException {
        Connection connectionCpuIntel= DBConnection.getDBConnection();
        Statement statement;

        try {
            statement = connectionCpuIntel.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String ricercaCpuIntel="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='" + "cpuIntel'" ;
        try {

            ResultSet queryCpuIntelResult=statement.executeQuery(ricercaCpuIntel);

            while(queryCpuIntelResult.next()){

                this.risultatoRicerca = queryCpuIntelResult.getString(1);
                this.risultatoCaratteristica = queryCpuIntelResult.getString(2);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String returnComponenteCpuIntel() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaCpuIntel() {
        return risultatoCaratteristica;
    }
}
