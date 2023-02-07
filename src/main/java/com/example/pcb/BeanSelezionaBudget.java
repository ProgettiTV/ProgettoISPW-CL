package com.example.pcb;

public class BeanSelezionaBudget {
    private int rispostaUtenteB;
    public void traduciB(String selezionatoB){
        this.rispostaUtenteB= selezionatoB.length();

    }

    public int returnB() {
        return rispostaUtenteB;
    }
}
