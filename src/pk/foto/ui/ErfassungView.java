package pk.foto.ui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class ErfassungView<T> extends Stage {
    boolean choice;
    Stage stage;
    Button bOk = new Button("OK");
    Button bAbbrechen = new Button("Abbrechen");

    Label lName = new Label("Name:");
    Label lOwner = new Label("Besitzer:");

    TextField tfName = new TextField();
    TextField tfOwner = new TextField();

    VBox vbMain = new VBox();
    HBox hb0 = new HBox();
    HBox hb1 = new HBox();
    HBox hb2 = new HBox();

    public ErfassungView(Stage stage) {
        this.stage = stage;
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);

        // new Insets(Top, Left, Bottom, Right)
        lName.setPadding(new Insets(0, 10, 0, 0));
        lOwner.setPadding(new Insets(0, 10, 0, 0));

        tfOwner.setPadding(new Insets(2));
        tfName.setPadding(new Insets(2));

        hb0.setPadding(new Insets(0, 0, 5, 0));
        hb1.setPadding(new Insets(0, 0, 5, 0));
        hb2.setPadding(new Insets(0, 0, 5, 0));
        vbMain.setPadding(new Insets(5));

        lName.setAlignment(Pos.CENTER_LEFT);
        lOwner.setAlignment(Pos.CENTER_LEFT);
        hb2.setAlignment(Pos.BOTTOM_CENTER);

        tfOwner.setMaxWidth(Double.MAX_VALUE);
        tfName.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(tfOwner, Priority.ALWAYS);
        HBox.setHgrow(tfName, Priority.ALWAYS);

        HBox.setHgrow(hb0, Priority.ALWAYS);
        HBox.setHgrow(hb1, Priority.ALWAYS);
        HBox.setHgrow(hb2, Priority.ALWAYS);
        VBox.setVgrow(hb2, Priority.ALWAYS);
        VBox.setVgrow(vbMain, Priority.ALWAYS);
        // Add items to scene

        hb0.getChildren().addAll(lName, tfName);
        hb1.getChildren().addAll(lOwner, tfOwner);
        hb2.getChildren().addAll(bOk, bAbbrechen);
        vbMain.getChildren().addAll(hb0, hb1, hb2);

        hb0.setSpacing(3.0);
        hb1.setSpacing(3.0);
        hb2.setSpacing(3.0);
    }

    public boolean showView() {
        try {setScene(new Scene(vbMain));}
        catch (java.lang.IllegalArgumentException e){}

        return choice;
    }

    @SuppressWarnings("hiding")
    public abstract <T> Object gibNeuesObjekt();

    public abstract void setButtons();

}
