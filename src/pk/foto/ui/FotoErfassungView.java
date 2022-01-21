package pk.foto.ui;

import java.io.File;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pk.foto.*;
import pk.foto.util.FotoUtil;

public class FotoErfassungView extends ErfassungView<Object> {
    Button bDatei = new Button("Datei auswählen");
    Label lDatei = new Label("Datei:");
    public File file = new File("Keine Datei ausgewählt");

    private Label lDateiPfad = new Label("Keine Datei ausgewählt");

    public FotoErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {
        super.showView();
        this.setTitle("Foto Erfassen");
        setButtons();

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Ordner auswählen");
        chooser.setInitialDirectory(new File("C:/Users/" + System.getProperty("user.name")));
        bDatei.setOnAction(e -> {
            file = chooser.showOpenDialog(stage);
            if (file != null)
                lDateiPfad.setText(file.getAbsolutePath());
        });

        gridpane.add(lDatei, 0, 1);
        gridpane.add(bDatei, 2, 1);
        gridpane.add(lDateiPfad, 1, 1);

        stage.setTitle("Foto hinzufügen");
        showAndWait();
        return super.showView();
    }

    public void setButtons() {
        bOk.setOnAction(e -> {
            super.choice = true;
            System.out.println(gibNeuesObjekt());
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
            return new Foto(super.tfName.getText(), file.getPath(), meta);
        } catch (Exception e) {
            System.out.println("ERROR: \n" + e.getMessage());
            return false;
        }
    }
}
