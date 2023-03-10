package com.example.pcb.design_pattern_decorator;

import java.util.List;

public abstract class Decorator extends Component{
    protected Component component;
    protected Integer budget;


    void getConfigurazione(List<String> list){
        component.getConfigurazione(list);
    }
     void getCaratteristica(List<String> caratteristica) {
         component.getCaratteristica(caratteristica);
    }
}
