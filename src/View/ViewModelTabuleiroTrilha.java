/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;

/**
 * 
 * @author Andrew, Viviane
 */
public class ViewModelTabuleiroTrilha extends ViewAbtractcModelTabuleiro {

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return oControle.getPecaTrilha(rowIndex, rowIndex);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
	    return null;
        }
    }
    
}
