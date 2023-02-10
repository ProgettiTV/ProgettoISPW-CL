package com.example.pcb.gui_class;

import com.example.pcb.*;
import com.example.pcb.bean_class.BeanModificaBudget;
import com.example.pcb.bean_class.BeanMostraVecchioBudget;
import com.example.pcb.dao_class.DaoBudget;
import com.example.pcb.exception.DaoException;
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

public class InserisciBudgetGUI extends AbstractObserver{


    private String mostraVecchioB;
    @FXML
    private TextField oldBudget;
    @FXML
    private TextField newBudget;
    private Stage stage;
    private Scene scene;
    private Parent root;


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


    }

    public void prova() {
        stampa();
    }

    public void modificaValoreBudget(ActionEvent actionEvent) throws SQLException, IOException, DaoException {
        String valoreInserito = newBudget.getText();
        BeanModificaBudget beanModificaBudget = new BeanModificaBudget();
        beanModificaBudget.prendiValoreInserito(valoreInserito);

        DaoBudget daoBudget = DaoBudget.getInstance();
        daoBudget.setOsservatoreBudget();
        daoBudget.addObserver(this);


        modificaParametri.prendiRiferimentoBeanModificaBudget(beanModificaBudget);


    }

    @Override
    public void updateBudget(int budget) {

        oldBudget.setText(String.valueOf(budget));
        newBudget.clear();

    }

}
