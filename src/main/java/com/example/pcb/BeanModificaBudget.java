package com.example.pcb;

public class BeanModificaBudget {

    private String budgetInInput;
    public void prendiValoreInserito(String valoreInserito) {
        this.budgetInInput = valoreInserito;
    }
    public String returnBudgetInserito(){
        return budgetInInput;
    }
}
