package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.*;

public class DaoRicercaRam {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public   DaoRicercaRam(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }
    public static void getDaoRamConnection() throws SQLException {

        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void cercaValore() throws SQLException {

        Statement statement;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String ricercaRam="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"ram'" ;
        try {

            ResultSet queryRamResult=statement.executeQuery(ricercaRam);

            while(queryRamResult.next()){
                this.risultatoRicerca = queryRamResult.getString(1);
                this.risultatoCaratteristica = queryRamResult.getString(2);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public String returnComponenteRam() {
        return risultatoRicerca;
    }


    public String returnCaratteristicaRam() {
        return risultatoCaratteristica;
    }
}
