/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Controller.ControllerJogo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Drew
 */
public class StateJogoIniciado extends StateJogo {
    
    public StateJogoIniciado(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void iniciar() {
        try {
            ControllerJogo.getInstance().iniciar();
            jogo.setEstado(new StateJogoFinalizado(jogo));
        } catch (Exception ex) {
            Logger.getLogger(StateJogoIniciado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
