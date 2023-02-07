package com.example.pcb.BeanClass;

import java.util.Objects;

public class BeanConferma {

    public Boolean conferma;
/*
    public ConfermaBean(String answer){
        if(answer.equals("Conferma")){
            this.conferma = true;
        }
        else{
            this.conferma = false;
        }
        //DomandeUtente.raccogliValoreR(conferma);
    }

    public ConfermaBean() {

    }

    public void conferma(DomandeUtente domandeUtente){

        domandeUtente.raccogliValoreR(conferma);
    }
    public void instanziaBeanPerStampa(){

    }
    public void inviaB(int b){
        int prendiB=b;
        String stampaB = null;
        for(int i=0; i<prendiB; i++){
            stampaB= stampaB+"€";
        }
        ConfermaBean confermaBean=new ConfermaBean();
        confermaBean.stampaAschermoB(stampaB);
    }

    public void inviaU(String utilizzoPreso) {
        ConfermaBean confermaBean=new ConfermaBean();
        confermaBean.stampaAschermoU(utilizzoPreso);
    }

    public void stampaAschermoB(String stampaBudgetUtente){
        // invia sull interfaccia quello che riceve;

    }
    public void stampaAschermoU(String stampaUtilizzoUtente){
        // invia sull interfaccia quello che riceve;

    }

*/
    public BeanConferma(String risposta){
        if(Objects.equals(risposta, "Conferma")){
            this.conferma= true;
        }else{
            this.conferma= false;
        }

    }
    public Boolean returnBool(){
       return conferma;
    }
}
