package com.example.pcb.design_pattern_decorator;

import java.util.List;

public class PcVuotoConcreteComponent extends Component{
    String risultatoRicerca="confiugrazione strandard Vuota";
    String risultatoCaratteristica="Vuota";




    @Override
    void getConfigurazione(List<String> list){

        list.add(risultatoRicerca);
    }
    @Override
    void getCaratteristica(List<String> caratteristica){

        caratteristica.add(risultatoCaratteristica);
    }
}
