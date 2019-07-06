/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 
 * @author Andrew, Viviane
 */
public class ViewRenderTabuleiro extends DefaultTableCellRenderer {
    
    private static final long serialVersionUID = 1L;

    public ViewRenderTabuleiro() {
        setOpaque(false);//torna o fundo da celula da tabela transparente
    }
    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        setIcon((ImageIcon) value);

        return this;
    }
    
}
