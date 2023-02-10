package com.example.pcb.cl_view;

import com.example.pcb.exception.DaoException;
import com.example.pcb.gui_class.InserisciBudgetGUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class InserisciBView {
    public void inserisciNuoviParametro(InserisciBudgetGUI inserisciBudgetGUI) throws SQLException, IOException, DaoException {


        System.out.println("------------------------------- PC Builder -------------------------------");
        System.out.println("Sei nella pagina per modificare il budget!");

        inserisciBudgetGUI.prova();

        System.out.println("inserisci il nuovo budget:");
        Scanner scanner1 = new Scanner(System.in);
        String budgetNew = scanner1.nextLine();
        System.out.println("Confermi la modifica? puoi rispondere 'si' o 'no'");
        Scanner scanner = new Scanner(System.in);
        String confermaModifiche = scanner.nextLine();

        if(confermaModifiche.equals("si")){

            inserisciBudgetGUI.modificaValoreBudget(budgetNew);



        }else{
            SwitchClassView switchClassView = SwitchClassView.getSwitchClassViewInstance();
            switchClassView.switchToInserisciBudget(inserisciBudgetGUI);
        }



    }
}
