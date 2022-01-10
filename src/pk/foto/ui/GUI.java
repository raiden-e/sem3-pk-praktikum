package pk.foto.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {
    private Scene sc;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Foto-App");
        primaryStage.show();

        var albumerfassungview1 = new FotoErfassungView(primaryStage);
        albumerfassungview1.showView();
    }
}
