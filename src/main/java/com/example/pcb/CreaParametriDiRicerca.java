package com.example.pcb;

import com.example.pcb.DesignPatternDecorator.RicercaComponenti;
import com.example.pcb.GUIClass.ComponentiGUI;

public class CreaParametriDiRicerca {
    public ComponentiGUI inviaRiferimentoComponenti;
    private Integer[] listaComp=new Integer[9] ;



    public CreaParametriDiRicerca() {

    }

    public void produciParametri(int budget, String[] listaCaratteristicheUtilizzo) {
        int budgetDaDividere=budget;
        String[] listaCaratteristiche=listaCaratteristicheUtilizzo;
        int copertura=0;
        int percentualeTOT=0;
        for(int i=0;i<9;i++){
            int percentuale = (Integer.parseInt(listaCaratteristiche[i]));
            percentualeTOT=percentualeTOT+percentuale;
            //double  percentuale1= percentuale / 100 ;
            float  percentuale1= (float) (percentuale * 0.01);
            int risultato= (int) ((budgetDaDividere*percentuale1));
            System.out.println("risultato percentuale "+ percentuale1);


            System.out.println("risultato INTERO singolo "+ risultato);
            listaComp[i]=risultato;
            copertura=copertura+ risultato;

            System.out.println("risultato STRINGA  "+ listaComp[i]);


        }
        System.out.println("risultato intero "+ copertura);
        System.out.println("risultato TOT PERCENT "+ percentualeTOT);
        generaRicercaComponenti(listaComp);
        System.out.println("ARRIVA USACOMPONENTIGUI IN PRODUCI PARAMETRI "+ inviaRiferimentoComponenti);
    }
    public void generaRicercaComponenti(Integer[] listaComp){

        RicercaComponenti ricercaComponenti=new RicercaComponenti(listaComp,inviaRiferimentoComponenti);
        System.out.println("ARRIVA USACOMPONENTIGUI IN CREA PARAMETRI "+ inviaRiferimentoComponenti);
        ricercaComponenti.creaConfigurazione();


    }
    public void inviaRiferimentoComponenti(ComponentiGUI componentiGUI){
        this.inviaRiferimentoComponenti=componentiGUI;
    }


}
