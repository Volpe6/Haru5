/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 * 
 * @author Andrew, Viviane
 */
public interface InterfaceViewModelTabuleiro {
    
    /**
     * Retorna a quantidade de linhas
     * 
     * @return int
     */
    public int getRowCount();

    /**
     * Retorna a quantidade de colunas
     * 
     * @return int
     */
    public int getColumnCount();

    /**
     * Retorna a imagem na posicao informada
     * 
     * @param rowIndex    - indice da linha
     * @param columnIndex - indice da coluna
     * @return 
     */
    public Object getValueAt(int rowIndex, int columnIndex);
}
