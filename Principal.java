
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/* ***************************************************************
* Autor............: Rafaela Pereira Santos
* Matricula........: 202110838
* Inicio...........: 16/03/2023
* Ultima alteracao.: 23/03/2023
* Nome.............: Principal
* Funcao...........: Inicializa o programa
*************************************************************** */
public class Principal extends Application {

  @Override
  public void start(Stage palco) throws Exception {
    //new TelaController();
    Parent root = FXMLLoader.load(getClass().getResource("/view/Tela.fxml"));
    palco.setTitle("Arvore Genealogica - Familia Code");
    palco.getIcons().add(new Image("/view/image/others/arvore-familia.png"));
    palco.setScene(new Scene(root));
    palco.setResizable(false);
    palco.centerOnScreen();
    palco.setOnCloseRequest(t -> {
      Platform.exit();
      System.exit(0);
    });
    palco.show();
  }
  
  public static void main(String[] args) {
  //new TelaController();
  launch(args);
  }
}