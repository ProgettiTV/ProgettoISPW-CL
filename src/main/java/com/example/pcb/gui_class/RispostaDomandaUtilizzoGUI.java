package com.example.pcb.gui_class;


import com.example.pcb.bean_class.BeanUtilizzo;
import com.example.pcb.DomandeUtente;
import com.example.pcb.cl_view.SwitchClassView;
import java.io.IOException;


public class RispostaDomandaUtilizzoGUI{

    private final DomandeUtente istanzaCA ;



    public RispostaDomandaUtilizzoGUI(DomandeUtente riferimentoCapplicativo) {
        this.istanzaCA=riferimentoCapplicativo;

    }





    public void vaiAConferma(String risposta) throws IOException {

        String rispostaU = risposta;

        BeanUtilizzo u = new BeanUtilizzo(risposta);
        istanzaCA.prendU(u);

        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
        switchClassView.switchToConferma(istanzaCA);


    }




}
