package org.example;

import java.util.Scanner;

public class DomandeUtilizzoView {
    public void selezionaRisposteU() {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per Rispondere alla domanda sull'utilizzo!");
        System.out.println("Puoi selezionare 5 utilizzi: 1) Professore 2) Gaming 3) Studente 4) Musicista 5) Illustratore ");
        System.out.println("per selezionare inserisci l'utilizzo scelto, se vuoi tornare indietro digita 'indietro' ");
        Scanner scanner = new Scanner(System.in);
        String rispostaUtente = scanner.nextLine();
        if (rispostaUtente.equals("indietro")) {
            // torna alla pagina indietro
        } else {
            //invia alla classe sotto

        }
    }
}
