package com.example.pcb.gui_class;

import com.example.pcb.BeanStampaCompatibilita;
import com.example.pcb.BeanStampaConfigurazione;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ComponentiGUI {

    @FXML
    private TextField compatibilita;
    @FXML
    private TextField componenteCpu;
    @FXML
    private TextField componenteSchedaMadre;
    @FXML
    private TextField componenteRam;
    @FXML
    private TextField componenteSchedaVideo;
    @FXML
    private TextField componenteSsd;
    @FXML
    private TextField componenteAlimentatore;
    @FXML
    private TextField componenteCase;
    @FXML
    private TextField componenteRaffredamento;
    @FXML
    private TextField componenteMonitor;

    private List<String> stampaConfigurazione;
    private String percentualeCompatibilita;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Entry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBudget(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Budget.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void prendiBeanStampaConfigurazione(BeanStampaConfigurazione beanStampaConfigurazione) {
        this.stampaConfigurazione = beanStampaConfigurazione.returnStampaConfigurazione();
    }
    public void prendiBeanStampaCompatibilita(BeanStampaCompatibilita beanStampaCompatibilita) {
        this.percentualeCompatibilita=beanStampaCompatibilita.returnStampaCombatilibilita();
    }
    public void prontoPerStampa() {

        this.componenteCpu.setText(stampaConfigurazione.get(0));
        this.componenteRam.setText(stampaConfigurazione.get(1));
        this.componenteSchedaVideo.setText(stampaConfigurazione.get(2));
        this.componenteSsd.setText(stampaConfigurazione.get(3));
        this.componenteMonitor.setText(stampaConfigurazione.get(4));
        this.componenteRaffredamento.setText(stampaConfigurazione.get(5));
        this.componenteCase.setText(stampaConfigurazione.get(6));
        this.componenteSchedaMadre.setText(stampaConfigurazione.get(7));
        this.componenteAlimentatore.setText(stampaConfigurazione.get(8));
        this.compatibilita.setText(percentualeCompatibilita);



    }


}
