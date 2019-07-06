/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panel;

import Decorator.DecoratorMarAmarelo;
import Decorator.DecoratorMarAquarela;
import Decorator.DecoratorMarBase;
import Decorator.DecoratorPanelTabuleiro;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Andrew, Viviane
 */
public class ViewPanelTabuleiro extends ViewAbstractPanel {

    public ViewPanelTabuleiro() {
        super(new ImageIcon("img/fundoMar.png"));
    }

    public ViewPanelTabuleiro(String nome) {
        this();
        this.sNome = nome;
    }
    
    @Override
    protected Image getImagem() {
        DecoratorPanelTabuleiro fundoMar         = new DecoratorMarBase();
//        DecoratorPanelTabuleiro fundoMarAmarelo  = new DecoratorMarAmarelo(fundoMar);
        DecoratorPanelTabuleiro fundoMarAquarela = new DecoratorMarAquarela(fundoMar);
        
        return fundoMarAquarela.getImage(); 
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        int iWTotal = getWidth();
        int iHTotal = getWidth();
        
        int w = getImagem().getWidth(null);
        int h = getImagem().getHeight(null);
        
        for(int i = 0; i*w < iWTotal; i++) {
            for(int j = 0; j*h < iHTotal; j++ ) {
                g.drawImage(getImagem(), i*w, j*h, this);
            }
        }
    }
    
}
