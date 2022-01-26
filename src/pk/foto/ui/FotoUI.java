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
    public static ListView<Album> listView = new ListView<>();
    public static Album selectedAlbum;
    public static Label lMetaDescVal = new Label("");
    public static Label lAlbumVal = new Label("");

    static MenuItem mi1 = new MenuItem("Laden");
    static MenuItem mi2 = new MenuItem("Speichern");
    static MenuItem mi3 = new MenuItem("CSV-Export");
    static MenuItem mi4 = new MenuItem("Beenden");
    static MenuItem miA = new MenuItem("Neues Album erstellen");

    private static TilePane tp = new TilePane();

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

        Label lAlbum = new Label("Album:\nBesitzer:");

        Button bKopfbereichFotoHinzufügen = new Button("Foto hinzufügen");

        // ListView<Album> listView = new ListView<>();

        ScrollPane spGalerie = new ScrollPane();

        Label lMetaDesc = new Label("Name:\nDateiname:\nGröße:\nKamera:\nErstellungsdatum:");

        File file = new File("images/DSC02033.jpg");
        System.out.println(file);
        Album album1 = new Album("Album1", "Dieter");
        album1.addFoto(file);
        file = new File("images/35835723323_b3ed4bf5d1_o.jpg");
        album1.addFoto(file);

        selectedAlbum = album1;

        fv.addAlbum(album1);

        m1.getItems().addAll(mi1, mi2, new SeparatorMenuItem(), mi3, new SeparatorMenuItem(), mi4);
        m2.getItems().addAll(miA);
        mb.getMenus().addAll(m1, m2);

        vbKopfbereich1.getChildren().addAll(lAlbum);
        vbKopfbereich2.getChildren().addAll(lAlbumVal);
        hbKopfbereich3.getChildren().addAll(bKopfbereichFotoHinzufügen);
        hbKopfbereich.getChildren().addAll(vbKopfbereich1, vbKopfbereich2, hbKopfbereich3);

        listView.getItems().addAll(fv.gibAlleAlben());

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Album>() {
            @Override
            public void changed(ObservableValue<? extends Album> observable, Album oldValue, Album newValue) {
                System.out.println("old val: " + oldValue + "\nNew val: " + newValue);
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

        hbContent.getChildren().addAll(listView, vbSub);
        hbMetaInformationen.getChildren().addAll(lMetaDesc, lMetaDescVal);

        vbSub.getChildren().addAll(hbKopfbereich, spGalerie, hbMetaInformationen);

        vbMain.getChildren().addAll(mb, hbContent);

        // new Insets(Top, Left, Bottom, Right)
        lAlbumVal.setPadding(new Insets(0, 0, 0, 5));
        lMetaDescVal.setPadding(new Insets(0, 0, 0, 5));
        hbContent.setPadding(new Insets(0, 5, 0, 5));
        hbMetaInformationen.setPadding(new Insets(2, 0, 0, 0));
        vbMain.setPadding(new Insets(0, 0, 10, 0));

        listView.setMaxWidth(150);
        listView.setMinWidth(150);

        vbMain.setSpacing(10);
        hbContent.setSpacing(10);

        spGalerie.setPrefSize(120, 120);

        spGalerie.setContent(tp);
        spGalerie.setFitToWidth(true);

        hbKopfbereich3.setAlignment(Pos.TOP_RIGHT);
        VBox.setVgrow(hbContent, Priority.ALWAYS);
        VBox.setVgrow(spGalerie, Priority.ALWAYS);
        HBox.setHgrow(vbSub, Priority.ALWAYS);
        HBox.setHgrow(hbKopfbereich3, Priority.ALWAYS);
        lMetaDesc.setMinWidth(100);

        Scene root = new Scene(vbMain, 800, 600);
        primaryStage.setScene(root);
        primaryStage.setTitle("Foto-App");
        primaryStage.show();

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
        
        
    }

    public static void updateGallery() throws FileNotFoundException {
        tp.getChildren().clear();
        for (Foto foto : selectedAlbum.getFotos()) {
            VBox vbox = new VBox();
            vbox.getChildren().addAll(createThumbnail(foto.getFilePath(), 200), new Label(foto.getName()));
            vbox.setPadding(new Insets(5, 0, 0, 5));
            tp.getChildren().add(vbox);
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
