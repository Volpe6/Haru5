/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *  Classe que possui a imagem do mar amarelo
 * 
 * @author Drew
 */
public class DecoratorMarAmarelo extends PanelTabuleiroDecorator {
    
    public DecoratorMarAmarelo(DecoratorPanelTabuleiro panel) {
        super(panel);
    }

    @Override
    public Image getImage() {
        return new ImageIcon("img/fundoMarAmarelo.png").getImage(); 
    }
    
}
