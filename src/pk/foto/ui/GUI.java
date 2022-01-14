package pk.foto.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.setTitle("Foto-App");
        primaryStage.show();

        System.out.println(new AlbumErfassungView(primaryStage).showView());
        System.out.println(new FotoErfassungView(primaryStage).showView());
    }
}
