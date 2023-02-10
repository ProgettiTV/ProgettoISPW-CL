package org.example;

import java.util.Scanner;

public class DomandeBudgetView {
    public void selezionaRisposteB(){
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per Rispondere alla domanda sul budget!");
        System.out.println("Puoi selezionare 5 budget: 1) € 2) €€ 3) €€€ 4) €€€€ 5) €€€€€ ");
        System.out.println("per selezionare inserisci il budget scelto, se vuoi tornare indietro digita 'indietro' ");
        Scanner scanner = new Scanner(System.in);
        String rispostaUtente = scanner.nextLine();
        if(rispostaUtente.equals("indietro")){
            // torna alla pagina indietro
        }else{
            //invia la riposta alla classe sotto

        }
    }
}
