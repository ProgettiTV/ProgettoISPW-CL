package com.example.pcb.design_pattern_decorator;

import com.example.pcb.design_pattern_decorator.dao_class_concrete_decorator.DaoRicercaSsd;
import com.example.pcb.exception.IoException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Ssd extends  Decorator{
    private final int budgetPerSsd;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public Ssd(Component component, int budget) {
        this.budgetPerSsd = budget;
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


    public void cercaSsd() throws IOException {

        DaoRicercaSsd daoRicercaSsd= new DaoRicercaSsd(this.budgetPerSsd);

        try {
            daoRicercaSsd.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException("errore in ssd");
        } catch (IOException e) {
            throw new IOException(e);
        }
        this.risultatoRicerca= daoRicercaSsd.returnComponenteSsd();
        this.risultatoCaratteristica=daoRicercaSsd.returnCaratteristicaSsd();

    }
}
