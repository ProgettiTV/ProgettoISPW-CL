package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.sql.*;

public class DaoRicercaAlimentatore {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public DaoRicercaAlimentatore(int budgetPreso){
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
