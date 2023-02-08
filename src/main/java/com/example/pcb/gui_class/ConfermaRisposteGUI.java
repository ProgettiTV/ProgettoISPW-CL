package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanConferma;
import com.example.pcb.bean_class.BeanMostraResoconto;
import com.example.pcb.DomandeUtente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConfermaRisposteGUI {

    public DomandeUtente riferimentoCapplicativo;
    public ComponentiGUI componentiGUI;
    public BeanMostraResoconto mostraResoconto;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField budgetTextField;

    @FXML
    private TextField utilizzoTextField;

    public ConfermaRisposteGUI(DomandeUtente istanzaCA) {
        this.riferimentoCapplicativo=istanzaCA;
    }


    public ConfermaRisposteGUI() {

    }

    public void switchToComponenti(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Componenti.fxml"));

        loader.setControllerFactory(f -> componentiGUI);

        scene = new Scene(loader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        componentiGUI.prontoPerStampa();

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

    public void switchToBudget(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Budget.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void vaiAComponenti(ActionEvent ae) throws IOException {


        String risposta = ((Button)ae.getSource()).getText();
        System.out.println("CG Conferma selezionato:" + risposta);
        BeanConferma beanConferma = new BeanConferma(risposta);



        if (Objects.equals(risposta, "Conferma")){

            riferimentoCapplicativo.prendC(beanConferma);

            this.componentiGUI=new ComponentiGUI();

            riferimentoCapplicativo.prendiCGComponenti(componentiGUI);

            switchToComponenti(ae);
        }
        else{
            switchToBudget(ae);
        }


    }
    public void crea(){

        this.mostraResoconto=new BeanMostraResoconto();

        riferimentoCapplicativo.getMostraResoconto(mostraResoconto);
        stampa(mostraResoconto);

    }

    public void stampa(BeanMostraResoconto mR) {


        String budget= mR.returnStampaB();
        String utilizzo= mR.returnStampaU();

        budgetTextField.setText(budget);
        utilizzoTextField.setText(utilizzo);


    }
}
