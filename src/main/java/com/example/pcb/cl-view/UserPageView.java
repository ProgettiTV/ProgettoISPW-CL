package org.example;

import java.util.Scanner;

public class UserPageView {
    public void Inizalizza(){
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nel tuo account User!");
        System.out.println("Cosa vuoi fare? Puoi selezionare : 'Nuova configurazione' o 'Vecchie configurazioni(non implementata)' ");
        Scanner scanner = new Scanner(System.in);
        String decisioneUtente = scanner.nextLine();
        if(decisioneUtente.equals("Nuova configurazione")){
            //chiama funzione


        }else{

        }


    }
}
