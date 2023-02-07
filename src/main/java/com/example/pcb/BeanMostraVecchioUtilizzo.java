package com.example.pcb;

public class BeanMostraVecchioUtilizzo {
    private String vecchioU;

    public BeanMostraVecchioUtilizzo(String utilizzo){
        this.vecchioU= utilizzo;
        System.out.println("RICEVO VECCHIO BEAN PER STAMPA"+vecchioU);
    }
    public String returnVecchioU(){
        return vecchioU;
    }
}
