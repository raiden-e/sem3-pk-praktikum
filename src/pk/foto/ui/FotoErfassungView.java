package pk.foto.ui;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pk.foto.*;
import pk.foto.util.FotoUtil;

public class FotoErfassungView extends ErfassungView<Object> {
    private static Button bDatei = new Button("Datei auswählen");
    private static Label lDatei = new Label("Datei:");
    private static Label lDateiPfad = new Label("Keine Datei ausgewählt");
    private static File file;
    private static HBox hbSub = new HBox();

    public FotoErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {

        setButtons();

        hbSub.getChildren().add(bDatei);
        hb0.getChildren().addAll(lName, tfName);
        hb1.getChildren().addAll(lDatei, lDateiPfad, hbSub);
        hb2.getChildren().addAll(bOk, bAbbrechen);
        vbMain.getChildren().addAll(hb0, hb1, hb2);

        // new Insets(Top, Left, Bottom, Right)
        lName.setPadding(new Insets(0, 10, 0, 0));
        lDatei.setPadding(new Insets(0, 10, 0, 0));
        lDateiPfad.setPadding(new Insets(0, 10, 0, 0));

        tfName.setMaxWidth(Double.MAX_VALUE);

        hb2.setSpacing(5);

        lName.setAlignment(Pos.CENTER_LEFT);
        lDatei.setAlignment(Pos.CENTER_LEFT);
        lDateiPfad.setAlignment(Pos.CENTER_LEFT);
        hb2.setAlignment(Pos.BOTTOM_CENTER);
        hb1.setAlignment(Pos.CENTER_LEFT);
        hbSub.setAlignment(Pos.CENTER_RIGHT);
        bDatei.setAlignment(Pos.TOP_RIGHT);
        lDatei.setAlignment(Pos.CENTER_LEFT);
        lDateiPfad.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(hbSub, Priority.ALWAYS);
        HBox.setHgrow(tfName, Priority.ALWAYS);
        HBox.setHgrow(hb1, Priority.ALWAYS);
        VBox.setVgrow(hb2, Priority.ALWAYS);

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Datei auswählen");
        chooser.setInitialDirectory(new File("C:/Users/" + System.getProperty("user.name")));
        bDatei.setOnAction(e -> {
            file = chooser.showOpenDialog(stage);
            if (file != null)
                lDateiPfad.setText(file.getAbsolutePath());
        });

        super.showView();
        this.setTitle("Foto hinzufügen");

        showAndWait();
        return super.showView();
    }

    public void setButtons() {
        bOk.setOnAction(e -> {
            if (tfName.getText() == "") {
                (new Alert(AlertType.WARNING, "Bitte geben Sie einen Namen an!", ButtonType.OK)).showAndWait();
                return;
            }
            if (file == null) {
                (new Alert(AlertType.WARNING, "Bitte wählen Sie eine Datei aus!", ButtonType.OK)).showAndWait();
                return;
            }
            super.choice = true;
            Foto foto = (Foto) gibNeuesObjekt();

            System.out.println(foto);
            FotoUI.selectedAlbum.addFoto(foto);
            FotoUI.lMetaDescVal.setText(FotoUI.selectedAlbum.getFotos()[0].toString());
            try {
                FotoUI.updateGallery();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            this.close();
        });
        bAbbrechen.setOnAction(e -> {
            super.choice = false;
            this.close();
        });
    }

    public Object gibNeuesObjekt() {
        if (file == null)
            return false;
        try {
            var meta = FotoUtil.readMetadata(file);
            System.out.println(meta);
            return new Foto(tfName.getText(), file.getPath(), meta);
        } catch (Exception e) {
            System.out.println("ERROR: \n" + e.getMessage());
            return false;
        }
    }
}
