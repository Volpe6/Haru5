/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.ListSelectionModel;

/**
 * 
 * @author Andrew, Viviane
 */
public class ViewTabuleiro extends ViewAbstractTabuleiro {
    
    public ViewTabuleiro() {
        this.oModel = new ViewModelTabuleiro();
        this.setModel(oModel);
        definicaoInicial();
    }
    
    /**
     * Configurações padrão da tabela
     */
    protected void definicaoInicial() {
        setTipoSelecao(ListSelectionModel.SINGLE_SELECTION);
        setEspacoEntreCelulas(10, 10);
        mostraGrid(false);
        setTamanhoColunas(100);
        setTamanhoLinha(100);
        setOpaque(false);
        this.setDefaultRenderer(Object.class, new ViewRenderTabuleiro());
    }
    
    public void setTamanhoColunas(int iTamanho) {
        for (int x=0; x < this.getColumnModel().getColumnCount(); x++) {
            this.getColumnModel().getColumn(x).setWidth(iTamanho);
            this.getColumnModel().getColumn(x).setMinWidth(iTamanho);
            this.getColumnModel().getColumn(x).setMaxWidth(iTamanho);
        }
    }
    
    public void setTamanhoLinha(int iTamanho) {
        this.setRowHeight(iTamanho);
    }
    
}
