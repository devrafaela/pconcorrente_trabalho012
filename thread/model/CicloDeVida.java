package model;

import java.util.ArrayList;

import controller.TelaController;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 17/03/2023
* Ultima alteracao.: 17/03/2023
* Nome.............: Pessoa
* Funcao...........: Eh a classe filha da classe Pessoa, aqui que
ira ocorrer todas as alteracoes na vida de cada Pessoa da Familia
*************************************************************** */
public class CicloDeVida extends Pessoa {
  
  /**
   * Ambos ArrayList's abaixo : Armazena toda a Arvore Genealogica, e
   * sera usada para colocar Emoji Chorando na tela.
   */
  private static final ArrayList<CicloDeVida> ARVORE_GENEALOGICA = new ArrayList<>();  
  private ArrayList <CicloDeVida> ARVORE_GENEALOGICA2;

  /**
   * Ambas sao inalteraveis/imutaveis e privadas.
   * IMAGEM_PESSOA : Ficara a imagem de cada Pessoa da familia.
   * LABEL : Ficara a idade de cada Pessoa da Familia.
   */
  private final ImageView IMAGEM_PESSOA;
  private final Label LABEL;

  /**
   * telaController : funcionara como o Controlador da Tela, onde ira aparacer
   * cada acontecimento na Familia
   */
  public static TelaController telaController;

  /***
   * @param nome        Nome da Pessoa
   * @param tempoDeVida Tempo de Vida da Pessoa
   * @param idadePai    Vetor que contera as Idades em que a Mae tera uma Filha
   * @param filhos      Vetor que contem as Filhas de cada Pessoa
   * @param imagemDaPessoa  Contera a Imagem da Pessoa da Familia
   * @param label Contera a Idade de cada Pessoa
   * ----------------------------------------------------------------------------
   * .add(this) : Eh um objeto que se refere a instancia atual 'CicloDeVida', e eh 
   * adicionado na 'ARVORE_GENEALOGICA', que eh uma variavel de classe do tipo static
   * que armazena todas as instacias do 'CicloDeVida'.
   * .forEach(...) : Recebe como parametro uma expressao Lambda, que eh uma funcao anonima
   * que recebe um objeto do tipo 'CicloDeVida' (do tipo 'ARVORE_GENEALOGICA') e adiona esse
   * objeto na lista 'ARVORE_GENEALOGICA2'.
   */
  public CicloDeVida (String nome, int tempoDeVida, int[] idadePai, Pessoa[] filhos, ImageView imagemDaPessoa, Label label) {
    super(nome, tempoDeVida, idadePai, filhos);
    this.IMAGEM_PESSOA = imagemDaPessoa;
    this.LABEL = label;
    ARVORE_GENEALOGICA.add(this);
    ARVORE_GENEALOGICA2 = new ArrayList<>(); // Cria um novo ArrayList de ARVORE_GENEALOGICA2
    ARVORE_GENEALOGICA.forEach(CicloDeVida -> ARVORE_GENEALOGICA2.add(CicloDeVida));
  }

  public void publish(String string) {
    Platform.runLater(() -> {
      System.out.println(string);
      telaController.nomedalabel.setText(string);  // pegar o nome da Label no Controller
    });
  }

} // fim da classe
