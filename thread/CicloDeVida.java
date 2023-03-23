import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 17/03/2023
* Ultima alteracao.: 20/03/2023
* Nome.............: CicloDeVida
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
   * @param idadeMae    Vetor que contera as Idades em que a Mae tera uma Filha
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
  public CicloDeVida (String nome, int tempoDeVida, int[] idadeMae, Pessoa[] filhos, ImageView imagemDaPessoa, Label label) {
    super(nome, tempoDeVida, idadeMae, filhos);
    this.IMAGEM_PESSOA = imagemDaPessoa;
    this.LABEL = label;
    ARVORE_GENEALOGICA.add(this);
    ARVORE_GENEALOGICA2 = new ArrayList<>(); // Cria um novo ArrayList de ARVORE_GENEALOGICA2
    ARVORE_GENEALOGICA.forEach(cicloDeVida -> ARVORE_GENEALOGICA2.add(cicloDeVida));
  }

  /*public void publish(String string){
    new Thread(() -> {
      System.out.println(string);
      telaController.label_Status.setText(string);
    }).run();
  }*/
  
  @Override
  public void publish(String s) {
    Platform.runLater(() ->{
      System.out.println(s);
      telaController.label_Status.setText(s);
    });
  }
   


  @Override
  public void publish() {
    IMAGEM_PESSOA.setVisible(true);
    LABEL.setVisible(true);
   // LABEL.setText(idade + " anos");
    Platform.runLater(() ->{
      LABEL.setText(idade + " anos");

    if (idade == TEMPO_DE_VIDA) {
      IMAGEM_PESSOA.setImage(Familia.DEATH);
      ARVORE_GENEALOGICA.remove(this);
     // ARVORE_GENEALOGICA.forEach(Pessoa -> { // Pessoa mesmo?
    //    Pessoa.IMAGEM_PESSOA.setImage((Familia.DEATH));
    //  });
    } else {
      if (IDADE_MAE.length == 0 || idade < IDADE_MAE[0] || idade > (IDADE_MAE[IDADE_MAE.length - 1] + 2)) {
        if (idade < TEMPO_DE_VIDA && idade >= 80 && !IMAGEM_PESSOA.getImage().equals(Familia.ELDERLY_3))IMAGEM_PESSOA.setImage(Familia.ELDERLY_3);
        if (idade < 80 && idade >= 66 && !IMAGEM_PESSOA.getImage().equals(Familia.ELDERLY_2))IMAGEM_PESSOA.setImage(Familia.ELDERLY_2);
        if (idade < 65 && idade >= 51 && !IMAGEM_PESSOA.getImage().equals(Familia.ELDERLY_1))IMAGEM_PESSOA.setImage(Familia.ELDERLY_1);
        if (idade < 50 && idade >= 36 && !IMAGEM_PESSOA.getImage().equals(Familia.ADULT_3))IMAGEM_PESSOA.setImage(Familia.ADULT_3);
        if (idade < 35 && idade >= 26 && !IMAGEM_PESSOA.getImage().equals(Familia.ADULT_2))IMAGEM_PESSOA.setImage(Familia.ADULT_2);
        if (idade < 25 && idade >= 19 && !IMAGEM_PESSOA.getImage().equals(Familia.ADULT_1))IMAGEM_PESSOA.setImage(Familia.ADULT_1);
        if (idade < 18 && idade >= 13 && !IMAGEM_PESSOA.getImage().equals(Familia.YOUNG))IMAGEM_PESSOA.setImage(Familia.YOUNG);
        if (idade < 12 && idade >= 7 && !IMAGEM_PESSOA.getImage().equals(Familia.KID))IMAGEM_PESSOA.setImage(Familia.KID);
       try {
        if (idade < 6 && idade >= 0 && !IMAGEM_PESSOA.getImage().equals(Familia.BABY))IMAGEM_PESSOA.setImage(Familia.BABY);
       } catch (Exception e) {
        IMAGEM_PESSOA.setImage(Familia.BABY);
       }
        //for (int i = 0; i < ARVORE_GENEALOGICA2.size(); i++) {
        //  if (ARVORE_GENEALOGICA2.get(i).idade == ARVORE_GENEALOGICA2.get(i).TEMPO_DE_VIDA) {
        //    IMAGEM_PESSOA.setImage(Familia.DEATH);
       //     ARVORE_GENEALOGICA2.remove(i);
        //  }
        //}
      } else {
        if (idFilho < IDADE_MAE.length) {
          if (idade == IDADE_MAE[idFilho]) {
            IMAGEM_PESSOA.setImage(Familia.ADULT_BABY);
          }
        }
      }
    }
  });

    }

}
  
  






 // fim da classe


/*
 


























 */