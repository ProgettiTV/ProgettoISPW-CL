package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.io.IOException;
import java.sql.*;

public class DaoRicercaSchedaVideo {

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    private final int ricercavalore;

    public  DaoRicercaSchedaVideo(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws SQLException, IOException {
        Connection connection= DBConnectionAmazon.getDBConnectionAmazon();
        Statement statement;

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        String ricercaSchedaVideo="SELECT link,caratteristica FROM amazon_componenti WHERE valore=" + ricercavalore + " AND tipo_c='"+"scheda video'" ;
        try {

            ResultSet querySchedaVideoResult=statement.executeQuery(ricercaSchedaVideo);

            while(querySchedaVideoResult.next()){
                this.risultatoRicerca = querySchedaVideoResult.getString(1);
                this.risultatoCaratteristica = querySchedaVideoResult.getString(2);
            }


        } catch (SQLException e) {
            throw new SQLException(e);
        }

    }


    public String returnComponenteSchedaVideo() {
        return risultatoRicerca;
    }

    public String returnCaratteristicaSchedaVideo() {
        return risultatoCaratteristica;
    }
}
