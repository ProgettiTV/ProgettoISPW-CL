package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaMonitor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Monitor extends Decorator{
    private final int budgetPerMonitor;

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Monitor(Component component, int budget) {
        this.budgetPerMonitor = budget;
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

    public void cercaMonitor(){
        DaoRicercaMonitor daoRicercaMonitor= new DaoRicercaMonitor(this.budgetPerMonitor);


        try {
            daoRicercaMonitor.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaMonitor.returnComponenteMonitor();
        this.risultatoCaratteristica=daoRicercaMonitor.returnCaratteristicaMonitor();

    }
}
