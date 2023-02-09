package com.example.pcb;

import java.sql.SQLException;
import java.util.Arrays;


public class ModificaParametri {
    private int vecchioB;
    private int idVecchioB;
    private String vecchioU;
    private String nuovoB;
    private String nuovoU;
    private BeanSelezionaBudget beanSelezionaBudget;
    private BeanMostraVecchioBudget beanMostraVecchioBudget;
    private InserisciBudgetGUI inserisciBudgetGUI;
    private BeanSelezionaUtilizzo beanSelezionaUtilizzo;
    private BeanMostraVecchioUtilizzo beanMostraVecchioUtilizzo;
    private InserisciUtilizzoGUI inserisciUtilizzoGUI;
    private BeanModificaBudget beanModificaBudget;


    private BeanModificaUtilizzo beanModificaUtilizzo;

    private String idUtilizzo;




    public void prendiRiferimentoBean(BeanSelezionaBudget beanSelezionaBudget) throws SQLException {
        this.beanSelezionaBudget = beanSelezionaBudget;
        setVecchioB();

    }


    public void setVecchioB() throws SQLException {
        this.vecchioB = beanSelezionaBudget.returnB();
        this.idVecchioB = beanSelezionaBudget.returnB();

        DaoBudget daoBudgetAdmin = DaoBudget.getInstance();
        daoBudgetAdmin.setValoreRicercaBudget(vecchioB);
        DaoBudget.getDaoBudgetConnection();
        daoBudgetAdmin.cercaBudget();
        this.vecchioB = daoBudgetAdmin.returnValoreBudgetDB();

        inviaBudgetVecchio();
    }
    public void inviaBudgetVecchio(){
        this.beanMostraVecchioBudget = new BeanMostraVecchioBudget(vecchioB, idVecchioB);

    }

    public void prendiBeanRiferimentoInviaVecchio(InserisciBudgetGUI inserisciBudgetGUI) {
        this.inserisciBudgetGUI = inserisciBudgetGUI;
        inserisciBudgetGUI.beanPerStampa(beanMostraVecchioBudget);

    }

    public void prendiRiferimentoBeanU(BeanSelezionaUtilizzo beanSelezionaUtilizzo) throws SQLException {
        this.beanSelezionaUtilizzo = beanSelezionaUtilizzo;
        setVecchioU();
    }

    private void setVecchioU() throws SQLException {
        this.vecchioU = beanSelezionaUtilizzo.returnU();
        this.idUtilizzo = vecchioU;
        DaoUtilizzi daoUtilizziAdmin = new DaoUtilizzi();
        daoUtilizziAdmin.setNomeRicercaUtilizzo(vecchioU);
        DaoUtilizzi.getDaoUtilizziConnection();
        daoUtilizziAdmin.cercaPercentualiUtilizzo();
        this.vecchioU= Arrays.toString(daoUtilizziAdmin.returnValoreUtilizzoDB());
        inviaUtilizzoVecchio();
    }

    private void inviaUtilizzoVecchio() {
        this.beanMostraVecchioUtilizzo = new BeanMostraVecchioUtilizzo(vecchioU);
    }

    public void prendiBeanRiferimentoInviaVecchioU(InserisciUtilizzoGUI inserisciUtilizzoGUI) {
        this.inserisciUtilizzoGUI = inserisciUtilizzoGUI;
        inserisciUtilizzoGUI.beanPerStampa(beanMostraVecchioUtilizzo);
    }

    public void prendiRiferimentoBeanModificaBudget(BeanModificaBudget beanModificaBudget) throws SQLException {
        this.beanModificaBudget=beanModificaBudget;
        setNuovoB();
    }

    public void prendiRiferimentoBeanModificaUtilizzo(BeanModificaUtilizzo beanModificaUtilizzo) throws SQLException {
        this.beanModificaUtilizzo=beanModificaUtilizzo;
        setNuovoU();
    }

    public void setNuovoU() throws SQLException {
        this.nuovoU = beanModificaUtilizzo.returnPercentualiInserite();
        DaoUtilizzi daoUtilizziAdmin = new DaoUtilizzi();

        daoUtilizziAdmin.setNomeRicercaUtilizzo(idUtilizzo);
        daoUtilizziAdmin.setStringaPercentualiUtilizzo(nuovoU);
        DaoUtilizzi.getDaoUtilizziConnection();
        daoUtilizziAdmin.aggiornaUtilizzo();
        


    }


    public void setNuovoB() throws SQLException {
        this.nuovoB = beanModificaBudget.returnBudgetInserito();
        DaoBudget daoBudgetAdmin = DaoBudget.getInstance();

        daoBudgetAdmin.setValoreRicercaBudget(idVecchioB);
        daoBudgetAdmin.setNuovoValoreBudget(nuovoB);
        DaoBudget.getDaoBudgetConnection();
        daoBudgetAdmin.aggiornaBudget();


    }


}
