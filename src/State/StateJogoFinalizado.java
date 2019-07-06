/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Controller.ControllerJogo;

/**
 *
 * @author Drew
 */
public class StateJogoFinalizado extends StateJogo {
    
    public StateJogoFinalizado(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void finalizar() {
        ControllerJogo.getInstance().notificaFimJogo();
    }
    
}
