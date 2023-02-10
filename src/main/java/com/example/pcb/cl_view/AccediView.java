package com.example.pcb.cl_view;

import com.example.pcb.Login;
import com.example.pcb.Registrazione;

import java.io.IOException;
import java.util.Scanner;

public class AccediView {

    public void validaLogin() throws IOException {

        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina di Login!");
        System.out.println("Inserisci il tuo Username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Inserisci la tua Password:");
        String password = scanner.nextLine();
        System.out.println("Vuoi accedere?puoi rispondere 'si' o 'no', se digiti 'no' devi re inserire i tuoi dati");
        String accedi = scanner.nextLine();
        Login login = new Login();
        if (accedi.equals("si"))

            login.validateLogin(username, password);

        else
            login.tornaIndietro();


    }

}
