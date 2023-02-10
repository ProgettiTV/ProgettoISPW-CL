package com.example.pcb.cl_view;

import com.example.pcb.DomandeUtente;
import com.example.pcb.exception.DaoException;
import com.example.pcb.gui_class.ComponentiGUI;
import com.example.pcb.gui_class.InserisciBudgetGUI;
import com.example.pcb.gui_class.InserisciUtilizzoGUI;

import java.io.IOException;
import java.sql.SQLException;

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

    public void switchToAdminProfile() throws IOException, SQLException, DaoException {
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

    public void switchToLogin() throws IOException {
        AccediView accediView = new AccediView();
        accediView.validaLogin();
    }

    public void switchToModificaBudget() throws IOException, SQLException, DaoException {
        ModificaBudgetView modificaBudgetView = new ModificaBudgetView();
        modificaBudgetView.modificaB();
    }

    public void switchToModificaUtilizzo() throws SQLException, IOException, DaoException {
        ModificaUtilizzoView modificaUtilizzoView = new ModificaUtilizzoView();
        modificaUtilizzoView.modificaU();
    }

    public void switchToInserisciBudget(InserisciBudgetGUI inserisciBudgetGUI) throws SQLException, IOException, DaoException {
        InserisciBView inserisciBView = new InserisciBView();
        inserisciBView.inserisciNuoviParametro(inserisciBudgetGUI);
    }

    public void switchToInserisciUtilizzo(InserisciUtilizzoGUI inserisciUtilizzoGUI) throws SQLException, IOException {
        InserisciUView inserisciUView = new InserisciUView();
        inserisciUView.inserisciNuovoParametro(inserisciUtilizzoGUI);
    }
}
