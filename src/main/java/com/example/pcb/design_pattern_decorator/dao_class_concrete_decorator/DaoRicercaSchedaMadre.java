package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.sql.*;

public class DaoRicercaSchedaMadre {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public  DaoRicercaSchedaMadre(int budgetPreso){
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
