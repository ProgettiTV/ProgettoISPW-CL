package com.example.pcb;



public class BeanStampaCompatibilita {
    private String percentualeDaStampare;
    public BeanStampaCompatibilita(int percentuale) {
       String finale= String.valueOf(percentuale);
       this.percentualeDaStampare=finale+"%";
    }
    public String returnStampaCombatilibilita(){
        return percentualeDaStampare;
    }
}
