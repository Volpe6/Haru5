/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import View.Panel.ViewAbstractPanel;
import java.util.ArrayList;

/**
 * Classe criada para o projeto ter o padrao composite. A classe mantem os objetos que extendem o ViewAbstractPanel, imprime seus nomes no 
 * console.
 * 
 * @author Drew
 */
public class CompositeGerenciador extends ViewAbstractPanel {
    
    protected ArrayList<ViewAbstractPanel> elementos;// lista  que mantem os elementos
    
    /**
     * Construtor que recebe como parametro o nome do objeto
     * 
     * @param nome - nome do objeto
     */
    public CompositeGerenciador(String nome) {
        this.sNome     = nome;
        this.elementos = new ArrayList();
    }
    
    /**
     * Adiciona um novo elemento na lista
     */
    public void add(ViewAbstractPanel view) {
        this.elementos.add(view);
    }

    @Override
    public void imprimeNome() {
        System.out.println(this.sNome);
        for(ViewAbstractPanel view : elementos) {
            view.imprimeNome();
        }
    }
    
}
