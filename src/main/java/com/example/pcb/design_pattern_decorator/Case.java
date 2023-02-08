package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaCase;

import java.sql.SQLException;
import java.util.List;

public class Case extends Decorator{
    private final int budgetPerCase;
    private String risultatoRicerca;
    private String risultatoCaratteristica;

    public Case(Component component, int budget) {
        this.budgetPerCase = budget;
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

    public void cercaCase(){
        DaoRicercaCase daoRicercaCase= new DaoRicercaCase(this.budgetPerCase);

        try {
            DaoRicercaCase.getDaoCaseConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaCase.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaCase.returnComponenteCase();
        this.risultatoCaratteristica=daoRicercaCase.returnCaratteristiCase();

    }

}
