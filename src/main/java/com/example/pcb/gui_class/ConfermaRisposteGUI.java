package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanConferma;
import com.example.pcb.bean_class.BeanMostraResoconto;
import com.example.pcb.DomandeUtente;
import com.example.pcb.cl_view.SwitchClassView;
import com.example.pcb.exception.QueryException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ConfermaRisposteGUI extends SwitchClassGUI{

    private DomandeUtente riferimentoCapplicativo;
    private ComponentiGUI componentiGUI;
    private BeanMostraResoconto mostraResoconto;
    private Stage stage;
    private Scene scene;


    @FXML
    private TextField budgetTextField;

    @FXML
    private TextField utilizzoTextField;

    public ConfermaRisposteGUI(DomandeUtente istanzaCA) {
        this.riferimentoCapplicativo=istanzaCA;
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



    public void vaiAComponenti(String risposta) throws IOException  {
        String errore="mostra errore a utente";



        BeanConferma beanConferma = new BeanConferma(risposta);


        if (Objects.equals(risposta, "Conferma")){

            try {
                riferimentoCapplicativo.prendC(beanConferma);
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle(errore);
                alert.setContentText("errore SQL");
                alert.show();
            } catch (QueryException e) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle(errore);
                alert.setContentText("errore Query");
                alert.show();
            }

            this.componentiGUI=new ComponentiGUI();

            try {
                riferimentoCapplicativo.prendiCGComponenti(componentiGUI);
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle(errore);
                alert.setContentText("IO errore");
                alert.show();
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setTitle(errore);
                alert.setContentText("SQL errore");
                alert.show();
            }
            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToComponenti(componentiGUI);
        }
        else{
            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToBudget();
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

        System.out.println("Il budget scelto è: "+ budget);
        System.out.println("L'utilizzo scelto è: "+ utilizzo);


    }
}
