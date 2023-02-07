package com.example.pcb.DesignPatternDecorator;



import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaRam;

import java.sql.SQLException;
import java.util.List;

public class Ram extends Decorator{
    private int budgetPerRam;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Ram(Component component, int budget) {
        this.budgetPerRam= budget;
        this.component=component;
        System.out.println("R");

    }



    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaRam(){

        DaoRicercaRam daoRicercaRam= new DaoRicercaRam(this.budgetPerRam);


        try {
            DaoRicercaRam.getDaoRamConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaRam.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaRam.returnComponenteRam();
        this.risultatoCaratteristica=daoRicercaRam.returnCaratteristicaRam();
        System.out.println("Concrete Decorator RAM  " + risultatoRicerca);


    }
}
