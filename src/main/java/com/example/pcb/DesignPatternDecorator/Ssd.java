package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaSsd;

import java.sql.SQLException;
import java.util.List;

public class Ssd extends  Decorator{
    private int budgetPerSsd;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Ssd(Component component, int budget) {
        this.budgetPerSsd = budget;
        this.component=component;
        System.out.println("S.V.");

    }

    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }


    public void cercaSsd(){

        DaoRicercaSsd daoRicercaSsd= new DaoRicercaSsd(this.budgetPerSsd);

        try {
            DaoRicercaSsd.getDaoSsdConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaSsd.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaSsd.returnComponenteSsd();
        this.risultatoCaratteristica=daoRicercaSsd.returnCaratteristicaSsd();
        System.out.println("Concrete Decorator SSD  " + risultatoRicerca);

    }
}
