package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.*;

public class DaoRicercaRaffredamentoAcqua {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connectionAffredamentoAcqua;
    private String risultatoRicerca;
    private String risultatoCaratteristica;

    private final int ricercavalore;

    public DaoRicercaRaffredamentoAcqua(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }
    public static void getDaoRaffredamentoAcquaConnection() throws SQLException {

        try{
            if(connectionAffredamentoAcqua ==null){
                connectionAffredamentoAcqua = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void cercaValore() throws SQLException {

        Statement statement;


        try {
            statement = connectionAffredamentoAcqua.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String ricercaRaffredamentoAcqua="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"raffreddamento acqua'" ;
        try {

            ResultSet queryRaffredamentoAcquaResult=statement.executeQuery(ricercaRaffredamentoAcqua);

            while(queryRaffredamentoAcquaResult.next()){
                this.risultatoRicerca = queryRaffredamentoAcquaResult.getString(1);
                this.risultatoCaratteristica = queryRaffredamentoAcquaResult.getString(2);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public String returnComponenteRaffredamentoAcqua() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaRaffredamentoAcqua() {
        return risultatoCaratteristica;
    }
}
