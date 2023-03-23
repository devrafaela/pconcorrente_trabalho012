

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
* Ultima alteracao.: 23/03/2023
* Nome.............: TelaController
* Funcao...........: Controla as alteracoes da Tela
*************************************************************** */
public class TelaController {

  @FXML
  public ImageView imgBackground;
  public ImageView imgTitulo;
  public ImageView imgSubtitulo;
  public ImageView imgMusic;
  public ImageView imgNotMusic;
  public ImageView imgArvore;
  @FXML
  public ImageView imgMae = new ImageView();
  public ImageView imgFilho2 = new ImageView();
  public ImageView imgFilho3 = new ImageView();
  public ImageView imgFilho1 = new ImageView();
  public ImageView imgNeto1 = new ImageView();
  public ImageView imgBisneto1 = new ImageView();
  public ImageView imgNeto2 = new ImageView();
  public static Label labelStatus = new Label();
  public Label label_Ano;
  public Label label_Status = new Label();
  public Label label_IdadeMae = new Label();
  public Label label_IdadeFilho2 = new Label();
  public Label label_IdadeFilho3 = new Label();
  public Label label_IdadeFilho1 = new Label();
  public Label label_IdadeNeto1 = new Label();
  public Label label_IdadeBisneto1 = new Label();
  public Label label_IdadeNeto2 = new Label();
  public CheckBox checkBoxMusic;
  public ImageView imgButtonPlay;
  
  @FXML
  public void buttonIniciar(MouseEvent event){

   //if (event.getSource().equals(imgButtonPlay)) {
    imgButtonPlay.setDisable(true);
    imgButtonPlay.setVisible(false);
    // label_Status.setVisible(true);
    
    // label_Status.getClass().getResourceAsStream();
    checkBoxMusic.setVisible(true);
    checkBoxMusic.setSelected(true);
  
    Jukebox.play("music.wav");
    
    System.out.println("=====================\n INICIO da Simulacao \n=====================");
    System.out.println("\nArvore Genealogica da Familia Code\n");
    CicloDeVida mae, filhaUm, filhaDois, filhaTres, netaUm, netaDois, bisnetaUm;
    CicloDeVida.telaController = this;

    bisnetaUm = new CicloDeVida("Susan Code\n(primeira bisneta da\nprimeira filha)\n", 12, packIdade(), packFilhos(), imgBisneto1, label_IdadeBisneto1);
    netaUm = new CicloDeVida("Barbara Code\n(primeira neta da primeira filha)\n", 34, packIdade(30), packFilhos(bisnetaUm), imgNeto1, label_IdadeNeto1);
    netaDois = new CicloDeVida("Radia Code\n(segunda neta da segunda filha)\n", 33, packIdade(), packFilhos(), imgNeto2, label_IdadeNeto2);
    filhaUm = new CicloDeVida("Sofia Code (primeira filha)\n", 61, packIdade(16), packFilhos(netaUm), imgFilho1, label_IdadeFilho1);
    filhaDois = new CicloDeVida("Grace Code (segunda filha)\n", 55, packIdade(20), packFilhos(netaDois), imgFilho2, label_IdadeFilho2);
    filhaTres = new CicloDeVida("Hedy Code (terceira filha)\n", 55, packIdade(), packFilhos(), imgFilho3, label_IdadeFilho3);
    mae = new CicloDeVida("Ada Code (mae)", 90, packIdade(21,24,31), packFilhos(filhaUm, filhaDois, filhaTres), imgMae, label_IdadeMae);
   
    mae.start();

  Timer timer = new Timer();
   timer.scheduleAtFixedRate(new TimerTask() {
      int i;
      public void run() {
        Platform.runLater(() ->{
        label_Ano.setText("ANO: " + (2000 + i));
      });
      i++;

      if (i == 90){
        timer.cancel();
      }

    }}, 0, 1000);

    if(event.getSource().equals(checkBoxMusic)){ // Se a check box for pressionada
      Jukebox.pause();
    }
  }

    @FXML
  public void buttonPause(ActionEvent event){
    if(event.getSource().equals(checkBoxMusic)) {
      Jukebox.pause();
    }
  }

  public int[] packIdade(int ... i){
    return i;
  }
  public Pessoa[] packFilhos(Pessoa ... sons){
    return sons;
  }


/**
    Mae - Ada Code
    Filha 1 - Sofia Code
    Filha 2 - Grace Code
    Filha 3 - Hedy Code
    Neta 1 - Barbara Code
    Neta 2 - Radia Code
    Bisneta 1 - Susan Code
 */
}
