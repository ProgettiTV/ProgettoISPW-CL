package org.example;


import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class EntryView {
 public void eseguiEntry() {

     System.out.println("------------------------------- PC Builder -------------------------------");
     System.out.println("Sei nella pagina di Login!");
     System.out.println("Inserisci il tuo Username:");
     Scanner scanner = new Scanner(System.in);
     String username = scanner.nextLine();
     System.out.println("Inserisci la tua Password:");
     String password = scanner.nextLine();
     System.out.println("Vuoi accedere?puoi rispondere 'si' o 'no', se ditigiti 'no' devi re inserire i tuoi dati");
     String accedi = scanner.nextLine();
    if(accedi.equals("si")){

        // passa i parametri alla classe sotto per login


    }else if(accedi.equals("si!")){
        //da eliminare questo  else if

    }else{
        // chiama classe sotto per switch
    }
 }


 }
