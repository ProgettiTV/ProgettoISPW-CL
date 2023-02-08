package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.io.IOException;
import java.sql.*;

public class DaoRicercaRam {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public   DaoRicercaRam(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws SQLException, IOException {
        Connection connection= DBConnectionAmazon.getDBConnectionAmazon();
        Statement statement;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String ricercaRam="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"ram'" ;
        try {

            ResultSet queryRamResult=statement.executeQuery(ricercaRam);

            while(queryRamResult.next()){
                this.risultatoRicerca = queryRamResult.getString(1);
                this.risultatoCaratteristica = queryRamResult.getString(2);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public String returnComponenteRam() {
        return risultatoRicerca;
    }


    public String returnCaratteristicaRam() {
        return risultatoCaratteristica;
    }
}
