package pk.foto.ui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class ErfassungView<T> extends Stage {
    Stage stage;
    GridPane gridpane;

    public ErfassungView(Stage stage) {
        this.stage = stage;
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public boolean showView() {
        gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.prefWidthProperty().bind(stage.widthProperty());
        gridpane.prefHeightProperty().bind(stage.heightProperty());
        var lName = new Label("Name:");
        var tfName = new TextField();
        var bOk = new Button("OK");
        var bAbbrechen = new Button("Abbrechen");

        tfName.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(tfName, Priority.ALWAYS);

        gridpane.add(lName, 0, 0);
        gridpane.add(bOk, 0, 2);
        gridpane.add(bAbbrechen, 1, 2);
        gridpane.add(tfName, 1, 0);

        GridPane.setHalignment(bOk, HPos.RIGHT);
        GridPane.setHalignment(bAbbrechen, HPos.LEFT);
        return false;
    }

    public abstract <T> Object gibNeuesObjekt();
}
