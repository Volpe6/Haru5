/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strategy;

import Model.ModelTabuleiro;

/**
 *
 * @author Drew
 */
public class CalculoPontuacao {
    
    private Pontuacao      pontuacao;
    private ModelTabuleiro tabuleiro;
    private int linha;
    private int coluna;
    
    public CalculoPontuacao(Pontuacao pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public String calcularPontuacao() {
        return pontuacao.calcular(this);
    }
    
    public Pontuacao getPontuacao() {
        return pontuacao;
    }
    
    public void setPontuacao(Pontuacao pont) {
        this.pontuacao = pont;
    }
    
    public void addTabuleiro(ModelTabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    public ModelTabuleiro getTabuleiro() {
        return tabuleiro;
    }
    
    public void setLinha(int linha) {
        this.linha = linha;
    }
    
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    public int getLinha() {
        return linha;
    }
    
    public int getColuna() {
        return coluna;
    }
}
