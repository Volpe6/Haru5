/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import Model.ModelTabuleiro;
import Factory.FactoryAbstractPeca;
import Factory.FactoryPeca;

/**
 * Classe que representa o builder concreto. Define e mantém a representação que cria. Fornece uma interface para recuperação do produto 
 * 
 * @author Andrew, Viviane
 */
public class BuilderTabuleiroPadrao extends BuilderTabuleiro {
    
    private ModelTabuleiro oTabuleiro;

    @Override
    public ModelTabuleiro getTabuleiro() {
        return oTabuleiro;
    }

    @Override
    public void reset() {
        this.oTabuleiro = new ModelTabuleiro(5);
    }

    @Override
    public void controiTabuleiro() {
        FactoryAbstractPeca oFabricaObjetos = new FactoryPeca();
        
        //percorre todas as linhas e colunas do tabuleiro adicionando as pecas
        for(int i = 0; i < 5; i++) {
            for(int j = 0;j < 5; j++)  {
                //linha 1
                if(i == 0) {
                    if(j == 1 && i == 0) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                    if(j == 3 && i == 0) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                }
                //linha 2
                if(i == 1) {
                    if(j == 0 && i == 1) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                    if(j == 4 && i == 1) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                }
                //linha 3
                if(i == 2) {
                    if(j == 2 && i == 2) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                }
                //linha 4
                if(i == 3) {
                    if(j == 0 && i == 3) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                    if(j == 4 && i == 3) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                }
                
                //linha 5
                if(i == 4) {
                    if(j == 1 && i == 4) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                    if(j == 3 && i == 4) {
                        oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarMar());
                        continue;
                    }
                }
                
                
                oTabuleiro.adicionaPeca(j, i, oFabricaObjetos.criarNeufarClaro());
                
                
            }
        }
        
        oTabuleiro.adicionaPeca(0, 0, oFabricaObjetos.criarNeufarEscuro());
        oTabuleiro.adicionaPeca(4, 2, oFabricaObjetos.criarSapoRosa());
        oTabuleiro.adicionaPeca(0, 2, oFabricaObjetos.criarSapoAmarelo());
    }
    
}
