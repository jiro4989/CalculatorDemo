package app;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  public static final String TITLE = "電卓";

  @Override
  public void start(Stage primaryStage) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
    try {
      VBox root = (VBox) loader.load();
      Scene scene = new Scene(root, 200, 300);
      scene.getStylesheets().add(getClass().getResource("Basic.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.setTitle(TITLE);

      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String... args) {
    launch(args);
  }
}
