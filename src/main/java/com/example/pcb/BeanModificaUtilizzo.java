package com.example.pcb;

public class BeanModificaUtilizzo {

    private String percUtilizzo;
    public void prendiPercentualiInserite(String percentualiUtilizzo) {
        this.percUtilizzo = percentualiUtilizzo;
    }

    public String returnPercentualiInserite(){
        return percUtilizzo;
    }
}
