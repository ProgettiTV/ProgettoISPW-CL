package com.example.pcb;

import com.example.pcb.cl_view.SwitchClassView;
import com.example.pcb.dao_class.DBConnection;
import com.example.pcb.exception.DaoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;


public class Login {

    private static final String ERRORE="mostra errore utente";


    public void validateLogin(String username, String password) throws IOException {

        String usernameInserito = username;
        String passwordInserita = password;


        double randomAccess = Math.random() * 20;

        if (randomAccess % 2 == 0) {

            Connection myConnection = DBConnection.getDBConnection();


            String verifyLoginQuery = "SELECT count(1), Role FROM useraccounts WHERE username = '" + usernameInserito + "' AND password = '" + passwordInserita + "'" + " GROUP BY Role";

            try {

                Statement statement = myConnection.createStatement();
                ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);

                while (queryLoginResult.next()) {

                    if ((queryLoginResult.getInt(1) == 1) && queryLoginResult.getString(2).equals("User")) {
                        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
                        switchClassView.switchToUserProfile();
                    }
                    else if ((queryLoginResult.getInt(1) == 1) && queryLoginResult.getString(2).equals("Admin")) {

                        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
                        switchClassView.switchToAdminProfile();
                    }
                }


            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle(ERRORE);
                alert.setContentText("SQL errore");
                alert.show();
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }


        } else fileLogin(usernameInserito, passwordInserita);
    }


    public void fileLogin(String usernameInserito, String passwordInserita) throws IOException {

        String[] datiInseriti = new String[2];
        datiInseriti[0] = usernameInserito;
        datiInseriti[1] = passwordInserita;
        String[] datiPresenti = new String[3];
        DBConnection dBPath = new DBConnection();
        String pathFileName = dBPath.getFilePath();
        File inputFile = new File(pathFileName);
        Scanner scannerDaFile;
        try {
            scannerDaFile = new Scanner(inputFile);

            int i = 0;

            while (scannerDaFile.hasNextLine() && !((datiInseriti[0]).equals(datiPresenti[0]) && (datiInseriti[1]).equals(datiPresenti[1]))) {

                datiPresenti[i % 3] = scannerDaFile.nextLine();

                i++;

            }


            if (Objects.equals(scannerDaFile.nextLine(), "User")) {
                SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
                switchClassView.switchToUserProfile();
            }
            else {
                SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
                switchClassView.switchToAdminProfile();
            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle(ERRORE);
            alert.setContentText("IO errore");
            alert.show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }


    public void tornaIndietro() throws IOException {
        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToEntry();
    }
}
