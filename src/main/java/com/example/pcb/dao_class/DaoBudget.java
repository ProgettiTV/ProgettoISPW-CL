package com.example.pcb.dao_class;

import com.example.pcb.exception.DaoException;

import java.sql.*;

public class DaoBudget {
    private static final String databaseName = "parametridb";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private int risultatoBudget;
    private final int ricercavalore;
    public  DaoBudget(int budgetPreso){
        this.ricercavalore=budgetPreso;

    }
    public static void getDaoBudgetConnection() throws SQLException {

        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void cercaValore() throws DaoException {

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
