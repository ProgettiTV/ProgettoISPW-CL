package com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator;

import java.sql.*;

public class DaoRicercaAlimentatore {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private int ricercavalore;

    public   DaoRicercaAlimentatore(int budgetPreso){
        this.ricercavalore=budgetPreso;
        System.out.println("DAO riceve B  "+ ricercavalore );


    }
    public static void  getDaoAlimentatoreConnection() throws SQLException {

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


        String ricercaAlimentatore="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"alimentatore'" ;
        try {

            ResultSet queryAlimentatoreResult=statement.executeQuery(ricercaAlimentatore);

            while(queryAlimentatoreResult.next()){
                this.risultatoRicerca = queryAlimentatoreResult.getString(1);
                this.risultatoCaratteristica = queryAlimentatoreResult.getString(2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }


    public String returnComponenteAlimentatore() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaAlimentatore() {
        return risultatoCaratteristica;
    }
}
