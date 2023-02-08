package com.example.pcb;

import java.sql.*;
import java.util.Arrays;

public class DaoUtilizzi {
    private static final String databaseName = "parametridb";
    private static final String databaseUser = "root";
    private static final String databasePassword = "ciao";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;
    private String stringaRicercaUtilizzo;
    private String[] rispostaUtilizzoDB;
    private String[] stringaAggiornamentoUtilizzo;
    private String stringaPercentualiUtilizzo;


    public DaoUtilizzi() {
        //costruttore
    }

    public void setNomeRicercaUtilizzo(String nomeUtilizzo){
        this.stringaRicercaUtilizzo = nomeUtilizzo;
    }

    public void setStringaPercentualiUtilizzo(String percentualiUtilizzo){
        this.stringaPercentualiUtilizzo = percentualiUtilizzo;
    }

    public static Connection getDaoUtilizziConnection(){

        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void cercaPercentualiUtilizzo() throws SQLException {

        rispostaUtilizzoDB = new String[9];
        String showUtilizzoQuery = "SELECT C_CPU, RAM, SCHEDA_VIDEO, SSD, MONITOR, RAFFREDDAMENTO, C_CASE, SCHEDA_MADRE, ALIMENTATORE FROM parametri_utilizzo WHERE nome_utilizzo = '" + stringaRicercaUtilizzo + "'";

        Statement statement = connection.createStatement();
        ResultSet queryUtilizzoResult = statement.executeQuery(showUtilizzoQuery);

        while (queryUtilizzoResult.next()){
            for(int i=0; i<9; i++) {
                rispostaUtilizzoDB[i]=queryUtilizzoResult.getString(i+1);
            }

        }
    }
    public String[] returnValoreUtilizzoDB(){
        return rispostaUtilizzoDB;
    }


    public void aggiornaUtilizzo() throws SQLException {

        stringaAggiornamentoUtilizzo = stringaPercentualiUtilizzo.split(",");
        String updateUtilizzoQuery =  "UPDATE parametri_utilizzo SET C_CPU = '" + stringaAggiornamentoUtilizzo[0] + "', RAM = '" + stringaAggiornamentoUtilizzo[1] + "', SCHEDA_VIDEO = '" + stringaAggiornamentoUtilizzo[2] + "', SSD = '" + stringaAggiornamentoUtilizzo[3] + "', MONITOR = '" + stringaAggiornamentoUtilizzo[4] + "', RAFFREDDAMENTO = '" + stringaAggiornamentoUtilizzo[5] + "', C_CASE = '" + stringaAggiornamentoUtilizzo[6] + "', SCHEDA_MADRE = '" + stringaAggiornamentoUtilizzo[7] + "', ALIMENTATORE = '" + stringaAggiornamentoUtilizzo[8] + "' WHERE nome_utilizzo = '" + stringaRicercaUtilizzo + "'";



        Statement statement = connection.createStatement();
        statement.executeUpdate(updateUtilizzoQuery);

    }
}