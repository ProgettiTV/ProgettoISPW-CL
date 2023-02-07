package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaCase;

import java.sql.SQLException;
import java.util.List;

public class Case extends Decorator{
    private int budgetPerCase;
    private String risultatoRicerca;
    private String risultatoCaratteristica;

    public Case(Component component, int budget) {
        this.budgetPerCase = budget;
        this.component=component;
        System.out.println("Ca");

    }

    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
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
        System.out.println("Concrete Decorator RAM  " + risultatoRicerca);
    }

}
