package com.example.pcb.DesignPatternDecorator;

import java.util.List;

public class PcVuotoConcreteComponent extends Component{
    String risultatoRicerca="confiugrazione strandard Vuota";
    String risultatoCaratteristica="Vuota";




    void getConfigurazione(List<String> list){

        list.add(risultatoRicerca);
    }
    void getCaratteristica(List<String> caratteristica){

        caratteristica.add(risultatoCaratteristica);
    }
}
