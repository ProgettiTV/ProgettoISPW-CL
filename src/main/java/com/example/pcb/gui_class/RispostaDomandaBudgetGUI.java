package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanBudget;
import com.example.pcb.DomandeUtente;
import com.example.pcb.cl_view.SwitchClassView;
import java.io.IOException;


public class RispostaDomandaBudgetGUI{

    private DomandeUtente domandeUtente;


    public void selezionaRisposteBudget(String rispostaUtente) throws IOException {

        String risposta = rispostaUtente;
        BeanBudget b = new BeanBudget(risposta);
        domandeUtente= new DomandeUtente();
        domandeUtente.prendiBudget(b);
        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToUtilizzo(domandeUtente);

    }



}
