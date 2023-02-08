package com.example.pcb.bean_class;

public class BeanBudget {

    private final int ricercaValore;

    public BeanBudget(String risposta){
        this.ricercaValore = risposta.length();

    }
    public int returnID(){

        return ricercaValore;
    }

}

