/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 
 * @author Andrew, Viviane
 */
public abstract class ModelAbstracPeca {
    
    private ImageIcon oImagem;
    
    /**
     * Contrutor da classe ModelAbstracPeca, recebe como para um ImageIcon
     * 
     * @param oImagem - ImageIcon
     */
    public ModelAbstracPeca(ImageIcon oImagem) {
        this.oImagem = oImagem;
    }
    
    /**
     * Seta um novo ImageIcon para a classe
     * 
     * @param oImagem - ImageIcon
     */
    public void setImagem(ImageIcon oImagem) {
        this.oImagem = oImagem;
    }
    
    /**
     * @return Icon
     */
    public Icon getImagem() {
        return oImagem;
    }
    
    /**
     * @return ImageIcon
     */
    public ImageIcon getImageIcon() {
        return oImagem;
    }
}
