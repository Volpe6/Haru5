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
 *
 * @author Drew
 */
public class CalculoLinha implements Pontuacao {

    @Override
    public String calcular(CalculoPontuacao calculo) {
        ModelAbstracPeca peca = calculo.getTabuleiro().getPecaConcreta(calculo.getColuna(), calculo.getLinha());
        int flores = 0;
        int col    = calculo.getColuna();
        int row    = calculo.getLinha();
        
        if(!isFlor(peca)) {
            return "0";
        }
        
        for(int i = 0; i < calculo.getTabuleiro().getLinha(); i++) {// de cima para baixo
            if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(col, i).getClass()) {
                flores++;
            } else {
                break;
            }
        }
        
        if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "2" + cor;
        }
        
        flores = 0;
        
        for(int k = calculo.getTabuleiro().getLinha() - 1; k > 0 ; k--) {// de baixo para cima
            if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(col, k).getClass()) {
                flores++;
            } else {
                break;
            }
        }
        
        if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "2" + cor;
        }
        
        flores = 0;
        
        for(int j = 0; j < calculo.getTabuleiro().getColuna(); j++) {
            if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(j, row).getClass()) {
                flores++;
            } else {
                break;
            }
        }
        
        if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "2" + cor;
        }
        
        flores = 0;
        
        for(int l = calculo.getTabuleiro().getColuna() - 1; l > 0; l--) {
            if(peca.getClass() == calculo.getTabuleiro().getPecaConcreta(l, row).getClass()) {
                flores++;
            } else {
                break;
            }
        }
        
        if(flores >= 4) {
            String cor = (peca.getClass() == ModelNeufarFlorAmarela.class) ? "amarelo" : "rosa";
            return "2" + cor;
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
