package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanSelezionaBudget;
import com.example.pcb.ModificaParametri;
import com.example.pcb.cl_view.SwitchClassView;
import com.example.pcb.exception.DaoException;
import java.io.IOException;
import java.sql.SQLException;


public class AdminBudgetGUI{

    private final InserisciBudgetGUI inserisciBudgetGUI;


    public AdminBudgetGUI(){
        super();
        this.inserisciBudgetGUI =new InserisciBudgetGUI();
    }



    public void selezionaValoreBudget(String risposta) throws IOException, SQLException, DaoException {

        BeanSelezionaBudget beanSelezionaBudget =new BeanSelezionaBudget();


        beanSelezionaBudget.traduciB(risposta);

        ModificaParametri modificaParametri= new ModificaParametri();
        modificaParametri.prendiRiferimentoBeanBudget(beanSelezionaBudget);
        modificaParametri.prendiBeanRiferimentoInviaVecchioBudget(inserisciBudgetGUI);

        inserisciBudgetGUI.prendiRiferimentoCAB(modificaParametri);

        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToInserisciBudget(inserisciBudgetGUI);
    }

}
