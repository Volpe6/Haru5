/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panel;

import Model.ModelAbstracPeca;
import Model.ModelAbstractFlor;
import Model.ModelFlorAmarela;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Drew
 */
public class ViewPanelPierSuperior extends ViewPanelPier {
    
    public ViewPanelPierSuperior(ImageIcon oImage) {
        super(oImage);
        trataPanel();
    }
    
    public ViewPanelPierSuperior(String nome, ImageIcon oImage) {
        this(oImage);
        this.sNome = nome;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        desenhar(g);
    }
    
    private void desenhar(Graphics g) {
        if(imgJogador == null) {
            return;
        }
        drawJogador(g);
        
        
        if(imgFlor == null) {
            return;
        }
        drawFlor(g);
    }
    
    @Override
    public void setJogador(Image oJogador) {
        this.imgJogador = oJogador;
    }
    
    @Override   
    public void setFlor(Image oFlor, int qtd) {
        this.imgFlor     = oFlor;
        this.iQuantidade = qtd;
    }
    
    @Override
    public void drawFlor(Graphics g) {
        for(int i = 0; i < iQuantidade; i++) {
            g.drawImage(imgFlor, i*5, 30, this);
        }
        
        this.iPosicaoX   = 5;
        this.iPosicaoY   = 33;
        this.comprimento = 80;
        this.altura      = 83;
    }

    @Override
    public void drawJogador(Graphics g) {
        g.drawImage(imgJogador, 150, 50, this);
    }

}
