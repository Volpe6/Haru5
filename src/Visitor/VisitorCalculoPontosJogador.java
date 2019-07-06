/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Model.ModelJogador;

/**
 *
 * @author Andrew, Viviane
 */
public class VisitorCalculoPontosJogador implements VisitorJogador {

    private int pontos;
    
    @Override
    public void visit(ModelJogador jogador) {
        pontos = jogador.getPontuacao();
    }
    
    public int getPontos() {
        return pontos;
    }
    
}
