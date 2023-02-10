package com.example.pcb.cl_view;

import com.example.pcb.DomandeUtente;
import com.example.pcb.gui_class.ComponentiGUI;

import java.io.IOException;

public class SwitchClassView {

    private static SwitchClassView switchClassViewInstance;
    public SwitchClassView(){

    }

    public static SwitchClassView getSwitchClassViewInstance(){

        if(switchClassViewInstance == null)
            switchClassViewInstance = new SwitchClassView();
        return switchClassViewInstance;
    }

    public void switchToUserProfile() throws IOException {
        UserPageView userPageView = new UserPageView();
        userPageView.Inizalizza();
    }

    public void switchToAdminProfile() {
        AdminPageView adminPageView = new AdminPageView();
        adminPageView.selezionaDecisioneAdmin();
    }

    public void switchToEntry() throws IOException {
        EntryView entryView = new EntryView();
        entryView.inizio();
    }

    public void switchToBudget() throws IOException {
        DomandeBudgetView domandeBudgetView = new DomandeBudgetView();
        domandeBudgetView.selezionaRisposteB();
    }

    public void switchToUtilizzo(DomandeUtente domandeUtente) throws IOException {
        DomandeUtilizzoView domandeUtilizzoView = new DomandeUtilizzoView();
        domandeUtilizzoView.selezionaRisposteU(domandeUtente);
    }

    public void switchToConferma(DomandeUtente domandeUtente) throws IOException {
        ConfermaRisposteView confermaRisposteView = new ConfermaRisposteView();
        confermaRisposteView.confermaLeScelte(domandeUtente);

    }

    public void switchToComponenti(ComponentiGUI componentiGUI) {
        ComponentiView componentiView = new ComponentiView();
        componentiView.mostraRicercaComponenti(componentiGUI);

    }
}
