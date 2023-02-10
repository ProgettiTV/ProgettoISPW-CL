package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanSelezionaUtilizzo;
import com.example.pcb.ModificaParametri;
import com.example.pcb.cl_view.SwitchClassView;
import java.io.IOException;
import java.sql.SQLException;


public class AdminUtilizziGUI{

    private final InserisciUtilizzoGUI inserisciUtilizzoGUI;

    public AdminUtilizziGUI(){
        super();
        this.inserisciUtilizzoGUI =new InserisciUtilizzoGUI();
    }


    public void selezionaNomeUtilizzo(String risposta) throws IOException, SQLException {

        BeanSelezionaUtilizzo beanSelezionaUtilizzo = new BeanSelezionaUtilizzo();
        beanSelezionaUtilizzo.prendiU(risposta);

        ModificaParametri modificaParametri= new ModificaParametri();
        modificaParametri.prendiRiferimentoBeanU(beanSelezionaUtilizzo);
        modificaParametri.prendiBeanRiferimentoInviaVecchioU(inserisciUtilizzoGUI);

        inserisciUtilizzoGUI.prendiRiferimentoCAU(modificaParametri);

        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToInserisciUtilizzo(inserisciUtilizzoGUI);

    }
}
