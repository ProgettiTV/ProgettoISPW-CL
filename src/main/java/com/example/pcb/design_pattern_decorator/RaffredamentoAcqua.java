package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoGeneral;

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

    public void cercaRaffredamentoAcqua() throws IOException, SQLException {
        DaoGeneral daoGeneral= new DaoGeneral(this.budgetPerRaffredamentoAcqua,"raffredamentoAcqua");
        try {
            daoGeneral.cercaValore();
        } catch (SQLException e) {
            throw new SQLException(e);
        } catch (IOException e) {
            throw new IOException(e);
        }
        this.risultatoRicerca= daoGeneral.returnComponente();
        this.risultatoCaratteristica=daoGeneral.returnCaratteristica();

    }

}
