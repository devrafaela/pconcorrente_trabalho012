import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 17/03/2023
* Ultima alteracao.: 24/03/2023
* Nome.............: CicloDeVida
* Funcao...........: Eh a classe filha da classe Pessoa, aqui que
ira ocorrer todas as alteracoes na vida de cada Pessoa da Familia
*************************************************************** */
public class CicloDeVida extends Pessoa {
  
  /* ***********************************************************************
  *  Eh definido abaixo duas variaveis para armazenar os objetos do
  * tipo 'ArrayList <ClicoDeVida>'.
  * Explicacao: Eh declarada uma variavel estatica final chamada 
  * 'ARVORE_GENEALOGICA', que eh inicializada como uma nvoa instancia
  * de 'ArrayList <ClicoDeVida>'. A lista criada sera usada par armazenar as
  * pessoas da Familia Code, bem como seus parametros (nome, idade, ...).
  *  Ja a variavel 'ARVORE_GENEALOGICA2', eh uma variavel de instancia, que eh 
  * inicializada como uma nova instancia de 'ArrayList <ClicoDeVida>'. Essa 
  * variavel so pode ser acessada dentro da instancia atual da classe que foi
  * declarada.
  *********************************************************************** */
  private static final ArrayList<CicloDeVida> ARVORE_GENEALOGICA = new ArrayList<>();  
  private ArrayList <CicloDeVida> ARVORE_GENEALOGICA2;


  /* *************************************************************************
  *  Eh declarado abaixo duas variaveis, uma ImageView chamada 'IMAGEM_PESSOA'
  * e uma Label chamado 'LABEL'. Ambas sao declaradas como finais, ou seja, nao
  * podem ser alterados depois que seus valores ja forema atribuidos, e tambem
  * como privadas, ou seja, so podem ser acessadas dentro dessa classe.
  * Funcao: A 'IMAGEM_PESSOA' servira para armazenar a imagem de cada pessoa da
  * familia, e a 'LABEL' ira armazenar a idade de cada integrante da Familia.
  ************************************************************************* */
  private final ImageView IMAGEM_PESSOA;
  private final Label LABEL;

  /* *************************************************************************
  *  Essa declaracao permite que um objeto do tipo TelaController seja acessado
  * e manipulado em outras partes do codigo, isso por ser publica e estatica.
  * Com isso nao eh necessario criar um objeto da classe.
  ************************************************************************* */
  public static TelaController telaController;

  /*********************************************************************************************
  * Nome do Constutor: CicloDeVida
  * Funcao: Cria um novo objeto CicloDeVida e inicializa suas variaveis
  * de instancia com os valores fornecidos nos parametros.
  * Parametros: 'nome' (uma String que contera o Nome de uma Pessoa), 'tempoDeVida' (um int que 
  * representa o Tempo de Vida da Pessoa), 'idadeMae' (um Array de int, que representa as idades
  *  de quando se torna Mae), 'filhos' (um Array de objetos Pessoa, que representa os filhos de
  *  cada Mae), 'imagemDaPessoa' (um objeto ImageView que armazena a imagem de cada Pessoa) e 'label'
  *  (um objeto Label que representara a idade de cada pessoa, ao lado da imagem).
  * Retorno: void
  * Explicacao: O construtor abaixo começa chamando o construtor da superclasse (Pessoa), passando
  * para ele os parametros: 'nome', 'tempoDeVida', 'idadeMae' e 'filhos'. Em seguida ele atribui a
  * 'imagemDaPessoa' a variavel de instancia 'IMAGEM_PESSOA' e o objeto 'Label' a 'LABEL'.
  *   Ele tambem adiciona o objeto atual (this) a lista 'ARVORE_GENEALOGICA' e cria um novo ArrayList
  * de 'ARVORE_GENEALOGICA2'. Ele entao itera sobre todos os elementos da lista 'ARVORE_GENEALOGICA'
  * e adiciona cada um a lista 'ARVORE_GENEALOGICA2'.
  ********************************************************************************************* */
  public CicloDeVida (String nome, int tempoDeVida, int[] idadeMae, Pessoa[] filhos, ImageView imagemDaPessoa, Label label) {
    super(nome, tempoDeVida, idadeMae, filhos);
    this.IMAGEM_PESSOA = imagemDaPessoa;
    this.LABEL = label;
    ARVORE_GENEALOGICA.add(this);
    ARVORE_GENEALOGICA2 = new ArrayList<>(); // Cria um novo ArrayList de ARVORE_GENEALOGICA2
    ARVORE_GENEALOGICA.forEach(cicloDeVida -> ARVORE_GENEALOGICA2.add(cicloDeVida));
  }

  
  /**
   *  - O metodo publish : Esta sendo usado para publicar alterar em um objeto da interface GUI.
   *  - O codigo eh executado usando o metodo *Platform.runLater()**.
   *   ** Foi necessario o uso deste metodo para que a interface nao fosse bloqueada
   *     durante a execucao do codigo. Tentando implementar de outra maneira, acabou
   *     gerando um problema de concorrencia, e as alteracoes da dela nao aconteciam.
   *  - O Lambda "() ->", foi usada para criar uma funcao anonima que eh passada para o metodo
   * runLater(), nessa funcao contem o codigo que sera executado na thread da interface.
   *  - O metodo SOUT foi chamado para exibir a mensagem no terminal. 
   *  - E por fim, o metodo 'telaController.label_Status.setText(s)' eh chamado para definir o
   * texto da Label (na interface) do objeto telaController, com a mensagem recebida por parametro.
   * Eh nesse trecho que sera exibido na interface o que acontece em cada estagio de vida da pessoa  
   */
  @Override
  public void publish(String s) {
    Platform.runLater(() ->{
      System.out.println(s);
      telaController.label_Status.setText(s);
    });
  }
   
