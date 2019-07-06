/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panel;

import Model.ModelAbstracPeca;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Drew
 */
public class ViewPanelInferior extends ViewPanelPier {
    
    public ViewPanelInferior(ImageIcon oImage) {
        super(oImage);
        trataPanel();
    }
    
    public ViewPanelInferior(String nome, ImageIcon oImage) {
        this(oImage);
        this.sNome = nome;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
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
        this.altura      = 79;
    }

    @Override
    public void drawJogador(Graphics g) {
        g.drawImage(imgJogador, 150, 30, this);
    }
    
}
