/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;

/**
 * Classe abstrata que define metodos comuns a suas subclasses
 * 
 * @author Andrew, Viviane
 */
public abstract class ModelAbstractFlor extends ModelAbstracPeca {
    
    private int iValor;
   
    public ModelAbstractFlor(ImageIcon oImagem) {
        super(oImagem);
    }
   
    /**
     * Adiciona uma valor a flor
     * 
     * @param iValor - Valor
     */
    public void setValor(int iValor) {
        this.iValor = iValor;
    }
    
    /**
     * Retorna o valor da flor
     * 
     * @return int
     */
    public int getValor() {
        return iValor;
    }
    
}
