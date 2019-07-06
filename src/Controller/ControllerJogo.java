
package Controller;

import Builder.BuilderMontador;
import Model.ModelTabuleiro;
import Builder.BuilderTabuleiro;
import Builder.BuilderTabuleiroPadrao;
import Command.CommandEmbaralhaFlores;
import Command.CommandInvoker;
import Factory.FactoryAbstractPeca;
import Factory.FactoryPeca;
import Model.ModelAbstracPeca;
import Model.ModelAbstractFlor;
import Model.ModelFlorAmarela;
import Model.ModelFlorRosa;
import Model.ModelJogador;
import Model.ModelNenufaresEscuros;
import Model.ModelNeufarFlorRosa;
import Strategy.CalculoDiagonal;
import Strategy.CalculoLinha;
import Strategy.CalculoPontuacao;
import Strategy.CalculoQuadrado;
import View.Panel.ViewPanelPier;
import Visitor.VisitorCalculoPontosJogador;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Classe que serve como controladora do jogo, e nesta classe que ocorre a cominicacao entre a view o controller e o model
 * 
 * @author Andrew, Viviane
 */
public class ControllerJogo implements InterfaceControllerJogo {
    
    private static ControllerJogo oInstance;// referencia a instancia da classe
    
    private BuilderTabuleiro          oTabuleiro;
    private ModelTabuleiro            oTabuleiroTrilha;
    private FactoryAbstractPeca       oFabricaObjetos;
    private ModelJogador              oJogadorRosa;
    private ModelJogador              oJogadorAmarelo;
    private List<InterfaceObservador> lObservadores = new ArrayList<>();
    private ModelAbstractFlor         oModelFlorSelecionada;
    private ModelJogador              jogadorAtual;
    private String                    estado;
    private Point                     ponto = new Point();
    
    private ControllerJogo() {}
    
    public static ControllerJogo getInstance() {
        if(oInstance == null) {
            oInstance = new ControllerJogo();
        }
        return oInstance;
    }

    @Override
    public Icon getPecaTabuleiro(int iCol, int iRow) throws Exception {
        return oTabuleiro.getTabuleiro().getPeca(iCol, iRow);
    }

    @Override
    public Icon getPecaTrilha(int iCol, int iRow) throws Exception {
        return oTabuleiroTrilha.getPeca(iCol, iRow);
    }

    @Override
    public void addObservador(InterfaceObservador oObservador) {
        lObservadores.add(oObservador);
    }

    @Override
    public void iniciar() throws Exception {
        oFabricaObjetos = new FactoryPeca();
        adicionaPecasTabuleiro();
        adicionaPecasTabuleiroTrilha();
        colocaFlorJogadores();
        notificaAdicionouJogadores();
        notificaAdicionouFlores();
        notificaInicioJogo();
        novaRodada();
    }
    
    /**
     * Metodo chamado toda vez que uma nova rodada é iniciada
     */
    private void novaRodada() {
        estado = "iniciado";
        oJogadorAmarelo.setSenior(false);
        oJogadorAmarelo.setFlorAtual(null);
        oJogadorRosa.setSenior(false);
        oJogadorRosa.setFlorAtual(null);
    }
    
    @Override
    public void clicouFlor(ModelAbstractFlor oFlor) {
       
        String sCor = "";
        List<ModelAbstracPeca> pecas = new ArrayList();
        if(oFlor.getClass() == ModelFlorAmarela.class) {
            sCor = "amarelo";
            oJogadorAmarelo.removeFlor(oFlor);
            pecas = oJogadorAmarelo.getFlores();
        } else {
            sCor = "rosa";
            oJogadorRosa.removeFlor(oFlor);
            pecas = oJogadorRosa.getFlores();
        }
        
        notificaClicouFlor(oFlor, sCor);
        notificaFloresSelecionadasModificadas(sCor, pecas);
    }
    

    @Override
    public void clicouDeck(ViewPanelPier v, MouseEvent e) {
        if(!estado.equals("iniciado")) {
            return;
        }
        if(e.getX() >= v.getPosicaoX() && e.getX() <= v.getComprimento() && e.getY()>=v.getPosicaoY() && e.getY()<=v.getAltura()) {
            
            if(v.getName().equals("rosa")) {
                notificaClicouDeck(oJogadorRosa.getFlores(), "rosa");
            } else {
                notificaClicouDeck(oJogadorAmarelo.getFlores(), "amarelo");
            }
        }
    }
    
