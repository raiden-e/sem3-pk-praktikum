package pk.foto.ui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import pk.foto.Album;

public class AlbumErfassungView extends ErfassungView<Object> {
    private File file = new File("irgendwo");
    TextField tfBesitzer = new TextField();

    public AlbumErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {
        super.showView();

        var lBesitzer = new Label("Besitzer:");
        tfBesitzer.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(tfBesitzer, Priority.ALWAYS);

        gridpane.add(lBesitzer, 0, 1);
        gridpane.add(tfBesitzer, 1, 1);

        stage.setTitle("Neues Album erstellen");
        showAndWait();
        return super.showView();
    }

    public Object gibNeuesObjekt() {
        if (file == null)
            return false;

        return new Album(super.tfName.getText(), tfBesitzer.getText());
    }
}
