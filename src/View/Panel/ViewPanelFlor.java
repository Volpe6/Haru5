
package View.Panel;

import Model.ModelAbstractFlor;
import Utils.TratamentoImagem;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 * 
 * @author Drew
 */
public class ViewPanelFlor extends ViewAbstractPanel {
    
    private ModelAbstractFlor oFlor;
    private boolean bMostra;
    
    public ViewPanelFlor(ImageIcon oImagem, ModelAbstractFlor oModel, boolean bMostra) {
        super(oImagem);
        setPreferredSize(new Dimension(40, 40));
        setOpaque(false);
        this.oFlor = oModel;
        this.bMostra = bMostra;
    }
    
    public ViewPanelFlor(String sNome, ImageIcon oImagem, ModelAbstractFlor oModel, boolean bMostra) {
        this(oImagem, oModel, bMostra);
        this.sNome = sNome;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(TratamentoImagem.redimensionaImagem(getImagem(), 40, 40), 0, 0, this);
        if(bMostra) {
            g.drawString(oFlor.getValor() + "", 17, 25);
        }
    }
    
    /**
     * @return ModelAbstractFlor
     */
    public ModelAbstractFlor getFlor() {
        return oFlor;
    }
    
    /**
     * Define se mostrara o numero da flor
     * 
     * @param mostra 
     */
    public void setMostra(boolean mostra) {
        this.bMostra = mostra;
    }
}
