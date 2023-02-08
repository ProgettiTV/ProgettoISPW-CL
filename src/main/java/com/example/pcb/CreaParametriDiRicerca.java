package com.example.pcb;



public class CreaParametriDiRicerca {


    public CreaParametriDiRicerca() {

    }

    public Integer[] produciParametri(int budget, String[] listaCaratteristicheUtilizzo) {
        Integer[] listaComp=new Integer[9];

        for(int i=0;i<9;i++){

            int percentuale = (Integer.parseInt(listaCaratteristicheUtilizzo[i]));

            float  percentuale1= (float) (percentuale * 0.01);
            int risultato= (int) ((budget*percentuale1));
    //prova mmerge
            listaComp[i]=risultato;
        }
        return listaComp;
    }

}
