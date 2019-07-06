/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.ModelAbstracPeca;

/**
 * 
 * @author Andrew, Viviane
 */
public abstract class FactoryAbstractPeca {
    
    
    /**
     * Retorna a flor amarela
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarFlorAmarela();
    
    /**
     * Retorna o neufar com flor amarela
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarNeufarFlorAmarela();
    
    /**
     * Retorna sapo amarelo
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarSapoAmarelo();
    
    /**
     * Retorna neufar claro
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarNeufarClaro();
    
    /**
     * Retorna a flor rosa
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarFlorRosa();
    
    /**
     * Retorna o neufar com flor rosa
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarNeufarFlorRosa();
    
    /**
     * Retorna sapo rosa
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarSapoRosa();
    
    /**
     * Retorna neufar escuro
     * 
     * @return ModelAbstracPeca
     */
    public abstract ModelAbstracPeca criarNeufarEscuro();
    
    /**
     * Retorna pedra
     * 
     * @return ModelAbstractPeca
     */
    public abstract ModelAbstracPeca criarPedraPontuacao();
    
    /**
     * Retorna mar
     * 
     * @return ModelAbstractPeca
     */
    public abstract ModelAbstracPeca criarMar();
    
}
