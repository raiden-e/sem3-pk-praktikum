package pk.foto.ui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class ErfassungView<T> extends Stage {
    boolean choice;
    protected static Stage stage;
    protected static Button bOk = new Button("OK");
    protected static Button bAbbrechen = new Button("Abbrechen");

    protected static TextField tfName = new TextField();
    protected static Label lName = new Label("Name:");

    protected static VBox vbMain = new VBox();
    protected static HBox hb0 = new HBox();
    protected static HBox hb1 = new HBox();
    protected static HBox hb2 = new HBox();

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
        try {
            setScene(new Scene(vbMain));
        } catch (java.lang.IllegalArgumentException e) {
        }

        return choice;
    }

    @SuppressWarnings("hiding")
    public abstract <T> Object gibNeuesObjekt();

    public abstract void setButtons();

}
