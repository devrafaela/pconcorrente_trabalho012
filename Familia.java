import javafx.scene.image.Image;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 16/03/2023
* Nome.............: Familia
* Funcao...........: Vai instanciar todas as imagens da Familia Code
que serao usadas no codigo.
*************************************************************** */
public abstract class Familia {

/* *****************************************************************
* Eh declarado uma constante estatica chamada 'img' do tipo String
* '/view/image/family'. Essa String sera utilizada para especificar 
* o caminho para a pasta onde as imagens da familia estao armazenadas 
******************************************************************* */
	private static final String img = "/view/image/family";
  

	/* ***********************************************************************
	* Constantes: ADULT_1, ADULT_2, ADULT_3, ADULT_BABY, BABY, DEATH, 
	* 						ELDERLY_1, ELDERLY_2, ELDERLY_3, KID E YOUNG.
	* Explicacao: As declaracoes abaixo usam um construtor de classe 
	* Image, que recebe como argumento um InputStream. O metodo utilizado
	* para obter o InputStream eh o ''.getResourceAsStream()', que eh 
	* invocado no objeto Class da classe 'Familia'. Este metodo vai 
	* carregar um arquivo de imagem (para cada constante) como um recurso
	* dentro do pacote da classe Familia.
	* Parametros: O parametro passado para o 'getResourceAsStream()' eh
	* uma String que especifica o acminho relativo do arquivo de imagem 
	* dentro do pacote (por exemplo: '/img/adult-1.png').
	* Retorna: Cada constante abaixo retornara tambem uma constante do tipo
	Image, que eh a imagem carregada como um recurso dentro de 'Familia'
	************************************************************************ */
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
	public static final Image YOUNG = new Image(Familia.class.getResourceAsStream(img+"/young.png"));

}
