package com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionAmazon {
    private static final String databaseName = "amazon_db";
    private static final String databaseUser = "root";
    private static final String databasePassword = "pierfrancesco";
    private static final String url = "jdbc:mysql://localhost/"+ databaseName;
    private static Connection connection;

    private DBConnectionAmazon(){

    }

    public static Connection getDBConnectionAmazon(){

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
