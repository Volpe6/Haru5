/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Visitor.VisitorJogador;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Andrew, Viviane
 */
public class ModelJogador {
    
    private String                      sNome;
    private ArrayList<ModelAbstracPeca> aFlores;
    private ArrayList<ModelAbstracPeca> aFloresMao;
    private ModelAbstractFlor           florAtual;
    private boolean                     bSenior;
    private ModelJogador                oRival;
    private int                         pontos;
    
    public ModelJogador(String nome, ArrayList<ModelAbstracPeca> flores) {
        this.sNome      = nome;
        this.aFlores    = flores; 
        this.aFloresMao = new ArrayList<>();
        this.bSenior    = false;
        this.pontos     = 0;
        poeValorFlores();
    }
    
    /**
     * @return String
     */
    public String getNome() {
        return sNome;
    }

    /**
     * @return ArrayList<ModelAbstracPeca>
     */
    public ArrayList<ModelAbstracPeca> getFlores() {
        return aFlores;
    }
    
    /**
     * Adiciona valor as flores do jogador
     */
    private void poeValorFlores() {
        int iCount = 1;
        for(ModelAbstracPeca oFlor : aFlores) {
            ((ModelAbstractFlor)oFlor).setValor(iCount);
            iCount++;
        }
    }
    
    public void embaralharFlores() {
        Collections.shuffle(aFlores);
    }
    
    /**
     * Remove a flor da lista de flores e a adiciona na lista de flores da mao, caso as flores da mao sejam menores que 3
     * 
     * @param oModel - Flor a ser removida
     */
    public void removeFlor(ModelAbstracPeca oModel) {
        if(aFloresMao.size() == 3) {
            return;
        }
        aFloresMao.add(oModel);
        aFlores.remove(oModel);
    }
    
    /**
     * Remove a flor da mao, e adiciona as flores que sobraram na lista de flores
     * 
     * @param oModel - Flor a ser removida
     */
    public void removeFlorMao(ModelAbstracPeca oModel) {
        aFloresMao.remove(oModel);
        for(ModelAbstracPeca p : aFloresMao) {
            aFlores.add(p);
        }
        aFloresMao.removeAll(aFloresMao);
    }
    
    /**
     * Retorna uma flor com base no valor informado
     * 
     * @param valor - Valor da flor
     * @return int
     */
    public ModelAbstracPeca getFlor(String valor) {
        for(ModelAbstracPeca oPec : aFlores) {
            if(((ModelAbstractFlor)oPec).getValor() == Integer.parseInt(valor)) {
                return oPec;
            }
        }
        
        return null;
    }
    
    /**
     * Seta a flor que o jogador escolheu no inicio do jogo, para comparacao dos valores quando ambos jogadores tiverem escolhido sua flor
     * 
     * @param flor 
     */
    public void setFlorAtual(ModelAbstractFlor flor) {
        this.florAtual = flor;
    }
    
    /**
     * Retorna a flor atual
     * 
     * @return ModelAbstractFlor
     */
    public ModelAbstractFlor getFlorAtual() {
        return florAtual;
    }
    
    /**
     * Seta se o jogador e o senior
     * 
     * @param bSenior 
     */
    public void setSenior(boolean bSenior) {
        this.bSenior = bSenior;
    }
    
    /**
     * @return boolean
     */
    public boolean getSenior() {
        return bSenior;
    }
    
    public void setRival(ModelJogador jogador) {
        this.oRival = jogador;
    }
    
    /**
     * @return ModelJogador
     */
    public ModelJogador getRival() {
        return oRival;
    }
    
    public void setPontuacao(int ponto) {
        this.pontos = pontos + ponto;
    }
    
    /**
     * @return int
     */
    public int getPontuacao() {
        return pontos;
    }
    
    public void accept(VisitorJogador visitor) {
        visitor.visit(this);
    }
}
