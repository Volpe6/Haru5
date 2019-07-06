/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import Model.ModelTabuleiro;

/**
 * Classe abstrata que especifica metodos para a criacao de objetos-produtos
 * 
 * @author Andrew, Viviane
 */
public abstract class BuilderTabuleiro {
    
    /**
     * Retorna o modelo do tabuleiro
     * 
     * @return ModelTabuleiro
     */
    public abstract ModelTabuleiro getTabuleiro();
    
    /**
     * Cria uma nova instancia do tabuleiro
     */
    public abstract void reset();
    
    /**
     * Constroi o tabuleiro com as pecas nas posicoes desejadas.
     */
    public void controiTabuleiro(){}
    
}
