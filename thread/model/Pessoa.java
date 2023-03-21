package model;

import java.util.Timer;
import java.util.TimerTask;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 17/03/2023
* Nome.............: Pessoa
* Funcao...........: Vai conter os estagios de vida de cada membro 
da familia.
*************************************************************** */
public abstract class Pessoa extends Thread {


	public final String NOME; // Nome da pessoa
	public final Pessoa[] FILHOS; // Vetor dos filhas

	protected int idFilho; // Identificador de cada filha (so quem tem filha usa)
	protected int idade; // Idade da Pessoa
	
	protected final int [] IDADE_PAI; // Idade em que a Pessoa tem um filha
	protected final int TEMPO_DE_VIDA; // Tempo de Vida de cada pessoa


	/**
	 * @param nome					Nome da Pessoa
	 * @param tempoDeVida		Tempo de Vida de cada Pessoa
	 * @param idadePai			Vetor que contera as Idades em que a Pessoa tera uma Filha
	 * @param filhos				Vetor que contem as Filhas de cada Pessoa
	 */
	public Pessoa (String nome, int tempoDeVida, int[] idadePai, Pessoa[] filhos){
		this.NOME = nome;
		this.TEMPO_DE_VIDA = tempoDeVida;
		this.IDADE_PAI = idadePai;
		this.FILHOS = filhos;
	}
    


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
				publish(); // A cada alteracao na vida da Pessoa, ira ser mostrado na tela a alteracao.
				
				// - PESSOA NASCEU E/OU TEVE UM FILHO - //
				if (idade == 0) { // Se a Idade da Pessoa for iguala 0, a pessoa acaba de nascer.
					publish(NOME + " nasceu"); // O metodo publish() ira mostrar na tela que a Pessoa nasceu.
				}
				if (idFilho < IDADE_PAI.length) { // Verifica se o ID do Filho eh menor que a idade para ele ser pai .
					if (idade == IDADE_PAI[idFilho]) { // Se acima for True, ira verificar se a Idade da Pessoa eh a mesma Idade para ela ter um filho.
						Pessoa filho = FILHOS[idFilho]; // Se acima for True, entao um Filho da ID de Filho ira nascer, e inciar seu cliclo de vida.
						filho.start();
						idFilho++; // Aponta para o proximo indice do vetor que devera nascer.
					}
				}

				// - PESSOA MORREU - //
				if (idade == TEMPO_DE_VIDA) { // Se a Idade da Pessoa for igual ao Tempo Maximo de Vida dela, significa que ela morreu.
					publish(NOME + " morreu aos " + idade + "anos :()"); // O metodo publish() entao mostrara na tela que a Pessoa X morreu aos X anos.
					timer.cancel(); // Se a pessoa morre, entao a o 'contador' de vida dela sera encerrado.
				} else {
					idade++; // Caso a pessoa esteja VIVA, NAO TEVE um filho e NAO MORREU ainda, eh incrementado 1 ano na Idade dela, a cada 1 segundo.
				}

			} // fim do segundo run
		} , 0, 1000);
	} // fim do primeiro run

	public abstract void publish(); // Mostra alteracoes na tela
	
	/**
	 * @param string : Mostra mensagem na tela
	 */
	public abstract void publish(String string);


} // fim da classe abstrata Pessoa
