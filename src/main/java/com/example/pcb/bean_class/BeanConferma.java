package com.example.pcb.bean_class;

import java.util.Objects;

public class BeanConferma {

    public Boolean conferma;

    public BeanConferma(String risposta){
        this.conferma= Objects.equals(risposta, "Conferma");

    }
    public Boolean returnBool(){
       return conferma;
    }
}
