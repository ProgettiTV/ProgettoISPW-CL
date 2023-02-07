package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaRaffredamentoAcqua;

import java.sql.SQLException;
import java.util.List;

public class RaffredamentoAcqua extends  Decorator{
    private int budgetPerRaffredamentoAcqua;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public RaffredamentoAcqua(Component component, int budget) {
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

    public void cercaRaffredamentoAcqua(){
        DaoRicercaRaffredamentoAcqua daoRicercaRaffredamentoAcqua = new DaoRicercaRaffredamentoAcqua(this.budgetPerRaffredamentoAcqua);

        try {
            DaoRicercaRaffredamentoAcqua.getDaoRaffredamentoAcquaConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaRaffredamentoAcqua.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaRaffredamentoAcqua.returnComponenteRaffredamentoAcqua();
        this.risultatoCaratteristica= daoRicercaRaffredamentoAcqua.returnCaratteristicaRaffredamentoAcqua();
        System.out.println("Concrete Decorator Raffredamento " + risultatoRicerca);

    }


}
