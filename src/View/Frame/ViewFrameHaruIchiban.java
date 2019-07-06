
package View.Frame;

import Composite.CompositeGerenciador;
import Controller.ControllerJogo;
import Controller.InterfaceControllerJogo;
import Controller.InterfaceObservador;
import Model.ModelAbstracPeca;
import Model.ModelAbstractFlor;
import State.Jogo;
import View.Panel.ViewPanelFlor;
import View.Panel.ViewPanelHaruIchiban;
import View.Panel.ViewPanelInferior;
import View.Panel.ViewPanelPier;
import View.Panel.ViewPanelPierSuperior;
import View.ViewAbstractTabuleiro;
import View.ViewTabuleiro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * 
 * @author Andrew, Viviane
 */
public class ViewFrameHaruIchiban extends JFrame implements InterfaceObservador {
    
    private static final long serialVersionUID = 1L;
    
    private InterfaceControllerJogo oControle;
    private ViewAbstractTabuleiro   oTabuleiro;
    private ViewPanelHaruIchiban    jPanelHaruIchiban;
    private ViewPanelPier           jPanelSuperior;
    private ViewPanelPier           jPanelInferor;
    private JFrame                  jFrameDesempate;
    private Jogo                    jogo;
    
    public ViewFrameHaruIchiban() throws Exception {
        oControle = ControllerJogo.getInstance();
        oControle.addObservador(this);
        definicoesIniciais();
        
        jogo = new Jogo();
//        jogo.inicia();
        
        oControle.iniciar();
    }
    
    /**
     * Aqui define o tamanho da tela, o titulo entre outras coisas
     */
    private void definicoesIniciais() {
        setTitle("teste tabuleiro");
        setSize(1000, 610);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
    }
    
    /**
     * Inicializa os componentes da view
     */
    private void initComponents() {
        CompositeGerenciador view = new CompositeGerenciador("Geral");
        
        oTabuleiro        = new ViewTabuleiro();
        jPanelHaruIchiban = new ViewPanelHaruIchiban();
        jPanelSuperior    = new ViewPanelPierSuperior("PanelSuperior", new ImageIcon("img/pier.png"));
        jPanelInferor     = new ViewPanelInferior("PanelInferior", new ImageIcon("img/pier01.png"));
        jPanelInferor.setBackground(Color.red);
        
        jPanelSuperior.setName("amarelo");
        jPanelInferor.setName("rosa");
        
        oTabuleiro.setCellSelectionEnabled(true);
        oTabuleiro.setTamanhoColunas(75);
        oTabuleiro.setTamanhoLinha(60);
        
        jPanelHaruIchiban.setTabuleiro(oTabuleiro);
        jPanelHaruIchiban.iniciaPanelTabuleiro();
        
        jPanelHaruIchiban.add(jPanelSuperior, BorderLayout.NORTH);
        jPanelHaruIchiban.add(jPanelInferor , BorderLayout.SOUTH);
      
        
        setBackground(Color.yellow);
        add(jPanelHaruIchiban, BorderLayout.CENTER);
        
        view.add(jPanelInferor);
        view.add(jPanelSuperior);
        view.imprimeNome();
        
        addEventos();
    }

    @Override
    public void atualizaImagemJogadorAmarelo(Image image) {
        jPanelSuperior.setJogador(image);
    }

    @Override
    public void atualizaImagemJogadorVermelho(Image image) {
        jPanelInferor.setJogador(image);
    }

    @Override
    public void adicionouFloresAmarelas(Image image) {
        jPanelSuperior.setFlor(image, 8);
    }

    @Override
    public void adicionouFloresRosas(Image image) {
        jPanelInferor.setFlor(image, 8);
    }

    @Override
    public void mudouTabuleiro() {
        oTabuleiro.repaint();
    }

    @Override
    public void iniciouJogo() {
        JOptionPane.showMessageDialog(null,"jogadores selecionem tres flores e escolham uma para jogar.");
    }

    @Override
    public void fimJogo() {
        JOptionPane.showMessageDialog(null, "Fim de jogo");
        this.dispose();
    }
    
    public void finalizaJogo() {
        jogo.finaliza();
    } 

