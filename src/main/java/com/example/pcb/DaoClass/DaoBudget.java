package com.example.pcb.DaoClass;

import java.sql.*;

public class DaoBudget {
    private static final String databaseName = "parametridb";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private int risultatoBudget;
    private int ricercavalore;
    public  DaoBudget(int budgetPreso){
        this.ricercavalore=budgetPreso;
        System.out.println("DAO riceve B  "+ ricercavalore );


    }
    public static Connection getDaoBudgetConnection() throws SQLException {

        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
    public void cercaValore() throws SQLException {

        Statement statement;

        String result="";
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("TUTTO OKAY 1  SU DB  " );
        String ricercaValoreBudget="SELECT valore FROM parametri_budget WHERE idparametri_budget=" + ricercavalore ;
        try {
            //System.out.println("TUTTO OKAY 2  SU DB  " );
            ResultSet queryBudgetResult=statement.executeQuery(ricercaValoreBudget);

            while(queryBudgetResult.next()){
                result = queryBudgetResult.getString(1);
            }
            System.out.println("prende dal db  " + queryBudgetResult );

            System.out.println("TUTTO OKAY 3  SU DB  " + result );


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println("TUTTO OKAY 5 SU DB  " );
        this.risultatoBudget= Integer.parseInt(result);
       // System.out.println("TUTTO OKAY 6  SU DB  " );

        System.out.println("TROVATO SU DB  " + risultatoBudget);

    }


    public int returnValoreBudget() {
        return risultatoBudget;
    }
}
