package com.example.pcb.cl_view;

import java.util.Scanner;

public class ModificaBudgetView {
    public void modificaB() {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per selezionare cosa modificare!");
        System.out.println("Puoi selezionare 5 budget: 1) € 2) €€ 3) €€€ 4) €€€€ 5) €€€€€ ");
        System.out.println("per selezionare inserisci il budget scelto, se vuoi tornare indietro digita 'indietro' ");
        Scanner scanner = new Scanner(System.in);
        String rispostaAdmin = scanner.nextLine();
        if(rispostaAdmin.equals("indietro")){
            // torna alla pagina indietro
        }else{
            //invia la riposta alla classe sotto


        }
    }
}
