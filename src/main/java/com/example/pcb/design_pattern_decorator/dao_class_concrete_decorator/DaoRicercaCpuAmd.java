package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DaoLoginConnection;

import java.sql.*;

public class DaoRicercaCpuAmd {

    private static Connection connectionCpuAmd;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public DaoRicercaCpuAmd(int budgetPreso){
        this.ricercavalore=budgetPreso;
        connectionCpuAmd= DaoLoginConnection.getDBConnection();
        // da fare in tutti i dao;

    }

    public void cercaValore() throws SQLException {

        Statement statement;


        try {
            statement = connectionCpuAmd.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String ricercaCpuAmd="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='" + "cpuAmd'" ;
        try {

            ResultSet queryCpuAmdResult=statement.executeQuery(ricercaCpuAmd);

            while(queryCpuAmdResult.next()){
                this.risultatoCaratteristica = queryCpuAmdResult.getString(2);
                this.risultatoRicerca = queryCpuAmdResult.getString(1);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String returnComponenteCpuAmd() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaCpuAmd() {
        return risultatoCaratteristica;
    }
}
