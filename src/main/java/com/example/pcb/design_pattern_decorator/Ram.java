package com.example.pcb.design_pattern_decorator;



import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaRam;

import java.sql.SQLException;
import java.util.List;

public class Ram extends Decorator{
    private final int budgetPerRam;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Ram(Component component, int budget) {
        this.budgetPerRam= budget;
        this.component=component;

    }


    @Override
    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    @Override
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaRam(){

        DaoRicercaRam daoRicercaRam= new DaoRicercaRam(this.budgetPerRam);



        try {
            daoRicercaRam.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaRam.returnComponenteRam();
        this.risultatoCaratteristica=daoRicercaRam.returnCaratteristicaRam();

    }
}
