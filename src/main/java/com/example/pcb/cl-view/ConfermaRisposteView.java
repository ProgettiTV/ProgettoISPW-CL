package org.example;

import java.util.Scanner;

public class ConfermaRisposteView {

    public void confermaLeScelte() {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per confermare le tue risposte!");
        System.out.println("Vuoi confermare? Puoi selezionare : 'si' o 'no' ");
        Scanner scanner = new Scanner(System.in);
        String risposta = scanner.nextLine();
        if(risposta.equals("si") ){
            // vai avanti classe sotto

        }else{
            // chiama metodo per andare indietro
        }
    }
}