  @Override
  public void publish() {

    // -- Torna a Imagem visivel na interface -- //
    IMAGEM_PESSOA.setVisible(true);

    // -- Torna a Label visivel na interface -- //
    LABEL.setVisible(true);

    /**  O trecho abaixa indica que as alteracoes a seguir serao aplicadas na interface
     *  Foi necessario o uso do 'Platform.runLater()' para garantir que as atualizacoes da interface do
     * usuario sejam executadas na thread de interface do usuario e nao em outra thread, o que pode
     * levar a erros de concorrencia e falhas no programa.
     */
    Platform.runLater(() ->{

      // -- Se a idade for igual a 1 e a 0, eh mostrado na tela uma Label com a 'idade' + o ano (palavra no singular)
      if (idade == 1 && idade == 0) {
        LABEL.setText(idade + " ano");
      } else {
      // -- Caso nao, eh motrado na tela a Label com 'idade' + anos (palavra no plural)
      LABEL.setText(idade + " anos");
      } // fim do if

    // -- Se a idade da pessoa for igual ao TEMPO_DE_VIDA, significa que a pessoa acaba de morrer -- //
    if (idade == TEMPO_DE_VIDA) { // if inicial
      // -- Eh trocado entao a imagem atual dela pela imagem de um tumulo, para demonstrar que ela morreu -- //
      IMAGEM_PESSOA.setImage(Familia.DEATH);
      // -- E seu processo eh encerrado dentro da 'ARVORE_GENEALOGICA' e ela eh retirada do Array -- //
      ARVORE_GENEALOGICA.remove(this);

      // -- O codigo abaixo eh uma sequencia de instrucoes que atualiza a imagem da pessoa, dependendo da idade dela -- //
    } else {
      /**
       *  O primeiro if verifica se a Pessoa possui mae, ou se a idade esta fora do intervalo da idade da Mae.
       * Se qualquer um dos criterior for atendido, o trecho a seguir eh executado.
       */
      if (IDADE_MAE.length == 0 || idade < IDADE_MAE[0] || idade > (IDADE_MAE[IDADE_MAE.length - 1] + 2)) {
        /**
         *  O restante do codigo usa uma serie de if para determinar qual imagem deve ser exibida com base em um intervalo
         * de tempo da idade da pessoa. Ocorre uma verificacao no proprio if para determinar se a imgagem atual nao eh a mesma
         * que deve ser exibida. Se a imagem atual nao for a correta, a imagem eh alterada para a imagem apropriada usando a 
         * classe Familia e as constantes de imagem definidas nela.
         */
        if (idade < TEMPO_DE_VIDA && idade >= 80 && !IMAGEM_PESSOA.getImage().equals(Familia.ELDERLY_3))IMAGEM_PESSOA.setImage(Familia.ELDERLY_3); // foto do idoso 3
        if (idade < 80 && idade >= 66 && !IMAGEM_PESSOA.getImage().equals(Familia.ELDERLY_2))IMAGEM_PESSOA.setImage(Familia.ELDERLY_2); // foto do idoso 2
        if (idade < 65 && idade >= 51 && !IMAGEM_PESSOA.getImage().equals(Familia.ELDERLY_1))IMAGEM_PESSOA.setImage(Familia.ELDERLY_1); // foto do idoso 1
        if (idade < 50 && idade >= 36 && !IMAGEM_PESSOA.getImage().equals(Familia.ADULT_3))IMAGEM_PESSOA.setImage(Familia.ADULT_3); // foto do adulto 3
        if (idade < 35 && idade >= 26 && !IMAGEM_PESSOA.getImage().equals(Familia.ADULT_2))IMAGEM_PESSOA.setImage(Familia.ADULT_2); // foto do adulto 2
        if (idade < 25 && idade >= 19 && !IMAGEM_PESSOA.getImage().equals(Familia.ADULT_1))IMAGEM_PESSOA.setImage(Familia.ADULT_1); // foto do aduto 1
        if (idade < 18 && idade >= 13 && !IMAGEM_PESSOA.getImage().equals(Familia.YOUNG))IMAGEM_PESSOA.setImage(Familia.YOUNG); // foto de um adolescente
        if (idade < 12 && idade >= 7 && !IMAGEM_PESSOA.getImage().equals(Familia.KID))IMAGEM_PESSOA.setImage(Familia.KID); // foto de uma crianca
      
        /**
         *  Esse trecho faz parte de uma verifica de idade da pessoa. Se a idade for menor que 6 anos, e a imagem da pessoa atualmente
         * exibida na tela for diferete da imagem de um bebe 'Familia.BABY', a imagem da pessoa eh alterada para a de um bebe.
         *  O try-catch foi utilizado porque o codigo tenta acessar o atributo 'IMAGEM_PESSOA', que pode ter um valor nulo, e lanca uma
         * exececao 'NullPointerExeception'. Caso isso venha a acontecer, a imagem da pessoa eh definida como a imagem de um bebe, garantindo
         * que haja sempre uma imagem exibida na tela.
         */
        try {
          if (idade < 6 && idade >= 0 && !IMAGEM_PESSOA.getImage().equals(Familia.BABY))IMAGEM_PESSOA.setImage(Familia.BABY);
        } catch (Exception e) {
          IMAGEM_PESSOA.setImage(Familia.BABY);
        } // fim do try-catch
    
      /**
       *  Se nenhum dos casos acima for atendido, comeca a verificacao se a Pessoa criada no momento eh mae ou filho de alguem.
       * Se for mae, o bloco condicional eh ignorado e nada acontece, se for um filho a condicao dentro do bloco eh verificada.
       */
      } else {
        /**
         *  No primeiro if eh verificado se o 'idFilho' eh menor que o tamanho do Array 'IDADE_MAE'. Significando entao que o filho
         * nao eh o ultimo filho da Mae.
         */
        if (idFilho < IDADE_MAE.length) {
          /**
           * No segundo if, eh verificado se a 'idade' da pessoa que esta sendo criada eh igual a idade do filho atual, ou seja, a idade
           * da mae quando o filho nasceu 'IDADE_MAE[idFilho]'.
           */
          if (idade == IDADE_MAE[idFilho]) {
            /**
             * Se as duas condicoes forem verdadeiras, a imagem da pessoa eh definida com a de um adulto segurando um bebe no colo 'Familia.ADULT_BABY'
             * Caso constrario, nada acontece e a imagem continua a mesma.
             */
            IMAGEM_PESSOA.setImage(Familia.ADULT_BABY);
          } // fim do segundo if
        } // fim do primeiro if
      } // fim do  else
    } // fim do if inicial
  }); // fim do Platform.runLater()
 } // fim do publish()
} // fim da classe
  
  