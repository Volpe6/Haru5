/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelAbstractFlor;
import View.Panel.ViewPanelPier;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 * Interface do controle do jogo
 * 
 * @author Andrew, Viviane
 */
public interface InterfaceControllerJogo {
    
    /**
     * Inicia a aplicação
     * 
     * @throws Exception 
     */
    public void iniciar() throws Exception;
    
    /**
     * Retorna a imagem da peça na posilção especificadda
     * 
     * @param iCol - Coluna onde se encontra a peça
     * @param iRow - Linha onde se encontra a peça
     * @return Icon
     * @throws Exception 
     */
    public Icon getPecaTabuleiro(int iCol, int iRow) throws Exception;
    
    /**
     * Retorna a imagem da peça na posilção especificadda
     * 
     * @param iCol - Coluna onde se encontra a peça
     * @param iRow - Linha onde se encontra a peça
     * @return Icon
     * @throws Exception 
     */
    public Object getPecaTrilha(int iCol, int iRow) throws Exception;
    
    /**
     * Adiciona um novo observador na lista de observados
     * 
     * @param oObservador - Observador a ser adicionado
     */
    public void addObservador(InterfaceObservador oObservador);
    
    /**
     * Chama o processamento que ocorre apos a flor ser clicada, e atualiza o panel com as flores selecionadas, e panel das flores na mao
     * 
     * @param oFlor - ModelAbstractPeca, para ter controle sobre qual flor foi clicada
     */
    public void clicouFlor(ModelAbstractFlor oFlor);
    
    /**
     * Chama o processamento que ocorre apos a flor da mao ser clicada, remove a flor da lista do jogador
     * 
     * @param oFlor - ModelAbstractPeca, para ter controle sobre qual flor foi clicada
     */
    public void clicouFlorMao(ModelAbstractFlor oFlor);
    
    /**
     * Adiciona uma flor no tabuleiro na posicao informada, e atualiza o tabuleiro
     * 
     * @param iCol - Coluna na qual por a flor
     * @param iRow - Linha na qual por a flor
     */
    public void colocouFlorTabuleiro(int iCol, int iRow);
    
    /**
     * Notifica que a view que o tabuleiro foi atualizado 
     */
    public void notificaMudouTabuleiro();

    /**
     * Chama os metodos, que notificam a view que, tanto as flores amarelas quanto as vermelhas foram adicionadas
     */    
    public void notificaAdicionouFlores();
    
    /**
     * Notifica a view que as flores amarelas foram adicionadas
     */
    public void notificaAdicionouFloresAmarelas();
    
    /**
     * Notifica a view que as flores vermelhas foram adicionadas
     */
    public void notificaAdicionouFloresRosas();
    
    /**
     * Notifica a view que uma flor do panel de flores selecionadas foi clicada, ele atualiza o panel de flores selecionadas e o panel que 
     * tem as flores da mao
     * 
     * @param flor - Flor que foi clicada
     * @param sCor - Cor da flor clicada
     */
    public void notificaClicouFlor(ModelAbstractFlor flor, String sCor);
    
    /**
     * Notifica a view que flor da mao foi clicada
     */
    public void notificaClicouFlorMao();
    
    /**
     * Notifica a view que o jogo iniciou
     */
    public void notificaInicioJogo();

    /**
     * Chama o processamento que ocorre quando o deck e clicado, torna visivel o panel que contem as flores para serem selecionadas
     * 
     * @param viewPanelPier - Panel no qual o deck que foi clicado
     * @param e             - Eventos do mouse
     */
    public void clicouDeck(ViewPanelPier viewPanelPier, MouseEvent e);

    /**
     * Executa o processamento de comandos de acordo com o estado do jogo
     */
    public void processaComandos(int iColSel, int iRowCel, int selectedColumn, int selectedRow);
    
    /**
     * Notifica a view que ocorreu um empate
     */
    public void notificaEmpate();
    
    /**
     * Notifica a view que houve um desempate
     */
    public void notificaDesempate();
    
    /**
     * Evento que ocorre quando o botao de desempate da flor rosa
     */
    public void clicouBotaodesempateRosa();
    
    /**
     * Evento que ocorre quando o botao de desempate da flor amarela
     */
    public void clicouBotaoDesempateAmarelo();

}
