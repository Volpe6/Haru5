/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Model.ModelJogador;
import java.util.ArrayList;
import java.util.Collections;

/**
 *  Subclasse de CommandFlor, embaralha as flores
 * 
 * @author Andrew, Viviane
 */
public class CommandEmbaralhaFlores extends CommandFlor {

    /**
     * Contrutor da classe, recebe como parametro o modelo do jogador 
     * 
     * @param oModel - Modelo do jogador 
     */
    public CommandEmbaralhaFlores(ModelJogador oModel) {
        super(oModel);
    }
    
    @Override
    public void execute() {
        oJogador.embaralharFlores();
    }
    
}
