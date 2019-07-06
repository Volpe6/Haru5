/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panel;

import Model.ModelAbstracPeca;
import Model.ModelAbstractFlor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Drew
 */
public abstract class ViewPanelPier extends ViewAbstractPanel {
    
    protected  Image  imgFlor;
    protected  Image  imgJogador;
    protected  int    iQuantidade;
    protected  int    comprimento;
    protected  int    altura;
    protected  int    iPosicaoX;
    protected  int    iPosicaoY;
    protected  JPanel jPanelFloresSelecao;
    protected  JPanel jPanelFloresSelecionadas;
    
    public ViewPanelPier() {
        setPreferredSize(new Dimension(100, 139));
    }
    
    public ViewPanelPier(ImageIcon oImage) {
        super(oImage);
        setPreferredSize(new Dimension(100, 139));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        int iWTotal = getWidth();
        
        int w = getImagem().getWidth(null);
        
        for(int i = 0; i*w < iWTotal; i++) {
            g.drawImage(getImagem(), i*w, 0, this);
        } 
    }
    
    protected void trataPanel() {
         this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        jPanelFloresSelecao = new JPanel();
        jPanelFloresSelecao.setOpaque(false);
        jPanelFloresSelecao.setLayout(new GridBagLayout());
        jPanelFloresSelecao.setVisible(false);
        
        jPanelFloresSelecionadas = new JPanel();
        jPanelFloresSelecionadas.setLayout(new GridBagLayout());
        jPanelFloresSelecionadas.setPreferredSize(new Dimension(160,40));
        jPanelFloresSelecionadas.setOpaque(false);
        jPanelFloresSelecionadas.setVisible(false);
        
        this.add(Box.createHorizontalStrut(400));
        this.add(jPanelFloresSelecionadas);
        
        this.add(jPanelFloresSelecao);
    }
    
    public void adicionaFloresSelecao(List<ModelAbstracPeca> aFlores) {
        if(aFlores.size() == 0) {
            return;
        }
        
        if(jPanelFloresSelecao.getComponentCount() > 0) {
            jPanelFloresSelecao.removeAll();
        }
        
        GridBagConstraints oConstrains = new GridBagConstraints();
        oConstrains.fill = GridBagConstraints.HORIZONTAL;
        
        for(int i = 0; i < aFlores.size(); i++) {
            oConstrains.gridx = i;
            oConstrains.gridy = 0;
            jPanelFloresSelecao.add(new ViewPanelFlor(aFlores.get(i).getImageIcon(), (ModelAbstractFlor) aFlores.get(i), false), oConstrains);
        }
        
        jPanelFloresSelecao.setVisible(true);
        jPanelFloresSelecao.revalidate();
        jPanelFloresSelecao.repaint();
    }
    
    public void adicionaFlorMao(ModelAbstracPeca oPeca) {
        if(jPanelFloresSelecionadas.getComponentCount() == 3) {
            return;
        }
        
        jPanelFloresSelecionadas.add(new ViewPanelFlor(oPeca.getImageIcon(), (ModelAbstractFlor)oPeca, true));
        jPanelFloresSelecionadas.revalidate();
        jPanelFloresSelecionadas.repaint();
        jPanelFloresSelecionadas.setVisible(true);
    }
    
    public JPanel getPanelFloresSelecao() {
        return jPanelFloresSelecao;
    }
    
    public JPanel getPanelFloresMao() {
        return jPanelFloresSelecionadas;
    }
    
    public void ocultaPanelFlores() {
        jPanelFloresSelecao.setVisible(false);
        jPanelFloresSelecionadas.setVisible(false);
    }
    
    public int getAltura() {
        return altura;
    }

    public int getComprimento() {
        return comprimento;
    }

    public int getPosicaoX() {
        return iPosicaoX;
    }

    public int getPosicaoY() {
        return iPosicaoY;
    }
    
    public void removeComponentesPanelFloresMao() {
        jPanelFloresSelecionadas.removeAll();
    }
    
    public abstract void setFlor(Image oFlor, int qtd);
    
    public abstract void setJogador(Image oJogador);
    
    public abstract void drawFlor(Graphics g);
    
    public abstract void drawJogador(Graphics g);
    
}
