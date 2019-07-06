/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Model.*;
import Model.ModelFlorAmarela;

/**
 *
 * @author Drew
 */
public class CalculoQuadrado implements Pontuacao {

    @Override
    public String calcular(CalculoPontuacao calculo) {
        ModelAbstracPeca peca = calculo.getTabuleiro().getPecaConcreta(calculo.getColuna(), calculo.getLinha());
        int flores = 1;
        int col    = calculo.getColuna();
        int row    = calculo.getLinha();
        
        if(!isFlor(peca)) {
            return "0";
        }
        
        for(int i = ((row - 1 >= 0)? row -1 : row); i < ((row + 1 <=4)? row + 1: row); i++) {
            for(int j = ((col - 1 >= 0)? col -1 : col); j < ((col + 1 <=4)? col + 1: col); j++) {
                if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(j , i).getClass()) {
                    flores++;
                    if(flores == 4) {
                        break;
                    }
                }
            }
        }
 
        if(flores == 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "1" + cor;
        }
        
        return "0";
    }
    
    private boolean isFlor(ModelAbstracPeca peca) {
        if(ModelMar.class == peca.getClass()) {
            return false;
        }
        
        if(ModelNenufaresClaros.class == peca.getClass()) {
            return false;
        }
        
        if(ModelNenufaresEscuros.class == peca.getClass()) {
            return false;
        }
        
        return true;
    }
    
}
