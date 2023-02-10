package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanStampaCompatibilita;
import com.example.pcb.bean_class.BeanStampaConfigurazione;
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

public class ComponentiGUI extends SwitchClassGUI{

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




    public void prendiBeanStampaConfigurazione(BeanStampaConfigurazione beanStampaConfigurazione) {
        this.stampaConfigurazione = beanStampaConfigurazione.returnStampaConfigurazione();
    }
    public void prendiBeanStampaCompatibilita(BeanStampaCompatibilita beanStampaCompatibilita) {
        this.percentualeCompatibilita=beanStampaCompatibilita.returnStampaCombatilibilita();
    }
    public void prontoPerStampa() {

        System.out.println(stampaConfigurazione.get(0));
        System.out.println(stampaConfigurazione.get(1));
        System.out.println(stampaConfigurazione.get(2));
        System.out.println(stampaConfigurazione.get(3));
        System.out.println(stampaConfigurazione.get(4));
        System.out.println(stampaConfigurazione.get(5));
        System.out.println(stampaConfigurazione.get(6));
        System.out.println(stampaConfigurazione.get(7));
        System.out.println(stampaConfigurazione.get(8));
        System.out.println(percentualeCompatibilita);




    }


}
