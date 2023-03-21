import controller.TelaController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/* ***************************************************************
* Autor............: nome(s) do(s) autor(es) do codigo
* Matricula........: numero de matricula(s)
* Inicio...........: 16/03/2023
* Ultima alteracao.: 20/03/2023
* Nome.............: Nome do programa
* Funcao...........: descricao do que eh o programa
*************************************************************** */

public class Principal extends Application {

  
  @Override
  public void start(Stage palco) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("view/tela.fxml"));
    // Scene scene = new Scene(root);
    palco.setTitle("Arvore Genealogica - Familia Code");
    palco.getIcons().add(new Image("view/others/arvore-familia.png"));
    //palco.setScene(scene);
    palco.setScene(new Scene(root));
    palco.setOnCloseRequest(t -> {
      Platform.exit();
      System.exit(0);
    });
    palco.show();
  }

  public static void main(String[] args) {
    TelaController telaControl = new TelaController();
    launch( args);
  }
  
}