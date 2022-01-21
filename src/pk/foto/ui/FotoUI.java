package pk.foto.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FotoUI extends Application {
    static boolean exitCode;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Menu m1 = new Menu("Datei");
        Menu m2 = new Menu("Alben");

        MenuItem mi1 = new MenuItem("Laden");
        MenuItem mi2 = new MenuItem("Speichern");
        MenuItem mi3 = new MenuItem("CSV-Export");
        MenuItem mi4 = new MenuItem("Beenden");

        m1.getItems().addAll(mi1, mi2, new SeparatorMenuItem(), mi3, new SeparatorMenuItem(), mi4);

        MenuItem miA = new MenuItem("Neues Album erstellen");
        m2.getItems().addAll(miA);

        MenuBar mb = new MenuBar();
        mb.getMenus().add(m1);
        mb.getMenus().add(m2);
        VBox vb = new VBox(mb);

        primaryStage.setScene(new Scene(vb, 800, 600));
        primaryStage.setTitle("Foto-App");
        primaryStage.show();

//        exitCode = new AlbumErfassungView(primaryStage).showView();
//        System.out.println(exitCode);
//        if (exitCode) {
//            exitCode = new FotoErfassungView(primaryStage).showView();
//            System.out.println(exitCode);
//        }
    }
}
