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
public interface VisitorJogador {
    
    public void visit(ModelJogador jogador);
    
}
