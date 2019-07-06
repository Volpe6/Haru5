
package Decorator;

import java.awt.Image;

/**
 * Classe abstrata que define a interface e tratamento de eventos
 *
 * @author Drew
 */
public abstract class PanelTabuleiroDecorator implements DecoratorPanelTabuleiro {

    private DecoratorPanelTabuleiro viewPanelTabuleiro;
    
    
    /**
     * Construtor da classe PanelTabuleiroDecorator, que recebe como parametro um panel que implementa a interface DecoratorPanelTabuleiro
     * 
     * @param panel 
     */
    public PanelTabuleiroDecorator(DecoratorPanelTabuleiro panel) {
        this.viewPanelTabuleiro = panel;
    }
    
    @Override
    public Image getImage() {
        return viewPanelTabuleiro.getImage();
    }
}
