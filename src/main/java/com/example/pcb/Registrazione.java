package com.example.pcb;

import com.example.pcb.cl_view.SwitchClassView;
import com.example.pcb.dao_class.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;


public class Registrazione {



    public void registerUser(String Firstname, String Lastname, String Username, String Password) throws IOException {

        Connection myConnection = DBConnection.getDBConnection();


        String role = "User";


        String insertFields = "INSERT INTO useraccounts(firstname, lastname, username, password, Role) VALUES ('";
        String insertValues = Firstname + "','" + Lastname + "','" + Username + "','"+ Password + "','" + role + "')" ;
        String insertToRegister = insertFields + insertValues;

        try{

            Statement statement = myConnection.createStatement();
            statement.executeUpdate(insertToRegister);


        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }



    }

    public void tornaIndietro() throws IOException {
        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToEntry();
    }
}
