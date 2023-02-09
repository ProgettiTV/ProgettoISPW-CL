package com.example.pcb.bean_class;



public class BeanStampaCompatibilita {
    private final String percentualeDaStampare;
    public BeanStampaCompatibilita(int percentuale) {
       String finale= String.valueOf(percentuale);
       this.percentualeDaStampare=finale+"%";
    }
    public String returnStampaCombatilibilita(){
        return percentualeDaStampare;
    }
}
