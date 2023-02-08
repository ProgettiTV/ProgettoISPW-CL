package com.example.pcb.dao_class;

import java.io.IOException;
import java.sql.*;

public class DaoUtilizzi {


    private String[] risultatoUtilizzo;
    private final String ricercaUtilizzo;


    public DaoUtilizzi(String utilizzoPreso) {
        this.ricercaUtilizzo=utilizzoPreso;

    }




    public  void cercaCaratteristiche() throws SQLException, IOException {
        Connection connection=DBConnection.getDBConnection();
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