    @Override
    public void atualizaPontuacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void florClicada(ModelAbstractFlor flor, String cor) {
        if(cor.equals("rosa")) {
            
            jPanelInferor.adicionaFlorMao(flor);
            adicionaListenersComponente(jPanelInferor.getPanelFloresMao().getComponents(), true);
            
        } else {
        
            jPanelSuperior.adicionaFlorMao(flor);
            adicionaListenersComponente(jPanelSuperior.getPanelFloresMao().getComponents(), true);
            
        }
        
    }

    @Override
    public void empate() {
        jFrameDesempate = new JFrame();
        JPanel jp = new JPanel();
        JButton jbR = new JButton("Vermelho");
        JButton jbA = new JButton("Amarelo");
        
        jp.add(jbR, BorderLayout.NORTH);
        jp.add(jbA, BorderLayout.SOUTH);
        
        jFrameDesempate.add(jp);
        jFrameDesempate.setSize(500, 80);
        jFrameDesempate.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrameDesempate.setLocationRelativeTo(null);
        jFrameDesempate.setResizable(false);
        jFrameDesempate.setVisible(true);
        
        jbR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oControle.clicouBotaodesempateRosa();
            }
        });
        
        jbA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oControle.clicouBotaoDesempateAmarelo();
            }
        });
    }

    @Override
    public void desempate() {
        jFrameDesempate.dispose();
    }
    
    
    public void inicia() throws Exception {
        jogo.inicia();
    }
    
    @Override
    public void florMaoClicada() {
        jPanelInferor.ocultaPanelFlores();
        jPanelInferor.removeComponentesPanelFloresMao();
        jPanelSuperior.ocultaPanelFlores();
        jPanelSuperior.removeComponentesPanelFloresMao();
    }

    @Override
    public void novaRodada() {
        JOptionPane.showMessageDialog(null, "Selecione tres flores em sua mao e jogue uma");
    }

    @Override
    public void notifica(String msn) {
        JOptionPane.showMessageDialog(null, msn);
    }

    @Override
    public void clicoDeck(List<ModelAbstracPeca> aFlores, String sCor) {
        
        if(sCor.equals("rosa")) {
            
            jPanelInferor.adicionaFloresSelecao(aFlores);
            adicionaListenersComponente(jPanelInferor.getPanelFloresSelecao().getComponents(), false);
            
        } else {
        
            jPanelSuperior.adicionaFloresSelecao(aFlores);
            adicionaListenersComponente(jPanelSuperior.getPanelFloresSelecao().getComponents(), false);
            
        }
        
    }
    
    @Override
    public void notificaJogadorSenior(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    @Override
    public void floresSelecionadasModificadas(List<ModelAbstracPeca> aFlores, String sCor) {
        if(sCor.equals("rosa")) {
            
            jPanelInferor.adicionaFloresSelecao(aFlores);
            adicionaListenersComponente(jPanelInferor.getPanelFloresSelecao().getComponents(), false);
            
        } else {
        
            jPanelSuperior.adicionaFloresSelecao(aFlores);
            adicionaListenersComponente(jPanelSuperior.getPanelFloresSelecao().getComponents(), false);
            
        }
    }
    
    /**
     * Adiociona os eventos a view
     */
    private void addEventos() {
        
        jPanelInferor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                oControle.clicouDeck(jPanelInferor ,e);
            }
        });
        
        jPanelSuperior.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); 
                oControle.clicouDeck(jPanelSuperior ,e);
            }
        });
        
        oTabuleiro.addMouseListener(new MouseAdapter() {
                private int iColSel;//coluna inicial
                private int iRowCel;//linha inicial

                @Override
                public void mousePressed(MouseEvent e) {
                    iColSel  = oTabuleiro.getSelectedColumn();
                    iRowCel  = oTabuleiro.getSelectedRow();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    oControle.processaComandos(iColSel, iRowCel, oTabuleiro.getSelectedColumn(), oTabuleiro.getSelectedRow());
                }
            
        });
    }
    
    private void adicionaListenersComponente(Component[] aComp, boolean bMao) {
        for(Component comp : aComp) {
            
            if(comp.getClass() == ViewPanelFlor.class) {
                comp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        if(bMao) {
                            oControle.clicouFlorMao(((ViewPanelFlor)comp).getFlor());
                        } else {
                            oControle.clicouFlor(((ViewPanelFlor)comp).getFlor());
                        }
                    }
                });
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ViewFrameHaruIchiban d = new ViewFrameHaruIchiban();
                    d.setVisible(true);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        });
        
    }
 
}
