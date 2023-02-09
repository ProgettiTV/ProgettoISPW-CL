package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanModificaUtilizzo;
import com.example.pcb.bean_class.BeanMostraVecchioUtilizzo;
import com.example.pcb.ModificaParametri;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class InserisciUtilizzoGUI {

    @FXML
    private TextField oldUtilizzo;
    @FXML
    private TextField newUtilizzo;
    private BeanMostraVecchioUtilizzo riferimentoU;
    private String mostraVecchioU;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ModificaParametri modificaParametri;

    public void switchToEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Entry.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void switchToModificaUtilizzo(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ModificaUtilizzo.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    public void prendiRiferimentoCAU(ModificaParametri modificaParametri){
        this.modificaParametri = modificaParametri;
    }
    public void beanPerStampa(BeanMostraVecchioUtilizzo beanMostraVecchioUtilizzo) {
        this.riferimentoU= beanMostraVecchioUtilizzo;
        this.mostraVecchioU= riferimentoU.returnVecchioU();


    }
    public void prova() {
        stampa();
    }

    private void stampa() {
        oldUtilizzo.setText(mostraVecchioU);
        oldUtilizzo.setAlignment(Pos.CENTER);
    }

    public void modificaValoreUtilizzo(ActionEvent actionEvent) throws SQLException {
        String percentualiUtilizzo = newUtilizzo.getText();
        BeanModificaUtilizzo beanModificaUtilizzo = new BeanModificaUtilizzo();
        beanModificaUtilizzo.prendiPercentualiInserite(percentualiUtilizzo);


        modificaParametri.prendiRiferimentoBeanModificaUtilizzo(beanModificaUtilizzo);
    }

}
