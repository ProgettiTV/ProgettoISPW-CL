package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaRaffredamentoAria;

import java.sql.SQLException;
import java.util.List;

public class RaffredamentoAria extends Decorator{
    private int budgetPerRaffredamentoAcqua;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public RaffredamentoAria(Component component, int budget) {
        this.budgetPerRaffredamentoAcqua = budget;
        this.component=component;
        System.out.println("Ra");

    }


    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaRaffredamentoAria(){
        DaoRicercaRaffredamentoAria daoRicercaRaffredamentoAria = new DaoRicercaRaffredamentoAria(this.budgetPerRaffredamentoAcqua);

        try {
            DaoRicercaRaffredamentoAria.getDaoRaffredamentoAriaConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaRaffredamentoAria.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaRaffredamentoAria.returnComponenteRaffredamentoAria();
        this.risultatoCaratteristica= daoRicercaRaffredamentoAria.returnCaratteristicaRaffredamentoAria();

    }


}
