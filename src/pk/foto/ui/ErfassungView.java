package pk.foto.ui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class ErfassungView<T> extends Stage {
    boolean choice;
    Stage stage;
    GridPane gridpane;
    Button bOk = new Button("OK");
    Button bAbbrechen = new Button("Abbrechen");

    Label lName = new Label("Name:");
    TextField tfName = new TextField();

    public ErfassungView(Stage stage) {
        this.stage = stage;
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
    }

    public boolean showView() {
        var hb0 = new HBox();
        var hb1 = new HBox();
        var hb2 = new HBox();

        // Add items to scene
        hb0.getChildren().addAll(lName, tfName);
        hb0.getChildren().addAll(bOk, bAbbrechen);
        
        hb0.setSpacing(3.0);
        hb0.setHgrow(tfName, Priority.ALWAYS);
        
//        gridpane = new GridPane();
//        GridPane.setHgrow(tfName, Priority.ALWAYS);
//        GridPane.setHalignment(bOk, HPos.RIGHT);
//        GridPane.setHalignment(bAbbrechen, HPos.LEFT);
//        gridpane.setHgap(10);
//        gridpane.setVgap(10);
//        gridpane.setPadding(new Insets(10, 10, 10, 10));
//        gridpane.prefWidthProperty().bind(stage.widthProperty());
//        gridpane.prefHeightProperty().bind(stage.heightProperty());
//        gridpane.add(lName, 0, 0);
//        gridpane.add(tfName, 1, 0);
//        gridpane.add(bOk, 0, 2);
//        gridpane.add(bAbbrechen, 1, 2);
        tfName.setMaxWidth(Double.MAX_VALUE);
        setScene(new Scene(hb0));
        // gridpane

        return choice;
    }

    @SuppressWarnings("hiding")
    public abstract <T> Object gibNeuesObjekt();

    public abstract void setButtons();

}
