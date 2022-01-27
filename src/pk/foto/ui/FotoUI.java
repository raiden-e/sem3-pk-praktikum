package pk.foto.ui;

import pk.foto.Album;
import pk.foto.Foto;
import pk.foto.FotoVerwaltung;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FotoUI extends Application {
    static boolean exitCode;
    public static FotoVerwaltung fv = new FotoVerwaltung();

    private static VBox vbMain = new VBox();
    private static HBox hbContent = new HBox();
    private static VBox vbRight = new VBox();
    private static HBox hbKopfbereich = new HBox();
    private static VBox vbKopfbereich1 = new VBox();
    private static VBox vbKopfbereich2 = new VBox();
    private static HBox hbKopfbereich3 = new HBox();
    private static HBox hbMetaInformationen = new HBox();

    private static TilePane tp = new TilePane();
    public static ListView<Album> listView = new ListView<>();
    public static Album selectedAlbum;

    private static ScrollPane spGalerie = new ScrollPane();

    public static Label lMetaDescVal = new Label("");
    public static Label lAlbumVal = new Label("");
    private static Label lAlbum = new Label("Album:\nBesitzer:");
    private static Label lMetaDesc = new Label("Name:\nDateiname:\nGröße:\nKamera:\nErstellungsdatum:");

    private static MenuBar mb = new MenuBar();
    private static Menu m1 = new Menu("Datei");
    private static Menu m2 = new Menu("Alben");

    private static MenuItem mi1 = new MenuItem("Laden");
    private static MenuItem mi2 = new MenuItem("Speichern");
    private static MenuItem mi3 = new MenuItem("CSV-Export");
    private static MenuItem mi4 = new MenuItem("Beenden");
    private static MenuItem miA = new MenuItem("Neues Album erstellen");

    private static Button bKopfbereichFotoHinzufügen = new Button("Foto hinzufügen");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        vbKopfbereich1.getChildren().addAll(lAlbum);
        vbKopfbereich2.getChildren().addAll(lAlbumVal);
        hbKopfbereich3.getChildren().addAll(bKopfbereichFotoHinzufügen);
        hbKopfbereich.getChildren().addAll(vbKopfbereich1, vbKopfbereich2, hbKopfbereich3);

        hbContent.getChildren().addAll(listView, vbRight);
        hbMetaInformationen.getChildren().addAll(lMetaDesc, lMetaDescVal);
        vbRight.getChildren().addAll(hbKopfbereich, spGalerie, hbMetaInformationen);
        m1.getItems().addAll(mi1, mi2, new SeparatorMenuItem(), mi3, new SeparatorMenuItem(), mi4);
        m2.getItems().addAll(miA);
        mb.getMenus().addAll(m1, m2);

        vbMain.getChildren().addAll(mb, hbContent);

        listView.getItems().addAll(fv.gibAlleAlben());

        // Insets(double top, double right, double bottom, double left)
        lAlbumVal.setPadding(new Insets(0, 0, 0, 5));
        lMetaDescVal.setPadding(new Insets(0, 0, 0, 5));
        hbContent.setPadding(new Insets(0, 5, 0, 5));
        hbMetaInformationen.setPadding(new Insets(2, 0, 0, 0));
        vbMain.setPadding(new Insets(0, 0, 10, 0));

        listView.setMaxWidth(150);
        listView.setMinWidth(150);
        lMetaDesc.setMinWidth(100);

        vbMain.setSpacing(10);
        hbContent.setSpacing(10);

        spGalerie.setPrefSize(120, 120);
        spGalerie.setContent(tp);
        spGalerie.setFitToWidth(true);

        hbKopfbereich3.setAlignment(Pos.TOP_RIGHT);
        VBox.setVgrow(hbContent, Priority.ALWAYS);
        VBox.setVgrow(spGalerie, Priority.ALWAYS);
        HBox.setHgrow(vbRight, Priority.ALWAYS);
        HBox.setHgrow(hbKopfbereich3, Priority.ALWAYS);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Album>() {
            @Override
            public void changed(ObservableValue<? extends Album> observable, Album oldValue, Album newValue) {
                lMetaDescVal.setText("");
                lAlbumVal.setText(newValue.getName() + "\n" + newValue.getBesitzer());
                for (Foto foto : newValue.getFotos()) {
                    // update spGallery
                    System.out.println(foto);
                }
                if (newValue.getFotos().length != 0)
                    lMetaDescVal.setText(newValue.getFotos()[0].toString());
                tp.getChildren().clear();
                selectedAlbum = newValue;
                try {
                    updateGallery();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        miA.setOnAction(e -> {
            exitCode = new AlbumErfassungView(primaryStage).showView();
            System.out.println(exitCode);
        });
        bKopfbereichFotoHinzufügen.setOnAction(e -> {
            exitCode = new FotoErfassungView(primaryStage).showView();
            System.out.println(exitCode);
        });

        mi1.setOnAction(e -> {
            fv.laden();
        });

        mi2.setOnAction(e -> {
            try {
                fv.speichern();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        mi3.setOnAction(e -> {
            File datei = new File("Fotoverwaltung.csv");
            StringBuilder sb = new StringBuilder();
            for (Album album : fv.gibAlleAlben())
                sb.append(album.exportiereAlsCsv()).append("\n");
            try {
                Files.writeString(datei.toPath(), sb);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        mi4.setOnAction(e -> {
            primaryStage.close();
        });

        Scene root = new Scene(vbMain, 800, 600);
        primaryStage.setScene(root);
        primaryStage.setTitle("Foto-App");
        primaryStage.show();
    }

    public static void updateGallery() throws FileNotFoundException {
        tp.getChildren().clear();
        for (Foto foto : selectedAlbum.getFotos()) {
            VBox vbox = new VBox();
            var image = createThumbnail(foto.getFilePath(), 200);
            vbox.getChildren().addAll(image, new Label(foto.getName()));
            vbox.setPadding(new Insets(5, 0, 0, 5));
            tp.getChildren().add(vbox);

            image.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                lMetaDescVal.setText(foto.toString());
            });
        }
    }

    public static void updateListView(Album album) {
        listView.getItems().addAll(album);
    }

    private static ImageView createThumbnail(String imageFile, int width) throws FileNotFoundException {
        ImageView iv = new ImageView(new Image(new FileInputStream(new File(imageFile)), width * 2, 0, true, true));
        iv.setViewport(new Rectangle2D(0, 0, width, width));

        return iv;
    }

}
