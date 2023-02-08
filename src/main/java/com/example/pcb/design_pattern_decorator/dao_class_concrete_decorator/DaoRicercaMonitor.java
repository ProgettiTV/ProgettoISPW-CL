package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.*;

public class DaoRicercaMonitor {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private  final int ricercavalore;

    public DaoRicercaMonitor(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }
    public static void getDaoMonitorConnection() throws SQLException {

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


        String ricercaMonitor="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"monitor'" ;
        try {

            ResultSet queryMonitorResult=statement.executeQuery(ricercaMonitor);

            while(queryMonitorResult.next()){
                this.risultatoRicerca = queryMonitorResult.getString(1);
                this.risultatoCaratteristica = queryMonitorResult.getString(2);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public String returnComponenteMonitor() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaMonitor() {
        return risultatoCaratteristica;
    }
}
