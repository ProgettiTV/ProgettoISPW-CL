package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.io.IOException;
import java.sql.*;

public class DaoRicercaCase {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public   DaoRicercaCase(int budgetPreso){
        this.ricercavalore=budgetPreso;
    }



    public void cercaValore() throws SQLException , IOException {
        Connection connection= DBConnectionAmazon.getDBConnectionAmazon();
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
