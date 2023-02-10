package com.example.pcb.cl_view;

import com.example.pcb.DomandeUtente;
import com.example.pcb.gui_class.ComponentiGUI;
import com.example.pcb.gui_class.ConfermaRisposteGUI;

import java.io.IOException;
import java.util.Scanner;


public class ConfermaRisposteView {

    public void confermaLeScelte(DomandeUtente domandeUtente) throws IOException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per confermare le tue risposte!");
        ConfermaRisposteGUI confermaRisposteGUI = new ConfermaRisposteGUI(domandeUtente);
        confermaRisposteGUI.crea();
        System.out.println("Vuoi confermare? Puoi selezionare : 'Conferma' o 'Annulla' ");
        Scanner scanner = new Scanner(System.in);
        String risposta = scanner.nextLine();
        System.out.println("risposta: "+risposta);
        if(risposta.equals("Conferma") ){

            confermaRisposteGUI.vaiAComponenti(risposta);



        }else{
            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToBudget();
        }

    }
}
