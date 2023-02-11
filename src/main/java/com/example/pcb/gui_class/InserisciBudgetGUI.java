package com.example.pcb.gui_class;

import com.example.pcb.*;
import com.example.pcb.bean_class.BeanModificaBudget;
import com.example.pcb.bean_class.BeanMostraVecchioBudget;
import com.example.pcb.dao_class.DaoBudget;
import com.example.pcb.exception.DaoException;
import java.io.IOException;
import java.sql.SQLException;


public class InserisciBudgetGUI extends AbstractObserver{


    private String mostraVecchioB;
    private BeanMostraVecchioBudget riferimento;
    private int mostraIdVecchioB;
    private ModificaParametri modificaParametri;


    public void prendiRiferimentoCAB(ModificaParametri modificaParametri){
        this.modificaParametri = modificaParametri;
    }
    public void stampa(){

        System.out.println("Il budget selezionato è : "+ mostraVecchioB);

    }


    public void beanPerStampa(BeanMostraVecchioBudget beanMostraVecchioBudget) {
         this.riferimento= beanMostraVecchioBudget;
         this.mostraVecchioB= riferimento.returnVecchioB();
         this.mostraIdVecchioB = riferimento.returnIdVecchioB();


    }

    public void prova() {
        stampa();
    }

    public void modificaValoreBudget(String risposta) throws SQLException, IOException, DaoException {
        String valoreInserito = risposta;
        BeanModificaBudget beanModificaBudget = new BeanModificaBudget();
        beanModificaBudget.prendiValoreInserito(valoreInserito);

        DaoBudget daoBudget = DaoBudget.getInstance();
        daoBudget.setOsservatoreBudget();
        daoBudget.addObserver(this);


        modificaParametri.prendiRiferimentoBeanModificaBudget(beanModificaBudget);


    }

    @Override
    public void updateBudget(int budget) {

        System.out.println(budget);


    }

}
