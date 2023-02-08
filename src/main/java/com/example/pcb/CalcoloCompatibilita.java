package com.example.pcb;



import java.util.List;

public class CalcoloCompatibilita {
    private final List<String> listaCompatibilita;
    private int percentualeCompatibilita;
    public CalcoloCompatibilita(List<String> caratteristica) {
        this.listaCompatibilita=caratteristica;
    }
    public int CalcoloPercentualeCompatibilita(){


        if( ( (listaCompatibilita.get(1)!=null) ) && ( (listaCompatibilita.get(8)!=null) ) ){
            if(((Integer.parseInt(listaCompatibilita.get(8))-2 )<= (Integer.parseInt(listaCompatibilita.get(1)) ) ) && ( (Integer.parseInt(listaCompatibilita.get(1)) )<= (Integer.parseInt(listaCompatibilita.get(8))+2)) ) {
                percentualeCompatibilita += 20;
            }

        }
        else if(( (listaCompatibilita.get(1)!=null) ) && (  (listaCompatibilita.get(6)!=null) )){


             if ( (Integer.parseInt(listaCompatibilita.get(6))-2 )<= (Integer.parseInt(listaCompatibilita.get(1)) ) && (Integer.parseInt(listaCompatibilita.get(1)) )<= (Integer.parseInt(listaCompatibilita.get(6))+2) && ( !(listaCompatibilita.get(1)).equals("null") ) && ( !(listaCompatibilita.get(6)).equals("null") ) ) {
                 percentualeCompatibilita += 20;
             }

        }
        else if ( ( (listaCompatibilita.get(4)!=null) ) && (  (listaCompatibilita.get(2)!=null) )){
                if((Integer.parseInt(listaCompatibilita.get(4)) ) > (10 * ( (Integer.parseInt(listaCompatibilita.get(2)) ) ) )) {
                    percentualeCompatibilita += 20;
                }

        }
        else if ( ( (listaCompatibilita.get(7)!=null) ) && (  (listaCompatibilita.get(9)!=null) ) ){
                if((listaCompatibilita.get(7)).equals(listaCompatibilita.get(9))) {
                    percentualeCompatibilita += 20;
                }

        }
        else if (  ( (listaCompatibilita.get(3)!=null) ) && (  (listaCompatibilita.get(5)!=null) ) ){

                if((listaCompatibilita.get(3)).equals(listaCompatibilita.get(5) ) ) {
                    percentualeCompatibilita += 20;
                }

        }

        return  percentualeCompatibilita;
    }
}
