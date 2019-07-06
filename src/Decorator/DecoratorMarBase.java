/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Decorator que possui a imagem do mar padrao
 * 
 * @author Drew
 */
public class DecoratorMarBase implements DecoratorPanelTabuleiro {

    @Override
    public Image getImage() {
        return new ImageIcon("img/fundoMar.png").getImage();
    }

}
