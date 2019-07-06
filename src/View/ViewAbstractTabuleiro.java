/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * 
 * @author Andrew, Viviane
 */
public abstract class ViewAbstractTabuleiro extends JTable {
    
    protected TableModel oModel;
    
    /**
     * Configurações padrão da tela
     */
    protected abstract void definicaoInicial();
    
    public abstract void setTamanhoColunas(int iTamanho);
    
    public abstract void setTamanhoLinha(int iTamanho);
    
    /**
     * Define o espaço entre as células
     * 
     * @param iLarg - Largura entre as celulas
     * @param iAlt  - Altura entre as celulas
     */
    public void setEspacoEntreCelulas(int iLarg, int iAlt) {
        this.setIntercellSpacing(new Dimension(iLarg, iAlt));
    }
    
    /**
     * Torna o grid visivel
     * 
     * @param bMostra - Se torna o grid visivel
     */
    public void mostraGrid(boolean bMostra) {
        this.setShowGrid(bMostra);
    }
    
    /**
     * Define o tipo da Seleção
     * 
     * @param iTipo - O tipo da seleção(exemplo: ListSelectionModel.SINGLE_SELECTION)
     */
    public void setTipoSelecao(int iTipo) {
        this.setSelectionMode(iTipo);
    }
    
    /**
     * Define a imagem de fundo do tabuleiro
     */
    public void setBackGround(Color oCor) {
        this.setBackground(oCor);
    }
    
    /**
     * Retorna o modelo usado no tabuleiro
     * 
     * @return ModelTabuleiro
     */
    public TableModel getModelTabuleiro() {
        return oModel;
    }
    
    /**
     * Define o tamanho do tabuleiro
     * 
     * @param iComp - Comprimento
     * @param iLar  - Altura
     */
    public void setTamanhoTabuleiro(int iComp, int iLar) {
        this.setPreferredSize(new Dimension(iComp, iLar));
    }
    
}
