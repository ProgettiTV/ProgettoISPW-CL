package com.example.pcb;

import com.example.pcb.BeanClass.BeanBudget;
import com.example.pcb.BeanClass.BeanConferma;
import com.example.pcb.BeanClass.BeanMostraResoconto;
import com.example.pcb.BeanClass.BeanUtilizzo;
import com.example.pcb.DaoClass.DaoBudget;
import com.example.pcb.DaoClass.DaoUtilizzi;
import com.example.pcb.GUIClass.ComponentiGUI;

import java.sql.SQLException;

public  class DomandeUtente {
    private int budget;
    private String[] listaCaratteristicheUtilizzo= new String[9];
    public BeanMostraResoconto mostraResoconto;
    public ComponentiGUI usaComponentiGUI;
    public CreaParametriDiRicerca creaParametriDiRicerca;
    private Boolean confermatoRisposte;
    public int budgetProvissorio;
    public String utilizzoProvissorio;
   // public ConfermaRisposteGUI confermaRisposteGUI;


    public DomandeUtente(){

    }

    public void prendB(BeanBudget b){

        //int budget1= b.returnID();
        this.budgetProvissorio =b.returnID();
        //System.out.println("ricevo budget da CA  "+ budget1);
    }
    public void prendU(BeanUtilizzo u){

        //String risposta= u.returnStr();
        this.utilizzoProvissorio =u.returnStr();
        //System.out.println("ricevo Utilizzo da CA  "+ risposta);

    }

    public void getMostraResoconto(BeanMostraResoconto mR) {
        this.mostraResoconto=mR;
        System.out.println("indirizzo mostraResoconto Bean  "+ mostraResoconto);
        invioResoconto();
    }

    public void prendC(BeanConferma c) {
        this.confermatoRisposte= c.returnBool();
        //System.out.println("ricevo Conferma da CA  "+ confermatoRisposte);
        if(confermatoRisposte){
            //crea classe dao

            DaoBudget daoBudget=new DaoBudget(budgetProvissorio);

            try {
                DaoBudget.getDaoBudgetConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                daoBudget.cercaValore();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            DaoUtilizzi daoUtilizzi=new DaoUtilizzi(utilizzoProvissorio);
            try {
                DaoUtilizzi.getDaoUtilizziConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                daoUtilizzi.cercaCaratteristiche();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            //chiedi il return dei valori trovati e this. attributo
            this.budget=daoBudget.returnValoreBudget();
            this.listaCaratteristicheUtilizzo=daoUtilizzi.returnListaUtilizzo();
        }
        //inviaRisposteUtente(budget,listaCaratteristicheUtilizzo);

        //creaParametriDiRicerca.prendiCGComponenti(this.usaComponentiGUI);

        //this.creaParametriDiRicerca=new CreaParametriDiRicerca();
        System.out.println("ARRIVA USACOMPONENTIGUI IN DomandeUtente " + usaComponentiGUI);

        //creaParametriDiRicerca.produciParametri( budget,listaCaratteristicheUtilizzo);

    }



    public void invioResoconto(){

        mostraResoconto.getmostraB(budgetProvissorio);
        mostraResoconto.getmostraU(utilizzoProvissorio);

    }


    public void prendiCGComponenti(ComponentiGUI componentiGUI) {
         //this.usaComponentiGUI=componentiGUI;
        this.creaParametriDiRicerca=new CreaParametriDiRicerca();
        creaParametriDiRicerca.inviaRiferimentoComponenti(componentiGUI);
        creaParametriDiRicerca.produciParametri( budget,listaCaratteristicheUtilizzo);
        System.out.println("ARRIVA USACOMPONENTIGUI IN DomandeUtente, prendiCGComponenti " + usaComponentiGUI);


    }
}
