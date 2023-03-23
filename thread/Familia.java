import javafx.scene.image.Image;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 16/03/2023
* Nome.............: Familia
* Funcao...........: Vai instanciar todas as imagens da Familia Code
que serao usadas nas classes:
*************************************************************** */
public abstract class Familia {

	/**
	 * @img : eh uma lista constante de classe que nao pode ser alterada e que nao 
	 * pode ser acessada diretamente por outras classes
	 */
	private static final String img = "/view/image/family";
  
	/**
	 * Abaixo esta sendo declarado cada imagem para determinado estagio de vida de um 
	 * membro da familia
	 */
	public static final Image ADULT_1 = new Image (Familia.class.getResourceAsStream(img+"/adult-1.png"));
	public static final Image ADULT_2 = new Image(Familia.class.getResourceAsStream(img+"/adult-2.png"));
	public static final Image ADULT_3 = new Image(Familia.class.getResourceAsStream(img+"/adult-3.png"));
	public static final Image ADULT_BABY = new Image(Familia.class.getResourceAsStream(img+"/adultbaby.png"));
	public static final Image BABY = new Image(Familia.class.getResourceAsStream(img+"/baby.png"));
	public static final Image DEATH = new Image(Familia.class.getResourceAsStream(img+"/death.png"));
	public static final Image ELDERLY_1 = new Image(Familia.class.getResourceAsStream(img+"/elderly-1.png"));
	public static final Image ELDERLY_2 = new Image(Familia.class.getResourceAsStream(img+"/elderly-2.png"));
	public static final Image ELDERLY_3 = new Image(Familia.class.getResourceAsStream(img+"/elderly-3.png"));
	public static final Image KID = new Image(Familia.class.getResourceAsStream(img+"/kid.png"));
	//public static final Image SAD = new Image(Familia.class.getResourceAsStream(img+"/sad.png"));
	 //public static final Image TEENAGER = new Image(Familia.class.getResourceAsStream(img+"/teenager.png"));
	public static final Image YOUNG = new Image(Familia.class.getResourceAsStream(img+"/young.png"));

}
