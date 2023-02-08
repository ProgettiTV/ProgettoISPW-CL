package com.example.pcb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    private ModificaParametri modificaParametri;
    private BeanModificaUtilizzo beanModificaUtilizzo;

    private String idUtilizzo;



    /*public void addObserver(BudgetObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        int budget = Integer.parseInt(concreteSubjectBudget.returnNuovoB());
        for (BudgetObserver observer : observers) {
            observer.update(budget);
        }
    }*/


    public void prendiRiferimentoBean(BeanSelezionaBudget beanSelezionaBudget) throws SQLException {
        this.beanSelezionaBudget = beanSelezionaBudget;
        setVecchioB();

    }


    public void setVecchioB() throws SQLException {
        this.vecchioB = beanSelezionaBudget.returnB();
        this.idVecchioB = beanSelezionaBudget.returnB();
        //inserisciBudgetGUI.prendiRiferimentoCA();
        DaoBudget daoBudgetAdmin = DaoBudget.getInstance();
        daoBudgetAdmin.setValoreRicercaBudget(vecchioB);
        DaoBudget.getDaoBudgetConnection();
        daoBudgetAdmin.cercaBudget();
        this.vecchioB = daoBudgetAdmin.returnValoreBudgetDB();
        System.out.println("valore vecchioB dopo db: "+vecchioB);

        System.out.println("budget vecchio ricevuto a CA dopo db" +vecchioB);
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
        System.out.println("modificaparametri nuovou = "+ nuovoU);
        daoUtilizziAdmin.setNomeRicercaUtilizzo(idUtilizzo);
        daoUtilizziAdmin.setStringaPercentualiUtilizzo(nuovoU);
        DaoUtilizzi.getDaoUtilizziConnection();
        daoUtilizziAdmin.aggiornaUtilizzo();
        
        inviaUtilizzoPerModifica(daoUtilizziAdmin);

    }

    private void inviaUtilizzoPerModifica(DaoUtilizzi daoUtilizziAdmin) {
        //this.concreteSubjectUtilizzo = new ConcreteSubjectUtilizzo(nuovoU);
    }

    public void setNuovoB() throws SQLException {
        this.nuovoB = beanModificaBudget.returnBudgetInserito();
        DaoBudget daoBudgetAdmin = DaoBudget.getInstance();
        System.out.println("modificaparametri idvecchiob = "+ idVecchioB);
        daoBudgetAdmin.setValoreRicercaBudget(idVecchioB);
        daoBudgetAdmin.setNuovoValoreBudget(nuovoB);
        DaoBudget.getDaoBudgetConnection();
        daoBudgetAdmin.aggiornaBudget();

        //this.concreteSubjectBudget = new ConcreteSubjectBudget(nuovoB);
        //notifyObservers(Integer.parseInt(nuovoB));

        inviaBudgetPerModifica(daoBudgetAdmin);
    }
    public void inviaBudgetPerModifica(DaoBudget daoBudgetAdmin){
        //this.concreteSubjectBudget = new ConcreteSubjectBudget(nuovoB);
        //daoBudgetAdmin.setNuovoValoreBudget();
    }



}
