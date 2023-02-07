package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaSchedaMadre;

import java.sql.SQLException;
import java.util.List;

public class SchedaMadre extends Decorator{
    private int budgetPerSchedaMadre;
    private String  risultatoRicerca;
    private String  risultatoCaratteristica;
    public SchedaMadre(Component component, int budget) {
        this.budgetPerSchedaMadre= budget;
        this.component=component;
        System.out.println("S.M.");

    }

    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaSchedaMadre (){
        DaoRicercaSchedaMadre daoRicercaSchedaMadre= new DaoRicercaSchedaMadre(this.budgetPerSchedaMadre);


        try {
            DaoRicercaSchedaMadre.getDaoSchedaMadreConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaSchedaMadre.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaSchedaMadre.returnComponenteSchedaMadre();
        this.risultatoCaratteristica=daoRicercaSchedaMadre.returnCaratteristicaSchedaMadre();
        System.out.println("Concrete Decorator SSD  " + risultatoRicerca);

    }
}
