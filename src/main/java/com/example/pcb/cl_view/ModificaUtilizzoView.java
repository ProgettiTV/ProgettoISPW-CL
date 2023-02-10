package com.example.pcb.cl_view;

import com.example.pcb.exception.DaoException;
import com.example.pcb.gui_class.AdminUtilizziGUI;
import com.example.pcb.gui_class.InserisciUtilizzoGUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ModificaUtilizzoView {
    public void modificaU() throws SQLException, IOException, DaoException {
        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per selezionare cosa modificare!");
        System.out.println("Puoi selezionare 5 utilizzi: 1) Professore 2) Gaming 3) Studente 4) Musicista 5) Illustratore ");
        System.out.println("per selezionare inserisci l'utilizzo scelto, se vuoi tornare indietro digita 'indietro' ");
        Scanner scanner = new Scanner(System.in);
        String rispostaAdmin = scanner.nextLine();
        if(rispostaAdmin.equals("indietro")){

            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToAdminProfile();

        }else{

            AdminUtilizziGUI adminUtilizziGUI = new AdminUtilizziGUI();
            adminUtilizziGUI.selezionaNomeUtilizzo(rispostaAdmin);

        }
    }
}
