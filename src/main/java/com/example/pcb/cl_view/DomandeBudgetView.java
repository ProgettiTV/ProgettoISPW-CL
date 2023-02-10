package com.example.pcb.cl_view;

import com.example.pcb.gui_class.RispostaDomandaBudgetGUI;

import java.io.IOException;
import java.util.Scanner;

public class DomandeBudgetView {
    public void selezionaRisposteB() throws IOException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per Rispondere alla domanda sul budget!");
        System.out.println("Puoi selezionare 5 budget: 1) € 2) €€ 3) €€€ 4) €€€€ 5) €€€€€ ");
        System.out.println("per selezionare inserisci il budget scelto, se vuoi tornare indietro digita 'indietro' ");
        Scanner scanner = new Scanner(System.in);
        String rispostaUtente = scanner.nextLine();
        if(rispostaUtente.equals("indietro")){

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToUserProfile();

        }else{

            RispostaDomandaBudgetGUI rispostaDomandaBudgetGUI = new RispostaDomandaBudgetGUI();
            rispostaDomandaBudgetGUI.selezionaRisposteBudget(rispostaUtente);

        }
    }
}
