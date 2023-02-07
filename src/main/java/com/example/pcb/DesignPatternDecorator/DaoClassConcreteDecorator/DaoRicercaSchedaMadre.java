package com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator;

import java.sql.*;

public class DaoRicercaSchedaMadre {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private int ricercavalore;

    public  DaoRicercaSchedaMadre(int budgetPreso){
        this.ricercavalore=budgetPreso;
        System.out.println("DAO riceve B  "+ ricercavalore );


    }
    public static void getDaoSchedaMadreConnection() throws SQLException {

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
        String ricercaSchedaMadre="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"scheda madre'" ;
        try {
            ResultSet querySchedaMadreResult=statement.executeQuery(ricercaSchedaMadre);

            while(querySchedaMadreResult.next()){
                this.risultatoRicerca = querySchedaMadreResult.getString(1);
                this.risultatoCaratteristica = querySchedaMadreResult.getString(2);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String returnComponenteSchedaMadre() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaSchedaMadre() {
        return risultatoCaratteristica;
    }
}
