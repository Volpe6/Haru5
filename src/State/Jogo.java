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
public class Jogo {
    
    StateJogo estado;
    
    public Jogo() {
        setEstado(new StateJogoIniciado(this));
    }
    
    public void inicia() throws Exception {
        estado.iniciar();
    }
    
    public void finaliza() {
        estado.finalizar();
    }
    
    public void setEstado(StateJogo estado) {
        estado = estado;
    }
}
