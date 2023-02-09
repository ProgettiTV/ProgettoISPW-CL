package com.example.pcb.dao_class;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;


public class DBConnection {

    private static Connection connection;

    private DBConnection(){

    }

    public static Connection getDBConnection() throws IOException{
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\justo\\Desktop\\Progetto\\src\\main\\java\\com\\example\\pcb\\dao_class\\credenzialiDB"));
        String databaseUser = prop.getProperty("databaseUser");
        String databasePassword = prop.getProperty("databasePassword");
        String url = prop.getProperty("url");
        try{
            if(connection==null){
                connection = DriverManager.getConnection(url, databaseUser, databasePassword);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}
