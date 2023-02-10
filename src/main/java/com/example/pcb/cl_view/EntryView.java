package com.example.pcb.cl_view;


import com.example.pcb.Registrazione;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class EntryView {

    public void inizio() throws IOException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("digita ciò che vuoi fare! Hai due possibilita: 1)Accedi 2)Registrazione");
        System.out.println("Inserisci cosa desideri fare:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();

        if(input.equals("Accedi")){

            switchClassView.switchToLogin();

        }else if (input.equals("Registrazione")){

            switchClassView.switchToRegistrazione();

        }

    }


 }
