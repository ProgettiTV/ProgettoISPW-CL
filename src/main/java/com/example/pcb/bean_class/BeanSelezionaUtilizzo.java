package com.example.pcb.bean_class;

public class BeanSelezionaUtilizzo {

    private String rispostaUtenteU;
    public void prendiU(String utilizzo) {
        this.rispostaUtenteU = utilizzo;
    }

    public String returnU() {
        return rispostaUtenteU;
    }
}
