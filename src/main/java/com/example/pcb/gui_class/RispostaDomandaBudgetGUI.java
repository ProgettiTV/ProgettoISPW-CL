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


public class RispostaDomandaBudgetGUI{

    private DomandeUtente domandeUtente;


    public void selezionaRisposteBudget(String rispostaUtente) throws IOException {

        String risposta = rispostaUtente;
        BeanBudget b = new BeanBudget(risposta);
        domandeUtente= new DomandeUtente();
        domandeUtente.prendB(b);
        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToUtilizzo(domandeUtente);

    }



}
