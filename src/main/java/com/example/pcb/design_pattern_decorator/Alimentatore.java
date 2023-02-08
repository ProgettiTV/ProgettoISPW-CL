package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaAlimentatore;

import java.sql.SQLException;
import java.util.List;

public class Alimentatore extends  Decorator{
    private final int budgetPerAlimentatore;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Alimentatore(Component component, int budget) {
        this.budgetPerAlimentatore = budget;
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

    public void cercaAlimentatore(){
        DaoRicercaAlimentatore daoRicercaAlimentatore= new DaoRicercaAlimentatore(this.budgetPerAlimentatore);
        try {
            daoRicercaAlimentatore.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaAlimentatore.returnComponenteAlimentatore();
        this.risultatoCaratteristica=daoRicercaAlimentatore.returnCaratteristicaAlimentatore();

    }
}
