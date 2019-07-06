/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Panel;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Classe abstrata que define metodos comuns ao panels
 * 
 * @author Andrew, Viviane
 */
public abstract class ViewAbstractPanel extends JPanel {

    private ImageIcon oImagem;
    protected String  sNome;
    
    public ViewAbstractPanel() {}
    
    public ViewAbstractPanel(ImageIcon oImagem) {
        this.oImagem = oImagem;
    }
    
    /**
     * @return Image
     */
    protected Image getImagem() {
        return oImagem.getImage();
    };
    
    /**
     * Imprime o nome
     */
    public void imprimeNome() {
        System.out.println(this.sNome);
    }
    
}
