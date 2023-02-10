package com.example.pcb.gui_class;

import com.example.pcb.bean_class.BeanStampaCompatibilita;
import com.example.pcb.bean_class.BeanStampaConfigurazione;
import java.util.List;


public class ComponentiGUI{

    private List<String> stampaConfigurazione;
    private String percentualeCompatibilita;


    public void prendiBeanStampaConfigurazione(BeanStampaConfigurazione beanStampaConfigurazione) {
        this.stampaConfigurazione = beanStampaConfigurazione.returnStampaConfigurazione();
    }
    public void prendiBeanStampaCompatibilita(BeanStampaCompatibilita beanStampaCompatibilita) {
        this.percentualeCompatibilita=beanStampaCompatibilita.returnStampaCombatilibilita();
    }
    public void prontoPerStampa() {

        System.out.println(stampaConfigurazione.get(0));
        System.out.println(stampaConfigurazione.get(1));
        System.out.println(stampaConfigurazione.get(2));
        System.out.println(stampaConfigurazione.get(3));
        System.out.println(stampaConfigurazione.get(4));
        System.out.println(stampaConfigurazione.get(5));
        System.out.println(stampaConfigurazione.get(6));
        System.out.println(stampaConfigurazione.get(7));
        System.out.println(stampaConfigurazione.get(8));
        System.out.println(percentualeCompatibilita);




    }


}
