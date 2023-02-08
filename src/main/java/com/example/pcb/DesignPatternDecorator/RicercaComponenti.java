package com.example.pcb.DesignPatternDecorator;

import com.example.pcb.BeanStampaCompatibilita;
import com.example.pcb.BeanStampaConfigurazione;
import com.example.pcb.CalcoloCompatibilita;
import com.example.pcb.GUIClass.ComponentiGUI;

import java.util.ArrayList;
import java.util.List;

public class RicercaComponenti {
    protected Integer[] listaBudget;
    protected List<String> configurazioneFinale;
    protected List<String> caratteristica;
    private ComponentiGUI inviaComponentiGUI;
    Component component;
    public RicercaComponenti(Integer[] listaComp, ComponentiGUI usaComponentiGUI) {
        System.out.println("Ricerca componenti costruito");
        this.listaBudget=listaComp;
        this.inviaComponentiGUI=usaComponentiGUI;
        this.component = new PcVuotoConcreteComponent();
        this.configurazioneFinale = new ArrayList<>();
        this.caratteristica = new ArrayList<>();

    }
    //ok
    public void creaConfigurazione(){

        double randomCpu =  Math.random()*10;

        if(randomCpu%2==0){
            CpuIntel cpuIntel =new CpuIntel( this.component, listaBudget[0]);
            this.component = cpuIntel;
            cpuIntel.cercaCpuIntel();
        }else{
            CpuAmd cpuAmd =new CpuAmd( this.component, listaBudget[0]);
            this.component = cpuAmd;
            cpuAmd.cercaCpuAmd();
        }





        Ram ram=new Ram( this.component, listaBudget[1]);
        this.component = ram;
        ram.cercaRam();

        SchedaVideo schedaVideo=new SchedaVideo( this.component, listaBudget[2]);
        this.component = schedaVideo;
        schedaVideo.cercaSchedaVideo();

        Ssd ssd=new Ssd( this.component, listaBudget[3]);
        this.component =  ssd;
        ssd.cercaSsd();

        Monitor monitor=new Monitor( this.component, listaBudget[4]);
        this.component =  monitor;
        monitor.cercaMonitor();


        double randomRaffredamento = (Math.random() *20) ;

        if(randomRaffredamento%2==0){
            RaffredamentoAcqua raffredamentoAcqua=new RaffredamentoAcqua( this.component, listaBudget[5]);
            this.component =  raffredamentoAcqua;
            raffredamentoAcqua.cercaRaffredamentoAcqua();
        }else{
            RaffredamentoAria raffredamentoAria=new RaffredamentoAria( this.component, listaBudget[5]);
            this.component =  raffredamentoAria;
            raffredamentoAria.cercaRaffredamentoAria();
        }


        Case case_component=new Case( this.component, listaBudget[6]);
        this.component =  case_component;
        case_component.cercaCase();

        SchedaMadre schedaMadre=new SchedaMadre( this.component, listaBudget[7]);
        this.component = schedaMadre;
        schedaMadre.cercaSchedaMadre();

        Alimentatore alimentatore=new Alimentatore( this.component, listaBudget[8]);
        this.component =  alimentatore;
        alimentatore.cercaAlimentatore();



        this.component.getConfigurazione(configurazioneFinale);


        this.component.getCaratteristica(caratteristica);

        CalcoloCompatibilita calcoloCompatibilita=new CalcoloCompatibilita(caratteristica);
        int percentualeCompatibilita=calcoloCompatibilita.CalcoloPercentualeCompatibilita();

        BeanStampaConfigurazione beanStampaConfigurazione=new BeanStampaConfigurazione(configurazioneFinale);
        BeanStampaCompatibilita beanStampaCompatibilita= new BeanStampaCompatibilita(percentualeCompatibilita);
        inviaComponentiGUI.prendiBeanStampaConfigurazione(beanStampaConfigurazione);
        inviaComponentiGUI.prendiBeanStampaCompatibilita(beanStampaCompatibilita);


    }
}