    @Override
    public void clicouFlorMao(ModelAbstractFlor oFlor) {
        if(oFlor.getClass() == ModelFlorAmarela.class) {
            oJogadorAmarelo.removeFlorMao(oFlor);
        } else {
            oJogadorRosa.removeFlorMao(oFlor);
        }
        
        oModelFlorSelecionada = oFlor;
        notificaClicouFlorMao();
        
        processaComandos(0,0,0,0);
    }

    @Override
    public void colocouFlorTabuleiro(int iCol, int iRow) {
        if(jogadorAtual.getNome().equals("rosa")) {
            oTabuleiro.getTabuleiro().adicionaPeca(iCol, iRow, oFabricaObjetos.criarNeufarFlorRosa());
        } else {
            oTabuleiro.getTabuleiro().adicionaPeca(iCol, iRow, oFabricaObjetos.criarNeufarFlorAmarela());
        }
        
        oModelFlorSelecionada = null;
        notificaMudouTabuleiro();
        jogadorAtual = jogadorAtual.getRival();
        estado = "junior";
    }
    
    /**
     * Coloca o sapo no tabuleiro na posicao especificada
     * 
     * @param iCol - coluna
     * @param iRow - linha
     */
    public void colocaSapoTabuleiro(int iCol, int iRow) {
        if(jogadorAtual.getNome().equals("rosa")) {
            oTabuleiro.getTabuleiro().adicionaPeca(iCol, iRow, oFabricaObjetos.criarSapoRosa());
        } else {
            oTabuleiro.getTabuleiro().adicionaPeca(iCol, iRow, oFabricaObjetos.criarSapoAmarelo());
        }
        estado = "mover_sapo_jog_sc";
        notificaMudouTabuleiro();
    }
    
    /**
     * Coloca o sapo no tabuleiro na posicao especificada
     * 
     * @param iCol - coluna
     * @param iRow - linha
     */
    public void colocaSapoSecundarioTabuleiro(int iCol, int iRow) {
        if(jogadorAtual.getRival().getNome().equals("rosa")) {
            oTabuleiro.getTabuleiro().adicionaPeca(iCol, iRow, oFabricaObjetos.criarSapoRosa());
        } else {
            oTabuleiro.getTabuleiro().adicionaPeca(iCol, iRow, oFabricaObjetos.criarSapoAmarelo());
        }
        novaRodada();
    }
    
    @Override
    public void notificaMudouTabuleiro() {
        for(InterfaceObservador obs : lObservadores) {
            obs.mudouTabuleiro();
        }
    }
    
    /**
     * Monta o tabuleiro
     */
    private void adicionaPecasTabuleiro() {
        oTabuleiro                = new BuilderTabuleiroPadrao();
        BuilderMontador oMontador = new BuilderMontador(oTabuleiro);
        oMontador.contruir();
    }
    
