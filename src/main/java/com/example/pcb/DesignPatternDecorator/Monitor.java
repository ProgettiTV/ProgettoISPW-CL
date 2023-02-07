package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaMonitor;

import java.sql.SQLException;
import java.util.List;

public class Monitor extends Decorator{
    private int budgetPerMonitor;

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Monitor(Component component, int budget) {
        this.budgetPerMonitor = budget;
        this.component=component;
        System.out.println("M");

    }

    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaMonitor(){
        DaoRicercaMonitor daoRicercaMonitor= new DaoRicercaMonitor(this.budgetPerMonitor);

        try {
            DaoRicercaMonitor.getDaoMonitorConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaMonitor.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaMonitor.returnComponenteMonitor();
        this.risultatoCaratteristica=daoRicercaMonitor.returnCaratteristicaMonitor();
        System.out.println("Concrete Decorator RAM  " + risultatoRicerca);

    }
}
