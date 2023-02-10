package com.example.pcb.cl_view;

import com.example.pcb.Login;

import java.io.IOException;
import java.util.Scanner;

public class UserPageView {
    public void Inizalizza() throws IOException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nel tuo account User!");
        System.out.println("Cosa vuoi fare? Puoi selezionare : 'Nuova configurazione' o 'Vecchie configurazioni(non implementata)' ");
        Scanner scanner = new Scanner(System.in);
        String decisioneUtente = scanner.nextLine();
        if(decisioneUtente.equals("Nuova configurazione")){

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToBudget();

        }else{
            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToLogin();
        }


    }
}
