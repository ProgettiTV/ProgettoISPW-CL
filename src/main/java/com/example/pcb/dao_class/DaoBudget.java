package com.example.pcb.dao_class;

import com.example.pcb.exception.DaoException;

import java.io.IOException;
import java.sql.*;

public class DaoBudget {

    private int risultatoBudget;
    private final int ricercavalore;
    public  DaoBudget(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }

    public void cercaValore() throws DaoException, IOException {
        Connection connection=DBConnection.getDBConnection();
        Statement statement;

        String result="";
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }


        String ricercaValoreBudget="SELECT valore FROM parametri_budget WHERE idparametri_budget=" + ricercavalore ;
        try {

            ResultSet queryBudgetResult=statement.executeQuery(ricercaValoreBudget);

            while(queryBudgetResult.next()){
                result = queryBudgetResult.getString(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.risultatoBudget= Integer.parseInt(result);


    }


    public int returnValoreBudget() {
        return risultatoBudget;
    }
}
