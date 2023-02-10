package org.example;

import java.util.Scanner;

public class InserisciBView {
    public void inserisciNuoviParametro() {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per modificare il budget!");
        String budgetOld="";
        String budgetAttuale="1354";
        System.out.println("ecco il vecchio budget: "+ budgetOld);
        System.out.println("inserisci il nuovo budget:");
        Scanner scanner1 = new Scanner(System.in);
        String budgetNew = scanner1.nextLine();
        System.out.println("Confermi la modifica? puoi rispondere 'si' o 'no'");
        Scanner scanner = new Scanner(System.in);
        String confermaModifiche = scanner.nextLine();

        if(confermaModifiche.equals("si")){
            //invio nuovo budget



        }else{
            //ricomincia
        }
        System.out.println("parametro attuale è: "+ budgetAttuale);


    }
}
