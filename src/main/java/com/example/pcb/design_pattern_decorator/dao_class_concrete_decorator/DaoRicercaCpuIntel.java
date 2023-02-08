package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.*;

public class DaoRicercaCpuIntel {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connectionCpuIntel;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public DaoRicercaCpuIntel(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }
    public static void getDaoCpuConnection() throws SQLException {

        try{
            if(connectionCpuIntel ==null){
                connectionCpuIntel = DriverManager.getConnection(url, databaseUser, databasePassword);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void cercaValore() throws SQLException {

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
