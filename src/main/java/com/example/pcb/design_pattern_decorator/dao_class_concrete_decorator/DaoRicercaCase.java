package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.*;

public class DaoRicercaCase {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public   DaoRicercaCase(int budgetPreso){
        this.ricercavalore=budgetPreso;
    }
    public static void getDaoCaseConnection() throws SQLException {

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

        String ricercaCase="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"case'" ;
        try {

            ResultSet queryCaseResult=statement.executeQuery(ricercaCase);

            while(queryCaseResult.next()){
                this.risultatoRicerca = queryCaseResult.getString(1);
                this.risultatoRicerca = queryCaseResult.getString(1);
                this.risultatoCaratteristica = queryCaseResult.getString(2);
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String returnComponenteCase() {
        return risultatoRicerca;
    }

    public String returnCaratteristiCase() {
        return risultatoCaratteristica;
    }
}
