package com.example.pcb.GUIClass;


import com.example.pcb.BeanClass.BeanUtilizzo;
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

public class RispostaDomandaUtilizzoGUI {

        private DomandeUtente istanzaCA ;

        private Stage stage;
        private Scene scene;
        private Parent root;


    public RispostaDomandaUtilizzoGUI(DomandeUtente riferimentoCapplicativo) {
        this.istanzaCA=riferimentoCapplicativo;

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

        public void switchToConferma(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Conferma.fxml"));

            ConfermaRisposteGUI cRisposte=new ConfermaRisposteGUI(istanzaCA);

            loader.setControllerFactory(f -> cRisposte);

            scene = new Scene(loader.load());
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            cRisposte.crea();

        }



    public void vaiAConferma(ActionEvent ae) throws IOException {

        String risposta = ((Button)ae.getSource()).getText();
        System.out.println("CG UTILIZZO   "+ risposta);

        BeanUtilizzo u = new BeanUtilizzo(risposta);
        istanzaCA.prendU(u);

        switchToConferma(ae);

    }




}
