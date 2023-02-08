package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaRaffredamentoAcqua;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RaffredamentoAcqua extends  Decorator{
    private final int budgetPerRaffredamentoAcqua;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public RaffredamentoAcqua(Component component, int budget) {
        this.budgetPerRaffredamentoAcqua = budget;
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

    public void cercaRaffredamentoAcqua(){
        DaoRicercaRaffredamentoAcqua daoRicercaRaffredamentoAcqua = new DaoRicercaRaffredamentoAcqua(this.budgetPerRaffredamentoAcqua);


        try {
            daoRicercaRaffredamentoAcqua.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaRaffredamentoAcqua.returnComponenteRaffredamentoAcqua();
        this.risultatoCaratteristica= daoRicercaRaffredamentoAcqua.returnCaratteristicaRaffredamentoAcqua();

    }


}
