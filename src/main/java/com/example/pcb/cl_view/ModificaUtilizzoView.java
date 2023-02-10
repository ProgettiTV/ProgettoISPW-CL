package com.example.pcb.cl_view;

import java.util.Scanner;

public class ModificaUtilizzoView {
    public void modificaU() {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per selezionare cosa modificare!");
        System.out.println("Puoi selezionare 5 utilizzi: 1) Professore 2) Gaming 3) Studente 4) Musicista 5) Illustratore ");
        System.out.println("per selezionare inserisci l'utilizzo scelto, se vuoi tornare indietro digita 'indietro' ");
        Scanner scanner = new Scanner(System.in);
        String rispostaAdmin = scanner.nextLine();
        if(rispostaAdmin.equals("indietro")){
            // torna alla pagina indietro
        }else{
            //invia la riposta alla classe sotto


        }
    }
}
