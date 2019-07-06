/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import Model.ModelTabuleiro;

/**
 * Age como director, contrói um objeto usando a classe builder.
 * 
 * @author Andrew, Viviane
 */
public class BuilderMontador {
    
    private BuilderTabuleiro oBuilderTabuleiro;
    
    /**
     * Construtor do director
     * 
     * @param oBuilderTabuleiro - o objeto a ser construido 
     */
    public BuilderMontador(BuilderTabuleiro oBuilderTabuleiro) {
        this.oBuilderTabuleiro = oBuilderTabuleiro;
    }
    
    /**
     * Cria uma nova instancia do tabuleiro, e constroi o tabuleiro
     */
    public void contruir() {
        oBuilderTabuleiro.reset();
        oBuilderTabuleiro.controiTabuleiro();
    }
    
}
