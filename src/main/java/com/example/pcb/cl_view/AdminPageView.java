package com.example.pcb.cl_view;

import com.example.pcb.exception.DaoException;
import com.example.pcb.gui_class.AdminBudgetGUI;
import com.example.pcb.gui_class.AdminUtilizziGUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminPageView {
    public void selezionaDecisioneAdmin() throws IOException, SQLException, DaoException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nel tuo account Admin!");
        System.out.println("Cosa vuoi fare? Puoi selezionare : 'Modifica Budget' o 'Modifica Utilizzo' oppure 'Visualizza Statistiche'(non implementata)' ");
        Scanner scanner = new Scanner(System.in);
        String decisioneUtente = scanner.nextLine();
        if(decisioneUtente.equals("Modifica Budget")){

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToModificaBudget();


        } else if(decisioneUtente.equals("Modifica Utilizzo")){

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToModificaUtilizzo();


        }else{

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToLogin();

        }
    }
}
