package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.sql.*;

public class DaoRicercaSsd {
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public  DaoRicercaSsd(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws SQLException {
        Connection connection= DBConnectionAmazon.getDBConnectionAmazon();
        Statement statement;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String ricercaSsd="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"ssd'" ;
        try {

            ResultSet querySsdResult=statement.executeQuery(ricercaSsd);

            while(querySsdResult.next()){
                this.risultatoCaratteristica = querySsdResult.getString(2);
                this.risultatoRicerca = querySsdResult.getString(1);

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public String returnComponenteSsd() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaSsd() {
        return risultatoCaratteristica;
    }
}
