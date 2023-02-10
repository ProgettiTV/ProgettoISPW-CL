package com.example.pcb.cl_view;

import com.example.pcb.Login;
import com.example.pcb.Registrazione;

import java.io.IOException;
import java.util.Scanner;

public class RegistrazioneView {
    public void registerUser() throws IOException {

        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina di Registrazione!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il tuo Nome:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il tuo Cognome:");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci il tuo Username:");
        String username = scanner.nextLine();
        System.out.println("Inserisci la tua Password:");
        String password = scanner.nextLine();
        System.out.println("Vuoi accedere?puoi rispondere 'si' o 'no', se digiti 'no' devi re inserire i tuoi dati");
        String accedi = scanner.nextLine();
        Registrazione registrazione = new Registrazione();
        if(accedi.equals("si"))

            registrazione.registerUser();

        else
            registrazione.tornaIndietro();





    }
}
