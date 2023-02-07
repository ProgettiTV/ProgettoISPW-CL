package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaAlimentatore;

import java.sql.SQLException;
import java.util.List;

public class Alimentatore extends  Decorator{
    private int budgetPerAlimentatore;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Alimentatore(Component component, int budget) {
        this.budgetPerAlimentatore = budget;
        this.component=component;
        System.out.println("A");

    }
    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaAlimentatore(){
        DaoRicercaAlimentatore daoRicercaAlimentatore= new DaoRicercaAlimentatore(this.budgetPerAlimentatore);
        try {
            DaoRicercaAlimentatore.getDaoAlimentatoreConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaAlimentatore.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaAlimentatore.returnComponenteAlimentatore();
        this.risultatoCaratteristica=daoRicercaAlimentatore.returnCaratteristicaAlimentatore();
        System.out.println("Concrete Decorator RAM  " + risultatoRicerca);
    }
}
