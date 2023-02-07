package com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator;

import java.sql.*;

public class DaoRicercaRaffredamentoAria {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connectionAffredamentoAria;
    private String risultatoRicerca;
    private String risultatoCaratteristica;

    private int ricercavalore;

    public DaoRicercaRaffredamentoAria(int budgetPreso){
        this.ricercavalore=budgetPreso;
        System.out.println("DAO riceve B  "+ ricercavalore );


    }
    public static void getDaoRaffredamentoAriaConnection() throws SQLException {

        try{
            if(connectionAffredamentoAria ==null){
                connectionAffredamentoAria = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void cercaValore() throws SQLException {

        Statement statement;


        try {
            statement = connectionAffredamentoAria.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String ricercaRaffredamentoAria="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"raffreddamento aria'" ;
        try {

            ResultSet queryRaffredamentoAriaResult=statement.executeQuery(ricercaRaffredamentoAria);

            while(queryRaffredamentoAriaResult.next()){
                this.risultatoRicerca = queryRaffredamentoAriaResult.getString(1);
                this.risultatoCaratteristica = queryRaffredamentoAriaResult.getString(2);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public String returnComponenteRaffredamentoAria() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaRaffredamentoAria() {
        return risultatoCaratteristica;
    }
}
