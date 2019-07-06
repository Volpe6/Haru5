/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Model.ModelAbstracPeca;
import Model.ModelFlorAmarela;
import Model.ModelFlorRosa;
import Model.ModelMar;
import Model.ModelNenufaresClaros;
import Model.ModelNenufaresEscuros;
import Model.ModelNeufarFlorAmarela;
import Model.ModelNeufarFlorRosa;
import Model.ModelPedraPontuacao;
import Model.ModelSapoAmarelo;
import Model.ModelSapoRosa;

/**
 * 
 * @author Andrew, Viviane
 */
public class FactoryPeca extends FactoryAbstractPeca {

    @Override
    public ModelAbstracPeca criarFlorAmarela() {
        return new ModelFlorAmarela();
    }

    @Override
    public ModelAbstracPeca criarNeufarFlorAmarela() {
        return new ModelNeufarFlorAmarela();
    }

    @Override
    public ModelAbstracPeca criarSapoAmarelo() {
        return new ModelSapoAmarelo();
    }

    @Override
    public ModelAbstracPeca criarNeufarClaro() {
        return new ModelNenufaresClaros();
    }

    @Override
    public ModelAbstracPeca criarFlorRosa() {
        return new ModelFlorRosa();
    }

    @Override
    public ModelAbstracPeca criarNeufarFlorRosa() {
        return new ModelNeufarFlorRosa();
    }

    @Override
    public ModelAbstracPeca criarSapoRosa() {
        return new ModelSapoRosa();
    }

    @Override
    public ModelAbstracPeca criarNeufarEscuro() {
        return new ModelNenufaresEscuros();
    }

    @Override
    public ModelAbstracPeca criarPedraPontuacao() {
        return new ModelPedraPontuacao();
    }

    @Override
    public ModelAbstracPeca criarMar() {
        return new ModelMar();
    }
}