    /**
     * Adiciona pecas na trilha
     */
    private void adicionaPecasTabuleiroTrilha() {
        oTabuleiroTrilha = new ModelTabuleiro(9,3);
        
        oTabuleiroTrilha.adicionaPeca(0, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(1, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(2, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(3, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(4, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(5, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(6, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(7, 0, oFabricaObjetos.criarPedraPontuacao());
        oTabuleiroTrilha.adicionaPeca(8, 0, oFabricaObjetos.criarPedraPontuacao());
    }
    
    /**
     * Coloca a flores dos jogadores
     */
    private void colocaFlorJogadores() {
        CommandInvoker inv = new CommandInvoker();

        ArrayList<ModelAbstracPeca> j1Flores = new ArrayList<>();
        ArrayList<ModelAbstracPeca> j2Flores = new ArrayList<>();
        
        for(int i = 0; i < 8; i++ ) {
            j2Flores.add(oFabricaObjetos.criarFlorAmarela());
            j1Flores.add(oFabricaObjetos.criarFlorRosa());
        }
        
        oJogadorRosa    = new ModelJogador("rosa"   , j1Flores);
        oJogadorAmarelo = new ModelJogador("amarelo", j2Flores);
        
        oJogadorRosa.setRival(oJogadorAmarelo);
        oJogadorAmarelo.setRival(oJogadorRosa);
        
        inv.addCommand(new CommandEmbaralhaFlores(oJogadorRosa));
        inv.addCommand(new CommandEmbaralhaFlores(oJogadorAmarelo));
        inv.execute();
        
    }
    
    /**
     * Chama os metodos, que notificam a view que, tanto as imagens dos jogadores foram adicionadas
     */  
    public void notificaAdicionouJogadores() {
        notificaAdicionouJogadorAmarelo();
        notificaAdicionouJogadorVermelho();
    }
    
    /**
     * Notifica a viw que a imagem do jogador vermelho foi adicionada
     */
    public void notificaAdicionouJogadorVermelho() {
        for(InterfaceObservador obs : lObservadores) {
            obs.atualizaImagemJogadorVermelho(new ImageIcon("img/jogadorVermelho.png").getImage());
        }
    }
    
    /**
     * Notifica a view que a imagem do jogador vermelho foi adicionada
     */
    public void  notificaAdicionouJogadorAmarelo() {
        for(InterfaceObservador obs : lObservadores) {
            obs.atualizaImagemJogadorAmarelo(new ImageIcon("img/jogadorAmarelo.png").getImage());
        }
    }
    
    @Override
    public void notificaAdicionouFlores() {
        notificaAdicionouFloresAmarelas();
        notificaAdicionouFloresRosas();
    }
    
    @Override
    public void notificaAdicionouFloresAmarelas() {
        for(InterfaceObservador obs : lObservadores) {
            obs.adicionouFloresAmarelas(oFabricaObjetos.criarFlorAmarela().getImageIcon().getImage());
        }
    }
    
    @Override
    public void notificaAdicionouFloresRosas() {
        for(InterfaceObservador obs : lObservadores) {
            obs.adicionouFloresRosas(oFabricaObjetos.criarFlorRosa().getImageIcon().getImage());
        }
    }
    
    @Override
    public void notificaClicouFlor(ModelAbstractFlor flor, String cor) {
        for(InterfaceObservador obs : lObservadores) {
            obs.florClicada(flor, cor);
        }
    }
    
    @Override
    public void notificaClicouFlorMao(){
        for(InterfaceObservador obs : lObservadores) {
            obs.florMaoClicada();
        }
    }
    
    @Override
    public void notificaInicioJogo() {
        for(InterfaceObservador obs : lObservadores) {
            obs.iniciouJogo();
        }
    }

    /**
     * Notifica a view que o deck foi clicado
     * 
     * @param aFlores - Lista de flores que serao adicionadas na view
     * @param sCor    - Cor das flores adicionadas
     */
    public void notificaClicouDeck(List<ModelAbstracPeca> aFlores, String sCor) {
         for(InterfaceObservador obs : lObservadores) {
             obs.clicoDeck(aFlores, sCor);
         }
    }
    
    /**
     * Notifica a view que o panel de flores a serem selecionadas foi modificado
     * 
     * @param sCor   - Cor das flores
     * @param aPecas - Flores
     */
    public void notificaFloresSelecionadasModificadas(String sCor, List<ModelAbstracPeca> aPecas) {
        for(InterfaceObservador obs : lObservadores) {
             obs.floresSelecionadasModificadas(aPecas, sCor);
         }
    }

    @Override
    public void processaComandos(int iColSel, int iRowCel, int selectedColumn, int selectedRow) {
            
        switch(estado) {
            case "iniciado" :
                verificaMaiorValorFlor();
                calculaPontuacao((int)ponto.getX(), (int)ponto.getY());
                verificaPontuacao();
                break;
            case "empate":
                notificaEmpate();
                break;
            case "mover_sapo_jog_at":
                colocaSapoTabuleiro(iColSel, iRowCel);
                break;
            case "mover_sapo_jog_sc":
                colocaSapoSecundarioTabuleiro(iColSel, iRowCel);
                break;
            case "senior_1": //quando o senior e o junior ja foram definidos    
                colocouFlorTabuleiro(iColSel, iRowCel);
                calculaPontuacao(iColSel, iRowCel);
                verificaPontuacao();
                break;
            case "junior":
                chamaVentoPrimavera(iColSel, iRowCel, selectedColumn, selectedRow);
                calculaPontuacao(iColSel, iRowCel);
                verificaPontuacao();
                break;
            case "senior_2":
                adicionaNenufarEscuro(iColSel, iRowCel);
                break;
        }
            
    }
    
    /**
     * Verifica qual das flores selecionadas tem o maior valor
     */
    private void verificaMaiorValorFlor() {
        try {
            if(oJogadorRosa.getFlorAtual() != null && oJogadorAmarelo.getFlorAtual() != null) {
                defineJogadorSenior();
            } else {
                adicionaFlorMaoJogador();
            }
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
                
    }
    
    /**
     * Calcula os pontos dos jogadores
     * 
     * @param col
     * @param row 
     */
    private void calculaPontuacao(int col, int row) {
        int valor = 0;
        String nome = "";
        String resu = "";
                
        CalculoPontuacao cal = new CalculoPontuacao(new CalculoQuadrado());
        cal.addTabuleiro(oTabuleiro.getTabuleiro());
        cal.setColuna(col);
        cal.setLinha(row);
        
        resu = cal.calcularPontuacao();
        if(resu.length() > 2) {
            valor = Integer.parseInt(resu.substring(0,1));
            nome  = resu.substring(1);
            poePontosJogador(nome, valor);
        }
        
        cal.setPontuacao(new CalculoLinha());
        resu = cal.calcularPontuacao();
        if(resu.length() > 2) {
            valor = Integer.parseInt(resu.substring(0,1));
            nome  = resu.substring(1);
            poePontosJogador(nome, valor);
        }

        
        cal.setPontuacao(new CalculoDiagonal());
        resu = cal.calcularPontuacao();
        if(resu.length() > 2) {
            valor = Integer.parseInt(resu.substring(0,1));
            nome  = resu.substring(1);
            poePontosJogador(nome, valor);
        }
    }
    
    /**
     * Poe pontos no jogador designado
     * 
     * @param jogador - Jogador no qual por os pontos
     * @param valor   - pontos
     */
    private void poePontosJogador(String jogador, int valor) {
        switch(jogador) {
            case "amarelo":
                oJogadorAmarelo.setPontuacao(valor);
                break;
            case "rosa":
                oJogadorRosa.setPontuacao(valor);
                break;
        }
    }
    
    /**
     * Define qual o sera o jogador senior
     */
    private void defineJogadorSenior() {
        
        if(oJogadorAmarelo.getFlorAtual().getValor() > oJogadorRosa.getFlorAtual().getValor()) {
            oJogadorAmarelo.setSenior(true);
            oJogadorRosa.setSenior(false);
            notificaJogadorSeniorJunior("O jogador amarelo é o senior e o vermelho o junior. Senior faca sua jogada.");
            jogadorAtual = oJogadorAmarelo;
            poeFlorNenufarEscuro();
            estado = "senior_1";
        } else if(oJogadorAmarelo.getFlorAtual().getValor() < oJogadorRosa.getFlorAtual().getValor()) {
            oJogadorAmarelo.setSenior(false);
            oJogadorRosa.setSenior(true);
            notificaJogadorSeniorJunior("O jogador vermelho é o senior e o amarelo o junior. Senior faca sua jogada.");
            jogadorAtual = oJogadorRosa;
            poeFlorNenufarEscuro();
            estado = "senior_1";
        } else {
            estado = "empate";
            poeFloresSapos();
        }
        
        oJogadorAmarelo.setFlorAtual(null);
        oJogadorRosa.setFlorAtual(null);
        
    }
    
    /**
     * Poe as flores nos sapos corespondentes
     */
    private void poeFloresSapos() {
        oTabuleiro.getTabuleiro().poeFloresPosicaoSapos();
        notificaMudouTabuleiro();
        processaComandos(0, 0, 0, 0);
    }
    
    /**
     * Adiciona a flor que o jogador selecionou no inicio para comparacao no modelo do jogador, para a comparacao
     */
    private void adicionaFlorMaoJogador() {
        if(oModelFlorSelecionada == null) {
            return;
        }
        
        if(ModelFlorAmarela.class == oModelFlorSelecionada.getClass()) {
            if(oJogadorAmarelo.getFlorAtual() == null) {
                oJogadorAmarelo.setFlorAtual(oModelFlorSelecionada);
            } else {
                throw new IllegalStateException("Voce ja selecionou uma flor");
            }
        } else if(ModelFlorRosa.class == oModelFlorSelecionada.getClass()) {
            if(oJogadorRosa.getFlorAtual() == null) {
                oJogadorRosa.setFlorAtual(oModelFlorSelecionada);
            } else {
                throw new IllegalStateException("Voce ja selecionou uma flor");
            }
        } 
        
        if(oJogadorRosa.getFlorAtual() != null && oJogadorAmarelo.getFlorAtual() != null) {
            defineJogadorSenior();
        }
    }
    
    /**
     * Notifica a view quem e o senior e quem e o junior
     * 
     * @param msg - mensagem a ser mostrada
     */
    public void notificaJogadorSeniorJunior(String msg) {
        for(InterfaceObservador obs :  lObservadores) {
            obs.notificaJogadorSenior(msg);
        }
    }
    
    /**
     * poe a flor do jogador junior no nenufar escuro
     */
    private void poeFlorNenufarEscuro() {
        ModelAbstracPeca peca = null;
        
        if(oJogadorAmarelo.getSenior()) {
            peca = new ModelNeufarFlorRosa();
        } else {
            peca = oFabricaObjetos.criarNeufarFlorAmarela();
        }
        oTabuleiro.getTabuleiro().adicionaPecaNenufarEscuro(peca);
        notificaMudouTabuleiro();
    }
    
    private void chamaVentoPrimavera(int oCol, int oRow, int dCol, int dRow) {
        oTabuleiro.getTabuleiro().moverNenufares(oCol, oRow, dCol, dRow);
        notificaMudouTabuleiro();
        jogadorAtual = jogadorAtual.getRival();
        estado = "senior_2";
    }
    
    private void adicionaNenufarEscuro(int col, int row) {
        oTabuleiro.getTabuleiro().adicionaPeca(col, row, new ModelNenufaresEscuros());
        ponto.x = col;
        ponto.y = row;
        notificaMudouTabuleiro();
        if(fimJogo()) {
            notificaFimJogo();
        } else {
            novaRodada();
        }
    }
    
    private void verificaPontuacao() {
        VisitorCalculoPontosJogador v1 = new VisitorCalculoPontosJogador();
        VisitorCalculoPontosJogador v2 = new VisitorCalculoPontosJogador();
        oJogadorAmarelo.accept(v1);
        oJogadorRosa.accept(v2);
        if(v1.getPontos() >= 5) {
            notificaObservadores("O jogador " + oJogadorAmarelo.getNome() + " venceu.");
            notificaFimJogo();
        } else if(v2.getPontos() >= 5) {
            notificaObservadores("O jogador " + oJogadorRosa.getNome() + " venceu.");
            notificaFimJogo();
        }
    }

    @Override
    public void clicouBotaoDesempateAmarelo() {
        jogadorAtual = oJogadorAmarelo;
        notificaDesempate();
        estado = "mover_sapo_jog_at";
    }
    
    @Override
    public void clicouBotaodesempateRosa() {
        jogadorAtual = oJogadorRosa;
        notificaDesempate();
        estado = "mover_sapo_jog_at";
    }
    
    /**
     * Verifica se o jogo acabou
     * 
     * @return boolean
     */
    private boolean fimJogo() {
        if(oJogadorAmarelo.getFlores().size() == 0 && oJogadorRosa.getFlores().size() == 0) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Manda uma mensagem qualque a view
     * 
     * @param msg - mensagem
     */
    public void notificaObservadores(String msg) {
        for(InterfaceObservador obs : lObservadores) {
            obs.notifica(msg);
        }
    }
    
    public void notificaFimJogo() {
        for(InterfaceObservador obs : lObservadores) {
            obs.fimJogo();
        }
    }

    @Override
    public void notificaEmpate() {
        for(InterfaceObservador obs : lObservadores) {
            obs.empate();
        }
    }

    @Override
    public void notificaDesempate() {
        for(InterfaceObservador obs : lObservadores) {
            obs.desempate();
        }
    }
}
