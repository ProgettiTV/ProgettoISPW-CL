package com.example.pcb;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AdminBudgetGUI {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private final InserisciBudgetGUI inserisciBudgetGUI;


    public AdminBudgetGUI(){
        this.inserisciBudgetGUI =new InserisciBudgetGUI();
    }

    public void switchToEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Entry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AdminProfile.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void switchToInserisciBudget(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InserisciBudget.fxml"));

        loader.setControllerFactory(f -> inserisciBudgetGUI);

        scene = new Scene(loader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        inserisciBudgetGUI.prova();

    }


    public void selezionaValoreBudget(ActionEvent event) throws IOException, SQLException {

        String selezioneB = ((Button)event.getSource()).getText();

        BeanSelezionaBudget beanSelezionaBudget =new BeanSelezionaBudget();


        beanSelezionaBudget.traduciB(selezioneB);

        ModificaParametri modificaParametri= new ModificaParametri();
        modificaParametri.prendiRiferimentoBean(beanSelezionaBudget);
        modificaParametri.prendiBeanRiferimentoInviaVecchio(inserisciBudgetGUI);

        inserisciBudgetGUI.prendiRiferimentoCAB(modificaParametri);

        switchToInserisciBudget(event);
    }

}
