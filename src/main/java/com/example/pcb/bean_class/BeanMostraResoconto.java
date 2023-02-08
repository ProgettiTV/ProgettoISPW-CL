package com.example.pcb.bean_class;

public class BeanMostraResoconto {
    public String mostraB;
    public String mostraU;
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
        System.out.println("stringa finale Utilizzo in MostraResoconto  " + mostraU);
    }
    public String returnStampaB(){
        return mostraB;
    }
    public String returnStampaU(){
        return mostraU;
    }

}
