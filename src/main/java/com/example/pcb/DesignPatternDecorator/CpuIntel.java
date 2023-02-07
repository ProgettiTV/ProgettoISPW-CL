package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaCpuIntel;

import java.sql.SQLException;
import java.util.List;

public class CpuIntel extends Decorator{
    private int budgetPerCpu;

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public CpuIntel(Component component, int budget) {
        this.budgetPerCpu= budget;
        this.component=component;
        System.out.println("C");

    }

    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }

    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaCpuIntel(){

        DaoRicercaCpuIntel daoRicercaCpu= new DaoRicercaCpuIntel(this.budgetPerCpu);
        try {
            DaoRicercaCpuIntel.getDaoCpuConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaCpu.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaCpu.returnComponenteCpuIntel();
        this.risultatoCaratteristica=daoRicercaCpu.returnCaratteristicaCpuIntel();
        System.out.println("Concrete Decorator CPU  " + risultatoRicerca);
    }
}
