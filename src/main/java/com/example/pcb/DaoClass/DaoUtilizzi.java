package com.example.pcb.DaoClass;

import java.sql.*;
import java.util.ArrayList;

public class DaoUtilizzi {
    private String[] risultatoUtilizzo;
    private String ricercaUtilizzo;



    private static final String databaseName = "parametridb";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;

    public DaoUtilizzi(String utilizzoPreso) {
        this.ricercaUtilizzo=utilizzoPreso;

    }

    public static Connection getDaoUtilizziConnection() throws SQLException {

        try{
            if(connection ==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }


    public  void cercaCaratteristiche()throws SQLException {

        Statement statement;

        String[] result = new String[9];

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("TUTTO OKAY 1  SU DB  " );
        String ricercaValoreUtilizzo ="SELECT C_CPU,RAM,SCHEDA_VIDEO,SSD,MONITOR,RAFFREDDAMENTO,C_CASE,SCHEDA_MADRE,ALIMENTATORE FROM parametri_utilizzo WHERE nome_utilizzo ='" + ricercaUtilizzo + "'";
        //System.out.println(" " );
        //String ricercaValoreUtilizzo ="SELECT * FROM parametri_utilizzo WHERE nome_utilizzo= " + ricercaUtilizzo;
        try {
            System.out.println("TUTTO OKAY 2  SU DB  " );

            // errore sul executQuery
            ResultSet queryUtilizzoResult = statement.executeQuery(ricercaValoreUtilizzo);
            //String  prova1=queryUtilizzoResult.getString(1);
            //System.out.println("prova 1 "+ prova1 );

            int i=0;
            //ArrayList<String> list = new ArrayList<String>();
            while(queryUtilizzoResult.next() ){
                for(int j=0;j<9;j++){
                    result[j]=queryUtilizzoResult.getString(j+1);
                }

            }
            this.risultatoUtilizzo=result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public String[] returnListaUtilizzo() {
        return risultatoUtilizzo;
    }
}
