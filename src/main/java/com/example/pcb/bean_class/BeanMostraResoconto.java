package com.example.pcb.bean_class;

public class BeanMostraResoconto {
    private String mostraB;
    private String mostraU;
    public BeanMostraResoconto() {

    }

    public void getmostraB(int b1){
        this.mostraB="";
        for(int i=0;i< b1;i++){
            this.mostraB= mostraB + "€";
        }

    }


    public void getmostraU(String u1){
        this.mostraU=u1;

    }
    public String returnStampaB(){
        return mostraB;
    }
    public String returnStampaU(){
        return mostraU;
    }

}
