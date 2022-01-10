package pk.foto.ui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class FotoErfassungView extends ErfassungView {
    private File file = new File("irgendwo");

    public FotoErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {
        super.showView();

        var bDatei = new Button("Datei auswählen");
        var lDatei = new Label("Datei:");

        DirectoryChooser chooser = new DirectoryChooser();
        bDatei.setOnAction(new ClickHandlerOk(chooser, stage));

        /*
         * DirectoryChooser chooser = new DirectoryChooser();
         * chooser.setTitle("JavaFX Projects"); File defaultDirectory = new
         * File("c:/Users/" + System.getProperty("user.name"));
         * chooser.setInitialDirectory(defaultDirectory); File selectedDirectory =
         * chooser.showDialog(stage);
         */

        gridpane.add(lDatei, 0, 1);
        gridpane.add(bDatei, 1, 1);

        stage.setScene(new Scene(gridpane));
        stage.setTitle("Foto hinzufügen");
        stage.show();

        return false;
    }

    public Object gibNeuesObjekt() {
        return null;
    }

    private class ClickHandlerOk implements EventHandler<ActionEvent> {
        private DirectoryChooser dc;
        private Stage stage;

        public ClickHandlerOk(DirectoryChooser dc, Stage stage) {
            this.dc = dc;
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent event) {
            dc.setTitle("JavaFX Projects");
            dc.setInitialDirectory(new File("c:/Users/" + System.getProperty("user.name")));
            file = dc.showDialog(stage);
        }
    }
}
