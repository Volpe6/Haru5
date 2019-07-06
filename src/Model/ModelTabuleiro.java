
package Model;

import Factory.FactoryPeca;
import Model.ModelAbstracPeca;
import javax.swing.Icon;

/**
 * Classe que mantem as pecas do tabuleiro
 * 
 * @author Andrew, Viviane
 */
public class ModelTabuleiro {
    
    private ModelAbstracPeca [][] mTabuleiro;
    private FactoryPeca oFactory     = new FactoryPeca();
    private int iLinha;
    private int iColuna;
    
    /**
     * Construtor da classe ControllerTabuleiro
     * 
     * @param iCol - tanto de colunas
     * @param iRow - tanto de linhas
     */
    public ModelTabuleiro(int iCol, int iRow) {
        this.iLinha     = iRow;
        this.iColuna    = iCol;
        this.mTabuleiro = new ModelAbstracPeca[iCol][iRow];
    }
    
    /**
     * Construtor da classe ControllerTabuleiro
     * 
     * @param iTamanhoMatriz - Tamanho da matriz(sera uma matriz NxN)
     */
    public ModelTabuleiro(int iTamanhoMatriz) {
        this.iLinha  = iTamanhoMatriz;
        this.iColuna = iTamanhoMatriz;
        this.mTabuleiro = new ModelAbstracPeca[iTamanhoMatriz][iTamanhoMatriz];
    }
    
    public ModelTabuleiro() {}
    
    /**
     * Define o Tamanho da matriz
     * 
     * @param iTamanho - Tamanho da matriz(sera uma matriz NxN)
     */
    public void setTamanhoMantrizTabuleiro(int iTamanho) {
        this.iLinha  = iTamanho;
        this.iColuna = iTamanho;
        this.mTabuleiro = new ModelAbstracPeca[iTamanho][iTamanho];
    }
    
    /**
     * Define o tamanho da matriz, informando as linhas e colunas
     * 
     * @param iCol - Tanto de colunas
     * @param iRow - Tanto de linhas
     */
    public void setLinhasColunasMatriz(int iCol, int iRow) {
        this.iColuna = iCol;
        this.iLinha  = iRow;
        this.mTabuleiro = new ModelAbstracPeca[iCol][iRow];
    }
    
    /**
     * Adiciona uma peca no tubuleiro na posição informada
     * 
     * @param iCol   - Coluna na qual a peça ficara
     * @param iRow   - Linha na qual a peça ficará
     * @param oModel - Peca a ser adicionada
     */
    public void adicionaPeca(int iCol, int iRow, ModelAbstracPeca oModel) {
        if(this.mTabuleiro == null) {
            return;
        }
        this.mTabuleiro[iCol][iRow] = oModel;
        System.out.println("Peca colocada na posição:" + iCol + iRow);
    }
    
    /**
     * Retona a imagem da peça na posição passada
     * 
     * @param iCol - Coluna onde esta a peça
     * @param iRow - Linha onde esta a peça
     * @return Icon
     */
    public Icon getPeca(int iCol, int iRow) {
        if(this.mTabuleiro == null) {
            return null;
        }
        return (this.mTabuleiro[iCol][iRow] == null) ? null : this.mTabuleiro[iCol][iRow].getImagem();
    }
    
    /**
     * Retona o modelo da peca na posicao informada
     * 
     * @param iCol - Coluna
     * @param iRow - Linha
     * @return ModelAbstractPeca
     */
    public ModelAbstracPeca getPecaConcreta(int iCol, int iRow) {
        if(this.mTabuleiro == null) {
            return null;
        }
        checaIndex(iCol, iRow);
        return (this.mTabuleiro[iCol][iRow] == null) ? null : this.mTabuleiro[iCol][iRow];
    }
    
    /**
     * Adiciona uma peca na posicao em que se encontra o nenufar escuro
     * 
     * @param peca - peca a ser adicionada
     */
    public void adicionaPecaNenufarEscuro(ModelAbstracPeca peca) {
        for(int i = 0; i < iLinha; i++) {
            for(int j = 0; j <  iColuna; j++) {
                if(this.mTabuleiro[j][i].getClass() == ModelNenufaresEscuros.class) {
                    this.mTabuleiro[j][i] = peca;
                    break;
                }
            }
        }
    }
    
    public void poeFloresPosicaoSapos() {
        for(int i = 0; i < iLinha; i++) {
            for(int j = 0; j <  iColuna; j++) {
                if(this.mTabuleiro[j][i].getClass() == ModelSapoRosa.class) {
                    this.mTabuleiro[j][i] = oFactory.criarNeufarFlorRosa();
                }
                if(this.mTabuleiro[j][i].getClass() == ModelSapoAmarelo.class) {
                    this.mTabuleiro[j][i] = oFactory.criarNeufarFlorAmarela();
                }
            }
        }
    }
    
    public void moverNenufares(int oCol, int oRow, int dCol, int dRow) {
        ModelAbstracPeca peca    = getPecaConcreta(oCol, oRow);
        String direcao = ""; 
        
        if(oCol == dCol) {
            if(oRow > dRow ) {
                direcao = "b";
            } else {
                direcao = "s";
            }
        } else {
            if(oCol > dCol ) {
                direcao = "e";
            } else {
                direcao = "d";
            }
        }
        
        if(verificaCaiTabuleiro(dCol, dRow, direcao) == 1) {
            adicionaPeca(oCol, oRow, oFactory.criarMar());
            adicionaPecaMovendoNenufar(dCol, dRow, peca, direcao);
        } else {
        
        }
    }
    
    private void adicionaPecaMovendoNenufar(int dCol, int dRow, ModelAbstracPeca pecaAnterior, String direcao) {
        ModelAbstracPeca peca = getPecaConcreta(dCol, dRow);
        if(peca.getClass() == oFactory.criarMar().getClass()) {
            adicionaPeca(dCol, dRow, pecaAnterior);
            return;
        }
        adicionaPeca(dCol, dRow, pecaAnterior);
        switch(direcao) {
            case "b":
                dRow = dRow - 1;
                break;
            case "s":
                dRow = dRow + 1;
                break;
            case "e":
                dCol = dCol - 1; 
                break;
            case "d":
                dCol = dCol + 1; 
                break;
           
        }
        adicionaPecaMovendoNenufar(dCol, dRow, peca, direcao);
    }
    
    private int verificaCaiTabuleiro(int dCol, int dRow, String direcao) {

            if(getPecaConcreta(dCol, dRow).getClass() == oFactory.criarMar().getClass()) {
                return 1;
            } else if(!checaIndex(dCol, dRow)) {
                return -1;
            }
            switch(direcao) {
                 case "b":
                     dRow = dRow - 1;
                     break;
                 case "s":
                     dRow = dRow + 1;
                     break;
                 case "e":
                     dCol = dCol - 1; 
                     break;
                 case "d":
                     dCol = dCol + 1; 
                     break;

             } 
        return verificaCaiTabuleiro(dCol, dRow, direcao);
    }
    
    /**
     * verifica se sai da matriz
     * @return boolean
     */
    private boolean checaIndex(int dCol, int dRow) {
        if(dCol > iColuna || dRow > iLinha) {
            System.out.println("tentou acessar posição ilegal");
            return false;
        }
        
        return true;
    }
    
    /**
     * @return int
     */
    public int getLinha() {
        return iLinha;
    }
    
    /**
     * @return int
     */
    public int getColuna() {
        return iColuna;
    }
   
}
