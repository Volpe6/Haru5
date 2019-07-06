
package Controller;

import Model.ModelAbstracPeca;
import Model.ModelAbstractFlor;
import java.awt.Image;
import java.util.List;

/**
 * 
 * @author Andrew, Viviane
 */
public interface InterfaceObservador {
    
    /**
     * Notifica a pontuação do jogo
     */
    public void atualizaPontuacao();
    
    /**
     * Notifica a mudança de tabuleiro
     */
    public void mudouTabuleiro();
    
    /**
     * Notifica o inicio do jogo
     */
    public void iniciouJogo();
    
    /**
     * Notifica o fim do jogo
     */
    public void fimJogo();
    
    /**
     * Atualiza a view adicionando as flores amarelas
     * 
     * @param image - imagem da flor
     */
    public void adicionouFloresAmarelas(Image image);
    
     /**
     * Atualiza a view adicionando as flores rosas
     * 
     * @param image - imagem da flor
     */
    public void adicionouFloresRosas(Image image);
    
    /**
     * Atualiza a view, modificando a quantidade de flores no panel de flores selecionadas
     * 
     * @param flor - flor que foi clicada
     * @param cor  - cor da flor 
     */
    public void florClicada(ModelAbstractFlor flor, String cor);
    
    /**
     * Atualiza a view, removendo todos os componentes do panel de flores clicadas, e ocultando o panel de flores selecionadas
     */
    public void florMaoClicada();
    
    /**
     * Atualiza a view, mostrando o panel de flores clicadas
     * 
     * @param aFlores - lista das flores correspondentes ao deck clicado
     * @param sCor    - cor das flores
     */
    public void clicoDeck(List<ModelAbstracPeca> aFlores, String sCor);
    
    public void floresSelecionadasModificadas(List<ModelAbstracPeca> aFlores, String sCor);
    
    public void novaRodada();
    
    /**
     * Mostra um joption pane informando quem é senior e quem é o junior
     * 
     * @param msg 
     */
    public void notificaJogadorSenior(String msg);
    
    public void atualizaImagemJogadorVermelho(Image image);
    
    public void atualizaImagemJogadorAmarelo(Image image);
    
    /**
     * Mostra uma mensagem qualquer em um jOptionPane
     * 
     * @param msn - mensagem
     */
    public void notifica(String msn);
    
    public void empate();
    
    public void desempate();
}
