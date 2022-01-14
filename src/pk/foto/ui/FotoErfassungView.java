package pk.foto.ui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import pk.foto.*;
import pk.foto.util.FotoUtil;

public class FotoErfassungView extends ErfassungView<Object> {
    public File file = new File("irgendwo");

    private Label lDateiPfad = new Label("Keine Datei ausgewählt");

    public FotoErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {
        super.showView();
        var bDatei = new Button("Datei auswählen");
        var lDatei = new Label("Datei:");

        DirectoryChooser chooser = new DirectoryChooser();
        bDatei.setOnAction(new ClickHandlerPath(chooser, stage));

        gridpane.add(lDatei, 0, 1);
        gridpane.add(bDatei, 2, 1);
        gridpane.add(lDateiPfad, 1, 1);

        stage.setTitle("Foto hinzufügen");
        showAndWait();
        return super.showView();
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

    public class ClickHandlerPath implements EventHandler<ActionEvent> {
        // TODO: Warum verwenden wir einen DirectoryChooser??
        private DirectoryChooser dc;
        private Stage stage;

        public ClickHandlerPath(DirectoryChooser dc, Stage stage) {
            this.dc = dc;
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent event) {
            dc.setInitialDirectory(new File("C:/Users/" + System.getProperty("user.name")));
            file = dc.showDialog(stage);
            if (file != null)
                lDateiPfad.setText(file.getAbsolutePath());
        }
    }
}
