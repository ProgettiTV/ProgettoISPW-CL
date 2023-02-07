package com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator;

import java.sql.*;

public class DaoRicercaCpuAmd {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connectionCpuAmd;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private int ricercavalore;

    public DaoRicercaCpuAmd(int budgetPreso){
        this.ricercavalore=budgetPreso;
        System.out.println("DAO riceve B  "+ ricercavalore );

    }
    public static void getDaoCpuConnection() throws SQLException {

        try{
            if(connectionCpuAmd ==null){
                connectionCpuAmd = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }


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
