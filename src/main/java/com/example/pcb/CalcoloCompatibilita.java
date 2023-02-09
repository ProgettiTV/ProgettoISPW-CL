package com.example.pcb;



import java.util.List;

public class CalcoloCompatibilita {
    private final List<String> listaCompatibilita;
    private int percentualeCompatibilita;
    public CalcoloCompatibilita(List<String> caratteristica) {
        this.listaCompatibilita=caratteristica;
    }
    public int calcoloPercentualeCompatibilita(){
        String cpu = listaCompatibilita.get(1) ;
        String schedaMadre = listaCompatibilita.get(8);
        String raffredamento = listaCompatibilita.get(6);
        String ssd = listaCompatibilita.get(4);
        String ram = listaCompatibilita.get(2);
        String caseBox = listaCompatibilita.get(7);
        String alimentatore = listaCompatibilita.get(9);
        String schedaVideo = listaCompatibilita.get(3);
        String monitor = listaCompatibilita.get(5);



        if(cpu!=null  && schedaMadre!=null){
            if(((Integer.parseInt(schedaMadre)-2 )<= (Integer.parseInt(cpu) ) ) && ( (Integer.parseInt(cpu) )<= (Integer.parseInt(schedaMadre)+2)) ) {
                percentualeCompatibilita += 20;
            }

        }
        if( cpu!=null && raffredamento!=null){


             if ( (Integer.parseInt(raffredamento)-2 )<= (Integer.parseInt(cpu) ) && (Integer.parseInt(cpu) )<= (Integer.parseInt(raffredamento)+2) &&  !cpu.equals("null")  && raffredamento.equals("null") ) {
                 percentualeCompatibilita += 20;
             }

        }
        if (ssd!=null && ram!=null){
                if( Integer.parseInt(ssd)  > 10 * ( Integer.parseInt(ram) ) ) {
                    percentualeCompatibilita += 20;
                }

        }
        if (caseBox !=null  && alimentatore !=null){
                if(caseBox.equals(alimentatore) ){
                    percentualeCompatibilita += 20;
                }

        }
        if (schedaVideo!=null &&  monitor!=null){

                if(schedaVideo.equals(monitor)) {
                    percentualeCompatibilita += 20;
                }

        }

        return  percentualeCompatibilita;
    }
}
