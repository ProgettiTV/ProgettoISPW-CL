package com.example.pcb.bean_class;

public class BeanUtilizzo {

    private final String ricercaTipoUtilizzo;

    public BeanUtilizzo(String risposta) {

        this.ricercaTipoUtilizzo=risposta;
    }

    public String returnStr() {

        return ricercaTipoUtilizzo;
    }

}
