package com.example.pcb.cl_view;

import java.util.Scanner;

public class InserisciUView {
    public void inserisciNuoviParametro() {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per modificare l'utilizzo!");
        String utilizzoOld ="";
        String utilizzoAttuale ="1354";
        System.out.println("ecco il vecchio utilizzo: "+ utilizzoOld);
        System.out.println("inserisci il nuovo utilizzo:");
        Scanner scannerU = new Scanner(System.in);
        String utilizzoNew = scannerU.nextLine();
        System.out.println("Confermi la modifica? puoi rispondere 'si' o 'no'");
        Scanner scanner = new Scanner(System.in);
        String confermaModifiche = scanner.nextLine();

        if(confermaModifiche.equals("si")){
            //invio nuovo utilizzo



        }else{
            //ricomincia
        }
        System.out.println("parametro attuale è: "+ utilizzoAttuale);
    }
}
