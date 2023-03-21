package controller;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.CicloDeVida;
import model.Jukebox;
import model.Pessoa;


/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 16/03/2023
* Nome.............: Familia
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
  public ImageView imgMae;
  public ImageView imgFilho2;
  public ImageView imgFilho3;
  public ImageView imgFilho1;
  public ImageView imgNeto1;
  public ImageView imgBisneto1;
  public ImageView imgNeto2;
  public static Label labelStatus;
  public Label label_Ano;
  public Label label_Status;
  public Label label_IdadeMae;
  public Label label_IdadeFilho2;
  public Label label_IdadeFilho3;
  public Label label_IdadeFilho1;
  public Label label_IdadeNeto1;
  public Label label_IdadeBisneto1;
  public Label label_IdadeNeto2;
  public CheckBox checkBoxMusic;
  public ImageView imgButtonPlay;

  @FXML
  public void buttonPlay(ActionEvent event){
    if (event.getSource().equals(imgButtonPlay)) {
      imgButtonPlay.setDisable(true);
      imgButtonPlay.setVisible(false);
      checkBoxMusic.setVisible(true);
      checkBoxMusic.setSelected(true);
      Jukebox.play("sound.wav");
    }

    System.out.println("=====================\n INICIO da Simulacao \n=====================");
    System.out.println("\nArvore Genealogica da Familia Code\n");
    CicloDeVida mae, filhaUm, filhaDois, filhaTres, netaUm, netaDois, bisnetaUm;
    CicloDeVida.telaController = this;

  //  bisnetaUm = new CicloDeVida("Susan Code", 12, null, null, imgBisneto1, label_IdadeBisneto1);
    //netaUm = new CicloDeVida("Barbara Code", 35, 30, null, imgNeto1, label_IdadeNeto1);
   // netaDois = new CicloDeVida("Radia Code", 33, null, null, imgNeto2, label_IdadeNeto2);
    //filhaUm = new CicloDeVida("Sofia Code", 61, 16, netaUm, imgFilho1, label_IdadeFilho1);
   // filhaDois = new CicloDeVida("Grace Code", 55, 20, netaDois, imgFilho2, label_IdadeFilho2);

   mae = new CicloDeVida("Ada Code", 90, null, null, imgMae, labelStatus);
   mae.start();

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
