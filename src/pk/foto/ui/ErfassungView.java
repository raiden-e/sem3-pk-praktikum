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

        hb0.setPadding(new Insets(0, 0, 5, 0));
        hb1.setPadding(new Insets(0, 0, 5, 0));
        hb2.setPadding(new Insets(0, 0, 5, 0));
        vbMain.setPadding(new Insets(5));
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
