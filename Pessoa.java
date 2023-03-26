import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Label;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 17/03/2023
* Nome.............: Pessoa
* Funcao...........: Vai conter os estagios de vida de cada membro 
da familia
*************************************************************** */
public abstract class Pessoa extends Thread {


	/**
	 * 'NOME' : String que armazena o nome da Pessoa (nao pode ser alterada)
	 * 'FILHOS' : Vetor de objetos 'Pessoa' quer armazena as infomacoes dos filhos de cada Mae (nao pode ser alterada)
	 * 'idFilho' : Inteiro que representa o identificador de cada filha (utilizada so por quem tem filhas)
	 * 'idade' : Inteiro que armazena a idade de cada pessoa
	 * 'IDADE_MAE' : Vetor de inteiros que armazena a idade em que a pessoa se torna Mae (nao pode ser alterada)
	 * 'TEMPO_DE_VIDA' : Inteiro que armazena o tempo de vida da pessoa
	 * 'label' : Objeto 'Label' que sera utilizado para exibir uma mensagem na interface
	 */
	public final String NOME;
	public final Pessoa[] FILHOS;
	protected int idFilho;
	protected int idade; 
	protected final int [] IDADE_MAE; 
	protected final int TEMPO_DE_VIDA;
	protected Label label;

  /*********************************************************************************************
  * Nome do Constutor: Pessoa
  * Funcao: Cria um novo objeto Pessoa e inicializa suas variaveis de instancia com os valores 
	* fornecidos nos parametros.
  * Parametros: 'nome' (uma String que contera o Nome de uma Pessoa), 'tempoDeVida' (um int que 
  * representa o Tempo de Vida da Pessoa), 'idadeMae' (um vetor de int, que representa as idades
  * de quando se torna Mae), 'filhos' (um Array de objetos Pessoa, que representa os filhos de
  * cada Mae)
  * Retorno: void
  * Explicacao: Eh usado o 'this' para se referir aos campos da propria instancia da classe 'Pessoa'
	* e atribui os valores dos parametros a seus campos correspondentes. Por exemplo, 'this.NOME = nome',
	* e assim sucessivamente. 
	********************************************************************************************* */
	public Pessoa (String nome, int tempoDeVida, int[] idadeMae, Pessoa[] filhos){
		this.NOME = nome;
		this.TEMPO_DE_VIDA = tempoDeVida;
		this.IDADE_MAE = idadeMae;
		this.FILHOS = filhos;
	}
    
	/********************************************************************
	* Metodo: run
	* Funcao: Eh executado quando uma thread eh inciada
	* Parametros: sem parametros
	* Retorno: sem retorno
****************************************************************** */
	public void run() {
	
		/**
		 * timer: Servira como cronometro, ira contar o tempo da thread e
		 * 				consequentemente da vida de cada pessoa.
		 */
		Timer timer = new Timer();

		/**
		 * .scheduleAtFixedRate : Esse metodo executara em intervalo de um segundo (em loop)
		 * 												a sequencia abaixo. Recebe como parametro os itens abaixo:
		 * @param new TimerTask() : Agendara tarefas para serem executadas em determinado
		 * 												 intervalo de tempo.
		 * @param delay : Eh um valor em milissegundos que especifica o atraso inicial
		 * 								antes da primeira execucao da tarefa. Nesse caso, 0.
		 * @param period: Eh um valor em milissegundos que especifica o intervalo de tempo 
		 * 								entre as execucoes periodicas da tarefa. Eh definido como 1000, 
		 * 								significa que a tarefa sera executada a cada 1000 milissegundos, 
		 * 								ou seja, a cada 1 segundo.
		 */
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				/**
				 * A sequencia de codigo abaixo ira realizar os acontecimentos na vida de cada 
				 * Pessoa, ou seja, ira mostrar quando a pessoa: Nasceu, Cresceu, Teve um Filho 
				 * e Morreu.
				*/
				publish(); // -- A cada alteracao na vida da Pessoa, ira ser mostrado na tela a alteracao -- //

				// -- PESSOA NASCEU E/OU TEVE UM FILHO -- //
				if (idade == 0) { // -- Se a Idade da Pessoa for iguala 0, a pessoa acaba de nascer -- //
					publish(NOME + " nasceu!!"); // -- O metodo publish() ira mostrar na tela que a Pessoa nasceu -- //
					
				}
				if (idFilho < IDADE_MAE.length) { // -- Verifica se o ID do Filho eh menor que a idade para ele ser pai -- //
					if (idade == IDADE_MAE[idFilho]) { // -- Se acima for True, ira verificar se a Idade da Pessoa eh a mesma Idade para ela ter um filho -- //
						Pessoa filho = FILHOS[idFilho]; // -- Se acima for True, entao um Filho da ID de Filho ira nascer, e inciar seu cliclo de vida -- //
						filho.start();
						idFilho++; // -- Aponta para o proximo indice do vetor que devera nascer -- //
					}
				}

				// -- PESSOA MORREU -- //
				if (idade == TEMPO_DE_VIDA) { // Se a Idade da Pessoa for igual ao Tempo Maximo de Vida dela, significa que ela morreu.
					publish(NOME + " morreu aos\n" + idade + " anos de idade!"); // O metodo publish() entao mostrara na tela que a Pessoa X morreu aos X anos.
					timer.cancel(); // Se a pessoa morre, entao a o 'contador' de vida dela sera encerrado.
				} else {
					idade++; // Caso a pessoa esteja VIVA, NAO TEVE um filho e NAO MORREU ainda, eh incrementado 1 ano na Idade dela, a cada 1 segundo.
				}
			} // fim do segundo run
		} , 0, 1000);
	} // fim do primeiro run

	/********************************************************************
	* Metodo: publish
	* Funcao: Por ser abstrato, significa que nao possui uma implementacao
	* na classe atual e deve ser implementado em classes concentras que
	* estendem ela
	* Parametros: sem parametros
	* Retorno: sem retorno
****************************************************************** */
	public abstract void publish(); // Mostra alteracoes na tela

	/********************************************************************
	* Metodo: publish
	* Funcao: Eh declarado um metodo abstrato tambem sem implementacao, de
	* mesmo nome (utilizacao de sobrecarga). Eh permitido aqui que as classe
	* que a estendam possam escrever algum tipo de saida na tela.
	* Parametros: Uma String chamada 'string'
	* Retorno: sem retorno
****************************************************************** */
	public abstract void publish(String string);

} // fim da classe abstrata Pessoa
