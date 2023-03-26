import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 25/03/2023
* Nome.............: TelaController 
* Funcao...........: Controla as alteracoes da Tela
*************************************************************** */
public class TelaController {

  @FXML
  public ImageView imgBackground; // -- ImageView que armazena o background da interface -- //
  public ImageView imgTitulo; // -- ImageView que armazena a imagem do titulo da interface -- //
  public ImageView imgSubtitulo;  // -- ImageView que armazena a imagem do subtitulo da interface -- //
  public ImageView imgMusic;  // -- ImageView que armazena a imdagem do icone de som da interface -- //
  public ImageView imgArvore; // -- ImageView que armazena o a imagem da arvore da interface -- //
  public ImageView imgMae = new ImageView();  // -- ImageView que armazena a imagem da Mae -- //
  public ImageView imgFilho2 = new ImageView(); // -- ImageView que armazena a imagem da Filha 2 -- //
  public ImageView imgFilho3 = new ImageView(); // -- ImageView que armazena a imagem da Filha 3 -- //
  public ImageView imgFilho1 = new ImageView(); // -- ImageView que armazena a imagem da Filha 1 -- //
  public ImageView imgNeto1 = new ImageView();  // -- ImageView que armazena a imagem da Neta 1 -- //
  public ImageView imgNeto2 = new ImageView();  // -- ImageView que armazena a imagem da Neta 2 -- //
  public ImageView imgBisneto1 = new ImageView(); // -- ImageView que armazena a imagem da Bisneta 1 -- //

  @FXML
  public static Label labelStatus = new Label();   // -- Label que armazena a 'labelStatus' que mostrara o que acontece em determinado tempo -- //
  public Label label_Ano; // -- Label que armazena a 'label_Ano' que mostrata a contagem de anos -- //
  public Label label_Status = new Label();  // -- Label que armazena a label_Status que mostrara o que acontece em determinado tempo -- //
  public Label label_IdadeMae = new Label();  // -- Label que armazena a idade da Mae -- //
  public Label label_IdadeFilho2 = new Label(); // -- Label que armazena a idade da Filha 2 -- //
  public Label label_IdadeFilho3 = new Label(); // -- Label que armazena a idade da Filha 3 -- //
  public Label label_IdadeFilho1 = new Label(); // -- Label que armazena a idade da Filha 1 -- //
  public Label label_IdadeNeto1 = new Label();  // -- Label que armazena a idade da Neta 1 -- //
  public Label label_IdadeNeto2 = new Label();  // -- Label que armazena a idade da Neta 2 -- //
  public Label label_IdadeBisneto1 = new Label(); // -- Label que armazena a idade da Bisneta 1 -- //

  @FXML
  public CheckBox checkBoxMusic; // -- CheckBox que servira para pausar ou iniciar a musica -- //
  public ImageView imgButtonPlay; // -- ImageView que armazena a imagem do botao para iniciar a simulacao -- //
  

