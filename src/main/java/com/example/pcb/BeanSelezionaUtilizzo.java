package com.example.pcb;

public class BeanSelezionaUtilizzo {

    private String rispostaUtenteU;
    public void prendiU(String utilizzo) {
        this.rispostaUtenteU = utilizzo;
    }

    public String returnU() {
        return rispostaUtenteU;
    }
}
