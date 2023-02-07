package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.DesignPatternDecorator.DaoClassConcreteDecorator.DaoRicercaSchedaVideo;

import java.sql.SQLException;
import java.util.List;

public class SchedaVideo extends Decorator{
    private int budgetPerSchedaVideo;
    private String risultatoRicerca;
    private String risultatoCaratteristica;
    public SchedaVideo(Component component, int budget) {
        this.budgetPerSchedaVideo= budget;
        this.component=component;
        System.out.println("S.V.");

    }


    void getConfigurazione(List<String> list){
        super.getConfigurazione(list);
        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){
        super.getCaratteristica(caratteristica);
        caratteristica.add(risultatoCaratteristica);
    }

    public void cercaSchedaVideo(){
        DaoRicercaSchedaVideo daoRicercaSchedaVideo= new DaoRicercaSchedaVideo(this.budgetPerSchedaVideo);


        try {
            DaoRicercaSchedaVideo.getDaoSchedaVideoConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            daoRicercaSchedaVideo.cercaValore();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.risultatoRicerca= daoRicercaSchedaVideo.returnComponenteSchedaVideo();
        this.risultatoCaratteristica=daoRicercaSchedaVideo.returnCaratteristicaSchedaVideo();
        System.out.println("Concrete Decorator SSD  " + risultatoRicerca);

    }
}
