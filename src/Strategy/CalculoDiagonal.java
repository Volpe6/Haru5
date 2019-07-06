/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Model.ModelAbstracPeca;
import Model.ModelMar;
import Model.ModelNenufaresClaros;
import Model.ModelNenufaresEscuros;
import Model.ModelNeufarFlorAmarela;

/**
 *  Verifica se ha flores na diagonal
 * 
 * @author Drew
 */
public class CalculoDiagonal implements Pontuacao {

    @Override
    public String calcular(CalculoPontuacao calculo) {
        ModelAbstracPeca peca = calculo.getTabuleiro().getPecaConcreta(calculo.getColuna(), calculo.getLinha());
        int flores = 0;
        
        if(!isFlor(peca)) {
            return "0";
        }
        
        for(int i = 0; i < calculo.getTabuleiro().getLinha(); i++) {//diagonal principal de cima para baixo
            for(int j = 0; j < calculo.getTabuleiro().getColuna(); j++) {
                if(i == j) {
                    if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(j, i).getClass()) {
                        flores++;
                    } 
                }
            }
        }
        
        if(flores == 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "3" + cor;
        } else if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "5" + cor;
        }
        
        flores = 0;
        
        for(int k = calculo.getTabuleiro().getLinha() - 1; k > 0; k--) {//diagonal principal de baixo para cima
            for(int l = calculo.getTabuleiro().getColuna() - 1; l > 0 ; l--) {
                if(k == l) {
                    if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(l, k).getClass()) {
                        flores++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        if(flores == 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "3" + cor;
        } else if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "5" + cor;
        }
        
        flores = 0;

        for(int m = 0; m < calculo.getTabuleiro().getLinha(); m++) {//diagonal secundaria de cima para baixo
            for(int n = 0; n < calculo.getTabuleiro().getColuna() ; n++) {
                if(n == (calculo.getTabuleiro().getColuna()-1-m)) {
                    if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(n, m).getClass()) {
                        flores++;
                    } else {
                        break;
                    }
                }
                
            }
        }
        
        if(flores == 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "3" + cor;
        } else if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "5" + cor;
        }
        
        flores = 0;
        
        for(int o = calculo.getTabuleiro().getLinha() - 1; o > 0 ; o--) {//diagonal secundaria de baixo para cima
            for(int p = calculo.getTabuleiro().getColuna() - 1; p >= 0 ; p--) {
                if(p == (calculo.getTabuleiro().getColuna()-1-o)) {
                    if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(p, o).getClass()) {
                        flores++;
                    } else {
                        break;
                    }
                }
                
            }
        }
        
        if(flores == 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "3" + cor;
        } else if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "5" + cor;
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
