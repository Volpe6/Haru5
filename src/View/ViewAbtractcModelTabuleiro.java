/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerJogo;
import Controller.InterfaceControllerJogo;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Andrew, Viviane
 */
public abstract class ViewAbtractcModelTabuleiro extends AbstractTableModel {
    
    protected InterfaceControllerJogo oControle = ControllerJogo.getInstance();
}
