
 
package View;

import Utils.TratamentoImagem;
import javax.swing.JOptionPane;

/**
 * 
 * @author Andrew, Viviane
 */
public class ViewModelTabuleiro extends ViewAbtractcModelTabuleiro {

    @Override
    public int getRowCount() {  
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return TratamentoImagem.redimensionaImagem(oControle.getPecaTabuleiro(columnIndex, rowIndex), 50, 50);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
	    return null;
        }
    }
   
    
}
