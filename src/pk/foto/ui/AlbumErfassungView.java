package pk.foto.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlbumErfassungView extends ErfassungView {
    public AlbumErfassungView(Stage stage) {
        super(stage);
        // TODO Auto-generated constructor stub
    }

    public Object gibNeuesObjekt() {
        return null;
    }

    public boolean showView() {
        super.showView();

        var lBesitzer = new Label("Besitzer:");
        var tfBesitzer = new TextField();
        tfBesitzer.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(tfBesitzer, Priority.ALWAYS);
        gridpane.add(lBesitzer, 0, 1);
        gridpane.add(tfBesitzer, 1, 1);
        stage.setScene(new Scene(gridpane));
        stage.setTitle("Neues Album erstellen");
        stage.show();

        return false;
    }
}