	/********************************************************************
	* Metodo: buttonInciar
	* Funcao: Quando o botao for pressionado com o mouse a execucao da
  * simulacao eh inciada.
	* Parametros: Recebe como parametro um objeto do tipo 'MouseEvent',
  * que representa um evento de mouse gerado quando um botao (nesse caso
  * imagem de um botao) eh clicado
	* Retorno: sem retorno
****************************************************************** */
  @FXML
  public void buttonIniciar(MouseEvent event){

    // -- Quando iniciada a simulacao, o botao fica desabilitado e invisivel na interface -- //
    imgButtonPlay.setDisable(true);
    imgButtonPlay.setVisible(false);

    // -- o CheckBox da musica eh tornada visivel e selecionada por padrao na interface, fazendo a musica ser iniciada logo de cara -- //
    checkBoxMusic.setVisible(true);
    checkBoxMusic.setSelected(true);

    // -- A musica eh tocada usando o arquivo 'musica.wav' atraves do metodo '.play()' da classe 'Jukebox' -- //
    Jukebox.play("music.wav");
    

    System.out.println("=====================\n INICIO da Simulacao \n=====================");
    System.out.println("\nArvore Genealogica da Familia Code\n");

    /**
     * Ocorre uma criacao de objetos da classe 'CicloDeVida', que representa os membros da Familia Code
     * O trecho 'CicloDeVida.telaController = this' associa o objeto atual (uma instancia da classe que contem esse codigo)
     * como um controlador da interface grafica da simulacao.
     */
    CicloDeVida mae, filhaUm, filhaDois, filhaTres, netaUm, netaDois, bisnetaUm;
    CicloDeVida.telaController = this;

    /**
     * 'bisnetaUm' : representa a primeira bisneta da primeira filha, com nome 'Susan Code', com tempo de vida de 12 anos de idade, 
     *               sem filhos e com uma imagem associada a ela, junto com uma label para exibir sua idade na interface
     * 'netaUm' : representa a primeira neta da primeira filha, com nome 'Barbara Code', com tempo de vida de 35 anos de idade, 
     *            uma filha (bisnetaUm) e tambem com imagem e label (para mostrar sua idade) associadas a ela
     * 'netaUm' : representa a primeira neta da primeira filha, com nome 'Barbara Code', com tempo de vida de 35 anos de idade, 
     *            uma filha (bisnetaUm) e tambem com imagem e label (para mostrar sua idade) associadas a ela
     * 'netaDois' : representa a segunda neta da segunda filha, com nome 'Radia Code', com tempo de vida de 33 anos de idade, 
     *              sem filhos e tambem com imagem e label (para mostrar sua idade) associadas a ela
     * 'filhaUm' : representa a primeira filha, com nome 'Sofia Code', com tempo de vida de 61 anos de idade, uma filha (netaUm)
     *             e tambem com imagem e label (para mostrar sua idade) associadas a ela
     * 'filhaDois' : representa a segunda filha, com nome 'Grace Code', com tempo de vida de 55 anos de idade, uma filha (netaDois)
     *               e tambem com imagem e label (para mostrar sua idade) associadas a ela
     * 'filhaTres' : representa a terceira filha, com nome 'Hedy Code', com tempo de vida de 55 anos de idade, sem filhos e tambem
     *               com imagem e label (para mostrar sua idade) associadas a ela
     * 'mae' : representando a mae (raiz) da Familia Code, com nome 'Ada Code', possui um tempo de vida de 90 anos (tempo total da execucao
     * da simulacao), tem tres filhas (filhaUm, filhaDois, filhaTres) e tambem com imagem e label (para mostrar sua idade) associadas a ela
     **/
    bisnetaUm = new CicloDeVida("Susan Code\n(primeira bisneta da\nprimeira filha)\n", 12, packIdade(), packFilhos(), imgBisneto1, label_IdadeBisneto1);
    netaUm = new CicloDeVida("Barbara Code\n(primeira neta da primeira filha)\n", 35, packIdade(30), packFilhos(bisnetaUm), imgNeto1, label_IdadeNeto1);
    netaDois = new CicloDeVida("Radia Code\n(segunda neta da segunda filha)\n", 33, packIdade(), packFilhos(), imgNeto2, label_IdadeNeto2);
    filhaUm = new CicloDeVida("Sofia Code (primeira filha)\n", 61, packIdade(16), packFilhos(netaUm), imgFilho1, label_IdadeFilho1);
    filhaDois = new CicloDeVida("Grace Code (segunda filha)\n", 55, packIdade(20), packFilhos(netaDois), imgFilho2, label_IdadeFilho2);
    filhaTres = new CicloDeVida("Hedy Code (terceira filha)\n", 55, packIdade(), packFilhos(), imgFilho3, label_IdadeFilho3);
    mae = new CicloDeVida("Ada Code (mae)", 90, packIdade(21,24,31), packFilhos(filhaUm, filhaDois, filhaTres), imgMae, label_IdadeMae);
   
    // -- O objeto mae eh iniciado com o comando 'mae.start()'
    mae.start();

  Timer timer = new Timer();
   timer.scheduleAtFixedRate(new TimerTask() {
      // -- O int i eh utilizado para contar os anos a cada 1 segundo -- //
      int i;
      public void run() {
        Platform.runLater(() ->{
        // -- A Label abaixo mostrara a contagem de Anos na interface -- //
        label_Ano.setText("ANO: " + (2000 + i));
      });
      // -- Eh incrementado um Ano a cada segundo -- //
      i++;

      // -- Se o Ano (i) for igual a 90, o Timer eh cancelado e a simulacao encerrada -- //
      if (i == 90){
        timer.cancel();
      }
    // -- O Delay eh igual a 0, e o Period igual 1000 (milisegundos), representando 1 segundo -- //
    }}, 0, 1000);

  }

  
	/********************************************************************
	* Metodo: buttonPause
	* Funcao: Eh executado quando a checkBox eh selecionada na interface
	* Parametros:Recebe como parametro o tipo 'ActionEvent', que eh gerado
  * quando algo eh clicado na tela
	* Retorno: sem retorno
****************************************************************** */
  @FXML
  public void buttonPause(ActionEvent event){
    // -- Eh verificado se o evento ocorreu -- // 
    if(event.getSource().equals(checkBoxMusic)) {
      // -- Se sim, a musica que esta tocando na hora eh pausada -- //
      Jukebox.pause();
    }
  }

	/********************************************************************
	* Metodo: packIdade
	* Funcao: permite passar vários valores inteiros como argumentos para 
  * o método sem precisar criar um array manualmente.
  * Parametros: Uma variavel de inteiros i
	* Retorno: retorna um array de inteiros com essas idades
****************************************************************** */
  public int[] packIdade(int ... i){
    return i;
  }

	/********************************************************************
	* Metodo: packFihos
	* Funcao:  permite passar vários objetos Pessoa como argumentos para o 
  * método sem precisar criar um array manualmente
	* Parametros: Um numero variavel de objetos do tipo Pessoa que representa
  * os filhos de uma pessoa
	* Retorno: retorna um array de Pessoa com os filhos
****************************************************************** */
  public Pessoa[] packFilhos(Pessoa ... filhos){
    return filhos;
  }

} // fim da classe
