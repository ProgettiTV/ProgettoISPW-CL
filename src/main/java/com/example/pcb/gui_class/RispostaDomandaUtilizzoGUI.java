package com.example.pcb.gui_class;


import com.example.pcb.bean_class.BeanUtilizzo;
import com.example.pcb.DomandeUtente;

import com.example.pcb.cl_view.SwitchClassView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RispostaDomandaUtilizzoGUI extends SwitchClassGUI{

        private final DomandeUtente istanzaCA ;

        private Stage stage;
        private Scene scene;



    public RispostaDomandaUtilizzoGUI(DomandeUtente riferimentoCapplicativo) {
        this.istanzaCA=riferimentoCapplicativo;

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



    public void vaiAConferma(String risposta) throws IOException {

        String rispostaU = risposta;

        BeanUtilizzo u = new BeanUtilizzo(risposta);
        istanzaCA.prendU(u);

        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToConferma(istanzaCA);


    }




}
