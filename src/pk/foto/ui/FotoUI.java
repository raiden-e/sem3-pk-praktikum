package pk.foto.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FotoUI extends Application {
    static boolean exitCode;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbMain = new VBox();
        HBox hbContent = new HBox();
        VBox vbSub = new VBox();
        HBox hbKopfbereich = new HBox();
        VBox vbKopfbereich1 = new VBox();
        VBox vbKopfbereich2 = new VBox();
        HBox hbKopfbereich3 = new HBox();

        HBox hbMetaInformationen = new HBox();

        MenuBar mb = new MenuBar();
        Menu m1 = new Menu("Datei");
        Menu m2 = new Menu("Alben");

        MenuItem mi1 = new MenuItem("Laden");
        MenuItem mi2 = new MenuItem("Speichern");
        MenuItem mi3 = new MenuItem("CSV-Export");
        MenuItem mi4 = new MenuItem("Beenden");
        MenuItem miA = new MenuItem("Neues Album erstellen");

        m1.getItems().addAll(mi1, mi2, new SeparatorMenuItem(), mi3, new SeparatorMenuItem(), mi4);
        m2.getItems().addAll(miA);
        mb.getMenus().addAll(m1, m2);

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("Menschen", "Naturbilder", "Test:");

        Label lAlbum = new Label("Album:");
        Label lOwner = new Label("Besitzer: ");
        Label lAlbumVal = new Label("Menschen");
        Label lOwnerVal = new Label("Sven");
        Button bKopfbereichFotoHinzufügen = new Button("Foto hinzufügen");
        vbKopfbereich2.getChildren().addAll(lAlbumVal, lOwnerVal);
        vbKopfbereich1.getChildren().addAll(lAlbum, lOwner);
        hbKopfbereich3.getChildren().addAll(bKopfbereichFotoHinzufügen);
        hbKopfbereich.getChildren().addAll(vbKopfbereich1, vbKopfbereich2, hbKopfbereich3);
        hbKopfbereich3.setAlignment(Pos.TOP_RIGHT);
        Rectangle rect = new Rectangle(200, 200, Color.BLUE);
        ScrollPane spGalerie = new ScrollPane();
        spGalerie.setPrefSize(120, 120);
        spGalerie.setContent(rect);

        Label lMetaDesc = new Label("Name:\nDateiname:\nGröße:\nKamera:\nErstellungsdatum:");
        Label lMetaDescVal = new Label("Peter\npeter.jpg\n1920 x 1920 px\nNikon noice Cam\nDamals");
        lMetaDescVal.setPadding(new Insets(0, 0, 0, 5));
        hbMetaInformationen.getChildren().addAll(lMetaDesc, lMetaDescVal);
        hbMetaInformationen.setPadding(new Insets(2, 0, 0, 0));
        vbSub.getChildren().addAll(hbKopfbereich, spGalerie, hbMetaInformationen);

        hbContent.getChildren().addAll(listView, vbSub);
        hbContent.setSpacing(10); // Left padding
        hbContent.setPadding(new Insets(0, 5, 0, 5)); // Left-Right padding

        vbMain.getChildren().addAll(mb, hbContent);
        vbMain.setSpacing(10);
        vbMain.setPadding(new Insets(0, 0, 10, 0)); // Bottom Padding
        VBox.setVgrow(hbContent, Priority.ALWAYS);
        VBox.setVgrow(spGalerie, Priority.ALWAYS);
        HBox.setHgrow(vbSub, Priority.ALWAYS);
        HBox.setHgrow(hbKopfbereich3, Priority.ALWAYS);

        primaryStage.setScene(new Scene(vbMain, 800, 600));
        primaryStage.setTitle("Foto-App");
        primaryStage.show();

        // exitCode = new AlbumErfassungView(primaryStage).showView();
        // System.out.println(exitCode);
        // if (exitCode) {
        // exitCode = new FotoErfassungView(primaryStage).showView();
        // System.out.println(exitCode);
        // }
    }

    private ImageView createThumbnail(String imageFile, int width) throws FileNotFoundException {
        ImageView iv = new ImageView(new Image(new FileInputStream(new File(imageFile)), width * 2, 0, true, true));
        iv.setViewport(new Rectangle2D(0, 0, width, width));
        return iv;
    }
}
