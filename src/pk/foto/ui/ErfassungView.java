package pk.foto.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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

    private boolean returner;

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
        gridpane = new GridPane();
        GridPane.setHgrow(tfName, Priority.ALWAYS);
        GridPane.setHalignment(bOk, HPos.RIGHT);
        GridPane.setHalignment(bAbbrechen, HPos.LEFT);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.prefWidthProperty().bind(stage.widthProperty());
        gridpane.prefHeightProperty().bind(stage.heightProperty());
        gridpane.add(lName, 0, 0);
        gridpane.add(bOk, 0, 2);
        gridpane.add(bAbbrechen, 1, 2);
        gridpane.add(tfName, 1, 0);

        tfName.setMaxWidth(Double.MAX_VALUE);
        bOk.setOnAction(new ClickHandlerConfirm());
        bAbbrechen.setOnAction(new ClickHandlerCancel());

        setScene(new Scene(gridpane));

        return returner;
    }

    public abstract <T> Object gibNeuesObjekt();

    private class ClickHandlerConfirm implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            returner = true;
            stage.close();
        }
    }

    private class ClickHandlerCancel implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            returner = false;
            stage.close();
        }
    }
}
