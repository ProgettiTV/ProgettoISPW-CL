package org.example;

import java.util.Scanner;

public class AdminPageView {
    public void selezionaDecisioneAdmin(){
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nel tuo account Admin!");
        System.out.println("Cosa vuoi fare? Puoi selezionare : 'Modifica Budget' o 'Modifica Utilizzo' oppure 'Visualizza Statistiche'(non implementata)' ");
        Scanner scanner = new Scanner(System.in);
        String decisioneUtente = scanner.nextLine();
        if(decisioneUtente.equals("Modifica Budget")){
            //chiama funzione


        } else if(decisioneUtente.equals("Modifica Utilizzo")){


        }else{

        }
    }
}
