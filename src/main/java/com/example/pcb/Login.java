package com.example.pcb;

import com.example.pcb.dao_class.DBConnection;
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

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private static final String ERRORE="mostra errore utente";

    public void switchToEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gui_class/Entry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gui_class/UserProfile.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void switchToAdminProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gui_class/AdminProfile.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void validateLogin(ActionEvent event) throws IOException {

        String usernameInserito = usernameTextField.getText();
        String passwordInserita = passwordPasswordField.getText();

        double randomAccess = Math.random() * 20;

        if (randomAccess % 2 == 0) {

            Connection myConnection = DBConnection.getDBConnection();


            String verifyLoginQuery = "SELECT count(1), Role FROM useraccounts WHERE username = '" + usernameInserito + "' AND password = '" + passwordInserita + "'" + " GROUP BY Role";

            try {

                Statement statement = myConnection.createStatement();
                ResultSet queryLoginResult = statement.executeQuery(verifyLoginQuery);

                while (queryLoginResult.next()) {

                    if ((queryLoginResult.getInt(1) == 1) && queryLoginResult.getString(2).equals("User"))

                        switchToUserProfile(event);

                    else if ((queryLoginResult.getInt(1) == 1) && queryLoginResult.getString(2).equals("Admin"))

                        switchToAdminProfile(event);

                }


            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle(ERRORE);
                alert.setContentText("SQL errore");
                alert.show();
            }


        } else fileLogin(usernameInserito, passwordInserita, event);
    }


    public void fileLogin(String usernameInserito, String passwordInserita, ActionEvent event) throws IOException {

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


            if (Objects.equals(scannerDaFile.nextLine(), "User"))
                switchToUserProfile(event);

            else switchToAdminProfile(event);

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle(ERRORE);
            alert.setContentText("IO errore");
            alert.show();
        }
    }


}
