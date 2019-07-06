/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

/**
 *
 * @author Drew
 */
public abstract class StateJogo {
    
    protected Jogo jogo;

    public StateJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    public void iniciar() {}
    
    public void finalizar() {}
    
    public void proxEstado() {}
    
}
