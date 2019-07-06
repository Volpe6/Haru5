/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que recebe os comandos e os executa
 * 
 * @author Andrew, Viviane
 */
public class CommandInvoker {
    
    private List<Command> imediatos = new ArrayList<>(); // lista de comandos a serem executados
    
    /**
     * Adiciona um comando a lista
     * 
     * @param comando - Comando a ser adicionado na lista
     */
    public void addCommand(Command comando) {
        imediatos.add(comando);
    }
    
    /**
     * Executa os comandos da lista de imediatos
     */
    public void execute() {
        for(Command com : imediatos) {
            com.execute();
        }
    }
    
}
