package com.example.pcb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class InserisciBudgetGUI extends AbstractObserver {

    private BeanSelezionaBudget riferimentoBeanVecchio;
    private String mostraVecchioB;
    @FXML
    private TextField oldBudget;
    @FXML
    private TextField newBudget;
    @FXML
    private TextField obsTextField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private int budgetSelezionato;
    private BeanMostraVecchioBudget riferimento;
    private int mostraIdVecchioB;
    private ModificaParametri modificaParametri;


    public void switchToEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Entry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToModificaBudget(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ModificaBudget.fxml")));
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

    public void prendiRiferimentoCAB(ModificaParametri modificaParametri){
        this.modificaParametri = modificaParametri;
    }
    public void stampa(){

        oldBudget.setText(mostraVecchioB);
    }


    public void beanPerStampa(BeanMostraVecchioBudget beanMostraVecchioBudget) {
         this.riferimento= beanMostraVecchioBudget;
         this.mostraVecchioB= riferimento.returnVecchioB();
         this.mostraIdVecchioB = riferimento.returnIdVecchioB();

        //oldBudget.setText(mostraVecchioB);
    }

    public void prova() {
        stampa();
    }

    public void modificaValoreBudget(ActionEvent actionEvent) throws SQLException {
        String valoreInserito = newBudget.getText();
        BeanModificaBudget beanModificaBudget = new BeanModificaBudget();
        beanModificaBudget.prendiValoreInserito(valoreInserito);
        System.out.println("budget inserito: " + valoreInserito);
        System.out.println("budget nel bean: " + beanModificaBudget.returnBudgetInserito());

        //ModificaParametri modificaParametri = new ModificaParametri();

        System.out.println("sto invocando add");
        DaoBudget.getInstance().addObserver(this);
        System.out.println("ho invocato add");

        modificaParametri.prendiRiferimentoBeanModificaBudget(beanModificaBudget);


    }

    @Override
    public void updateBudget(int budget) {
        obsTextField.setText(String.valueOf(budget));
        System.out.println("ciaociao");
    }

}
