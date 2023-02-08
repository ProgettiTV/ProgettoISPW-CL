package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaCpuIntel;

import java.sql.SQLException;
import java.util.List;

public class CpuIntel extends Decorator{
    private final int budgetPerCpu;

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public CpuIntel(Component component, int budget) {
        this.budgetPerCpu= budget;
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

    public void cercaCpuIntel(){

        DaoRicercaCpuIntel daoRicercaCpu= new DaoRicercaCpuIntel(this.budgetPerCpu);

        try {
            daoRicercaCpu.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaCpu.returnComponenteCpuIntel();
        this.risultatoCaratteristica=daoRicercaCpu.returnCaratteristicaCpuIntel();

    }
}
