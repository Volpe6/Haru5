/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Model.ModelJogador;

/**
 * Subclasse que implementa command, e classe abstrata para os comados envolvendo flores, define um atributo comum a todas as suas 
 * subclasses 
 * 
 * @author Andrew, Viviane
 */
public abstract class CommandFlor implements Command {
    
    protected ModelJogador oJogador;
    
    public CommandFlor(ModelJogador oModel) {
	this.oJogador = oModel;
    }
    
}
