package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.*;

public class DaoRicercaSchedaVideo {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public  DaoRicercaSchedaVideo(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }
    public static void getDaoSchedaVideoConnection() throws SQLException {

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

        String ricercaSchedaVideo="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"scheda video'" ;
        try {

            ResultSet querySchedaVideoResult=statement.executeQuery(ricercaSchedaVideo);

            while(querySchedaVideoResult.next()){
                this.risultatoRicerca = querySchedaVideoResult.getString(1);
                this.risultatoCaratteristica = querySchedaVideoResult.getString(2);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String returnComponenteSchedaVideo() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaSchedaVideo() {
        return risultatoCaratteristica;
    }
}