package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanBudget;
import com.example.pcb.DomandeUtente;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class RispostaDomandaBudgetGUI {

    private static DomandeUtente domandeUtente;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToUtilizzo(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Utilizzo.fxml"));
        loader.setControllerFactory(f -> new RispostaDomandaUtilizzoGUI(domandeUtente));
        scene = new Scene(loader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }


    public void switchToUserProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserProfile.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void switchToEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Entry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    public void selezionaRisposteBudget(ActionEvent ae) throws IOException {

        String risposta = ((Button)ae.getSource()).getText();
        BeanBudget b = new BeanBudget(risposta);
        domandeUtente= new DomandeUtente();
        domandeUtente.prendB(b);
        switchToUtilizzo(ae);
    }



}
