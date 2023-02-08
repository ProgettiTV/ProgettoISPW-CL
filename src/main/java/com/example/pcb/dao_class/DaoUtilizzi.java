package com.example.pcb.dao_class;

import java.sql.*;

public class DaoUtilizzi {

    private static final String databaseName = "parametridb";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String[] risultatoUtilizzo;
    private final String ricercaUtilizzo;


    public DaoUtilizzi(String utilizzoPreso) {
        this.ricercaUtilizzo=utilizzoPreso;

    }

    public static void getDaoUtilizziConnection() throws SQLException {

        try{
            if(connection ==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public  void cercaCaratteristiche()throws SQLException {

        Statement statement;

        String[] result = new String[9];

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String ricercaValoreUtilizzo ="SELECT C_CPU,RAM,SCHEDA_VIDEO,SSD,MONITOR,RAFFREDDAMENTO,C_CASE,SCHEDA_MADRE,ALIMENTATORE FROM parametri_utilizzo WHERE nome_utilizzo ='" + ricercaUtilizzo + "'";

        try {

            ResultSet queryUtilizzoResult = statement.executeQuery(ricercaValoreUtilizzo);

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
