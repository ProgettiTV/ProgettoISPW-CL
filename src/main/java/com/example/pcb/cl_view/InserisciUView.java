package com.example.pcb.cl_view;

import com.example.pcb.gui_class.InserisciUtilizzoGUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class InserisciUView {
    public void inserisciNuovoParametro(InserisciUtilizzoGUI inserisciUtilizzoGUI) throws SQLException, IOException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per modificare l'utilizzo!");
        inserisciUtilizzoGUI.prova();
        System.out.println("inserisci il nuovo utilizzo:");
        Scanner scannerU = new Scanner(System.in);
        String utilizzoNew = scannerU.nextLine();
        System.out.println("Confermi la modifica? puoi rispondere 'si' o 'no'");
        Scanner scanner = new Scanner(System.in);
        String confermaModifiche = scanner.nextLine();

        if(confermaModifiche.equals("si")){

            inserisciUtilizzoGUI.modificaValoreUtilizzo(utilizzoNew);

        }else{

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToInserisciUtilizzo(inserisciUtilizzoGUI);

        }

    }
}
