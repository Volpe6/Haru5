
package View.Panel;

import Model.ModelAbstracPeca;
import Model.ModelFlorAmarela;
import Model.ModelFlorRosa;
import View.ViewAbstractTabuleiro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Andrew, Viviane
 */
public class ViewPanelHaruIchiban extends JPanel {
    
    private ViewAbstractTabuleiro oTabuleiro;
    private ViewAbstractPanel     jPanelTabuleiro;
    
    public ViewPanelHaruIchiban() {
        definicoesIniciais();
    }
    
    /**
     * Configuracao padrao
     */
    private void definicoesIniciais() {
        this.setBackground(Color.getColor("brown"));
        setInstancias();
        defineLayout();
    }
    
    /**
     * Define o tipo de layout que sera usadado pelo panel principal
     */
    private void defineLayout() {
        this.setLayout(new BorderLayout());
    }
    
    /**
     * Inicializa componentes padrao
     */
    private void setInstancias() {
        jPanelTabuleiro = new ViewPanelTabuleiro();
    }
 
    public void setTabuleiro(ViewAbstractTabuleiro oTabuleiro) {
        this.oTabuleiro = oTabuleiro;
    }
    
    public ViewAbstractTabuleiro getTabuleiro() {
        return oTabuleiro;
    }
    
    public JPanel getPanelTabuleiro() {
        return jPanelTabuleiro;
    }

    public void iniciaPanelTabuleiro() {
        jPanelTabuleiro.add(oTabuleiro);
        add(jPanelTabuleiro, BorderLayout.CENTER);
    }
}
