package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanBudget;
import com.example.pcb.DomandeUtente;
import com.example.pcb.cl_view.SwitchClassView;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;


public class RispostaDomandaBudgetGUI extends SwitchClassGUI{

    private DomandeUtente domandeUtente;
    private Stage stage;
    private Scene scene;


    public void switchToUtilizzo(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Utilizzo.fxml"));
        loader.setControllerFactory(f -> new RispostaDomandaUtilizzoGUI(domandeUtente));
        scene = new Scene(loader.load());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }




    public void selezionaRisposteBudget(String rispostaUtente) throws IOException {

        String risposta = rispostaUtente;
        BeanBudget b = new BeanBudget(risposta);
        domandeUtente= new DomandeUtente();
        domandeUtente.prendB(b);
        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToUtilizzo(domandeUtente);
    }



}
