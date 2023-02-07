package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaCpuAmd;

import java.sql.SQLException;
import java.util.List;

public class CpuAmd extends Decorator{
    private int budgetPerCpu;

    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public CpuAmd(Component component, int budget) {
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

    public void cercaCpuAmd(){

        DaoRicercaCpuAmd daoRicercaCpu = new DaoRicercaCpuAmd(this.budgetPerCpu);
        try {
            DaoRicercaCpuAmd.getDaoCpuConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaCpu.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaCpu.returnComponenteCpuAmd();
        this.risultatoCaratteristica=daoRicercaCpu.returnCaratteristicaCpuAmd();
        System.out.println("Concrete Decorator CPU  " + risultatoRicerca);
    }
}
