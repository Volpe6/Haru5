
package View;

import java.awt.Color;

/**
 * 
 * @author Andrew, Viviane
 */
public class ViewTabuleiroTrilha extends ViewAbstractTabuleiro {
    
    public ViewTabuleiroTrilha() {
        this.oModel = new ViewModelTabuleiroTrilha();
        this.setModel(oModel);
        definicaoInicial();
    }

    @Override
    protected void definicaoInicial() {
        setEspacoEntreCelulas(10, 10);
        mostraGrid(false);
        setTamanhoColunas(100);
        setTamanhoLinha(100);
        setBackGround(Color.GREEN);
        this.setDefaultRenderer(Object.class, new ViewRenderTabuleiroTrilha());
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
