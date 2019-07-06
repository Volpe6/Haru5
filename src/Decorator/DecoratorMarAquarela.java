/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Classe que possui a imagem do mar aquarela
 * 
 * @author Drew
 */
public class DecoratorMarAquarela extends PanelTabuleiroDecorator {
    
    public DecoratorMarAquarela(DecoratorPanelTabuleiro panel) {
        super(panel);
    }

    @Override
    public Image getImage() {
        return new ImageIcon("img/fundoMarAquarela.png").getImage();
    }
    
}
