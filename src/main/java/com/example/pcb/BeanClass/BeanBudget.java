package com.example.pcb.BeanClass;

public class BeanBudget {

    public int ricercaValore;

    public BeanBudget(String risposta){
        this.ricercaValore = risposta.length();

    }
    public int returnID(){

        return ricercaValore;
    }

}

