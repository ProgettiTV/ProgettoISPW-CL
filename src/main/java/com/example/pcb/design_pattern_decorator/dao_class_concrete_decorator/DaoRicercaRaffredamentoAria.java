package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import com.example.pcb.dao_class.DBConnection;

import java.io.IOException;
import java.sql.*;

public class DaoRicercaRaffredamentoAria {
    private String risultatoRicerca;
    private String risultatoCaratteristica;

    private final int ricercavalore;

    public DaoRicercaRaffredamentoAria(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws SQLException, IOException {
        Connection connectionAffredamentoAria= DBConnectionAmazon.getDBConnectionAmazon();
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
