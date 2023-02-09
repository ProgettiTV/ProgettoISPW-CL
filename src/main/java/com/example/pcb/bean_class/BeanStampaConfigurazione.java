package com.example.pcb.bean_class;

import java.util.ArrayList;
import java.util.List;

public class BeanStampaConfigurazione {
    private final List<String> stampaConfigurazioneFinale;
    public BeanStampaConfigurazione(List<String> configurazioneFinale) {
        stampaConfigurazioneFinale=new ArrayList<>();
        for (String s : configurazioneFinale) {
            if (s != null) {
                if (!(s.equals("confiugrazione strandard Vuota"))) {
                    this.stampaConfigurazioneFinale.add(s);
                }
            } else {
                this.stampaConfigurazioneFinale.add("Mi spiace componente non trovato");
            }
        }
    }
    public List<String> returnStampaConfigurazione(){
        return stampaConfigurazioneFinale;
    }
}
