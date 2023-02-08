package com.example.pcb;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observer;

public class DaoBudget extends AbstractSubject{
    private static final String databaseName = "parametridb";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private int valoreRicercaBudget;
    private String rispostaBudgetDB;
    private String budgetDaInserire;
    private String valoreNuovoBudget;
    private int budgetObs;
    private static DaoBudget instance;


    private DaoBudget() {

        this.observers = new ArrayList<>();

    }

    public static DaoBudget getInstance(){
        if(instance==null){
            instance = new DaoBudget();
        }
        return instance;
    }
    public void setValoreRicercaBudget(int valore){
        this.valoreRicercaBudget = valore;
    }

    public void setNuovoValoreBudget(String valore){

        this.valoreNuovoBudget = valore;
        System.out.println("vnb: " + valoreNuovoBudget);
    }

    public static Connection getDaoBudgetConnection(){

        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void cercaBudget() throws SQLException {

        String showBudgetQuery = "SELECT Valore FROM parametri_budget WHERE idparametri_budget = " + valoreRicercaBudget;

        Statement statement = connection.createStatement();
        ResultSet querySearchBudgetResult = statement.executeQuery(showBudgetQuery);

        while (querySearchBudgetResult.next()){
            rispostaBudgetDB = querySearchBudgetResult.getString(1);

            System.out.println(rispostaBudgetDB);
        }
    }

    public void aggiornaBudget() throws SQLException {


        System.out.println("nb: "+ valoreNuovoBudget + "id: " + valoreRicercaBudget);
        String updateBudgetQuery = "UPDATE parametri_budget SET Valore = '" + valoreNuovoBudget + "' WHERE idparametri_budget = " + valoreRicercaBudget;
        Statement statement = connection.createStatement();
        statement.executeUpdate(updateBudgetQuery);
        notifyObservers(Integer.parseInt(valoreNuovoBudget));

    }
    public int returnValoreBudgetDB(){
        return Integer.parseInt(rispostaBudgetDB);
    }

    @Override
    public void addObserver(AbstractObserver observer) {

        observers.add(observer);
    }


    @Override
    public void notifyObservers(int budget) {

        System.out.println("subject invocato");
        for (AbstractObserver observer : observers) {
            observer.updateBudget(budget);
            System.out.println("sono il subject");
        }

    }


}
